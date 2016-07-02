package com.vadym.pectoralepawnshop.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.database.DepartmentEntity;
import com.vadym.pectoralepawnshop.database.PectoraleDatabaseHelper;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String DEPARTNO = "DEPARTNO";
    private GoogleMap mMap;
    private DepartmentEntity department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        int numberOfDepartment = intent.getIntExtra(MapsActivity.DEPARTNO, 0);

        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new PectoraleDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursorDepartment = db.query(PectoraleDatabaseHelper.TN_DEPARTMENT,
                    new String[]{"NAME", "COORDINATE_X", "COORDINATE_Y", "CITY", "ADDRESS", "WORKING_HOURS"},
                    "_id = ?",
                    new String[]{Integer.toString(numberOfDepartment)},
                    null, null, null);
            Cursor cursorNumber = db.query("TELEPHONE",
                    new String[]{"TELEPHONE"},
                    "DEPARTMENT_ID = ?",
                    new String[]{Integer.toString(numberOfDepartment)},
                    null, null, null);
            //Переход к первой записи в курсоре
            if (cursorDepartment.moveToFirst()) {
                //Получение данных напитка из курсора
                String name = cursorDepartment.getString(0);
                double coordinateX = Double.parseDouble(cursorDepartment.getString(1));
                double coordinateY = Double.parseDouble(cursorDepartment.getString(2));
                String city = cursorDepartment.getString(3);
                String address = cursorDepartment.getString(4);
                String wordingHours = cursorDepartment.getString(5);
                String[] numbers = new String[cursorNumber.getCount()];
                int count = 0;
                while (cursorNumber.moveToNext()){
                    numbers[count++] = cursorNumber.getString(0);
                }
                department = new DepartmentEntity(name, coordinateX, coordinateY, city, address, numbers, wordingHours);
            }
            cursorDepartment.close();
            cursorNumber.close();
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, R.string.dbunvaliable, Toast.LENGTH_SHORT);
            toast.show();
        }

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(department.getName());

        TextView name = (TextView) findViewById(R.id.name);
        TextView city = (TextView) findViewById(R.id.city);
        TextView address = (TextView) findViewById(R.id.address);
        TextView telephonNumber = (TextView) findViewById(R.id.telephone);
        TextView hoursWorking = (TextView) findViewById(R.id.workingHours);

        name.setText(department.getName());
        city.setText(department.getCity());
        address.setText(department.getAddress());
        StringBuilder telephons = new StringBuilder();
        for(String telephon : department.getTelephoneNumbers()){
            telephons.append(telephon).append(" ");
        }
        telephonNumber.setText(telephons.toString());
        hoursWorking.setText(department.getHoursWorking());
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng departmentCoordinate = new LatLng(department.getCoordinateX(), department.getCoordinateY());
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(departmentCoordinate)
                .zoom(16)
                .tilt(20)
                .build();
        mMap.addMarker(new MarkerOptions().position(departmentCoordinate).title(department.getName()));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.getUiSettings().setAllGesturesEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
