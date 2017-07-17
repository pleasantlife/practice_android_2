package com.kimjinhwan.android.naverapi;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapLocationManager;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.mapviewer.overlay.NMapMyLocationOverlay;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends NMapActivity {

    private NMapView mMapView;
    private NMapLocationManager locationManager;
    private NMapController controller;
    private NMapMyLocationOverlay myLocation;
    private NGeoPoint geoPoint;
    private Canvas canvas;
    private final String CLIENT_ID = "Q7zT8TpqPwVErRdFruH1";






    public static String url = "https://openapi.naver.com/v1/search/shop.json";
    //public static String clientID = "Z8Mv5Goz0iWaNZj3wuxB";
    //public static String clientSecret = "Sea37fKlWx";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapView = new NMapView(this);
        setContentView(mMapView);

        setMapView();








    }

    private final NMapView.OnMapStateChangeListener onMapViewStateChangeListener = new NMapView.OnMapStateChangeListener() {

        @Override
        public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {

            if (errorInfo == null) { // success
                // restore map view state such as map center position and zoom level.
                restoreInstanceState();

            } else { // fail
                Log.e(LOG_TAG, "onFailedToInitializeWithError: " + errorInfo.toString());

                Toast.makeText(NMapViewer.this, errorInfo.toString(), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onAnimationStateChange(NMapView mapView, int animType, int animState) {
            if (DEBUG) {
                Log.i(LOG_TAG, "onAnimationStateChange: animType=" + animType + ", animState=" + animState);
            }
        }

        @Override
        public void onMapCenterChange(NMapView mapView, NGeoPoint center) {
            if (DEBUG) {
                Log.i(LOG_TAG, "onMapCenterChange: center=" + center.toString());
            }
        }

        @Override
        public void onZoomLevelChange(NMapView mapView, int level) {
            if (DEBUG) {
                Log.i(LOG_TAG, "onZoomLevelChange: level=" + level);
            }
        }

        @Override
        public void onMapCenterChangeFine(NMapView mapView) {

        }
    };

    private final NMapView.OnMapViewTouchEventListener onMapViewTouchEventListener = new NMapView.OnMapViewTouchEventListener() {

        @Override
        public void onLongPress(NMapView mapView, MotionEvent ev) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onLongPressCanceled(NMapView mapView) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSingleTapUp(NMapView mapView, MotionEvent ev) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTouchDown(NMapView mapView, MotionEvent ev) {

        }

        @Override
        public void onScroll(NMapView mapView, MotionEvent e1, MotionEvent e2) {
        }

        @Override
        public void onTouchUp(NMapView mapView, MotionEvent ev) {
            // TODO Auto-generated method stub

        }

    };

    private final NMapView.OnMapViewDelegate onMapViewTouchDelegate = new NMapView.OnMapViewDelegate() {

        @Override
        public boolean isLocationTracking() {
            if (locationManager != null) {
                if (locationManager.isMyLocationEnabled()) {
                    return locationManager.isMyLocationFixed();
                }
            }
            return false;
        }

    };


    public void setMapView(){
        mMapView.setClientId(CLIENT_ID);
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();
        mMapView.setBuiltInZoomControls(true, null);
        mMapView.displayZoomControls(true);
        setLocate();

    }


    public void setListener(){
        mMapView.setOnMapStateChangeListener(onMapViewStateChangeListener);
        mMapView.setOnMapViewTouchEventListener(onMapViewTouchEventListener);
        mMapView.setOnMapViewDelegate(onMapViewTouchDelegate);
    }

    public void setLocate(){

        locationManager = new NMapLocationManager(this);
        locationManager.setOnLocationChangeListener(new NMapLocationManager.OnLocationChangeListener() {
            @Override
            public boolean onLocationChanged(NMapLocationManager nMapLocationManager, NGeoPoint nGeoPoint) {
                nGeoPoint.getLatitude();
                nGeoPoint.getLongitude();
                return false;
            }

            @Override
            public void onLocationUpdateTimeout(NMapLocationManager nMapLocationManager) {
                Toast.makeText(MainActivity.this, "현재 위치 확인 불가", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLocationUnavailableArea(NMapLocationManager nMapLocationManager, NGeoPoint nGeoPoint) {
                Toast.makeText(MainActivity.this, "지도 상에 표시할 수 있는 범위 밖", Toast.LENGTH_SHORT).show();
            }
        });

        /*
        geoPoint = new NGeoPoint();
        canvas = new Canvas();
        locationManager = new NMapLocationManager(getBaseContext());
        locationManager.enableMyLocation(true);
        locationManager.getMyLocation();
        double x = geoPoint.getLatitude();
        double y = geoPoint.getLongitude();
        myLocation.draw(canvas, mMapView, false);
        */
    }



    public void draw(){

    }

}


