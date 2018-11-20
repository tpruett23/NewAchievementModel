package screens;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import load.XMLTrailParser;
import trailsystem.Trail;
import trailsystem.TrailSystem;
import trailsystem.WayPoint;

/**
 * Screen which will show all of the trail systems on a specific trail
 * @author - Melchor Dominguez
 * @version - 1.0
 */
public class TrailMap extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    /** Google map which will display the trail system*/
    private GoogleMap mGoogleMap;
    /** SupportMapFrament to achieve the proper display*/
    private SupportMapFragment mapFragment;
    /** LocationRequest to handle location requests for the application*/
    private LocationRequest locationRequest;
    /** LocationCallback which will allow locations to be received*/
    private LocationCallback locationCallback;
    /** ApiClient to provide any additions to map*/
    private GoogleApiClient mGoogleApiClient;
    /** last location received from the user*/
    private Location lastLocation;
    /** location marker for the current location*/
    private Marker locationMarker;

    public static final int PERMISSIONS_REQUEST_LOCATION = 99;

    private Polyline line;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if(mapFragment != null)
            mapFragment.getMapAsync(this);

        createLine();
    /* end onCreate*/
    }

    @Override
    public void onPause(){
        super.onPause();

        //stop location updates when Map no longer active
        if(mGoogleApiClient != null)
            LocationServices.getFusedLocationProviderClient(this).removeLocationUpdates(this.locationCallback);

    /* end onPause()*/
    }

    @Override
    public void onMapReady(GoogleMap googleMap){

        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Initialize Google Play Services
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED){
                //Location Permission already ganted
                buildGoogleApiClient();
                mGoogleMap.setMyLocationEnabled(true);
            }else{
                //Request Location Permission
                checkLocationPermission();
            }//end if-else
        }else{
            buildGoogleApiClient();
            mGoogleMap.setMyLocationEnabled(true);
        }//end if-else

    /* end onMapReady*/
    }

    protected  synchronized void buildGoogleApiClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();

    /* end buildGoogleApiClient*/
    }

    @Override
    public void onLocationChanged(Location location){
        lastLocation = location;

        //remove the current marker
        if(locationMarker != null){
            locationMarker.remove();
        }//end if

        //place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        locationMarker = mGoogleMap.addMarker(markerOptions);

        //move the camera to the current location
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));

    /* end onLocationChanged*/
    }

    @Override
    public void onConnected(@Nullable Bundle bundle){
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        locationCallback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult){
                if(locationResult == null){
                    return;
                }//end if
                for(Location location: locationResult.getLocations()){
                    if(location != null){
                        lastLocation = location;
                    }//end if
                }//end for

            /* end onLocationResult()*/
            }

        /* end locationCallback()*/
        };

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            LocationServices.getFusedLocationProviderClient(this).removeLocationUpdates(locationCallback);
        }//end if

    /* end onConnected() */
    }

    private void checkLocationPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED){

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){

                //Show an explanation to the user *asynchronously* -- don't block
                //this thread waiting for the user's response! After the user
                //sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please " +
                                "accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(TrailMap.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();;

            }else{

                //we can request permission.
                ActivityCompat.requestPermissions(TrailMap.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSIONS_REQUEST_LOCATION);
            }//end if-else

        }//end if

    /* end checkLocationPermission()*/
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                          int[] grantResults){

        switch (requestCode) {
            case PERMISSIONS_REQUEST_LOCATION: {
                //if request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //permission was granted
                    //do location related task
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }//end if
                        mGoogleMap.setMyLocationEnabled(true);
                    } else {
                        //permission denied
                        Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                        ;
                    }//end if-else
                    return;
                }
                //other 'case' lines to check for other permissions
                // app might need
            }
        }
    }

    /**
     * Create the entire polyline for the trail system
     */
    private void createLine(){
        try {
            XMLTrailParser trailParser;
            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("wcu_trail_system.xml");
            trailParser = new XMLTrailParser(is);

            PolylineOptions path = new PolylineOptions();
            TrailSystem trailSystem = trailParser.getTrailSystem();
            Collection<Trail> trails = trailSystem.getTrails();
            for (Trail trail : trails) {
                addTrailToLine(path, trail, R.color.dk_pink);
            }//end for
            path.width(6);

            line = mGoogleMap.addPolyline(path);

        }catch (Exception e){
            e.printStackTrace();
        }

    /* end createLine()*/
    }

    /**
     * Adds a trail to the map with the specified color
     * @param path - options for line to be displayed
     * @param trail - trail which will be displayed
     * @param color - int value of color
     */
    private void addTrailToLine(PolylineOptions path, Trail trail, int color){
        Collection<WayPoint> waypoints = trail.getPath();
        ArrayList<LatLng> latLngs = new ArrayList<>();

        for(WayPoint wayPoint: waypoints){
            latLngs.add(wayPoint.getPoint());
        }//end for
        path.color(color);

    /* end addTrailToLine()*/
    }

    @Override
    public void onConnectionSuspended(int i){

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult){

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){

    }

    @Override
    public void onProviderEnabled(String provider){

    }

    @Override
    public void onProviderDisabled(String provider){

    }
}

