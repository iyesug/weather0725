package com.vis.weather.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.vis.weather.R;
import com.vis.weather.view.base.BaseActivity;


public class VideoFileActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ListView mVideoListView;
    private VideoAdapter mVideoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_file);
        TextView title=setToolbar();
        title.setText("气象视频");
        mVideoListView = (ListView) findViewById(R.id.FileListView);
        mVideoAdapter = new VideoAdapter(this);

        mVideoListView.setAdapter(mVideoAdapter);
        mVideoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                Intent intent = new Intent(VideoFileActivity.this,PLVideoTextureActivity.class);
//                Intent intent = new Intent(VideoFileActivity.this,VideoViewActivity.class);
                intent.putExtra("videoPath", mVideoAdapter.getVideoPath(position));
                setResult(Activity.RESULT_OK, intent);
                startActivity(intent);
            }
        });

        getSupportLoaderManager().initLoader(1, null, this);
//        sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"
//                + Environment.getExternalStorageDirectory())));
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.parse("file://" + Environment.getExternalStorageDirectory())));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, MediaStore.Video.Media.getContentUri("external"), null, null, null,
                "UPPER(" + MediaStore.Video.Media.DATA + ")");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mVideoAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public class VideoAdapter extends SimpleCursorAdapter {
      String [] name=new String[]{"气象科普"};
        String [] data=new String[]{"气象科普.mp4"};
        String [] path=new String[]{"http://i.weather.com.cn/images/cn/index/dtpsc/2013/05/27/89682A3AE97AD3330B0CE9D060914CDC.swf"};
        public VideoAdapter(Context context) {
            super(context, R.layout.item_video, null,
                    new String[]{"气象科普", "气象科普.mp4"},
                    new int[]{R.id.id_textview, R.id.id_textview1}, 0);
        }

        @Override
        public long getItemId(int position) {
            final Cursor cursor = getCursor();
            if (cursor == null || cursor.getCount() == 0 || position >= cursor.getCount()) {
                return 0;
            }
            cursor.moveToPosition(position);
            return cursor.getLong(0);
        }

        public String getVideoPath(int position) {
            final Cursor cursor = getCursor();
            if (cursor.getCount() == 0) {
                return "";
            }
            cursor.moveToPosition(position);
            return "http://i.weather.com.cn/images/cn/index/dtpsc/2013/05/27/89682A3AE97AD3330B0CE9D060914CDC.swf";
        }
    }

}
