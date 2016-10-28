package com.example.dllo.carhome.recommend.listviewandinside;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.carhome.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/27.
 * ListView的Adapter
 */
public class RecommendPageListViewAdapter extends BaseAdapter{
    Context context;
    private ArrayList<RecommendPageListViewBean.ResultBean.HeadlineinfoBean> arrayList;

    public RecommendPageListViewAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<RecommendPageListViewBean.ResultBean.HeadlineinfoBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_recommend_listview,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(arrayList.get(position).getTitle());
        viewHolder.playcount.setText(arrayList.get(position).getReplycount());
        viewHolder.date.setText(arrayList.get(position).getTime());
        Picasso.with(context).load(arrayList.get(position).getSmallpic()).into(viewHolder.imageView);
        return convertView;
    }

    private class ViewHolder {
        private TextView title;
        private TextView playcount;
        private TextView date;
        private ImageView imageView;
        public ViewHolder(View convertView) {
            title = (TextView) convertView.findViewById(R.id.tv_listview_title);
            playcount = (TextView) convertView.findViewById(R.id.tv_listview_playcount);
            date = (TextView) convertView.findViewById(R.id.tv_listview_date);
            imageView = (ImageView) convertView.findViewById(R.id.iv_listview_picture);

        }
    }
}
