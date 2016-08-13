package com.gabi.pharminternat.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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
    static List<PharmaFile> pharmaFiles;

    public PharmaFileAdapter(Context context, List<PharmaFile> PharmaFiles) {
        super(context, 0, PharmaFiles);
        pharmaFiles = PharmaFiles;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout,parent, false);
        }

        this.viewHolder = (PharmaFileViewHolder) convertView.getTag();
        if(this.viewHolder == null){
            this.viewHolder = new PharmaFileViewHolder();
            this.viewHolder.fileId = (TextView) convertView.findViewById(R.id.file_id);
            this.viewHolder.displayOrder = (TextView) convertView.findViewById(R.id.displayOrder);
            this.viewHolder.pharmaFileTitle = (TextView) convertView.findViewById(R.id.pharmaFileTitle);
            this.viewHolder.lastReview = (TextView) convertView.findViewById(R.id.last_review);
            this.viewHolder.reviewCounter = (TextView) convertView.findViewById(R.id.review_counter);
            this.viewHolder.star = (ImageButton) convertView.findViewById(R.id.star_btn);

            convertView.setTag(viewHolder);
        }

        PharmaFile pharmaFile = getItem(position);

        if(pharmaFile.getTodoDate() != null &&
                pharmaFile.getTodoDate().after(Utils.currentWeek()) &&
                (pharmaFile.getTodoDate().before(Utils.nextWeek()) ||
                        pharmaFile.getTodoDate().equals(Utils.nextWeek()))){
            if(pharmaFile.getLastReview().before(pharmaFile.getTodoDate()) &&
                    pharmaFile.getLastReview().after(Utils.currentWeek()) ){
                ((ViewGroup)this.viewHolder.star.getParent().getParent()).setBackgroundColor(Color.parseColor("#4caf50"));
            } else {
                ((ViewGroup)this.viewHolder.star.getParent().getParent()).setBackgroundColor(Color.parseColor("#f8bbd0"));
            }
            this.viewHolder.star.setImageResource(R.drawable.star_green);
        } else {
            this.viewHolder.star.setImageResource(R.drawable.star_blank);
            convertView.setBackgroundColor(Color.WHITE);
            ((ViewGroup)this.viewHolder.star.getParent().getParent()).setBackgroundColor(Color.WHITE);
        }
        this.viewHolder.fileId.setText(pharmaFile.getId()+"");
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
        viewHolder.reviewCounter.setText(pharmaFile.getReviewCounter() + "");


        this.viewHolder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean fileFound = false;
                ImageButton star = (ImageButton) v;
                ViewGroup parent = (ViewGroup)v.getParent();
                Integer fileId = Integer.parseInt(((TextView) parent.getChildAt(0)).getText().toString());

                star.setImageResource(R.drawable.star_green);
                for(int i = 0; i < pharmaFiles.size() && !fileFound; i++){
                    PharmaFile file = pharmaFiles.get(i);
                    if(file.getId() == fileId){
                        file.setTodoDate(Utils.nextWeek());
                        fileFound = true;
                    }
                }

                ((ViewGroup)parent.getParent()).setBackgroundColor(Color.parseColor("#f8bbd0"));
                try {
                    DAO.getInstance(v.getContext()).setTodoDate(fileId);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        return convertView;
    }

    private class PharmaFileViewHolder{
        public TextView fileId;
        public TextView displayOrder;
        public TextView pharmaFileTitle;
        public TextView lastReview;
        public TextView reviewCounter;
        public ImageButton star;
    }

}
