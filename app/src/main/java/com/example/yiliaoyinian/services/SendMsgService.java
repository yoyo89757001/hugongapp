package com.example.yiliaoyinian.services;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;



public class SendMsgService extends Service {

    public static final String TAG = "viclee";



    @Override
    public void onCreate() {
        Log.i(TAG, "ProcessTestService onCreate");



    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

}
