package com.xm.timberdemo;

import android.app.Application;
import android.util.Log;

import timber.log.Timber;

/**
 * Created by Administrator on 2016/6/24.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //在这里先使用Timber.plant注册一个Tree，然后调用静态的.d .v 去使用
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    /**
     * A tree which logs important information for crash reporting.
     */
    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }
            FakeCrashLibrary.log(priority, tag, message);
            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t);
                }
            }
        }
    }
}
