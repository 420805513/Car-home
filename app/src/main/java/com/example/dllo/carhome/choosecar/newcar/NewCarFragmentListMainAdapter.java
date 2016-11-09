package com.example.dllo.carhome.choosecar.newcar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by dllo on 16/11/8.
 */
public class NewCarFragmentListMainAdapter extends BaseAdapter implements StickyListHeadersAdapter{
    private MyListview listView;
    private NewCarFragmentListBean newCarFragmentListBean;
    private CommonVH headViewHolder,bodyViewHolder;

    public void setNewCarFragmentListBean(NewCarFragmentListBean newCarFragmentListBean) {
        this.newCarFragmentListBean = newCarFragmentListBean;
    }

    @Override
    public long getHeaderId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return newCarFragmentListBean.getResult().getBrandlist().size();
    }

    @Override
    public Object getItem(int position) {
        return newCarFragmentListBean.getResult().getBrandlist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    // 头部
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        headViewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_choosecar_new_car_head_item);
        headViewHolder.setText(R.id.tv_choose_car_new_car_head,newCarFragmentListBean.getResult().getBrandlist().get(position).getLetter());
        return headViewHolder.getItemView();
    }
    // 主体
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        bodyViewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_choosecar_new_car_body_main);
        listView = (MyListview) bodyViewHolder.getItemView().findViewById(R.id.lv_choose_car_new_car_main_body);
        NewCarFragmentListBean.ResultBean.BrandlistBean listBean = newCarFragmentListBean.getResult().getBrandlist().get(position);
        NewCarFragmentListViewBodyAdapter adapter = new NewCarFragmentListViewBodyAdapter();
        adapter.setListBean(listBean);
        listView.setAdapter(adapter);
        return bodyViewHolder.getItemView();
    }


}
