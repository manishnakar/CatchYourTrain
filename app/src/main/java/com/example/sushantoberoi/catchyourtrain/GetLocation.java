package com.example.sushantoberoi.catchyourtrain;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.util.List;
import java.util.Locale;

/**
 * Created by sushant oberoi on 24-03-2017.
 */
public class GetLocation extends Activity {

    LocationListener locationListener;
    LocationManager locationManager;
    String abc="";


    public void getAddress(){
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                String str = getCompleteAdsdressString(latitude,longitude);
                abc=str;
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);

            }
        };
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}, 10);
                }
                return ;
        }else {
            configureButton();
        }
    }

    private String getCompleteAdsdressString(double LATITUDE, double LONGITUDE){
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try{
            List<Address> addresses = geocoder.getFromLocation(LATITUDE,LONGITUDE,1);
            if(addresses!= null){
                Address returnedAdresses = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for(int i = 0; i <returnedAdresses.getMaxAddressLineIndex();i++){
                    strReturnedAddress.append(returnedAdresses.getAddressLine(i)).append("\n");
                }
            }else{
                Log.v("N","No Address returned!");
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.v("w","Cannot get Address!");
        }
        return strAdd;
    }

    private void configureButton(){
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,0,locationListener);
    }
}