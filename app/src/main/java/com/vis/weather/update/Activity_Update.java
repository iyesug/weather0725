package com.vis.weather.update;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.orhanobut.logger.Logger;
import com.vis.weather.R;
import com.vis.weather.model.UpdateAPK;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.update.download.DownloadActivity;
import com.vis.weather.view.base.BaseActivity;
import rx.Observer;

import java.io.File;


public class Activity_Update extends BaseActivity {

    private String newVerName = "";// 新版本名称
    private int newVerCode = -1;// 新版本号
    private ProgressDialog pd = null;
    private String UPDATE_SERVERAPK = "new.apk";

    private TextView tip;
    private boolean b;
    private String path;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        tip= (TextView) findViewById(R.id.tip);
        GetOnlineData.queryLastUpdateAPK(observerCheckLastUpdateAPK);
//        getServerVer();
    }

    private void gotInfo() {

        tip.setText("获取成功！");
//        pb.setVisibility(View.GONE);
        int verCode = this.getVerCode(this);

        if (newVerCode > verCode) {
            doNewVersionUpdate();// 更新版本
        } else {
            notNewVersionUpdate();// 提示已是最新版本
        }

    }

    private void fail() {
        tip.setText("连接服务器失败");
//        pb.setVisibility(View.GONE);
        Toast.makeText(this, "请检查网络！！", Toast.LENGTH_SHORT).show();
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
         } catch (NameNotFoundException e) {
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
        } catch (NameNotFoundException e) {
            Log.e("版本名称获取异常", e.getMessage());
        }
        return verName;
    }

    /**
     * 从服务器端获得版本号与版本名称
     *
     * @return
     */
//    public boolean getServerVer() {
//        b = false;
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                String uri = p.getRestMsg();
//                HttpClient httpClient = new DefaultHttpClient();
//                HttpPost httpPost = new HttpPost(uri);
//
//                List<NameValuePair> params = new ArrayList<NameValuePair>();
//
//                params.add(new BasicNameValuePair("do", "update_soft_msg"));
//
//                try {
//                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
//                    httpPost.setEntity(entity);
//
//                    HttpResponse httpResponse = httpClient.execute(httpPost);
//                    Log.i("获取版本号：", "发送请求");
//                    if (httpResponse.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
//                        Log.i("获取版本号：", "有回应");
//                        InputStream in = httpResponse.getEntity().getContent();
//
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
//
//                        String buffer = reader.readLine();
//
//                        JSONObject jsonObj = new JSONObject(buffer);
//                        newVerCode = Integer.parseInt(jsonObj.getString("verCode"));
//                        Log.i("获取版本号：", "" + newVerCode);
//                        newVerName = jsonObj.getString("verName");
//                        Log.i("获取版本名：", newVerName);
//                        b = true;
//                        Message message = handler.obtainMessage();
//                        message.what = 2;
//                        handler.sendMessage(message);
//
//                    }
//
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                    b = false;
//                    Message message = handler.obtainMessage();
//                    message.what = 3;
//                    handler.sendMessage(message);
//
//                }
//
//            }
//        });
//        thread.start();
//
//        return b;
//    }

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
        sb.append(",发现版本：");
        sb.append(newVerName);
        sb.append(" 版本号:");
        sb.append(newVerCode);
        sb.append(",是否更新?");
        Dialog dialog = new AlertDialog.Builder(this).setTitle("软件更新").setMessage(sb.toString())
                .setPositiveButton("更新", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        tip.setText("");
                        pd = new ProgressDialog(Activity_Update.this);
                        pd.setTitle("正在下载");
                        pd.setMessage("请稍后。。。");
                        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                        downFile();
                        startActivity(new Intent(Activity_Update.this, DownloadActivity.class));
                    }
                }).setNegativeButton("暂不更新", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        tip.setText("");
                        finish();
                    }
                }).create();
        // 显示更新框
        dialog.show();
    }

    /**
     * 下载apk
     */
