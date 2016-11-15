package com.example.dllo.carhome.recommend.recommendsearchpart;

import android.content.SharedPreferences;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;

/**
 * Created by dllo on 16/11/15.
 */
public class RecommendSearchActivity extends BaseActivity implements View.OnClickListener, TextWatcher, AdapterView.OnItemClickListener {
    private TextView textViewCancel;
    private ListView lvSearch,lvHistory;
    private WebView webView;
    private EditText editText;
    private SearchBean searchBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_recommend_search;
    }

    @Override
    protected void initViews() {
        lvSearch = bindView(R.id.lv_recommend_search);
        lvSearch.setOnItemClickListener(this);
        lvHistory = bindView(R.id.lv_recommend_history);
        webView = bindView(R.id.wv_recommend_detail);
        textViewCancel = bindView(R.id.tv_recommend_search_cancel);
        editText = bindView(R.id.et_recommend_search);
        editText.addTextChangedListener(this);
//        editText.setOnFocusChangeListener(this);
        textViewCancel.setOnClickListener(this);

    }

    @Override
    protected void initData() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_recommend_search_cancel:
                finish();
                break;
        }
    }

//    @Override
//    public void onFocusChange(View v, boolean hasFocus) {
//        switch (v.getId()){
//            case R.id.et_recommend_search:
//                if (hasFocus){
//                    // 当搜索栏获得焦点
//                    lvSearch.setVisibility(View.VISIBLE);
//                    lvHistory.setVisibility(View.GONE);
//                    webView.setVisibility(View.GONE);
//                }
//                break;
//        }
//    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        lvSearch.setVisibility(View.VISIBLE);
        lvHistory.setVisibility(View.GONE);
        webView.setVisibility(View.GONE);
        String str = editText.getText().toString();
        // 文字栏不为空
        if (!str.isEmpty()) {
            GsonRequest<SearchBean> gsonRequest = new GsonRequest<SearchBean>(SearchBean.class, "http://mobilenc.app.autohome.com.cn/sou_v5.7.0/sou/suggestwords.ashx?pm=2&k=" + str + "&t=4", new Response.Listener<SearchBean>() {
                @Override
                public void onResponse(SearchBean response) {
                    // 正确
                    SearchListAdapter adapter = new SearchListAdapter();
                    adapter.setSearchBean(response);
                    searchBean = response;
                    lvSearch.setAdapter(adapter);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // 错误
                }

            });
            VolleySingleton.getInstance().addRequest(gsonRequest);
        } else {
            // 文字栏为空
            lvSearch.setVisibility(View.GONE);
            lvHistory.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       String str =  searchBean.getResult().getWordlist().get(position).getName();
        if (str != null) {
            lvSearch.setVisibility(View.GONE);
            lvHistory.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
            webView.loadUrl("http://sou.m.autohome.com.cn/h5/1.1/search.html?type=0&keyword=" + str + "&night=0&bbsid=0&lng=121.550912&lat=38.889734&nettype=5&netprovider=0");
//            SharedPreferences sp = getPreferences(MODE_PRIVATE);
//            SharedPreferences.Editor editor = sp.edit();
//            editor.putString("history",str);

        }
    }
}
