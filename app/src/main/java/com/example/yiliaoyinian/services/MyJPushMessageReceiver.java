package com.example.yiliaoyinian.services;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.yiliaoyinian.Beans.Dfgg;

import com.example.yiliaoyinian.Beans.JPushMSGBean;


import com.example.yiliaoyinian.Beans.TSWGBean;
import com.example.yiliaoyinian.MyApplication;
import com.example.yiliaoyinian.R;

import com.example.yiliaoyinian.ui.MainActivity;


import org.greenrobot.eventbus.EventBus;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import io.objectbox.Box;

public class MyJPushMessageReceiver extends JPushMessageReceiver {
    private static final String TAG = "PushMessageReceiver";
    private Box<JPushMSGBean> jPushMSGBeanBox=MyApplication.myApplication.getjPushMSGBeanBox();

    @Override
    public void onMessage(Context context, CustomMessage customMessage) {
        Log.e(TAG,"[onMessage] "+customMessage);
        processCustomMessage(context,customMessage);
    }

    @Override
    public void onNotifyMessageOpened(Context context, NotificationMessage message) {
        Log.e(TAG,"[onNotifyMessageOpened] "+message);
        try{
            //打开自定义的Activity
            Intent i = new Intent(context, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(JPushInterface.EXTRA_NOTIFICATION_TITLE,message.notificationTitle);
            bundle.putString(JPushInterface.EXTRA_ALERT,message.notificationContent);
            i.putExtras(bundle);
            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
            context.startActivity(i);
        }catch (Throwable throwable){
            Log.d(TAG, "打开自定义的Activity:" + throwable.getMessage());
        }
    }

    @Override
    public void onMultiActionClicked(Context context, Intent intent) {
        Log.e(TAG, "[onMultiActionClicked] 用户点击了通知栏按钮");
        String nActionExtra = intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA);

        //开发者根据不同 Action 携带的 extra 字段来分配不同的动作。
        if(nActionExtra==null){
            Log.d(TAG,"ACTION_NOTIFICATION_CLICK_ACTION nActionExtra is null");
            return;
        }
        if (nActionExtra.equals("my_extra1")) {
            Log.e(TAG, "[onMultiActionClicked] 用户点击通知栏按钮一");
        } else if (nActionExtra.equals("my_extra2")) {
            Log.e(TAG, "[onMultiActionClicked] 用户点击通知栏按钮二");
        } else if (nActionExtra.equals("my_extra3")) {
            Log.e(TAG, "[onMultiActionClicked] 用户点击通知栏按钮三");
        } else {
            Log.e(TAG, "[onMultiActionClicked] 用户点击通知栏按钮未定义");
        }
    }

    @Override
    public void onNotifyMessageArrived(Context context, NotificationMessage message) {
        Log.e(TAG,"[onNotifyMessageArrived] "+message);
       // setStyleBasic(true,context);

//        JPushMSGBean bean=new JPushMSGBean();
//        bean.setMessage("ffsdfseqw多萨达所打额外全额");
//        bean.setTime2(System.currentTimeMillis());
//        jPushMSGBeanBox.put(bean);
//        EventBus.getDefault().post("updateGaoJing");

    }

    @Override
    public void onNotifyMessageDismiss(Context context, NotificationMessage message) {
        Log.e(TAG,"[onNotifyMessageDismiss] "+message);
    }

    @Override
    public void onRegister(Context context, String registrationId) {
        Log.e(TAG,"[onRegister] "+registrationId);
        EventBus.getDefault().post("registrationId,"+registrationId);

    }

    @Override
    public void onConnected(Context context, boolean isConnected) {
        Log.e(TAG,"[onConnected] "+isConnected);
    }

    @Override
    public void onCommandResult(Context context, CmdMessage cmdMessage) {
        Log.e(TAG,"[onCommandResult] "+cmdMessage);
    }

