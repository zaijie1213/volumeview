package com.example.szg.volumeview;

/**
 * Created by szg on 2015/10/24.
 * for
 */

import android.os.Handler;

import java.lang.ref.WeakReference;

public class NoLeakHandler<T> extends Handler {
    protected WeakReference<T> mOuterClass;

    public NoLeakHandler(T outerClassInstance) {
        mOuterClass = new WeakReference<>(outerClassInstance);
    }
}