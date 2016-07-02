package com.vadym.pectoralepawnshop.fragments;


import android.app.ListFragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.vadym.pectoralepawnshop.activities.MapsActivity;
import com.vadym.pectoralepawnshop.database.PectoraleDatabaseHelper;

public class DepartmentFragment extends ListFragment {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new PectoraleDatabaseHelper(getActivity());
            db = starbuzzDatabaseHelper.getReadableDatabase();
            cursor = db.query("DEPARTMENT",
                    new String[]{"_id", "NAME"},
                    null, null, null, null, null);
            CursorAdapter listAdapter = new SimpleCursorAdapter(getActivity(),
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            setListAdapter(listAdapter);
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        Intent intent = new Intent(getActivity(), MapsActivity.class);
        intent.putExtra(MapsActivity.DEPARTNO, (int) id);
        getActivity().startActivity(intent);
    }
}
