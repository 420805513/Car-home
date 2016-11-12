package com.example.dllo.carhome.found;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.UrlList;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;

/**
 * Created by dllo on 16/10/24.
 */
public class FoundFragment extends BaseFragment {
    private RecyclerView rv;
    @Override
    protected int getLayout() {
        return R.layout.fragment_found;
    }

    @Override
    protected void initView() {
        rv = bindView(R.id.rv_found);

    }

    @Override
    protected void initData() {
        GsonRequest<FoundFragmentBean> gsonRequest = new GsonRequest<FoundFragmentBean>(FoundFragmentBean.class, UrlList.URL_FIND, new Response.Listener<FoundFragmentBean>() {
            @Override
            public void onResponse(FoundFragmentBean response) {
                Log.d("FoundFragment123", "请求下来了");
                FoundFragmentAdapter adapter = new FoundFragmentAdapter();
                adapter.setFoundFragmentBean(addType(response));
                rv.setAdapter(adapter);

                GridLayoutManager gridM=new GridLayoutManager(getContext(),1);
                rv.setLayoutManager(gridM);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("FoundFragment456", "没有请求下来数据");
            }

    });
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }
    public FoundFragmentBean addType(FoundFragmentBean foundFragmentBean) {
        int type = -1;
        for (int i = 0;i < foundFragmentBean.getResult().getCardlist().size();i++) {
            switch (i) {
                case 0:
                    type = 0;
                    break;
                case 1:
                    type = 1;
                    break;
                case 2:
                    type = 2;
                    break;
                case 3:
                    type = 3;
                    break;
                case 4 :
                    type = 4;
                    break;
                case 5:
                    type = 5;
                    break;
                case 6:
                    type = 6;
                    break;
                case 7:
                    type = 6;
                    break;
                case 8:
                    type = 7;
                    break;
                default:
                    type = i;
                    break;
            }
            foundFragmentBean.getResult().getCardlist().get(i).setType(type);
        }
        return foundFragmentBean;
    }
}
