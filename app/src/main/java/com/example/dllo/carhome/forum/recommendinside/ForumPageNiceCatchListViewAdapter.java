package com.example.dllo.carhome.forum.recommendinside;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/7.
 */
public class ForumPageNiceCatchListViewAdapter  extends BaseAdapter{
    private CommonVH viewHolder;
    private static final String [] titles = { "媳妇当车模","美人'记'","论坛红人馆","论坛讲师","精挑细选","现身说法","高端阵地","电动车","汇买车"
            ,"行车点评","超级试驾员","海外购车","经典老车","妹子选车","优惠购车","原创大片","顶配风采","改装有理","养车有道",
            "首发阵营","新车直播","历史选题","摩友天地","蜜月之旅","甜蜜婚礼","摄影课堂","车友聚会","单车部落","杂谈俱乐部",
            "华北游记","西南游记","东北游记","西北游记","华中游记","华南游记","华东游记","港澳台游记","海外游记","沧海遗珠"
    };
    private static final String[] urls = {
            "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c104-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c110-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c172-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c230-p1-s30.json"
            , "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c121-p1-s30.json"
            , "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c106-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c118-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c210-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c199-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c198-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c168-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c113-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c109-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c191-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c196-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c107-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c105-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c122-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c194-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c119-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c112-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c120-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c184-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c108-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c124-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c123-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c185-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c186-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c214-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c218-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c223-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c221-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c222-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c224-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c219-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c225-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c226-p1-s30.json"
            ,"http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c212-p1-s30.json"};
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
      viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.activity_forum_nice_catch_list_view);
        viewHolder.setText(R.id.tv_listview_from_forum_nice_catch,titles[position]);
        viewHolder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(),ForumPageNiceCatchDetailListViewActivity.class);
                intent.putExtra("url",urls[position]);
                intent.putExtra("title",titles[position]);
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder.getItemView();
    }
}