//    public void downFile() {
//        Log.i("show", "发送请求");
//        pd.show();
//        Log.i("thread：", "发送请求");
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                String uri = p.getRestMsg();
//                HttpClient httpClient = new DefaultHttpClient();
//                HttpPost httpPost = new HttpPost(uri);
//
//                List<NameValuePair> params = new ArrayList<NameValuePair>();
//
//                params.add(new BasicNameValuePair("do", "update"));
//
//                try {
//                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
//                    httpPost.setEntity(entity);
//
//                    HttpResponse httpResponse = httpClient.execute(httpPost);
//                    Log.i("获取apk：", "发送请求");
//                    if (httpResponse.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
//                        Log.i("获取apk：", "有回应");
//                        InputStream in = httpResponse.getEntity().getContent();
//
//                        if (in != null) {
//
//                            String sdCardPath = Environment.getExternalStorageDirectory().toString();
//
//                            path = sdCardPath + "/" + UPDATE_SERVERAPK;
//                            File f = new File(path);
//                            Log.i("file path文件路径:::::", path);
//
//                            FileOutputStream fops = new FileOutputStream(f);
//                            int len = 0;
//                            byte[] b = new byte[1024 * 1024];
//                            while ((len = in.read(b)) != -1) {
//                                fops.write(b, 0, len);
//                                System.out.println("fops.write(b, 0, len);" + b.length);
//                                Log.i("fops.write(b, 0, len);", "" + b.length);
//                            }
//                            fops.flush();
//                            fops.close();
//                            Log.i("下载完成：", "fops.close()");
//                            Message message = handler.obtainMessage();
//                            message.what = 1;
//                            handler.sendMessage(message);
//                        }
//
//                    }
//
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//
//                }
//
//            }
//        });
//        thread.start();

        //
        // new Thread() {
        // public void run() {
        // HttpClient client = new DefaultHttpClient();
        // HttpPost post = new HttpPost();
        // HttpResponse response;
        // try {
        //
        // List<NameValuePair> params = new ArrayList<NameValuePair>();
        //
        // params.add(new BasicNameValuePair("do", "update"));
        // UrlEncodedFormEntity uentity = new UrlEncodedFormEntity(params,
        // HTTP.UTF_8);
        // post.setEntity(uentity);
        // response = client.execute(post);
        // Log.e("获取下载", ""+"apk");
        // if (response.getStatusLine().getStatusCode() ==
        // HttpURLConnection.HTTP_OK) {
        // Log.e("开始下载", ""+"apk。。。。。。。。。。。");
        // HttpEntity entity = response.getEntity();
        // long length = entity.getContentLength();
        // InputStream is = entity.getContent();
        // FileOutputStream fileOutputStream = null;
        // if (is != null) {
        // File file = new File(Environment.getExternalStorageDirectory(),
        // UPDATE_SERVERAPK);
        // fileOutputStream = new FileOutputStream(file);
        // byte[] b = new byte[1024];
        // int charb = -1;
        // int count = 0;
        // while ((charb = is.read(b)) != -1) {
        // fileOutputStream.write(b, 0, charb);
        // count += charb;
        // Log.i("@go", "勺子:" + charb);
        // }
        // }
        // fileOutputStream.flush();
        // if (fileOutputStream != null) {
        // fileOutputStream.close();
        // }
        // down();
        // }} catch (Exception e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }
        // }.start();
//    }


    Observer<UpdateAPK> observerCheckLastUpdateAPK = new Observer <UpdateAPK>() {
        @Override
        public void onCompleted() {
            waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {
            waitDialog.dismiss();
            Logger.e("onError" + e);
                 Toast.makeText(Activity_Update.this, R.string.request_failed, Toast.LENGTH_SHORT).show();
            fail();


        }

        @Override
        public void onNext(UpdateAPK dh) {

            if (dh.getTotal() == 0) {
                Toast.makeText(Activity_Update.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
            if (dh.getRows() != null) {
                Logger.i("APK path:" + dh.getRows().get(0).getApk_path());
                newVerCode=Integer.parseInt(dh.getRows().get(0).getVersionno());
                gotInfo();

            }
        }
    };




    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:

                    pd.cancel();
                    update();

                    break;
                case 2:
                    gotInfo();
                    break;
                case 3:
                    fail();

                    break;
                default:
                    break;

            }
        }
    };

    /**
     * 安装应用
     */
    public void update() {
        File file = new File(path);
        if (file == null || !file.exists() || !file.isFile()) {
            Log.e("@go", "文件检查:失败~~~~");
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(path)),
                "application/vnd.android.package-archive");
        startActivity(intent);

    }

    /**
     * 调用系统安装应用
     */
    public static boolean install(Context context, File file) {
        if (file == null || !file.exists() || !file.isFile()) {

            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        return true;
    }
}