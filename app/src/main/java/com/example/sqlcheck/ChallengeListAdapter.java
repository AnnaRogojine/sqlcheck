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

public class ChallengeListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Challenge> challengesList;

    public ChallengeListAdapter(Context context, int layout, ArrayList<Challenge> challengesList) {
        this.context = context;
        this.layout = layout;
        this.challengesList = challengesList;
    }

    @Override
    public int getCount() {
        return challengesList.size();
    }

    @Override
    public Object getItem(int position) {
        return challengesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtDays,txtDisc;
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

            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Challenge challenge = challengesList.get(position);

        holder.txtName.setText(challenge.getName());
        holder.txtDays.setText(challenge.getDays());
        holder.txtDisc.setText(challenge.getDisc());

        byte[] foodImage = challenge.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
