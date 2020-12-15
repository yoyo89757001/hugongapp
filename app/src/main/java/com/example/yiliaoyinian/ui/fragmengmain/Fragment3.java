package com.example.yiliaoyinian.ui.fragmengmain;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.yiliaoyinian.R;
import com.example.yiliaoyinian.utils.DateUtils;
import com.example.yiliaoyinian.views.RenWuFragmentPagerAdapter;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;



/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    TextView shijian,riqi,xingqi;
    View view1,view2;
    TextView renwu;
    LinearLayout l1;
    TextView zhangzhe;
    LinearLayout l2;
    ViewPager viewpage;
//    private List<ZhanShiDataBean.ResultBean.AbnormalListBean> taskBeanListzs = new ArrayList<>();
    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    //private SmartRefreshLayout refreshLayout;
   // private Vector<MachineBean.ResultBean> taskBeanList = new Vector<>();


    public Fragment3() {

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void wxMSG(String msgWarp){
        if (msgWarp.equals("timeiUpdate")){
            shijian.setText(DateUtils.ti(System.currentTimeMillis()+""));
            riqi.setText(DateUtils.times(System.currentTimeMillis()));
            xingqi.setText(DateUtils.getWeek(System.currentTimeMillis()));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        EventBus.getDefault().register(this);
        //  @OnClick({R.id.l1, R.id.l2, R.id.l3, R.id.l4, R.id.saoma})
        view.findViewById(R.id.l1).setOnClickListener(this);
        view.findViewById(R.id.l2).setOnClickListener(this);
        l1=view.findViewById(R.id.l1);
        l2=view.findViewById(R.id.l2);
        renwu=view.findViewById(R.id.renwu);
        zhangzhe=view.findViewById(R.id.zhangzhe);
        viewpage=view.findViewById(R.id.viewpage);
        shijian=view.findViewById(R.id.shijian);
        riqi=view.findViewById(R.id.riqi);
        xingqi=view.findViewById(R.id.xingqi);
        view1=view.findViewById(R.id.v11);
        view2=view.findViewById(R.id.v22);

//        refreshLayout=view.findViewById(R.id.refreshLayout);
//        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh(@NotNull RefreshLayout refreshlayout) {
//                link_getDeviceList();
//            }
//        });

        RenWuFragmentPagerAdapter renWuFragmentPagerAdapter = new RenWuFragmentPagerAdapter(getChildFragmentManager());
        viewpage.setAdapter(renWuFragmentPagerAdapter);
        //设置当前页的ID
        viewpage.setCurrentItem(0);
        //添加翻页监听事件
        viewpage.addOnPageChangeListener(this);
        viewpage.setOffscreenPageLimit(2);

        TextPaint tp3 = renwu.getPaint();
        tp3.setFakeBoldText(true);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(1100);
//                link_getDeviceList();
//            }
//        }).start();

        shijian.setText(DateUtils.ti(System.currentTimeMillis()+""));
        riqi.setText(DateUtils.times(System.currentTimeMillis()));
        xingqi.setText(DateUtils.getWeek(System.currentTimeMillis()));

        return view;
    }



//    private void link_getDeviceList() {
//        Request.Builder requestBuilder = new Request.Builder()
//                .header("token", MyApplication.myApplication.getToken())
//                .get()
//                .url(Consts.URL+"/api/deviceProduct/getDeviceList?deviceType=all");
//        // step 3：创建 Call 对象
//        Call call = MyApplication.okHttpClient.newCall(requestBuilder.build());
//        //step 4: 开始异步请求
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//                EventBus.getDefault().post(new ArrayList<MachineBean.ResultBean>());
//                link_getlumiList();
//                Log.d("AllConnects", "请求失败" + e.getMessage());
////                if (getActivity()!=null){
//                        // ToastUtils.setMessage("网络请求失败",recyclerView);
////                }
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("AllConnects", "请求成功" + call.request().toString());
//                //获得返回体
//                String ss=null;
//                MachineBean logingBe = null;
//                try {
//                    ResponseBody body = response.body();
//                    ss = body.string().trim();
//                    Log.d("LoginActivity", "获取设备数据"+ss);
//                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
//                    Gson gson = new Gson();
//                    logingBe = gson.fromJson(jsonObject, MachineBean.class);
//                    if (logingBe!=null && logingBe.isSuccess()){
//                        if (logingBe.getCode()==1 && logingBe.getResult()!=null){
//                                if (logingBe.getResult().size()>0){
//                                    logingBe.getResult().get(0).setType(1001);
//                                }
//                        }else {
//                            if (getActivity()!=null){
//                                ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(),zhangzhe);
//                            }
//                        }
//                    }else {
//                        if (logingBe.getCode()==102){
//                            //token过期
//                            DialogManager.getAppManager().showToken();
//                        }else {
//                            if (getActivity()!=null){
//                                ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(),zhangzhe);
//                            }
//                        }
//                    }
//                } catch (Exception e) {
//                    Log.d("AllConnects", e.getMessage() + "异常");
//                }finally {
//                    if (logingBe!=null){
//                        Log.d("Fragment3", "logingBe.getResult():" + logingBe.getResult());
//                        if (logingBe.getResult()==null){
//                            EventBus.getDefault().post(new ArrayList<MachineBean.ResultBean>());
//                        }else {
//                            EventBus.getDefault().post(logingBe.getResult());
//                        }
//                        Log.d("Fragment3", "发送");
//                    }
//                    link_getlumiList();
//                }
//            }
//        });
//    }
//
//    private MediaType JSONTYPE  = MediaType.parse("application/json");
//    private void link_getlumiList() {
//        JSONObject json =new  JSONObject();
//        try {
//            json.put("pinlessUser", MyApplication.myApplication.getSaveInfoBeanBox().get(123456).getPhone());
//            json.put("modelType", 1);
//        } catch (JSONException e) {
//           Log.d("Fragment3", e.getMessage()+"AllConnects");
//        }
//       // Log.d("Fragment3", "AllConnects1111");
//        Request.Builder requestBuilder = new Request.Builder()
//                .header("token", MyApplication.myApplication.getToken())
//                .post(RequestBody.create(json.toString(),JSONTYPE))
//                .url(Consts.URL2+"/app/lvmi/list");
//        // step 3：创建 Call 对象
//        Call call = MyApplication.okHttpClient.newCall(requestBuilder.build());
//        //step 4: 开始异步请求
//      //  Log.d("Fragment3", "AllConnects1111");
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d("AllConnects", "请求失败" + e.getMessage());
//                if (getActivity()!=null){
//                   // ToastUtils.setMessage("网络请求失败",recyclerView);
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            refreshLayout.finishRefresh();
//                        }
//                    });
//                }
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("AllConnects", "请求成功" + call.request().toString());
//                //获得返回体
//                String ss=null;
//                try {
//                    ResponseBody body = response.body();
//                    ss = body.string().trim();
//                    Log.d("AllConnects", "获取绿米设备数据"+ss);
//                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
//                    Gson gson = new Gson();
//                    LuMIDevBean logingBe = gson.fromJson(jsonObject, LuMIDevBean.class);
//                     if (logingBe.isSuccess()){
//                        if (logingBe.getCode()==1 && logingBe.getData()!=null){
//                            if (logingBe.getData().size()>0){
//                                    for (LuMIDevBean.DataDTO datum : logingBe.getData()) {
//                                        WGInfoSave save=MyApplication.myApplication.getWgInfoSaveBox().query().equal(WGInfoSave_.did,datum.getDid()).build().findFirst();
//                                        if (save==null){
//                                            WGInfoSave wgInfoSave=new WGInfoSave();
//                                            wgInfoSave.setModle(datum.getModel());
//                                            wgInfoSave.setWeizhi(datum.getPlace());
//                                            wgInfoSave.setName(datum.getName());
//                                            wgInfoSave.setState(datum.getStatus());
//                                            wgInfoSave.setFirmwareVersion(datum.getFirmwareVersion());
//                                            wgInfoSave.setDid(datum.getDid());
//                                            wgInfoSave.setParentDid(datum.getParentDid());
//                                            wgInfoSave.setModelType(datum.getModelType());
//                                            wgInfoSave.setPhoto(datum.getStr1());
//                                            wgInfoSave.setOPen(true);
//                                            wgInfoSave.setArgb("ffffff");
//                                            wgInfoSave.setLight(50);
//                                            wgInfoSave.setSoundValue(60);
//                                            wgInfoSave.setWeizhi("房间");
//                                            MyApplication.myApplication.getWgInfoSaveBox().put(wgInfoSave);
//                                        }
//                                    }
//                                   EventBus.getDefault().post(logingBe);
//                                }
//                        }
//                     }
//                } catch (Exception e) {
//                    Log.d("AllConnects", e.getMessage() + "异常");
//                }finally {
//                    if (getActivity()!=null){
//                       // ToastUtils.setMessage("网络请求失败",recyclerView);
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                refreshLayout.finishRefresh();
//                            }
//                        });
//                    }
//                }
//            }
//        });
//    }



    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();

    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }



    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        Log.d("Fragment1", "state:" + state);
        if (state == 2) {
            switch (viewpage.getCurrentItem()) {
                case PAGE_ONE: {
                    resetSelected();
                    TextPaint tp1 = renwu.getPaint();
                    tp1.setFakeBoldText(true);
                    renwu.setTextColor(Color.parseColor("#FF59B683"));
                    renwu.setTextSize(18);
                    view1.setVisibility(View.VISIBLE);
                    break;
                }
                case PAGE_TWO: {
                    resetSelected();
                    TextPaint tp1 = zhangzhe.getPaint();
                    tp1.setFakeBoldText(true);
                    zhangzhe.setTextColor(Color.parseColor("#FF59B683"));
                    zhangzhe.setTextSize(18);
                    view2.setVisibility(View.VISIBLE);
                    break;
                }
            }
        }
    }

    private void resetSelected() {
        renwu.setTextColor(Color.parseColor("#FFB6B6B6"));
        zhangzhe.setTextColor(Color.parseColor("#FFB6B6B6"));
        view1.setVisibility(View.GONE);
        view2.setVisibility(View.GONE);
        TextPaint tp1 = renwu.getPaint();
        tp1.setFakeBoldText(false);
        TextPaint tp2 = zhangzhe.getPaint();
        tp2.setFakeBoldText(false);
        renwu.setTextSize(15);
        zhangzhe.setTextSize(15);


    }





    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.l1:
                resetSelected();
                TextPaint tp1 = renwu.getPaint();
                tp1.setFakeBoldText(true);
                renwu.setTextColor(Color.parseColor("#FF59B683"));
                renwu.setTextSize(18);
                viewpage.setCurrentItem(PAGE_ONE);
                view1.setVisibility(View.VISIBLE);
                break;
            case R.id.l2:
                resetSelected();
                TextPaint tp2 = zhangzhe.getPaint();
                tp2.setFakeBoldText(true);
                zhangzhe.setTextColor(Color.parseColor("#FF59B683"));
                zhangzhe.setTextSize(18);
                viewpage.setCurrentItem(PAGE_TWO);
                view2.setVisibility(View.VISIBLE);
                break;
        }
    }
}
