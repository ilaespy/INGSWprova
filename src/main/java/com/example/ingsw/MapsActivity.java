package com.example.ingsw;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.FragmentActivity;

import com.example.ingsw.GPSTracker;
import com.example.ingsw.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> arrayList=new ArrayList<LatLng>();
    LatLng roma = new LatLng(40.839350, 14.185530);
    LatLng torino = new LatLng(40.630300, 14.358025);
    LatLng calabria = new LatLng(41.097081, 14.365486);
    LatLng napoli = new LatLng(40.846439, 14.257556);
    LatLng veneto = new LatLng(40.748428, 14.487176);

    private GPSTracker gpsTracker;
    private Location mLocation;
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        gpsTracker = new GPSTracker(getApplicationContext());
        mLocation = gpsTracker.getLocation();

        latitude = mLocation.getLatitude();
        longitude = mLocation.getLongitude();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(roma);
        arrayList.add(torino);
        arrayList.add(calabria);
        arrayList.add(napoli);
        arrayList.add(veneto);
    }

    public void onSearch(View view){
        EditText location_tf = (EditText)findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location , 1);


            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address =  addressList.get(0);
            LatLng latIng = new LatLng(address.getLatitude() , address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latIng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latIng));

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for(int i=0;i<arrayList.size();i++){
            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }
        // Add a marker in Sydney and move the camera
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
    public void onZoom(View view){
        if(view.getId() == R.id.zoomin){
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if(view.getId() == R.id.zoomout){
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    } }
