package skylark.intern.book.cinetic.cinemas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.fragment.cin_show;

public class MTheinGyi extends AppCompatActivity {

    FragmentManager fManager;
    FragmentTransaction fTransaction;
    private MapView mapView;
    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mthein_gyi);
        Toolbar tbar =(Toolbar) findViewById(R.id.z_toolbar);
        tbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(tbar);
        fManager= getSupportFragmentManager();
        fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.sanpyainfo ,new cin_show()).commit();
        tbar.setNavigationIcon(R.drawable.ic_arrow);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;

        }

        return true;
    }
    public void onClick(View v){
        if (v.getId()==R.id.call){
            call();
        }else {
            map();
            //Toast.makeText(getApplicationContext(),"Location is not available",Toast.LENGTH_LONG).show();

        }}
    public void call(){
        final AlertDialog.Builder custom = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.call_dialog,null);
        custom.setView(view);

        TextView phone1= (TextView) view.findViewById(R.id.ph1);
        TextView phone2= (TextView) view.findViewById(R.id.ph2);
        ImageView call1= (ImageView) view.findViewById(R.id.call1);
        ImageView call2= (ImageView) view.findViewById(R.id.call2);
        phone1.setText("01243057");
        phone2.setText("01243058");
        final AlertDialog dialog = custom.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:01243057"));
                    startActivity(callIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "You don't assign permission.", Toast.LENGTH_SHORT).show();

                }
                dialog.dismiss();

            }
        });
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:01243058"));
                    startActivity(callIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "You don't assign permission.", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });
    }
    public void map(){
        final AlertDialog.Builder custom = new AlertDialog.Builder(this);
        View view =LayoutInflater.from(this).inflate(R.layout.map_diag,null);
        custom.setView(view);
        mapView = (MapView) view.findViewById(R.id.map_view);
        TextView cinname= view.findViewById(R.id.cinname);


        final AlertDialog dialog = custom.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MapsInitializer.initialize(this);
        mapView.onCreate(dialog.onSaveInstanceState());
        mapView.onResume();
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                map.setMinZoomPreference(12);
                LatLng ny = new LatLng(16.7775883,96.1437957);
                BitmapDescriptor defaultmaker = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE);
                Marker marker = googleMap.addMarker(new MarkerOptions().position(ny).icon(defaultmaker));
                map.moveCamera(CameraUpdateFactory.newLatLng(ny));

            }
        });
        cinname.setText(R.string.mthelo);
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);


    }
}
