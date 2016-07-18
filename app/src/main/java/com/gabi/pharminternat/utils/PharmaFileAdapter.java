package com.gabi.pharminternat.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.gabi.pharminternat.model.PharmaFile;
import com.example.gabi.main.R;
import com.gabi.pharminternat.dao.DAO;

import java.text.ParseException;
import java.util.List;

/**
 * Created by gabi on 15/07/16.
 */
public class PharmaFileAdapter extends ArrayAdapter<PharmaFile> {
    PharmaFileViewHolder viewHolder;

    public PharmaFileAdapter(Context context, List<PharmaFile> PharmaFiles) {
        super(context, 0, PharmaFiles);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout,parent, false);
        }

        this.viewHolder = (PharmaFileViewHolder) convertView.getTag();
        if(this.viewHolder == null){
            this.viewHolder = new PharmaFileViewHolder();
            this.viewHolder.displayOrder = (TextView) convertView.findViewById(R.id.displayOrder);
            this.viewHolder.pharmaFileTitle = (TextView) convertView.findViewById(R.id.pharmaFileTitle);
            this.viewHolder.lastReview = (TextView) convertView.findViewById(R.id.last_review);
            this.viewHolder.reviewCounter = (TextView) convertView.findViewById(R.id.review_counter);

            convertView.setTag(viewHolder);
        }

        PharmaFile pharmaFile = getItem(position);

        this.viewHolder.pharmaFileTitle.setText(pharmaFile.getFileTitle());
        this.viewHolder.displayOrder.setText(pharmaFile.getDisplayOrder()+"");
        this.viewHolder.reviewCounter.setText(pharmaFile.getReviewCounter()+"");
        try {
            this.viewHolder.lastReview.setText(Utils.getDateTimeFromDate(pharmaFile.getLastReview()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            viewHolder.lastReview.setText(Utils.getDateTimeFromDate(pharmaFile.getLastReview()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewHolder.reviewCounter.setText(pharmaFile.getReviewCounter()+"");

        return convertView;
    }

    private class PharmaFileViewHolder{
        public TextView displayOrder;
        public TextView pharmaFileTitle;
        public TextView lastReview;
        public TextView reviewCounter;
    }

}
