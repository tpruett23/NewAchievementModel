package screens;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import achievements.AchievementXMLHandler;
import achievements.ListViewAchv;
import achievements.MyService;
import achievements.QuestionEvent;
import load.XMLTrailParser;
import services.LocationService;
import services.LightService;
import trailsystem.StoryEvent;
import trailsystem.Trail;
import trailsystem.TrailSystem;
import trailsystem.WayPoint;

import static android.app.Notification.DEFAULT_SOUND;
import static android.app.Notification.DEFAULT_VIBRATE;


/**
 * Screen which will show all of the trail systems on a specific trail
 * @author - Melchor Dominguez
 * @version - 1.4
 */
public class TrailMap extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener{
    /**
     * The context for this class that is used for various tasks.
     */
    Context mContext = this;
    /**
     * The toolbar to hold the buttons.
     */
    Toolbar mTopToolbar;
    /**
     * Facts instance used when wanting to display facts through this class.
     */
    Facts fact = new Facts();

    /** Google map which will display the trail system*/
    private static GoogleMap mGoogleMap;
    /** SupportMapFragment to achieve the proper display*/
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
    /** last amount of distance gathered - only 1 distance value should be calculated at a time**/
    public static double distance;
    /** boolean to check if lightService should be running - only 1 light service can be running**/
    private static boolean lightSensorService;
    /** Class for interacting with the main interface of the location service**/
    private BroadcastReceiver mLightReceiver;


    Button eventButton;


    private MyCustomObjectListener listener;

    static Double distanceSend;

    /** trail parser which will input all information for the trail system*/
    private XMLTrailParser trailParser;

    public static final int PERMISSIONS_REQUEST_LOCATION = 99;

    /** Polyline which will show the trail*/
    private Polyline line;

    /** Media player for the application - only 1 is needed **/
    public static MediaPlayer mediaPlayer;

    Animation bounce;

    /**
     * Called when the activity is starting. This is where most initialization
     * should go: calling setContentView(int) to inflate the activity's UI, using
     * findViewById(int) to programmatically interact with widgets in the UI, calling
     * managedQuery(android.net.Uri, String[], String, String[], String) to
     * retrieve cursors for data being displayed, etc.
     * @param savedInstanceState - current instance to reference
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
            /*Settings set = new Settings();
            set.savePrefs();*/

      /* points = (TextView) findViewById(R.id.pointtextview);
       points.setText(UserInfo.totalPoints + "");*/



        trailParser = new XMLTrailParser();


        mTopToolbar = findViewById(R.id.toolbar1);

