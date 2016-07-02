package com.vadym.pectoralepawnshop.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.database.DepartmentEntity;
import com.vadym.pectoralepawnshop.database.PectoraleDatabaseHelper;

/**
 * Created by Vadym on 06.05.2016.
 */
public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private int[] idsTopic;
    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public interface Listener {
        void onClick(int idTopic);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CaptionedImagesAdapter(String section, Context context) {
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new PectoraleDatabaseHelper(context);
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursorDepartment = db.query("TOPIC",
                    new String[]{"_id", "NAME", "IMAGE_RESOURCE_ID"},
                    "SECTION = ?",
                    new String[]{section},
                    null, null, null);
            //Переход к первой записи в курсоре
            int countData = cursorDepartment.getCount();
            captions = new String[countData];
            imageIds = new int[countData];
            idsTopic = new int[countData];
            int count = 0;
            while (cursorDepartment.moveToNext()) {
                idsTopic[count] = Integer.parseInt(cursorDepartment.getString(0));
                captions[count] = cursorDepartment.getString(1);
                imageIds[count] = Integer.parseInt(cursorDepartment.getString(2));
                count++;
            }
            cursorDepartment.close();
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(context, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(idsTopic[position]);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

}
