package com.example.demogk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class DonutAdapter extends BaseAdapter {


    private Context context;
     private int idImage;
     private List<Donut> donutList;
    private int positionSelect=-1;

    public DonutAdapter(Context context, int idImage, List<Donut> donutList) {
        this.context = context;
        this.idImage = idImage;
        this.donutList = donutList;
    }

    @Override
    public int getCount() {
        if(donutList.size()!=0 && !donutList.isEmpty())
            return donutList.size();
        return  0;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(idImage,viewGroup,false);
        }

        TextView tv_name= (TextView) view.findViewById(R.id.textView_Name);
        TextView tv_detail= (TextView) view.findViewById(R.id.textView_Detail);
        TextView tv_price= (TextView) view.findViewById(R.id.textView_Price);
        ImageView img= (ImageView) view.findViewById(R.id.imageView);

        final ConstraintLayout constraintLayout=(ConstraintLayout) view.findViewById(R.id.constraintlayout);
        final Donut donut= donutList.get(i);
        if(donutList!=null&& !donutList.isEmpty()){
            tv_name.setText(donut.getName());
            tv_detail.setText(donut.getDetail());
            tv_price.setText(donut.getPrice()+"$");

            idImage= donut.getId();
        switch (idImage){
            case 1:
                img.setImageResource(R.drawable.donut_yellow1);
                break;
            case 2: img.setImageResource(R.drawable.green_donut1);
                break;

            case 3: img.setImageResource(R.drawable.donut_red1);
                break;

            case 4: img.setImageResource(R.drawable.tasty_donut1);
                break;
            default: break;
            }
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, SecondActivity.class);
                Bundle bundle= new Bundle();
                bundle.putInt("id", donut.getId());
                bundle.putString("name", donut.getName());
                bundle.putString("detail", donut.getDetail());
                bundle.putString("price", donut.getPrice()+"$");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
