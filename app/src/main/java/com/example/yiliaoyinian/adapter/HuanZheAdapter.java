package com.example.yiliaoyinian.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.yiliaoyinian.Beans.HuanZheBean0;
import com.example.yiliaoyinian.Beans.Lojkdd;
import com.example.yiliaoyinian.R;
import com.example.yiliaoyinian.utils.DateUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HuanZheAdapter extends BaseQuickAdapter<Lojkdd.ResultDTO.DataDTO, BaseViewHolder> implements LoadMoreModule {


    public HuanZheAdapter(int layoutResId, @Nullable List<Lojkdd.ResultDTO.DataDTO> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Lojkdd.ResultDTO.DataDTO taskBean) {
        try {
            baseViewHolder.setText(R.id.fanghao,taskBean.getRoomName());
            baseViewHolder.setText(R.id.chuanghao,taskBean.getElderly().getBedName());
            baseViewHolder.setText(R.id.logo,taskBean.getElderly().getBuildName());
            baseViewHolder.setText(R.id.huanzhe,taskBean.getElderly().getElderName());
            baseViewHolder.setText(R.id.idid,taskBean.getElderly().getId()+"");
            baseViewHolder.setText(R.id.ruyuanshijian,taskBean.getElderly().getDoctorName());
            if (taskBean.getElderly().getElderSex()==1){
                baseViewHolder.setText(R.id.sex,"男");
            }else {
                baseViewHolder.setText(R.id.sex,"女");
            }
            if (taskBean.getElderly().getCheckInTime()==0){
                baseViewHolder.setText(R.id.zhuzhi, "暂未填写");
            }else {
                baseViewHolder.setText(R.id.zhuzhi, DateUtils.time3(taskBean.getElderly().getCheckInTime()+""));
            }
            baseViewHolder.setText(R.id.bingqing,"");
        }catch (Exception e){
            e.printStackTrace();
        }




//        Glide.with(mContext)
//                .load(item.getHeadImage())
//                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
//                .into((ImageView) helper.getView(R.id.touxiang));
//        //RequestOptions.bitmapTransform(new CircleCrop())//圆形
        //RequestOptions.bitmapTransform(new RoundedCorners( 5))//圆角
    }
}
