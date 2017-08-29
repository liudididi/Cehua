package com.example.asus.cehua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import Adapter.Myxlv;
import Bean.News;
import view.xlistview.XListView;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.xlv)
    XListView xlv;
    private List<News> list=new ArrayList<>();
    private Myxlv ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        x.view().inject(this);
        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
    /*    SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setFadeEnabled(true);
        menu.setBehindWidth(600);
        menu.attachToActivity(MainActivity.this,SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setFadeDegree(1f);
        menu.setFadeEnabled(true);
        menu.setMenu(R.layout.men);*/
        RequestParams params = new RequestParams("http://v.juhe.cn/toutiao/index?type=top&&key=22a108244dbb8d1f49967cd74a0c144d");
      //  params.addQueryStringParameter("type","yule");
      //  params.addQueryStringParameter("key","22a108244dbb8d1f49967cd74a0c144d");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
               try {
                    JSONObject json=new JSONObject(result);
                    JSONObject result1 = json.getJSONObject("result");
                    JSONArray data = result1.getJSONArray("data");
                    for (int i = 0; i <data.length() ; i++) {
                        JSONObject d= (JSONObject) data.get(i);
                        News news=new News();
                        news.title=d.optString("title");
                        System.out.println(news.title);
                        news.thumbnail_pic_s=d.optString("thumbnail_pic_s");
                        list.add(news);
                    }
                    if(list!=null){
                        ad = new Myxlv(MainActivity.this,list);
                        xlv.setAdapter(ad);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {

            }
        });

    }


}
