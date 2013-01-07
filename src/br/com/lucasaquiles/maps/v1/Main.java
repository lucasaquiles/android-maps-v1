package br.com.lucasaquiles.maps.v1;

import android.content.Context;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class Main extends MapActivity implements LocationListener{
	
	
	MapView mapa;
	LocationManager locationManager;
	MyLocationOverlay myLocationOverflay;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapa = (MapView) findViewById(R.id.map);
        
        mapa.getController().setZoom(14);
        mapa.setBuiltInZoomControls(true);

        myLocationOverflay = new MyLocationOverlay(this, mapa);
        mapa.getOverlays().add(myLocationOverflay);
        myLocationOverflay.enableCompass();
        myLocationOverflay.enableMyLocation();
        
        mapa.getOverlays().add(myLocationOverflay);
//        
      //  locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        
        int lat = (int) (-5.08947 * 1E6);
    	int lng = (int) (-42.80236053313725 * 1E6);
        
        GeoPoint point = new GeoPoint(lat, lng);
        mapa.getController().animateTo(point);        
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
		
		Toast.makeText(this, "OOpa, mudou: "+location.getLatitude()+" - "+location.getLongitude(),Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}