package com.example.dllo.carhome.choosecar.newcar;

import android.view.View;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.UrlList;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by dllo on 16/11/8.
 */
public class NewCarFragment extends BaseFragment {
    private ListView lv;
    private StickyListHeadersListView mainlv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_choosecar_new_car;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_choose_car_new_car_title);
        mainlv = bindView(R.id.lv_choose_car_new_car_main);


    }

    @Override
    protected void initData() {

        GsonRequest<NewCarFragmentListBean> gsonRequest = new GsonRequest<NewCarFragmentListBean>(NewCarFragmentListBean.class, UrlList.URL_CHOOSE_NEWCAR, new Response.Listener<NewCarFragmentListBean>() {
            @Override
            public void onResponse(NewCarFragmentListBean response) {
                NewCarFragmentListMainAdapter mainAdapter = new NewCarFragmentListMainAdapter();
                NewCarFragmentListAdapter adapter = new NewCarFragmentListAdapter();
                mainAdapter.setNewCarFragmentListBean(response);

                adapter.setNewCarFragmentListBean(response);
                mainlv.setAdapter(mainAdapter);
                lv.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

    });
        VolleySingleton.getInstance().addRequest(gsonRequest);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainlv.setSelection(position);
            }
        });
        mainlv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                  lv.smoothScrollToPositionFromTop(firstVisibleItem,0);
            }
        });





    }
}
