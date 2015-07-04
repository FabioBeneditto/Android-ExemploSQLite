package tk.altoscodigos.exemplosqlite.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by diovani on 7/4/15.
 */
public class LocationListenerApp implements LocationListener {

    private Context appContext;
    private double[] latLong;

    public LocationListenerApp (Context context) {
       appContext = context;
    }

    @Override
    public void onLocationChanged(Location location) {
        latLong = new double[]{location.getLatitude(), location.getLongitude()};
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(appContext, "Gps habilitado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText( appContext, "Gps desabilitado", Toast.LENGTH_SHORT).show();
    }

    public double[] getLatLong() {
        return latLong;
    }
}
