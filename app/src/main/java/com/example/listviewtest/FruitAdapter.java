package com.example.listviewtest;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 20372 on 2017/1/14.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private static final String TAG = "FruitAdapter";
    private int resourceId;
    private List<Fruit> mList;

    public FruitAdapter(Context context, int textViewResourceId,
                        List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
        mList = objects;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
//        Fruit fruit = getItem(position);//获取当前项的fruit实例
        Fruit fruit = mList.get(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,
                false);
        Log.i(TAG, "name : " + fruit.getName() + " size : " + mList.size());
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;
    }

}
