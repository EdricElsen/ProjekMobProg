package com.example.tri_games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.huawei.hms.ads.HwAds;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        HwAds.init(this);

        Button continueBtn = findViewById(R.id.continueBtn);
        EditText nameFill = findViewById(R.id.nameFill);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("name",nameFill.getText().toString());
                startActivity(i);
            }
        });



    }
}