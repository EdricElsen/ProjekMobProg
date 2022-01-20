package com.example.tri_games;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPond = findViewById(R.id.game1btn);
        Button btnMath = findViewById(R.id.game2btn);
        Button btnCapital = findViewById(R.id.game3btn);
        Button btnLogout = findViewById(R.id.btnLogout);

        String name = getIntent().getStringExtra("name");

        TextView user = findViewById(R.id.user);
        user.setText(name + "");

        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.score:
                        Intent i = new Intent(getApplicationContext(), ViewScoreActivity.class);
                        i.putExtra("name",user.getText().toString());
                        overridePendingTransition(0,0);
                        startActivity(i);
                        return true;
                    case R.id.home:

                        return true;
                }
                return false;
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),StartingActivity.class));
            }
        });

        btnPond.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PondActivity.class);
                i.putExtra("name",user.getText().toString());
                startActivity(i);
            }
        });

        btnMath.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MathActivity.class);
                i.putExtra("name",user.getText().toString());
                startActivity(i);
            }
        });

        btnCapital.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), StartQuizActivity.class);
                i.putExtra("name",user.getText().toString());
                startActivity(i);
            }
        });


    }
}
