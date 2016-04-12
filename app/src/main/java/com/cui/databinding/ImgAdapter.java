package com.cui.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.cui.databinding.entity.ResponseEntity;
import com.cui.mvvms.R;
import com.cui.mvvms.databinding.ItemImgBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuiyang on 16/4/11.
 */
public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.BindingHolder> {

    List<ResponseEntity.SubjectsEntity> list = new ArrayList<ResponseEntity.SubjectsEntity>();
    private Context mContext;

    public ImgAdapter(List<ResponseEntity.SubjectsEntity> list) {
        this.list = list;
    }

    @Override
    public ImgAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        ItemImgBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_img, parent, false);
        BindingHolder holder = new BindingHolder(binding.getRoot());
        holder.binding = binding;
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ResponseEntity.SubjectsEntity entity = list.get(position);
        Glide.with(mContext)
                .load(entity.getImages().getLarge())
                .fitCenter()
                .into(holder.binding.itemImg);
        holder.binding.setVariable(com.cui.mvvms.BR.entity, entity);
        holder.binding.executePendingBindings();
//        holder.binding.setEntity(entity);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder {
        public ItemImgBinding binding;

        public BindingHolder(View v) {
            super(v);
        }
    }
}
