package tk.altoscodigos.exemplosqlite;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import tk.altoscodigos.exemplosqlite.location.LocationListenerApp;

public class CapturaCamera extends ActionBarActivity{

    private double[] latLong;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura_camera);
    }

    public void tiraFoto(View v){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 1);

        /* Use the LocationManager class to obtain GPS locations */
        LocationManager locationManager      = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListenerApp locationListener = new LocationListenerApp(this);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        latLong = locationListener.getLatLong();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap bmp = (Bitmap) extras.get("data");
            ImageView imagem = (ImageView) findViewById(R.id.imageView);
            imagem.setImageBitmap(bmp);

            Toast.makeText(this, latLong.toString(), Toast.LENGTH_LONG);
        }
    }
}
