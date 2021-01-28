package com.example.sqlcheck;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class MyChallengeListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<MyChallenge> MychallengesList;

    public MyChallengeListAdapter(Context context, int layout, ArrayList<MyChallenge> MychallengesList) {
        this.context = context;
        this.layout = layout;
        this.MychallengesList = MychallengesList;
    }

    @Override
    public int getCount() {
        return MychallengesList.size();
    }

    @Override
    public Object getItem(int position) {
        return MychallengesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtDays,txtDisc,start_Date;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName2);
            holder.imageView = (ImageView) row.findViewById(R.id.imgChallenge2);
            holder.txtDays = (TextView) row.findViewById(R.id.txtDays2);
            holder.txtDisc = (TextView) row.findViewById(R.id.txtDisc2);
            holder.start_Date = (TextView) row.findViewById(R.id.txtDate);

        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        MyChallenge mychallenge = MychallengesList.get(position);

        holder.txtName.setText(mychallenge.getName());
        holder.txtDays.setText(mychallenge.getDays());
        holder.txtDisc.setText(mychallenge.getDisc());
        holder.start_Date.setText(mychallenge.getStart_date());



        byte[] foodImage = mychallenge.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
