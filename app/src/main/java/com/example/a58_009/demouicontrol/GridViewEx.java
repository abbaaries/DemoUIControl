package com.example.a58_009.demouicontrol;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewEx extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridviewex);
        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));
    }
    class ImageAdapter extends BaseAdapter{     //繼承BaseAdapter

        int[] imageResIds={      //圖片資源建一個陣列
                R.drawable.img001,R.drawable.img002,R.drawable.img003,
                R.drawable.img004,R.drawable.img005,R.drawable.img006,
                R.drawable.img007,R.drawable.img008,R.drawable.img009,
                R.drawable.img010,R.drawable.img011,R.drawable.img012
        };
        Context mCtx;
        ImageAdapter(Context context){
            mCtx = context;
        }

        @Override
        public int getCount() {
            return imageResIds.length;      //傳回陣列的長度
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            ImageView imageView = new ImageView(mCtx);//把外面資源Context 丟到裡面來使用
            imageView.setLayoutParams(new GridView.LayoutParams(300,300));//設定GridView.Layout 的邊框大小
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//修改照片
            imageView.setPadding(8,8,8,8);      //設定與左上右下距離間隔
            imageView.setImageResource(imageResIds[position]);
           return imageView;
        }
    }
}
