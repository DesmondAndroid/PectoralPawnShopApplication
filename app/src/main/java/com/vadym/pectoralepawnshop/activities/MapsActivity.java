package com.vadym.pectoralepawnshop.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;
import com.vadym.pectoralepawnshop.database.DepartmentEntity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final String NAME = "DEPARTMENT_NUMBER";
    private DepartmentEntity department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        int numberOfDepartment = intent.getIntExtra(MapsActivity.NAME, 0);
        department = DataBaseSimulation.departments[numberOfDepartment];
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
