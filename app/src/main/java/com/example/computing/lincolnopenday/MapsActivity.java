package com.example.computing.lincolnopenday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //initlise Map
    private GoogleMap mMap;
    private TextView Textv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Textv = (TextView)findViewById(R.id.name);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String j =(String) b.get("Place");
        Textv.setText(j);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

      // Dependent Map Position on text
      if (Textv.getText().toString().equals("On Campus"))
        {
            LatLng Junx = new LatLng(53.230707, -0.555671);
            mMap.addMarker(new MarkerOptions().position(Junx).title("On Campus Accomodation"));
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(Junx).zoom(15).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        if (Textv.getText().toString().equals("Hayes Wharf"))
        {
            LatLng Junx = new LatLng(53.230483, -0.548240);
            mMap.addMarker(new MarkerOptions().position(Junx).title("Hayes Wharf Accomodation"));
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(Junx).zoom(15).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        if (Textv.getText().toString().equals("Brayford Quay"))
        {
            LatLng Junx = new LatLng(53.229821, -0.545041);
            mMap.addMarker(new MarkerOptions().position(Junx).title("Brayford Quay Accomodation"));
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(Junx).zoom(15).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        if (Textv.getText().toString().equals("The Junxion"))
        {
            LatLng Junx = new LatLng(53.226234, -0.543837);
            mMap.addMarker(new MarkerOptions().position(Junx).title("Junxion Accomodation"));
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(Junx).zoom(15).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        if (Textv.getText().toString().equals("Park Court"))
        {
            LatLng Junx = new LatLng(53.230416, -0.542702);
            mMap.addMarker(new MarkerOptions().position(Junx).title("Park Court Accomodation"));
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(Junx).zoom(15).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        if (Textv.getText().toString().equals("The Pavilions"))
        {
            LatLng Junx = new LatLng(53.228052, -0.552939);
            mMap.addMarker(new MarkerOptions().position(Junx).title("Pavilions Accomodation"));
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(Junx).zoom(15).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }








    }






    }




