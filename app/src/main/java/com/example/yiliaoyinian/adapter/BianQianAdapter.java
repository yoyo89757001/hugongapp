package com.example.yiliaoyinian.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.yiliaoyinian.Beans.ZhiBanssBean;
import com.example.yiliaoyinian.R;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BianQianAdapter extends BaseQuickAdapter<ZhiBanssBean.ResultDTO.NoteListBean, BaseViewHolder> implements LoadMoreModule {


    public BianQianAdapter(int layoutResId, @Nullable List<ZhiBanssBean.ResultDTO.NoteListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ZhiBanssBean.ResultDTO.NoteListBean taskBean) {
        baseViewHolder.setText(R.id.title,taskBean.getNoteTitle());
        baseViewHolder.setText(R.id.content_tv,taskBean.getNoteContent());


//        Glide.with(mContext)
//                .load(item.getHeadImage())
//                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
//                .into((ImageView) helper.getView(R.id.touxiang));
//        //RequestOptions.bitmapTransform(new CircleCrop())//圆形
        //RequestOptions.bitmapTransform(new RoundedCorners( 5))//圆角
    }
}
