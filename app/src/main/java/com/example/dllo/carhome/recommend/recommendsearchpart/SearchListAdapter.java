package com.example.dllo.carhome.recommend.recommendsearchpart;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/15.
 */
public class SearchListAdapter extends BaseAdapter{
    private SearchBean searchBean;
    private CommonVH viewHolder;

    public void setSearchBean(SearchBean searchBean) {
        this.searchBean = searchBean;
    }

    @Override
    public int getCount() {
        return searchBean.getResult().getWordlist().size();
    }

    @Override
    public Object getItem(int position) {
        return searchBean.getResult().getWordlist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.activity_recommend_search_list_item);
        viewHolder.setText(R.id.tv_recommend_search_name,searchBean.getResult().getWordlist().get(position).getName());
        return viewHolder.getItemView();
    }
}
