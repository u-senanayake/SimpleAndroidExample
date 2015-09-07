package com.alumaworks.udayanga.maptesthistory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements LocationListener ,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private LocationManager locationManager;
    private String provider;
    Double Latitude,longitude;
    Circle circle;
    Marker startPerc=null;
    Location old_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        mMap=((SupportMapFragment)getSupportFragmentManager()
        .findFragmentById(R.id.map)).getMap();
        mMap.setMyLocationEnabled(true);

        LocationManager service=(LocationManager)getSystemService(LOCATION_SERVICE);
        boolean enabledGPS=service.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean enabledWIFI=service.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if(!enabledGPS){
            Toast.makeText(MapsActivity.this, "GPS signal not found",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
        else if(!enabledWIFI){
            Toast.makeText(MapsActivity.this,
                    "Network signal not found", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
        // default
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        // getCurrentLocation();

        // Initialize the location fields
        if (location != null) {
            // Toast.makeText(BasicMapActivity_new.this, "Selected Provider " +
            // provider,
            // Toast.LENGTH_SHORT).show();
            onLocationChanged(location);
        } else {

            // do something
        }
        // setUpMapIfNeeded();
        setUpMap();
    }

    @Override
    protected void onPause(){
        super.onPause();
        locationManager.removeUpdates(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(provider,400,1,this);
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        SMSLocation();
       // mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
    public void SMSLocation() {

        Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(Latitude, longitude)).radius(100)
                .strokeColor(Color.RED));

        float[] distances = new float[1];
        final ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            // random latitude and logitude
            double[] randomLocation = createRandLocation(Latitude, longitude);

            // Adding a marker
            MarkerOptions marker = new MarkerOptions().position(
                    new LatLng(randomLocation[0], randomLocation[1])).title(
                    "Hello Maps " + i);

            Location.distanceBetween(randomLocation[0], randomLocation[1],
                    circle.getCenter().latitude, circle.getCenter().longitude,
                    distances);

            // arrayList.add((int) distances[0]);
            System.out.println("latitude: " + randomLocation[0] + ", "
                    + randomLocation[1]);

            Log.e("Random", "> " + randomLocation[0] + ", " + randomLocation[1]);
            Toast.makeText(
                    MapsActivity.this,
                    " Random Location " + randomLocation[0] + ","
                            + randomLocation[0], Toast.LENGTH_LONG).show();

            if (i == 0)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            if (i == 1)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            if (i == 2)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
            if (i == 3)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            if (i == 4)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            if (i == 5)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
            if (i == 6)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));
            if (i == 7)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
            if (i == 8)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
            if (i == 9)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

            if (distances[0] < circle.getRadius()) {
                // Add Marker belong here
                mMap.addMarker(marker);
            }
            // Move the camera to last position with a zoom level
        /*
         * if (i == 9) { CameraPosition cameraPosition = new
         * CameraPosition.Builder() .target(new LatLng(randomLocation[0],
         * randomLocation[1])).zoom(15).build();
         * mMap.animateCamera(CameraUpdateFactory
         * .newCameraPosition(cameraPosition)); }
         */
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        // Toast.makeText(BasicMapActivity_new.this, "Location " + lat+","+lng,
        // Toast.LENGTH_LONG).show();
        LatLng coordinate = new LatLng(lat, lng);
        Latitude = lat;
        longitude = lng;

        Toast.makeText(MapsActivity.this,
                "Location " + coordinate.latitude + "," + coordinate.longitude,
                Toast.LENGTH_LONG).show();

        startPerc = mMap.addMarker(new MarkerOptions()
                .position(coordinate)
                .title("Current Location")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 18.0f));

    }
    private double[] createRandLocation(double latitude, double longitude) {
        return new double[] { latitude + ((Math.random() - 0.5) / 500),
                longitude + ((Math.random() - 0.5) / 500),
                150 + ((Math.random() - 0.5) * 10) };

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
