package com.example.administrator.arraylistwithonclicklistener;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 9/11/2015.
 */
public class CustomAdapter extends ArrayAdapter<ChartItems>{
    public CustomAdapter(Context context, List<ChartItems> object){
        super(context,0,object);
    }

    public View getView(int position,View convertView,ViewGroup parent){
        final  Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_view, null, false);

        TextView itemNameTV = (TextView) view.findViewById(R.id.customLargeText);
        TextView priceTV = (TextView) view.findViewById(R.id.customSmallText);
        ImageView itemImageView = (ImageView)view.findViewById(R.id.customImageView);

        ChartItems chartItems = getItem(position);

        itemNameTV.setText(chartItems.itemName);
        priceTV.setText(chartItems.price);
        itemImageView.setImageResource(chartItems.image);


        return view;

    }
}
