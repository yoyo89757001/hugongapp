package com.example.yiliaoyinian.ui.fragmengmain;



import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.yiliaoyinian.Beans.SMBean;
import com.example.yiliaoyinian.Beans.UnMessageBean;
import com.example.yiliaoyinian.MyApplication;
import com.example.yiliaoyinian.R;

import com.example.yiliaoyinian.ui.MainActivity;
import com.example.yiliaoyinian.ui.SaoMaActivity;
import com.example.yiliaoyinian.ui.wode.MessageInfoActivity;

import com.example.yiliaoyinian.utils.Consts;
import com.example.yiliaoyinian.utils.DateUtils;
import com.example.yiliaoyinian.utils.DialogManager;
import com.example.yiliaoyinian.utils.GsonUtil;
import com.example.yiliaoyinian.utils.ToastUtils;

import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.gongwen.marqueen.util.OnItemClickListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.qmuiteam.qmui.layout.QMUIButton;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;



import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {
    TextView shijian,riqi,xingqi;
    QMUIButton button1,button2,button3;
    ConstraintLayout jjk;
    LinearLayout topbutton;

    //几个代表页面的常量
//    public static final int PAGE_ONE = 0;
//    public static final int PAGE_TWO = 1;
//    public static final int PAGE_THREE = 2;
    private List<UnMessageBean.ResultBean> unMessageBeanList = new ArrayList<>();
    private SimpleMarqueeView tv_marquee;


    public Fragment1() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void wxMSG(String msgWarp) {
        if (msgWarp.equals("MessageInfoActivity")) {
            link_getUnread();
        }
        if (msgWarp.equals("timeiUpdate")){
            shijian.setText(DateUtils.ti(System.currentTimeMillis()+""));
            riqi.setText(DateUtils.times(System.currentTimeMillis()));
            xingqi.setText(DateUtils.getWeek(System.currentTimeMillis()));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void wxMSGss(SMBean msgWarp) {
        Log.d("Fragment1", msgWarp.toString()+"收到的扫码数据");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // @OnClick({R.id.l1, R.id.l2, R.id.l3, R.id.topbutton, R.id.jjk})
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        shijian=view.findViewById(R.id.shijian);
        riqi=view.findViewById(R.id.riqi);
        xingqi=view.findViewById(R.id.xingqi);
        button1=view.findViewById(R.id.l1);
        button1.setOnClickListener(this);
        button2=view.findViewById(R.id.l2);
        button2.setOnClickListener(this);
        button3=view.findViewById(R.id.l3);
        button3.setOnClickListener(this);
        jjk=view.findViewById(R.id.jjk);
        topbutton=view.findViewById(R.id.topbutton);
        EventBus.getDefault().register(this);
        tv_marquee = view.findViewById(R.id.tv_marquee);
        tv_marquee.setOnItemClickListener(new OnItemClickListener<TextView, String>() {
            @Override
            public void onItemClickListener(TextView mView, String mData, int mPosition) {
                Log.d("Fragment1", "mView" + mView.getText().toString());
                Log.d("Fragment1", "mData" + mData);
                Log.d("Fragment1", "mPosition:" + mPosition);
                /**
                 * 注意：
                 * 当MarqueeView有子View时，mView：当前显示的子View，mData：mView所填充的数据，mPosition：mView的索引
                 * 当MarqueeView无子View时，mView：null，mData：null，mPosition：－1
                 */
                startActivity(new Intent(getActivity(), MessageInfoActivity.class).putExtra("idid", unMessageBeanList.get(mPosition).getId()));

            }
        });

        shijian.setText(DateUtils.ti(System.currentTimeMillis()+""));
        riqi.setText(DateUtils.times(System.currentTimeMillis()));
        xingqi.setText(DateUtils.getWeek(System.currentTimeMillis()));

        button1.setRadius(QMUIDisplayHelper.dp2px(MyApplication.myApplication, 6));
        button1.setChangeAlphaWhenPress(true);//点击改变透明度
        button2.setRadius(QMUIDisplayHelper.dp2px(MyApplication.myApplication, 6));
        button2.setChangeAlphaWhenPress(true);//点击改变透明度
        button3.setRadius(QMUIDisplayHelper.dp2px(MyApplication.myApplication, 6));
        button3.setChangeAlphaWhenPress(true);//点击改变透明度

        link_getUnread();


        return view;
    }





    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();

    }






    private void link_getUnread() {//获取未读消息
        Request.Builder requestBuilder = new Request.Builder()
                .header("token", MyApplication.myApplication.getToken())
                .get()
                .url(Consts.URL + "/api/sysMessage/getUnread");
        // step 3：创建 Call 对象
        Call call = MyApplication.okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求失败" + e.getMessage() + call.request().url());
                if (getActivity() != null) {
                    ToastUtils.setMessage("网络请求失败", shijian);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("AllConnects", "请求成功" + call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("LoginActivity", "未读消息" + ss);
                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    UnMessageBean logingBe = gson.fromJson(jsonObject, UnMessageBean.class);
                    if (logingBe.isSuccess()) {
                        if (logingBe.getCode() == 1 && logingBe.getResult() != null) {
                            if (getActivity() != null) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {

                                            if (logingBe.getResult().size() > 0) {
                                                unMessageBeanList.clear();
                                                unMessageBeanList.addAll(logingBe.getResult());
                                                List<String> datas = new ArrayList<>();
                                                for (UnMessageBean.ResultBean bean : logingBe.getResult()) {
                                                    datas.add(bean.getTitle());
                                                }
                                                SimpleMF<String> marqueeFactory = new SimpleMF<String>(getActivity());
                                                marqueeFactory.setData(datas);
                                                tv_marquee.setMarqueeFactory(marqueeFactory);
                                                tv_marquee.startFlipping();
                                                jjk.setVisibility(View.VISIBLE);
                                            } else {
                                                List<String> datas = new ArrayList<>();
                                                SimpleMF<String> marqueeFactory = new SimpleMF<String>(getActivity());
                                                marqueeFactory.setData(datas);
                                                tv_marquee.setMarqueeFactory(marqueeFactory);
                                                tv_marquee.startFlipping();
                                                jjk.setVisibility(View.GONE);
                                            }

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        } else {
                            if (getActivity() != null)
                                ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(), shijian);
                        }
                    } else {
                        if (logingBe.getCode() == 102) {
                            Log.d("UnFinshFragment", "进来");
                            //token过期
                            DialogManager.getAppManager().showToken();
                        } else {
                            if (getActivity() != null)
                                ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(), shijian);
                        }
                    }
                } catch (Exception e) {
                    Log.d("AllConnects", e.getMessage() + "异常");
                }
            }
        });
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.l1:
                startActivity(new Intent(getContext(), SaoMaActivity.class).putExtra("type",1));
                break;
            case R.id.l2:
                startActivity(new Intent(getContext(), SaoMaActivity.class).putExtra("type",2));
                break;
            case R.id.l3:
                startActivity(new Intent(getContext(), SaoMaActivity.class).putExtra("type",3));
                break;
        }

    }
}
