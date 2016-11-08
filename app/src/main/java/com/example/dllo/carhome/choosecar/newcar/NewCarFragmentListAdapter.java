package com.example.dllo.carhome.choosecar.newcar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/8.
 */
public class NewCarFragmentListAdapter extends BaseAdapter {
    private NewCarFragmentListBean newCarFragmentListBean;
    private CommonVH viewHolder;

    public void setNewCarFragmentListBean(NewCarFragmentListBean newCarFragmentListBean) {
        this.newCarFragmentListBean = newCarFragmentListBean;
    }

    @Override
    public int getCount() {
        return newCarFragmentListBean.getResult().getBrandlist().size();
    }

    @Override
    public Object getItem(int position) {
        return newCarFragmentListBean.getResult().getBrandlist().get(position).getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_choosecar_new_car_list_item);
        viewHolder.setText(R.id.tv_choose_car_new_car_name,newCarFragmentListBean.getResult().getBrandlist().get(position).getList().get(position).getName())
                .setImage(R.id.iv_choose_car_new_car_icon,newCarFragmentListBean.getResult().getBrandlist().get(position).getList().get(position).getImgurl());
        return viewHolder.getItemView();
    }
}