    @Override
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
       // TagAliasOperatorHelper.getInstance().onTagOperatorResult(context,jPushMessage);
        super.onTagOperatorResult(context, jPushMessage);
    }
    @Override
    public void onCheckTagOperatorResult(Context context,JPushMessage jPushMessage){
      //  TagAliasOperatorHelper.getInstance().onCheckTagOperatorResult(context,jPushMessage);
        super.onCheckTagOperatorResult(context, jPushMessage);
    }
    @Override
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
      //  TagAliasOperatorHelper.getInstance().onAliasOperatorResult(context,jPushMessage);
        super.onAliasOperatorResult(context, jPushMessage);
    }

    @Override
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
       // TagAliasOperatorHelper.getInstance().onMobileNumberOperatorResult(context,jPushMessage);
        super.onMobileNumberOperatorResult(context, jPushMessage);
    }

    //send msg to MainActivity
    private void processCustomMessage(Context context, CustomMessage customMessage) {
        // Log.d(TAG, "极光的消息:"+customMessage.message+" "+customMessage.contentType);
       //  if (customMessage.contentType.equals("6"))
         try {
             JSONObject jsonObject= JSON.parseObject(customMessage.extra);
             JSONObject ssss= jsonObject.getJSONObject("data");
             Object type=ssss.get("msgType");
             if (type!=null){
               if (type.toString().equals("6")){
                   Log.d(TAG, "准备推送测量数据");
                   EventBus.getDefault().post("saveInfoUpadtaJG");
               }
                 if (type.toString().equals("7")){//更新系统消息
                     Log.d(TAG, "更新系统消息");
                     EventBus.getDefault().post("MessageInfoActivity");
                 }
                 if (type.toString().equals("4")){//生物雷达离床消息
                     Log.d(TAG, "生物雷达离床消息");
                     EventBus.getDefault().post(ssss);
                 }
                 if (type.toString().equals("10")){//生物雷达离床消息
                     Log.d(TAG, ssss+"收到的内容");
                     TSWGBean object=JSON.parseObject(String.valueOf(ssss),TSWGBean.class);
                     EventBus.getDefault().post(object);
                 }
                 if (type.toString().equals("11")) {//告警推送
                    // setStyleBasic(true,context);
                     Dfgg object=JSON.parseObject(String.valueOf(ssss),Dfgg.class);
                     JPushMSGBean bean=new JPushMSGBean();
                     bean.setMessage(object.getPlace()+object.getMsg()+"");
                     bean.setTime2(System.currentTimeMillis());
                     bean.setTime(object.getTime());
                     jPushMSGBeanBox.put(bean);
                     EventBus.getDefault().post(object);
                 }
             }



//             JSONObject yyy= ssss.getJSONObject("data");
//             if (yyy.get("msgType")!=null)
//             Log.d(TAG, yyy.get("msgType").toString()+"ddddddd");
//
//             JGBleBean jgBleBean= JSON.parseObject(yyy.toJSONString(), JGBleBean.class);


         }catch (Exception e){
            Log.d(TAG, e.getMessage()+"极光异常");
         }


    }

    @Override
    public void onNotificationSettingsCheck(Context context, boolean isOn, int source) {
        super.onNotificationSettingsCheck(context, isOn, source);
        Log.e(TAG,"[onNotificationSettingsCheck] isOn:"+isOn+",source:"+source);
    }

    private void setStyleBasic(boolean opened,Context context){
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(context);
        builder.statusBarDrawable = R.mipmap.ic_launcher;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL;  //设置为点击后自动消失
        if (opened) {
            builder.notificationDefaults = Notification.DEFAULT_SOUND;  //设置为铃声（ Notification.DEFAULT_SOUND）或者震动（ Notification.DEFAULT_VIBRATE）
        } else {
            builder.notificationDefaults = Notification.DEFAULT_LIGHTS;	//设置为闪光
        }
        JPushInterface.setDefaultPushNotificationBuilder(builder);
    }
}
