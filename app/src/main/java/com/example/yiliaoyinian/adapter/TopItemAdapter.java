package com.example.yiliaoyinian.adapter;





import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.yiliaoyinian.Beans.TopTieleBean;
import com.example.yiliaoyinian.R;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TopItemAdapter extends BaseQuickAdapter<TopTieleBean, BaseViewHolder> implements LoadMoreModule {


    public TopItemAdapter(int layoutResId, @Nullable List<TopTieleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, TopTieleBean taskBean) {
        baseViewHolder.setText(R.id.name,taskBean.getName());

    }
}