        //load an animation to make buttons "bounce"
        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Begin a media player
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.strange_beginnings);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        eventButton = findViewById(R.id.eventAvailable);

        AchievementXMLHandler.setCon(getApplicationContext());

        eventButton.setVisibility(View.GONE);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if(mapFragment != null)
            mapFragment.getMapAsync(this);

        // light receiver
        mLightReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.v("lService", "received something...");
                float lightQuality = intent.getFloatExtra("lightQuantity", -1);
                if(lightQuality > 150){
                    MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.style2_json);
                    TrailMap.UpdateMapStyleOptions(mapStyleOptions);
                }else{
                    MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.style_json);
                    TrailMap.UpdateMapStyleOptions(mapStyleOptions);
                }
                Log.v("lService", String.valueOf(lightQuality));
            }
        };




    }




    /**
     * When the activity is paused this is called to resume and re-register recievers.
     */
    @Override
    public void onResume(){
        super.onResume();
        //This registers message receiver to receive messages
        LocalBroadcastManager.getInstance(this).registerReceiver(mLightReceiver,
                new IntentFilter("light-number"));
    }
    /**
     * Called when the activity is paused to unregister receivers.
     */
    @Override
    public void onPause(){
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mLightReceiver);
        super.onPause();
    }

    /**
     * Called when the map is ready to be used
     * @param googleMap - A non-null instance of a GoogleMap
     *                  associated with the MapFragment or MapView
     *                  that defines the callback
     */
    @Override
    public void onMapReady(GoogleMap googleMap){

        //get the google map and set its type
        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //declare the style for the googleMap
        declareStyle(googleMap);

        /* Initialize Google Play Services */
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED){
                //Location Permission already granted
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

        LatLng hhs = new LatLng(35.306631, -83.201796);
        //mGoogleMap.addMarker(new MarkerOptions().position(hhs).title("Health and Human Sciences Building"));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(hhs));
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(17));


        createLine();

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20, 10, this);

        //when the style is first declared, the light service should be running
        lightSensorService = true;
        lightServiceChange();

    }

    /**
     * Method to update map styles for the google map if a different
     * style has been requested
     * @param mapStyleOptions - the mapStyleOption that has been changed.
     */
    public static void UpdateMapStyleOptions(MapStyleOptions mapStyleOptions){
        mGoogleMap.setMapStyle(mapStyleOptions);
    }

    /**
     * Helper function to help define the style of the Google map
     * @param googleMap - google map which will be updated
     */
    private void declareStyle(GoogleMap googleMap){
        try{
            //Customize the styling of the base map using a JSON object in
            // raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if(!success){
                Log.e("MAP", "Style parsing failed.");
            }
        }catch(Resources.NotFoundException e){
            Log.e("MAP", "Can't find style. Error: ", e);
        }//end try catch

    }

    public void setLightSensorService(boolean value){
        if(value != lightSensorService){
            lightSensorService = value;
            lightServiceChange();
        }
    }

    private void lightServiceChange(){
        if(lightSensorService){
            Log.v("lService", "let's start a service");
            startService(new Intent(this, LightService.class));
        }else{
            stopService(new Intent(this, MyService.class));
        }
    }


    /**
     * Create the Google APi Client with access to
     * Plus and Games
     */
    protected synchronized void buildGoogleApiClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();

        /* end buildGoogleApiClient*/
    }

    /**
     * Called when the location has changed.
     * There are no restrictions on the use of the supplied
     * Location object.
     * @param location - The new location, as a Location object
     */
    @Override
    public void onLocationChanged(Location location){

        setLightSensorService(Settings.lightSensor);
        lightServiceChange();
        //SharedPreferences prefs = getSharedPreferences("distance", MODE_PRIVATE);
        //SharedPreferences.Editor editor = prefs.edit();

        Log.v("location:", "location has been changed");
        if (location != null & lastLocation != null) {
            distance = lastLocation.distanceTo(location);

            //start the service to receive the location change
            startService(new Intent(this, LocationService.class));

        }
        lastLocation = location;

        //remove the current marker
        if (locationMarker != null) {
            locationMarker.remove();
        }//end if

        //place current location marker
        assert location != null;
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        //markerOptions.icon2(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.navigation);
        markerOptions.icon(icon);
        locationMarker = mGoogleMap.addMarker(markerOptions);

        //move the camera to the current location
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));

        if (trailParser.getTrailSystem().checkEvent(new LatLng(location.getLatitude(), location.getLongitude()))) {

            //Makes the button for the event bounce.
            eventButton.startAnimation(bounce);
            //eventButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            eventButton.setTextColor(getResources().getColor(R.color.black,getTheme()));
            eventButton.setVisibility(View.VISIBLE);
            eventButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    StoryEvent storyEvent = trailParser.getTrailSystem().getEvent();
                    Log.v("event:", "starting...");
                    //storyEvent.startEvent(mContext);


                    Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        if(vib != null) {
                            vib.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                        }
                    } else {
                        if(vib != null) {
                            vib.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                        }
                    }

                    storyEvent.startEvent(getApplicationContext());
                    //eventButton.setVisibility(View.GONE); //TODO: uncomment to have events show correctly

                }

            });

            //Creates the heads up notification channel.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String name = "Yay! New Event!";
                //String description = getString(R.string.achDes);
                int importance = NotificationManager.IMPORTANCE_HIGH; //Important for heads-up notification
                NotificationChannel channel = new NotificationChannel("1", name, importance);
                //channel.setDescription(description);
                channel.setShowBadge(true);
                channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                assert notificationManager != null;
                notificationManager.createNotificationChannel(channel);
            }
            //Creating the actual heads up notification.
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "1")
                    .setSmallIcon(R.drawable.mountainicon)
                    .setContentTitle("NEW EVENT AVAILABLE")
                    //.setStyle(new NotificationCompat.BigTextStyle().bigText("Yay! New Event!"))
                    .setContentText("You now have a new event available to explore!")
                    .setDefaults(DEFAULT_SOUND | DEFAULT_VIBRATE) //Important for heads-up notification
                    .setPriority(DEFAULT_VIBRATE); //Important for heads-up notification


            Notification buildNotification = mBuilder.build();
            NotificationManager mNotifyMgr = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
            assert mNotifyMgr != null;
            mNotifyMgr.notify(1, buildNotification);


            //* end onLocationChanged*//*
        }
    }


    /**
     * After calling connect(), this method will be invoked
     * asynchronously when the connect request has successfully
     * completed. After this callback, the application can make
     * requests on other methods provided by the client and expect
     * that no user intervention is required to call methods that
     * use account and scopes provided to the client constructor
     * @param bundle - Bundle of data provided to clients by Google
     *               Play services. May be null is no content is provided
     *               by service.
     */
    @Override
    public void onConnected(@Nullable Bundle bundle){
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(10); //change back to 1000
        locationRequest.setFastestInterval(10); // change back to 1000
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
                        Log.v("location2:", "new location???");
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


    /**
     * Method to perform operations to check if location permissions
     * have been granted by the user
     */
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
                        .show();

            }else{

                //we can request permission.
                ActivityCompat.requestPermissions(TrailMap.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSIONS_REQUEST_LOCATION);
            }//end if-else

        }//end if

        /* end checkLocationPermission()*/
    }

    /**
     * Callback for the result from requesting permissions.
     * This method is invoked for every call on
     * requestPermissions(android.app.Activity, String[], int).
     * @param requestCode - the request code passed in
     *                    requestPermissions(android.app.Activity, String[], int)
     * @param permissions - The requested permissions. Never null.
     * @param grantResults - The grant results for the corresponding permissions
     *                     which is either PERMISSION_GRANTED or PERMISSION_DENIED.
     *                     Never null.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults){

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
                    }//end if-else
                }
                // other 'case' lines to check for other permissions
                // app might need
            }
        }
    }

    /**
     * Create the entire polyline for the trail system
     */
    private void createLine(){
        Log.v("createLine", "Begin createLine");
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            Context context = getApplicationContext();
            InputStream is = context.getResources().openRawResource(R.raw.coffeeshop);
            saxParser.parse(is, handler);


            PolylineOptions path = new PolylineOptions();
            TrailSystem trailSystem = trailParser.getTrailSystem();
            Collection<Trail> trails =  trailSystem.getTrails();

            for (Trail trail : trails) {
                addTrailToLine(path, trail, R.color.dk_pink);
            }//end for
            path.width(10);

            line = mGoogleMap.addPolyline(path);
            Log.v("createLine", "finished polyline");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Adds a trail to the map with the specified color
     * @param path - options for line to be displayed
     * @param trail - trail which will be displayed
     * @param color - int value of color
     */
    private void addTrailToLine(PolylineOptions path, Trail trail, int color){
        Log.v("addTrailToLine", "begin addTrailToLine");
        Collection<WayPoint> waypoints = trail.getPath();
        ArrayList<LatLng> latLngs = new ArrayList<>();

        for(WayPoint wayPoint: waypoints){
            latLngs.add(wayPoint.getPoint());
            Log.v("addTrailToLine", String.valueOf(wayPoint.getPoint().latitude));
        }//end for
        path.addAll(latLngs);
        path.color(color);

        /* end addTrailToLine()*/
    }

    /**
     * Called when the client is temporarily in a disconnected state.
     * This can happen if there is a problem with the remote service
     * (e.g. a crash or resource problem causes it to be killed by
     * the system). When called, all requests have been canceled and no
     * outstanding listeners will be executed. GoogleApiClient will automatically
     * attempt to restore the connection. Applications should disable UI
     * components that require the service and wait for a call to
     * onConnected(Bundle) to re-enable them
     * @param cause - The reason for the disconnection. Defined by constants
     *          CAUSE_*
     */
    @Override
    public void onConnectionSuspended(int cause){

    }

    /**
     * Called when there was an error connecting the
     * client to the service.
     * @param connectionResult - A connectionResult that can be
     *                         used for resolving the error, and deciding
     *                         what sort of error occurred. To resolve the error,
     *                         the resolution must be started from an activity with
     *                         a non-negative requestCode passed to
     *                         startResolutionForResult(Activity, int). Applications should
     *                         implement onActivityResult in their Activity to call connect()
     *                         again if the user has resolved the issue(resultCode is RESULT_OK).
     */
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult){

    }

    /**
     * Called when the provider status changes. This method is called
     * when a provider is unable to fetch a location or if the provider has
     * recently become available after a period of unavailability.
     * @param provider - The name of the location provider associated with this update
     * @param status - LocationProvider.OUT_OF_SERVICE if the provider is out of service,
     *               and this is not expected to change in the near future;
     *               LocationProvider.TEMPORARILY_UNAVAILABLE if the provider is temporarily
     *               unavailable but is expected to be available shortly; and
     *               LocationProvider.AVAILABLE if the provider is currently available
     * @param extras - an optional Bundle which will contain prover specific status variables.
     *
     */
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){

    }

    /**
     * Called when the provider is enabled by the user.
     * @param provider - The name of the location provider associated
     *                 with this update.
     */
    @Override
    public void onProviderEnabled(String provider){

    }

    /**
     * Called when the provider is disabled by the user. If
     * requestLocationUpdates is called on an already disabled provider,
     * this method is called immediately.
     * @param provider - The name of the location provider associated with
     *                 this update.
     */
    @Override
    public void onProviderDisabled(String provider){

    }

    DefaultHandler handler = new DefaultHandler(){

        /** Boolean variables to check the current element in
         * the xml file */
        boolean trailSystem = false;
        boolean trail = true;
        boolean trailName = true;
        boolean name = false;
        boolean waypoint = false;
        boolean latitude = false;
        boolean longitude = false;
        boolean story = false;

        double curLat;
        double curLon;

        /**
         * Receive notification of the start of an element.
         * @param uri - The Namespace URI, or the empty string if the
         *            element has no Namespace URI or if Namespace
         *            processing is not being performed.
         * @param localName - The local name (without prefix), or the
         *                  empty string if Namespace processing is not
         *                  being performed
         * @param qName - The qualified name (with prefix), or the empty
         *              string if qualified names are not available
         * @param attributes - The attributes attached to the element. If
         *                   there are not attributes, it shall be an
         *                   empty Attributes object.
         */
        public void startElement(String uri, String localName,
                                 String qName, Attributes attributes) {

            //check for which element is being started
            if(qName.equalsIgnoreCase("trailsystem")){
                trailSystem = true;
            }else if(qName.equalsIgnoreCase("name")){
                name = true;
            }else if(qName.equalsIgnoreCase("waypoint")){
                waypoint = true;
            }else if(qName.equalsIgnoreCase("latitude")){
                latitude = true;
            }else if(qName.equalsIgnoreCase("longitude")){
                longitude = true;
            }else if(qName.equalsIgnoreCase("trail_name")) {
                trailName = true;
            }else if(qName.equalsIgnoreCase("story")) {
                story = true;
            }else if(trail){
                trail = false;
            }

            /* End startElement method*/
        }

        /**
         * Receive notification of the end of an element
         * By default, do nothing. Application writers may override
         * this method in a subclass to take specific actions at the
         * end of each element (such as finalising a tree node or writing
         * output to a file).
         * @param uri - The Namespace URI, or the empty string if the
         *            element has no Namespace URI or if Napmespace
         *            processing is not being performed
         * @param localName - The local name (without prefix), or the empty
         *                  string if Namespace processing is not being
         *                  performed
         * @param qName - The qualified name (with prefix), or the empty
         *              string if qualified names are not available.
         */
        public void endElement(String uri, String localName,
                               String qName) {

            /* end endElement()*/
        }

        /**
         * Receive notification of character data inside an element.
         * By default, do nothing Application writers may override this
         * method to take specific actions for each chunk of character
         * data (such as adding the data to a node or buffer, or printing
         * it to a file).
         * @param ch - The characters.
         * @param start - The start position in the character array.
         * @param length - The number of characters to use from the character
         *               array
         */
        public void characters(char[] ch, int start, int length) {
            if(name){
                trailParser.setTrailSystemName(new String(ch, start, length));
                name = false;
            }else if(trailSystem){
                trailSystem = false;
            }else if(waypoint){
                waypoint = false;
            }else if(latitude){
                curLat = Double.parseDouble(new String(ch, start, length));
                latitude = false;
            }else if(longitude){
                curLon = Double.parseDouble(new String(ch, start, length));
                LatLng latLng = new LatLng(curLat, curLon);
                trailParser.addPoint(latLng);
                longitude = false;
            }else if(story) {
                InputStream is = getResources().openRawResource(getResources().getIdentifier(
                        new String(ch,start,length), "raw", getPackageName()));
                trailParser.addEvent(is);
                story = false;
            } else if(trailName){
                trailParser.addTrail(new String(ch, start, length));
                Log.v("check", new String(ch, start, length));
                trailName = false;
            }//end if-else
        }
    };



    interface MyCustomObjectListener {

    }
    /**
     * Creates and inflates the toolbar layout.
     * @param menu The menu to inflate.
     * @return true or false if inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }
    /**
     * This method is called when one of the buttons in the toolbar is clicked.
     * @param item The item that was clicked.
     * @return true if an item in the toolbar was clicked.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent i;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_rib) {
            i = new Intent(this,ListViewAchv.class);
            startActivity(i);
            //Toast.makeText(this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.Settings) {
            i = new Intent(this,Settings.class);
            startActivity(i);
            //Toast.makeText(this, "Action clicked", Toast.LENGTH_LONG).show();
            setLightSensorService(Settings.lightSensor);
            return true;
        }
        if (id == R.id.action_story) {
            i = new Intent(this, QuestionEvent.class);
            //Toast.makeText(this, "Action clicked", Toast.LENGTH_LONG).show();
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}








