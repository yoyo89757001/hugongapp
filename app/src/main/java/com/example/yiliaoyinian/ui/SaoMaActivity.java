package com.example.yiliaoyinian.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.yiliaoyinian.Beans.SMBean;
import com.example.yiliaoyinian.R;
import com.google.zxing.DecodeHintType;
import com.qmuiteam.qmui.layout.QMUIButton;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import org.greenrobot.eventbus.EventBus;
import java.util.EnumMap;
import java.util.Map;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;


public class SaoMaActivity extends BaseActivity implements QRCodeView.Delegate, View.OnClickListener {


    ZXingView zxingview;
    ImageView blacks;
    QMUIButton guan;
    private boolean isop=false;
   // private boolean isA=false;
    private int type=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sao_ma);
        zxingview=findViewById(R.id.zxingview);
        blacks=findViewById(R.id.blacks);
        blacks.setOnClickListener(this);
        guan=findViewById(R.id.guan);
        guan.setOnClickListener(this);
        zxingview.setDelegate(this);
        Map<DecodeHintType, Object> hintMap = new EnumMap<>(DecodeHintType.class);
        // List<BarcodeFormat> formatList = new ArrayList<>();
        // formatList.add(BarcodeFormat.QR_CODE);
        // formatList.add(BarcodeFormat.UPC_A);
        // formatList.add(BarcodeFormat.EAN_13);
        // formatList.add(BarcodeFormat.CODE_128);
        //hintMap.put(DecodeHintType.POSSIBLE_FORMATS, formatList); // 可能的编码格式
        //hintMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE); // 花更多的时间用于寻找图上的编码，优化准确性，但不优化速度
        hintMap.put(DecodeHintType.CHARACTER_SET, "UTF-8"); // 编码字符集
        zxingview.setType(BarcodeType.CUSTOM, hintMap); // 自定义识别的类型
        TextView title = findViewById(R.id.title);

        guan.setRadius(QMUIDisplayHelper.dp2px(this, 16));
        guan.setChangeAlphaWhenPress(true);//点击改变透明度
        type=getIntent().getIntExtra("type",0);
        if (type==1){
            title.setText("上班签到");
        }else if (type==2){
            title.setText("巡视签到");
        }else if (type==3){
            title.setText("下班签到");
        }

    }


    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.d("SaoMaActivity", result+"结果");
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (vibrator != null)
            vibrator.vibrate(200);//震动
        SMBean smBean=new SMBean(type,result);
        EventBus.getDefault().post(smBean);
        finish();
    }


    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {
        Log.d("SaoMaActivity", "isDark:" + isDark);
        if (isDark) {
            if (!isop){
                guan.setVisibility(View.VISIBLE);
                isop=true;
                zxingview.openFlashlight(); // 打开闪光灯
            }
        }
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.d("SaoMaActivity", "相机出错");

    }

    @Override
    protected void onStart() {
        super.onStart();

        zxingview.startCamera(); // 打开后置摄像头开始预览，但是并未开始识别
//        mZXingView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT); // 打开前置摄像头开始预览，但是并未开始识别
        zxingview.startSpotAndShowRect(); // 显示扫描框，并开始识别
    }

    @Override
    protected void onStop() {
        zxingview.stopCamera(); // 关闭摄像头预览，并且隐藏扫描框
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        zxingview.onDestroy(); // 销毁二维码扫描控件
        super.onDestroy();
    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blacks:
                finish();
                break;
            case R.id.guan:
                guan.setVisibility(View.GONE);
                zxingview.closeFlashlight(); // 关闭闪光灯
                isop=false;
                break;
        }
    }
}
