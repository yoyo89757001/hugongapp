package com.example.yiliaoyinian.ui.fragmengmain;



import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.yiliaoyinian.Beans.AAbb;
import com.example.yiliaoyinian.Beans.AAbb2;
import com.example.yiliaoyinian.Beans.Dfgg;
import com.example.yiliaoyinian.Beans.ErWeiMaBean;
import com.example.yiliaoyinian.Beans.ErrorBean;
import com.example.yiliaoyinian.Beans.IKjdd;
import com.example.yiliaoyinian.Beans.JPushMSGBean;
import com.example.yiliaoyinian.Beans.JPushMSGBean_;
import com.example.yiliaoyinian.Beans.SMBean;
import com.example.yiliaoyinian.Beans.UnMessageBean;
import com.example.yiliaoyinian.MyApplication;
import com.example.yiliaoyinian.R;
import com.example.yiliaoyinian.dialog.CommomDialog2;
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
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import io.objectbox.Box;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {
    TextView shijian,riqi,xingqi,gdfgd;
    QMUIButton button1,button2,button3;
    ConstraintLayout jjk;
    LinearLayout topbutton;
    private QMUITipDialog qmuiTipDialog = null;

    //几个代表页面的常量
//    public static final int PAGE_ONE = 0;
//    public static final int PAGE_TWO = 1;
//    public static final int PAGE_THREE = 2;
    private List<UnMessageBean.ResultBean> unMessageBeanList = new ArrayList<>();
    private Vector<JPushMSGBean> jPushMSGBeans = new Vector<>();
    private SimpleMarqueeView tv_marquee;
    private Box<JPushMSGBean> jPushMSGBeanBox=MyApplication.myApplication.getjPushMSGBeanBox();
    private RecyclerView recyclerView;
    private BianQianAdapter adapter=null;

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

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void wxMSGts(Dfgg msgWarp) {
        jPushMSGBeans.clear();
        jPushMSGBeans.addAll(jPushMSGBeanBox.query().orderDesc(JPushMSGBean_.time2).build().find());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                gdfgd.setText("共"+jPushMSGBeans.size()+"条");
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)//注意这是子线程
    public void wxMSGss(SMBean msgWarp) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
            }
        });
        SystemClock.sleep(1000);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
            }
        });
        try {
            ErWeiMaBean student = JSONObject.parseObject(msgWarp.getMsg(), ErWeiMaBean.class);//type:1-患者，2-楼层，3-房间，4-床位
            Log.d("Fragment1", "student.getType():" + student.getType());
            if (student.getType()!=3 && student.getType()!=4){
                showMEG();
                return;
            }
            switch (msgWarp.getType()){
                case 1://上班
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //签到//发送请求给后台签到
                                qmuiTipDialog = new QMUITipDialog.Builder(getActivity())
                                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                                        .setTipWord("上班签到中...")
                                        .create();
                                qmuiTipDialog.show();
                                link_completeSB(student.getType(),student.getData().getDataName(),student.getData().getDataId(),1);

                            }catch (Exception e){
                                showMEG();
                            }
                        }
                    });
                    break;
                case 2://巡视
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //签到//发送请求给后台签到
                                qmuiTipDialog = new QMUITipDialog.Builder(getActivity())
                                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                                        .setTipWord("巡视签到中...")
                                        .create();
                                qmuiTipDialog.show();
                                String p=null;
                                if (student.getType()==1){
                                    p=student.getData().getDataName();
                                }else if (student.getType()==2){
                                    p="楼层签到";
                                }else if (student.getType()==3){
                                    p="房间签到";
                                }else if (student.getType()==4){
                                    p="床位签到";
                                }
                                link_complete(student.getType()+"",p,JSONObject.toJSONString(student.getData()),student.getData().getDataType());
                            }catch (Exception e){
                                showMEG();
                            }
                        }
                    });

                    break;
                case 3://下班
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //签到//发送请求给后台签到
                                qmuiTipDialog = new QMUITipDialog.Builder(getActivity())
                                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                                        .setTipWord("下班签到中...")
                                        .create();
                                qmuiTipDialog.show();
                                link_completeSB(student.getType(),student.getData().getDataName(),student.getData().getDataId(),2);

                            }catch (Exception e){
                                showMEG();
                            }
                        }
                    });
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
            showMEG();
        }

        Log.d("Fragment1", msgWarp.toString()+"收到的扫码数据");

    }


    private void showMEG(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                QMUITipDialog qmuiTipDialog1 = new QMUITipDialog.Builder(Fragment1.this.getActivity())
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                        .setTipWord("你扫错二维码了")
                        .create();
                qmuiTipDialog1.show();
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            qmuiTipDialog1.dismiss();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, 1800);
            }
        });
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
        recyclerView=view.findViewById(R.id.recyclerview);
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
        gdfgd=view.findViewById(R.id.gdfgd);
        button1.setRadius(QMUIDisplayHelper.dp2px(MyApplication.myApplication, 6));
        button1.setChangeAlphaWhenPress(true);//点击改变透明度
        button2.setRadius(QMUIDisplayHelper.dp2px(MyApplication.myApplication, 6));
        button2.setChangeAlphaWhenPress(true);//点击改变透明度
        button3.setRadius(QMUIDisplayHelper.dp2px(MyApplication.myApplication, 6));
        button3.setChangeAlphaWhenPress(true);//点击改变透明度
        adapter= new BianQianAdapter(R.layout.fdsfsdrewrw, jPushMSGBeans);
        View view1= LayoutInflater.from(getActivity()).inflate(R.layout.anull_data,null);
        adapter.setEmptyView(view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {

            }
        });

        link_getUnread();


        new Thread(new Runnable() {
            @Override
            public void run() {
                jPushMSGBeans.clear();
                jPushMSGBeans.addAll(jPushMSGBeanBox.query().orderDesc(JPushMSGBean_.time2).build().find());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gdfgd.setText("共"+jPushMSGBeans.size()+"条");
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();

        return view;
    }


    public static class BianQianAdapter extends BaseQuickAdapter<JPushMSGBean, BaseViewHolder>  {


        public BianQianAdapter(int layoutResId, @Nullable List<JPushMSGBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, JPushMSGBean taskBean) {
            baseViewHolder.setText(R.id.title,taskBean.getMessage());
            baseViewHolder.setText(R.id.time,DateUtils.timet(taskBean.getTime()+""));
            TextView textView=baseViewHolder.getView(R.id.title);
            textView.setSelected(true);

        }
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


    private void link_complete(String type,String typeName,String signQRData,int dataType) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        org.json.JSONObject object = new org.json.JSONObject();
        try {
            object.put("type", type);
            object.put("typeName", typeName);
            object.put("signQRData", signQRData);
            object.put("dataType", dataType);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("LoginActivity", object.toString()+"");
        RequestBody body = RequestBody.create(object.toString(), JSON);
        Request.Builder requestBuilder = new Request.Builder()
                .header("token", MyApplication.myApplication.getToken())
                .post(body)
                .url(Consts.URL + "/api/signIn/add");
        // step 3：创建 Call 对象
        Call call = MyApplication.okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求失败" + e.getMessage());
                if (getActivity()!=null){
                    ToastUtils.setMessage("网络请求失败", recyclerView);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (qmuiTipDialog != null)
                                qmuiTipDialog.dismiss();
                        }
                    });
                }

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("AllConnects", "请求成功" + call.request().toString());
                //获得返回体
                try {
                    if (getActivity()!=null)
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (qmuiTipDialog != null)
                                    qmuiTipDialog.dismiss();
                            }
                        });
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("LoginActivity", ss);
                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    ErrorBean logingBe = gson.fromJson(jsonObject, ErrorBean.class);
                    if (logingBe.isSuccess()) {
                        if (logingBe.getCode() == 1) {
                            if (getActivity()!=null)
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        qmuiTipDialog = new QMUITipDialog.Builder(getActivity())
                                                .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                                                .setTipWord("签到成功")
                                                .create();
                                        qmuiTipDialog.show();
                                        recyclerView.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (qmuiTipDialog != null)
                                                    qmuiTipDialog.dismiss();
                                            }
                                        }, 1800);

                                    }
                                });
                        } else {
                            ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(), recyclerView);
                        }
                    } else {
                        if (logingBe.getCode() == 102) {
                            //token过期
                            DialogManager.getAppManager().showToken();
                        }else {
                            if (getActivity()!=null)
                                ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(), recyclerView);
                        }
                    }
                } catch (Exception e) {
                    Log.d("AllConnects", e.getMessage() + "异hhh常");

                }
            }
        });
    }

    private void link_completeSB(int type,String dataName,long dataId,int modle) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        org.json.JSONObject object = new org.json.JSONObject();
        org.json.JSONObject object1 = new org.json.JSONObject();
        try {
            object1.put("type",type);
            object1.put("mold", modle);
            object1.put("dataName",dataName);
            object1.put("dataId",dataId);
            object.put("params", object1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("上班扫码：", object.toString()+"");
        RequestBody body = RequestBody.create(object.toString(), JSON);
        Request.Builder requestBuilder = new Request.Builder()
                .header("token", MyApplication.myApplication.getToken())
                .post(body)
                .url(Consts.URL + "/api/nurse/record/scanCode");
        // step 3：创建 Call 对象
        Call call = MyApplication.okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求失败" + e.getMessage());
                if (getActivity()!=null){
                    ToastUtils.setMessage("网络请求失败", recyclerView);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (qmuiTipDialog != null)
                                qmuiTipDialog.dismiss();
                        }
                    });
                }

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("AllConnects", "请求成功" + call.request().toString());
                //获得返回体
                try {
                    if (getActivity()!=null)
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (qmuiTipDialog != null)
                                    qmuiTipDialog.dismiss();
                            }
                        });
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("LoginActivity", ss+"上班扫码返回");
                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    IKjdd logingBe = gson.fromJson(jsonObject, IKjdd.class);
                    if (logingBe.isSuccess()) {
                        if (logingBe.getCode() == 1) {
                            if (getActivity()!=null)
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (modle==1){
                                            StringBuilder  tit = new StringBuilder();
                                            if (type==3){
                                                tit.append("已提取“").append(dataName).append("”房间任务\n");
                                                for (IKjdd.ResultDTO resultDTO : logingBe.getResult()) {
                                                    tit.append(resultDTO.getElderName());
                                                    tit.append(" ");
                                                    if (resultDTO.getElderSex()==1){
                                                        tit.append("男");
                                                    }else {
                                                        tit.append("女");
                                                    }
                                                    tit.append(" ");
                                                    tit.append(resultDTO.getElderAge()).append("岁");
                                                    tit.append("\n");
                                                }
                                            }
                                            if (type==4){
                                                tit.append("已提取“").append(dataName).append("”长者任务\n");
                                                for (IKjdd.ResultDTO resultDTO : logingBe.getResult()) {
                                                    tit.append(resultDTO.getElderName());
                                                    tit.append(" ");
                                                    if (resultDTO.getElderSex()==1){
                                                        tit.append("男");
                                                    }else {
                                                        tit.append("女");
                                                    }
                                                    tit.append(" ");
                                                    tit.append(resultDTO.getElderAge()).append("岁");
                                                    tit.append("\n");
                                                }
                                            }
                                            new CommomDialog2(getContext(), R.style.dialogs2, tit.toString(), new CommomDialog2.OnCloseListener() {
                                                @Override
                                                public void onClick(Dialog dialog, boolean confirm) {
                                                    // Log.d("DAFragment3", "confirm:" + confirm);
                                                    if (confirm) {
                                                        //退出动作
                                                        dialog.dismiss();
                                                    }
                                                }
                                            }).setTitle("上班签到").setPositiveButton("确定").show();
                                            EventBus.getDefault().post(new AAbb(""));
                                        }else {
                                            new CommomDialog2(getContext(), R.style.dialogs2, "下班签到成功", new CommomDialog2.OnCloseListener() {
                                                @Override
                                                public void onClick(Dialog dialog, boolean confirm) {
                                                    // Log.d("DAFragment3", "confirm:" + confirm);
                                                    if (confirm) {
                                                        //退出动作
                                                        dialog.dismiss();
                                                    }
                                                }
                                            }).setTitle("下班签到").setPositiveButton("确定").show();
                                            EventBus.getDefault().post(new AAbb2(""));
                                        }
                                    }
                                });
                        } else {
                            ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(), recyclerView);
                        }
                    } else {
                        if (logingBe.getCode() == 102) {
                            //token过期
                            DialogManager.getAppManager().showToken();
                        }else {
                            if (getActivity()!=null)
                                ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(), recyclerView);
                        }
                    }
                } catch (Exception e) {
                    Log.d("AllConnects", e.getMessage() + "异hhh常");

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
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       List<JPushMSGBean> jPushMSGBeanList= jPushMSGBeanBox.query().less(JPushMSGBean_.time2,System.currentTimeMillis()-604800000).build().find();
                        for (JPushMSGBean bean : jPushMSGBeanList) {
                            Log.d("Fragment1", "删掉过期7天的推送:" + jPushMSGBeanBox.remove(bean));
                        }
                    }
                }).start();
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
