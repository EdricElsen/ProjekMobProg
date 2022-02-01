package com.example.tri_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;
import com.huawei.hms.support.account.service.AccountAuthService;

import static android.content.ContentValues.TAG;

public class StartingActivity extends AppCompatActivity {

    private AccountAuthService mAuthService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);



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

//    @Override
//    protected void onStop() {
//        super.onStop();
//        cancelAuthorization();
//    }
//
//    private void cancelAuthorization() {
//        Task<Void> task = mAuthService.cancelAuthorization();
//        task.addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Log.i(TAG, "cancelAuthorization success");
//            }
//        });
//        task.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(Exception e) {
//                Log.i(TAG,"cancelAuthorization failure:" + e.getClass().getSimpleName());
//            }
//        });
//    }



}