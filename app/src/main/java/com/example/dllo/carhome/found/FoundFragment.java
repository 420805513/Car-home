package com.example.dllo.carhome.found;


import android.support.v7.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.UrlList;

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

                FoundFragmentAdapter adapter = new FoundFragmentAdapter();
                adapter.setFoundFragmentBean(addType(response));
                rv.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

    });

    }
    public FoundFragmentBean addType(FoundFragmentBean foundFragmentBean) {
        int type = -1;
        for (int i = 0;i < foundFragmentBean.getResult().getCardlist().size();i++) {
            switch (i) {
                case 6:
                type = 3;
                break;
                case 7:
                    type = 6;
                    break;
                case 8:
                    type = 3;
                    break;
                case 9:
                    type = 7;
                    break;
                case 10:
                    type = 10;
                    break;
                case 11:
                    type = 8;
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
