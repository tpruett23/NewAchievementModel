package examples;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.toripruett.newachievementmodel.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

import trailsystem.Trail;

/**
 * Example to show location updating on Google Maps
 * @author - Melchor Dominguez
 * @version - 1.0
 */
public class MapExample extends FragmentActivity implements OnMapReadyCallback {

    /** Google map for the application */
    private GoogleMap gMap;

    /** Line to demonstrate a path*/
    Polyline line;


    /**
     * Initialize the activity
     * @param savedInstanceState - InstanceState to be created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }//end onCreate

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
        gMap = googleMap;

        // Add a marker in stillwell and move the camera
        LatLng stilwell = new LatLng(35.312305, -83.180406);
        gMap.addMarker(new MarkerOptions().position(stilwell).title("Marker in StillWell"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(stilwell));

        gMap.animateCamera(CameraUpdateFactory.zoomTo(17));

    }//end onMapReady


}
