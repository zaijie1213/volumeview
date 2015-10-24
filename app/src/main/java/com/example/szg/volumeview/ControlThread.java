package com.example.szg.volumeview;

import android.os.Message;

/**
 * Created by szg on 2015/10/24.
 * for
 */
public class ControlThread extends Thread {
    private WkVolumeView.WkVolumeViewNoLeakHandler mWkVolumeViewNoLeakHandler;
    public boolean run = true;
    int count=0;

    long a;
    float b;
    float c;
    private boolean e;

    public ControlThread(WkVolumeView.WkVolumeViewNoLeakHandler handler) {
        this.mWkVolumeViewNoLeakHandler = handler;
    }

    public void stopControl(){
        run=false;
        this.interrupt();
    }

//    final float a(long paramLong)
//    {
//        float f1 = 0;
//        if (this.b == this.c) {
//            f1 = this.c;
//        }
//        do
//        {
//            do
//            {
//                return f1;
//                if (paramLong == this.a) {
//                    return this.b;
//                }
//                if (this.c <= this.b) {
//                    break;
//                }
//                f1 = this.b + 0.002F * (float)(paramLong - this.a);
//            } while (f1 < this.c);
//            float f3 = this.c;
//            this.b = this.c;
//            this.a = paramLong;
//            this.c = 0.23F;
//            return f3;
//            if (this.c >= this.b) {
//                break;
//            }
//            f1 = this.b + -0.001F * (float)(paramLong - this.a);
//        } while (f1 > this.c);
//        float f2 = this.c;
//        this.b = this.c;
//        this.a = paramLong;
//        this.c = 0.23F;
//        return f2;
//        return 0.23F;
//    }


    @Override
    public void run() {
        super.run();
        while (run) {
            count++;
            Message message = Message.obtain();
            message.arg1=count%100;
            message.what = WkVolumeView.WkVolumeViewNoLeakHandler.PLAY_NORMAL;
            mWkVolumeViewNoLeakHandler.sendMessage(message);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void a() {

    }
}
