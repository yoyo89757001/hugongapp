package com.example.yiliaoyinian.ui.fragmengmain;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import com.example.yiliaoyinian.Beans.Kdaasd;
import com.example.yiliaoyinian.Beans.RKLBENbean;
import com.example.yiliaoyinian.MyApplication;
import com.example.yiliaoyinian.R;
import com.example.yiliaoyinian.adapter.UnFinshAdapter;
import com.example.yiliaoyinian.utils.Consts;
import com.example.yiliaoyinian.utils.DialogManager;
import com.example.yiliaoyinian.utils.GsonUtil;
import com.example.yiliaoyinian.utils.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnFinshFragment extends Fragment {
    private RecyclerView recyclerView;
    private UnFinshAdapter adapter;
    private List<Kdaasd> taskBeanList=new ArrayList<>();
    private SmartRefreshLayout refreshLayout;
    private static final ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();


    public UnFinshFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fuwu_fragment_task, container, false);
        refreshLayout=view.findViewById(R.id.refreshLayout);
        EventBus.getDefault().register(this);
        recyclerView=view.findViewById(R.id.recyclerview);
        adapter=new UnFinshAdapter(R.layout.unfinsh_fragment1,taskBeanList);
        // 获取模块
       // adapter.getLoadMoreModule();
        adapter.getLoadMoreModule().setAutoLoadMore(false);//第一次不调用加载更多方法
        adapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);//加载完成不满一屏自动加载
        LinearLayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        View view1= LayoutInflater.from(getActivity()).inflate(R.layout.anull_data,null);
        adapter.setEmptyView(view1);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NotNull RefreshLayout refreshlayout) {
                link_getPendService();
            }
        });

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Log.d("Fragment1_1", "position:" + position);


            }
        });

        link_getPendService();


        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void wxMSG(String msgWarp){
        if (msgWarp.equals("UnFinshFragment")){
            link_getPendService();
        }
    }


    private Call call;
    private void link_getPendService() {
        Request.Builder requestBuilder = new Request.Builder()
                .header("token", MyApplication.myApplication.getToken())
                .get()
                .url(Consts.URL+"/api/nurse/mission/list");
        // step 3：创建 Call 对象
        call = MyApplication.okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求失败" + e.getMessage()+call.request().url());
                if (getActivity()!=null){
                    //ToastUtils.setMessage("网络请求失败",recyclerView);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            refreshLayout.finishRefresh();
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("AllConnects", "请求成功" + call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                   String ss = body.string().trim();
                    Log.d("LoginActivity", "未处理服务:"+ss);
                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    RKLBENbean logingBe = gson.fromJson(jsonObject, RKLBENbean.class);
                    if (logingBe.isSuccess()){
                        if (logingBe.getCode()==1 && logingBe.getResult()!=null){
                            concurrentHashMap.clear();
                            for (RKLBENbean.ResultDTO resultDTO : logingBe.getResult()) {
                                if (concurrentHashMap.containsKey(resultDTO.getPeriod())){
                                   String temp= concurrentHashMap.get(resultDTO.getPeriod());
                                    concurrentHashMap.put(resultDTO.getPeriod(),temp+"\n"+resultDTO.getProjectName());
                                }else {
                                    concurrentHashMap.put(resultDTO.getPeriod(),resultDTO.getProjectName());
                                }
                            }
                            taskBeanList.clear();
                            for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                                taskBeanList.add(new Kdaasd(entry.getKey(),entry.getValue()));
                               // System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                            }
                            if (getActivity()!=null){
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {

                                            adapter.notifyDataSetChanged();

                                        }catch (Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }else {
                            if (getActivity()!=null)
                                ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(),recyclerView);
                        }
                    }else {
                        if (logingBe.getCode()==102){
                            Log.d("UnFinshFragment", "进来");
                            //token过期
                            DialogManager.getAppManager().showToken();
                        }else {
                            if (getActivity()!=null)
                                ToastUtils.setMessage(jsonObject.get("errorMsg").getAsString(),recyclerView);
                        }

                    }

                } catch (Exception e) {
                    Log.d("AllConnects", e.getMessage() + "异常");
//                    AppManager.getAppManager().currentActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            QMUITipDialog qmuiTipDialog2 = new QMUITipDialog.Builder(AppManager.getAppManager().currentActivity())
//                                    .setIconType(QMUITipDialog.Builder.ICON_TYPE_NOTHING)
//                                    .setTipWord("后台数据异常")
//                                    .create();
//                            qmuiTipDialog2.show();
//                            recyclerView.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    qmuiTipDialog2.dismiss();
//                                }
//                            }, 2500);
//                        }
//                    });

                }finally {
                    if (getActivity()!=null){
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshLayout.finishRefresh();
                            }
                        });
                    }
                }
            }
        });
    }



    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }
}
