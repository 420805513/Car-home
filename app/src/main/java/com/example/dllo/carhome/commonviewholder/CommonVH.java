package com.example.dllo.carhome.commonviewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.carhome.gsonandvolley.VolleySingleton;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/10/31.
 * 通用的ViewHolder
 */
public class CommonVH extends RecyclerView.ViewHolder{
    // SparesArray 用法和HashMap一样,
    // 但是key 固定是 int 类型
    // 用它来存放所有的View, key 就是View的id
    private SparseArray<View> views;
    private View                                                                                                itemView; // 行布局

    public CommonVH(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }

    /**
     * 通过View的id来获得指定View
     * 如果该View没有赋值,就先执行findViewById
     * 使用泛型来取消强转
     * @param id
     * @return 指定View
     */
    public<T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            // 证明SparseArray里没有这个View
            view = itemView.findViewById(id);
            views.put(id,view);
        }
        return (T) view;
    }
    // 专门给ListView使用的方法
    public static CommonVH getViewHolder(View itemView,ViewGroup parent,int itemId) {
        CommonVH commonVH;
        if (itemView == null) {
            Context context = parent.getContext();
            itemView = LayoutInflater.from(context).inflate(itemId,parent,false);
            commonVH = new CommonVH(itemView);
            itemView.setTag(commonVH);
        } else {
            commonVH = (CommonVH) itemView.getTag();
        }
        return commonVH;

    }
    // 专门给RecyclerView使用的方法
    public static CommonVH getViewHolder(ViewGroup parent,int itemId) {
        return getViewHolder(null,parent,itemId);
    }

    public View getItemView() {
        return itemView;
    }

    /********* ViewHolder 设置数据的方法**********/
    // 设置文字
    public CommonVH setText(int id, String
            text) {
        TextView textView = getView(id);
        textView.setText(text);
        return this;
    }

    // 设置图片
    public CommonVH setImage(int id,int imgId) {
        ImageView imageView = getView(id);
        imageView.setImageResource(imgId);
        return this;
    }
    public CommonVH setImage(int id,String url) {
        ImageView imageView = getView(id);
        //TODO 网络请求图片
        VolleySingleton.getInstance().getImage(url,imageView);
        return this;
    }
    // 设置行布局点击事件
    public CommonVH setItemClick(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
        return this;
    }
    // 设置点击事件
    public CommonVH setViewClick(int id, View.OnClickListener listener) {
        getView(id).setOnClickListener(listener);
        return this;
    }

}
