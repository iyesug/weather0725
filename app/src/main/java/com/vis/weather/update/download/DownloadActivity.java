package com.vis.weather.update.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.vis.weather.R;
import com.vis.weather.update.download.bean.Download;
import com.vis.weather.update.download.service.DownloadService;
import com.vis.weather.update.download.utils.StringUtils;

public class DownloadActivity extends AppCompatActivity {
    private static final String TAG = "DownloadActivity";
    public static final String MESSAGE_PROGRESS = "message_progress";
    private LocalBroadcastManager bManager;


    private AppCompatButton btn_download;
    private ProgressBar progress;
    private TextView progress_text;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(MESSAGE_PROGRESS)) {

                Download download = intent.getParcelableExtra("download");
                progress.setProgress(download.getProgress());
                if (download.getProgress() == 100) {

                    progress_text.setText("File Download Complete");

                } else {

                    progress_text.setText(
                            StringUtils.getDataSize(download.getCurrentFileSize())
                            + "/" +
                            StringUtils.getDataSize(download.getTotalFileSize()));

                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download);
        btn_download = (AppCompatButton) findViewById(R.id.btn_download);
        progress = (ProgressBar) findViewById(R.id.progress);
        progress_text = (TextView) findViewById(R.id.progress_text);

        registerReceiver();

        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(DownloadActivity.this, DownloadService.class);
                    startService(intent);

            }
        });
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
}
