package com.vis.weather.update.download;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.*;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.orhanobut.logger.Logger;
import com.vis.weather.R;
import com.vis.weather.model.UpdateAPK;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.update.download.bean.Download;
import com.vis.weather.update.download.service.DownloadService;
import com.vis.weather.update.download.utils.StringUtils;
import com.vis.weather.view.base.BaseActivity;
import rx.Observer;

public class DownloadActivity extends BaseActivity {
    private static final String TAG = "DownloadActivity";
    public static final String MESSAGE_PROGRESS = "message_progress";
    private LocalBroadcastManager bManager;

    private UpdateAPK newVersion;
    private AppCompatButton btn_download;
    private ProgressBar progress;
    private TextView progress_text;
    private String newVerName;
    private int newVerCode;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(MESSAGE_PROGRESS)) {

                Download download = intent.getParcelableExtra("download");
                progress.setProgress(download.getProgress());
                if (download.getProgress() == 100) {
                    btn_download.setText(R.string.getInfo);
                    progress_text.setText(R.string.DownloadComplete);

                } else {

                    progress_text.setText("已下载:"+
                            StringUtils.getDataSize(download.getCurrentFileSize()) +"/共21M");

                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download);
        TextView title=setToolbar();
        title.setText("软件更新");
        btn_download = (AppCompatButton) findViewById(R.id.btn_download);
        progress = (ProgressBar) findViewById(R.id.progress);
        progress_text = (TextView) findViewById(R.id.progress_text);
        btn_download.setText(R.string.getInfo);
        GetOnlineData.queryLastUpdateAPK(observerCheckLastUpdateAPK);
        waitDialog.show();
        registerReceiver();

    }

    private void registerReceiver() {

        bManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MESSAGE_PROGRESS);
        bManager.registerReceiver(broadcastReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册时，使用注册时的manager解绑
        bManager.unregisterReceiver(broadcastReceiver);
    }


    Observer<UpdateAPK> observerCheckLastUpdateAPK = new Observer <UpdateAPK>() {
        @Override
        public void onCompleted() {
            waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {
            waitDialog.dismiss();
            Logger.e("onError" + e);
            Toast.makeText(DownloadActivity.this, R.string.request_failed, Toast.LENGTH_SHORT).show();
            fail();


        }

        @Override
        public void onNext(UpdateAPK dh) {

            if (dh.getTotal() == 0) {
                Toast.makeText(DownloadActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
            if (dh.getRows() != null) {
                newVersion=dh;
                newVerCode=Integer.parseInt(newVersion.getRows().get(0).getVersionno());
                newVerName=newVersion.getRows().get(0).getVersionname();
                Logger.i("APK path:" + dh.getRows().get(0).getApk_path());
                System.out.print('I'+'T');
                gotInfo();

            }
        }
    };
    private void fail() {
        btn_download.setText("连接服务器失败");
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetOnlineData.queryLastUpdateAPK(observerCheckLastUpdateAPK);
                waitDialog.show();
            }
        });
//        pb.setVisibility(View.GONE);
        Toast.makeText(this, "请检查网络！！", Toast.LENGTH_SHORT).show();
    }
    private void gotInfo() {

        btn_download.setText("服务器版本获取成功！");
//        pb.setVisibility(View.GONE);
        int verCode = this.getVerCode(this);

        if (newVerCode > verCode) {
            doNewVersionUpdate();// 更新版本
        } else {
            notNewVersionUpdate();// 提示已是最新版本
        }

    }

    /**
     * 更新版本
     */
    public void doNewVersionUpdate() {
        int verCode = this.getVerCode(this);
        String verName = this.getVerName(this);
        StringBuffer sb = new StringBuffer();
        sb.append("当前版本：");
        sb.append(verName);
        sb.append(" 版本号:");
        sb.append(verCode);
        sb.append("\r\n发现版本：");
        sb.append(newVerName);
        sb.append(" 版本号:");
        sb.append(newVerCode);
        sb.append("\n是否更新?");
        Dialog dialog = new AlertDialog.Builder(this).setTitle("软件更新").setMessage(sb.toString())
                .setPositiveButton("更新", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        btn_download.setText("正在下载.........");
                        Intent intent = new Intent(DownloadActivity.this, DownloadService.class);
                        intent.putExtra("path",newVersion.getRows().get(0).getApk_path());
                        startService(intent);
                    }
                }).setNegativeButton("暂不更新", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        btn_download.setText("");
                        finish();
                    }
                }).create();
        // 显示更新框
        dialog.show();
    }

    /**
     * 不更新版本
     */
    public void notNewVersionUpdate() {
        int verCode = this.getVerCode(this);
        String verName = this.getVerName(this);
        StringBuffer sb = new StringBuffer();
        sb.append("当前版本：");
        sb.append(verName);
        sb.append(" Code:");
        sb.append(verCode);
        sb.append("\n已是最新版本，无需更新");
        Dialog dialog = new AlertDialog.Builder(this).setTitle("软件更新").setMessage(sb.toString())
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        finish();
                    }
                }).create();
        dialog.show();
    }

    /**
     * 获得版本号
     */
    public int getVerCode(Context context) {
        int verCode = -1;
        try {
            verCode =
                    context.getPackageManager().getPackageInfo(getPackageName(),
                            0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            Log.e("版本号获取异常", e.getMessage());
        }
        return  verCode;
    }

    /**
     * 获得版本名称
     */
    public String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().getPackageInfo("com.great.activity", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("版本名称获取异常", e.getMessage());
        }
        return verName;
    }

}
