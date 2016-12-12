/*
 * Copyright 2015 Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vis.weather.util;

import android.os.StrictMode;
import com.baidu.mapapi.SDKInitializer;
import com.tencent.bugly.crashreport.CrashReport;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

//import com.squareup.leakcanary.RefWatcher;

/**
 * Created in Oct 23, 2015 12:59:13 PM.
 *
 * @author Yan Zhenjie.
 */
public class Application extends android.app.Application {

    private static Application _instance;
//    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        System.out.println("_1_______________Application _instance____________________");
        super.onCreate();
        _instance = this;
        CrashReport.initCrashReport(getApplicationContext(),"900057272", true);
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        SDKInitializer.initialize(this);
        enabledStrictMode();
//        refWatcher=LeakCanary.install(this);

    }

    public static Application getInstance() {
        return _instance;
    }

    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }
//
//    public static RefWatcher getRefWatcher(Context context) {
//        Application application = (Application) context.getApplicationContext();
//        return application.refWatcher;
//    }


}
