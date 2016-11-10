package com.example.dllo.carhome.gsonandvolley;

import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.myapp.MyAPP;

/**
 * volleySingleton 单例8
 * Created by dllo on 16/10/31.
 */
public class VolleySingleton {
    private static VolleySingleton volleySingleton;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private VolleySingleton() {
        mRequestQueue = Volley.newRequestQueue(MyAPP.getContext());
        mImageLoader = new ImageLoader(mRequestQueue,new MemoryCache());
    }

    public static VolleySingleton getInstance() {
        if (volleySingleton == null) {
            synchronized (VolleySingleton.class) {
                if (volleySingleton == null) {
                    volleySingleton = new VolleySingleton();
                }
            }
        }
        return volleySingleton;
    }

    public void getImage(String url, ImageView imageView) {
        mImageLoader.get(url,ImageLoader.getImageListener(imageView, R.mipmap.ic_launcher,R.mipmap.huaji));
    }
    public RequestQueue getmRequestQueue () {
        return mRequestQueue;
    }
    // 添加请求
    public <T> void addRequest (Request<T> request) {
        mRequestQueue.add(request);
    }

}
