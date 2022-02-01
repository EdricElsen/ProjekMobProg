package com.example.tri_game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;

import java.util.Vector;

public class ViewScoreActivity extends AppCompatActivity {

    RecyclerView rv;
    ConfirmAdapter confirmAdapter;
    Activity context;
    String user,game,score;
    TextView bayar;
    int total;
    Button pay;

    public Vector<CartModel> vector = new Vector<CartModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);

        HwAds.init(this);
        BannerView bannerView = findViewById(R.id.hw_banner_view);

        // Set the ad unit ID and ad dimensions. "testw6vs28auh3" is a dedicated test ad unit ID.
        bannerView.setAdId("testw6vs28auh3");
        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
        // Set the refresh interval to 60 seconds.
        bannerView.setBannerRefresh(60);
        // Create an ad request to load an ad.
        AdParam adParam = new AdParam.Builder().build();
        bannerView.loadAd(adParam);

        rv = findViewById(R.id.recycle);
        confirmAdapter = new ConfirmAdapter(context);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(confirmAdapter);

        vector = Cart.vector;

        Button userrr = findViewById(R.id.userrrr);

        String name = getIntent().getStringExtra("name");
        userrr.setText(name);
        userrr.setVisibility(View.INVISIBLE);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_nav);
        bottomNavigationView.setSelectedItemId(R.id.score);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.score:
                        return true;
                    case R.id.home:
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("name", userrr.getText().toString());
                        overridePendingTransition(0, 0);
                        startActivity(i);
                        return true;
                }
                return false;
            }
        });

    }

}