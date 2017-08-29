package com.example.asus.cehua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        x.view().inject(this);
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setFadeEnabled(true);
        menu.setBehindWidth(600);
        menu.setTouchModeAbove ( SlidingMenu. TOUCHMODE_FULLSCREEN ) ;
        menu.attachToActivity(MainActivity.this,SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setFadeDegree(1f);
        menu.setFadeEnabled(true);
        menu.setMenu(R.layout.men);
        RequestParams params = new RequestParams("http://v.juhe.cn/toutiao/index?type=yule&&key=22a108244dbb8d1f49967cd74a0c144d");
      //  params.addQueryStringParameter("type","yule");
      //  params.addQueryStringParameter("key","22a108244dbb8d1f49967cd74a0c144d");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result
                Toast.makeText(MainActivity.this,"结果为++"+result, Toast.LENGTH_SHORT).show();
                System.out.println("结果为++"+result);
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
