package com.vis.weather.photolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.vis.weather.R;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by GaoYu on 2016/8/25.
 */
public class PhotoViewActivity extends Activity{

    private PhotoView mImageView;
    private ProgressBar mProgressBar;
    private String[] URLs;
    private int position;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoview);
        mImageView = (PhotoView) findViewById(R.id.iv_photo);
        mProgressBar = (ProgressBar) findViewById(R.id.photoview_progressbar);
        Intent intent = getIntent();
        if (intent != null) {
            URLs=intent.getStringArrayExtra("URLs");
            position=intent.getIntExtra("position",0);
            String url = intent.getStringExtra("URL");
            Glide.with(this)
                    .load(URLs[position])
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String s, Target<GlideDrawable> target, boolean b) {

                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable glideDrawable, String s, Target<GlideDrawable> target, boolean b, boolean b1) {
                            mProgressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mImageView);
        }
        mImageView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                finish();
            }

        });

    }
}
