package com.example.scrambled_weggs;

import Model.Store;
import Model.WegmansStores;
import android.app.ListActivity;
import android.icu.text.IDNA;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import org.json.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.LinkedList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final String JSON_store_data = "https://api.wegmans.io/";
    private LinkedList<Store> wegmansLocations;
    private int number_of_stores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(JSON_store_data)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        WegmansStores current_store = retrofit.create(WegmansStores.class);
        Call<LinkedList<Store>> call = current_store.wegmans_stores();
        call.enqueue(new Callback<LinkedList<Store>>() {
            @Override
            public void onResponse(Call<LinkedList<Store>> call, Response<LinkedList<Store>> response) {
                wegmansLocations = response.body();
                Toast.makeText(MapsActivity.this,"Hello Jacob", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<LinkedList<Store>> call, Throwable t) {
                Toast.makeText(MapsActivity.this,"Error...",Toast.LENGTH_SHORT).show();
            }
        });
    }


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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Weggies = new LatLng(43.13316, -76.2232);
        mMap.addMarker(new MarkerOptions().position(Weggies).title("Weggies"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Weggies));
    }
}
