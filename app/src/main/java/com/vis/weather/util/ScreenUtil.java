package com.vis.weather.util;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by GaoYu on 2016/7/28.
 */

    public class ScreenUtil {

        public static int getScreenWidth(Context context) {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display defaultDisplay = wm.getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            return width;

        }
    }

