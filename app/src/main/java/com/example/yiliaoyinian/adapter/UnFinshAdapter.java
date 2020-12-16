package com.example.yiliaoyinian.adapter;


import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.yiliaoyinian.Beans.Kdaasd;
import com.example.yiliaoyinian.Beans.UnFinshBean;
import com.example.yiliaoyinian.R;
import com.example.yiliaoyinian.utils.DateUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;



public class UnFinshAdapter extends BaseQuickAdapter<Kdaasd, BaseViewHolder> implements LoadMoreModule {


    public UnFinshAdapter(int layoutResId, @Nullable List<Kdaasd> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Kdaasd taskBean) {
        try {
            baseViewHolder.setText(R.id.title,taskBean.getTitle());
            baseViewHolder.setText(R.id.time,taskBean.getTime());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
