package com.example.szg.volumeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;


/**
 * Created by szg on 2015/10/24.
 * for
 */
public class WkVolumeView extends View {
    public final Paint mPaint = new Paint();
    private final Path mPath;
    private ControlThread mControlThread;


    private float e = 0.23F;
    private float f = 0.0F;
    private float g = 0.4F;
    private final float[] alphas = {3.0F, 2.0F, 2.0F, 1.0F, 1.0F};
    private final float[] widths = {1.0F, 0.4F, 0.4F, 0.4F, 0.4F};
    private final int[] j = {0, 6, -9, 15, -21};
    private WkVolumeViewNoLeakHandler mWkVolumeViewNoLeakHandler;


    public WkVolumeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPaint.setStrokeWidth(1.0F);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPath = new Path();
        init();
    }

    public void init() {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(localDisplayMetrics);
        float density = localDisplayMetrics.density;
        this.g = (0.3F * density);
        for (int k = 0; k < this.alphas.length; k++) {
            this.alphas[k] = (density * this.alphas[k] / 2.0F);
        }
        mWkVolumeViewNoLeakHandler = new WkVolumeViewNoLeakHandler(this);
    }


    //
    public final void start() {
        this.f = 0.0F;
        this.e = 0.23F;
        invalidate();
        if (this.mControlThread != null) {
            this.mControlThread.a();
        } else {
            mControlThread = new ControlThread(mWkVolumeViewNoLeakHandler);
            mControlThread.start();
        }
    }


    private void play(int height) {
        float lineMaxHeight = 0.23F;
        if (height==0){
            return;
        }
        float f2 = lineMaxHeight + 0.385F * (2.0F - 30.0F / (height + 15));
        while (f2>=lineMaxHeight){

        }



    }
//    public final void change(int h) {
//
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth();
        float halfHeight = getHeight() / 2.0F;
        float halfWidth = width / 2.0F;
        float f4 = halfHeight - 4.0F;
        for (int k = 0; k < this.alphas.length; k++) {
            float f5 = 1.5F * (1.0F - (float) k / this.alphas.length) - 0.5F;
            this.mPaint.setStrokeWidth(this.alphas[k]);
            this.mPaint.setAlpha((int) (255.0F * this.widths[k]));
            this.mPath.reset();
            this.mPath.moveTo(0.0F, halfHeight);
            for (int x = 0; x < width; x++) {
                float y = (float) (f5 * (f4 * (float) (1.0D - Math.pow(1.0F / halfWidth * (x - halfWidth), 2.0D))) * this.e * Math.sin(1.5D * (6.283185307179586D * ((x + this.f + this.j[k]) / width))) + halfHeight);
                this.mPath.lineTo(x, y);
            }
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    public static class WkVolumeViewNoLeakHandler extends NoLeakHandler<WkVolumeView> {
        public static final int PLAY_NORMAL = 0;


        public WkVolumeViewNoLeakHandler(WkVolumeView outerClassInstance) {
            super(outerClassInstance);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mOuterClass.get() != null) {
                switch (msg.what) {
                    case PLAY_NORMAL:
                        mOuterClass.get().play();
                        break;

                }
            }
        }
    }
}
