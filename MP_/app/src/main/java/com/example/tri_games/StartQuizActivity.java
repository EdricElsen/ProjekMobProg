package com.example.tri_games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;



public class StartQuizActivity extends AppCompatActivity {
        private TextView tes;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_start_quiz);
            tes = findViewById(R.id.tesquiz);

            HwAds.init(this);

            // Obtain BannerView.
            BannerView bannerView = findViewById(R.id.hw_banner_view);
//            AdParam adParam = new AdParam.Builder().build();
//            bannerView.loadAd(adParam);
            // Set the ad unit ID and ad dimensions. "testw6vs28auh3" is a dedicated test ad unit ID.
            bannerView.setAdId("testw6vs28auh3");
            bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
            // Set the refresh interval to 60 seconds.
            bannerView.setBannerRefresh(60);
            // Create an ad request to load an ad.
            AdParam adParam = new AdParam.Builder().build();
            bannerView.loadAd(adParam);

            AdListener adListener = null;



            adListener = new AdListener() {
                @Override
                public void onAdLoaded() {
                    // Called when an ad is loaded successfully.
                }
                @Override
                public void onAdFailed(int errorCode) {
                    // Called when an ad fails to be loaded.

                }
                @Override
                public void onAdOpened() {
                    // Called when an ad is opened.

                }
                @Override
                public void onAdClicked() {
                    // Called when an ad is clicked.

                }
                @Override
                public void onAdLeave() {
                    // Called when an ad leaves an app.

                }
                @Override
                public void onAdClosed() {
                    // Called when an ad is closed.

                }
            };
            bannerView.setAdListener(adListener);

            String user = getIntent().getStringExtra("name");
            tes.setText(user);


        }



        public void startQuiz(View view) {
            int quizCategory = 0;


            Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
            intent.putExtra("name", tes.getText().toString());
            intent.putExtra("QUIZ_CATEGORY", quizCategory);
            startActivity(intent);


        }


}