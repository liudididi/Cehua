package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.cehua.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import Bean.News;

/**
 * Created by asus on 2017/8/29.
 */

public class Myxlv extends BaseAdapter{
    private Context context;
    private  List<News> list;

    public Myxlv(Context context, List<News> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = View.inflate(context, R.layout.xlv, null);
        }
        TextView tv_title = view.findViewById(R.id.tv_title);
        ImageView img_tu= view.findViewById(R.id.img_tu);
        ImageLoader.getInstance().displayImage(list.get(i).thumbnail_pic_s,img_tu);
        tv_title.setText(list.get(i).title);
        return view;
    }
}
