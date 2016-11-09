package com.example.dllo.carhome.choosecar.newcar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/9.
 */
public class NewCarFragmentListViewBodyAdapter extends BaseAdapter{
    NewCarFragmentListBean.ResultBean.BrandlistBean listBean;
    private CommonVH viewHolder;

    public void setListBean(NewCarFragmentListBean.ResultBean.BrandlistBean listBean) {
        this.listBean = listBean;
    }
    public NewCarFragmentListViewBodyAdapter(){

    }

    @Override
    public int getCount() {
        return listBean.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return listBean.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_choosecar_new_car_body_lv);
        viewHolder.setImage(R.id.iv_choose_car_new_car_list,listBean.getList().get(position).getImgurl())
                .setText(R.id.tv_choose_car_new_car_name,listBean.getList().get(position).getName());
        return viewHolder.getItemView();
    }
}
