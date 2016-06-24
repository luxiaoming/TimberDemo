package com.xm.timberdemo;

/**
 * Created by Administrator on 2016/6/24.
 */


/**
 * Not a real crash reporting library!
 */
public final class FakeCrashLibrary {
    private FakeCrashLibrary() {
        throw new AssertionError("No instances.");
    }

    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
    }
}