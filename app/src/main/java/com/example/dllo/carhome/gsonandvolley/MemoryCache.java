package com.example.dllo.carhome.gsonandvolley;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by dllo on 16/10/31.
 * ImageLoader 使用内存缓存,喵
 */
public class MemoryCache implements ImageLoader.ImageCache {
    // 用法和Hashmap差不多吧
    private LruCache<String,Bitmap> mCache;
    public MemoryCache() {
        int maxSize = (int) (Runtime.getRuntime().maxMemory() / 8);
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return super.sizeOf(key, value);
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url,bitmap);

    }
}
