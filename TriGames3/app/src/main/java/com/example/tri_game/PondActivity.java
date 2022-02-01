package com.example.tri_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PondActivity extends AppCompatActivity {

//    variable
        private TextView scr,start,tes;
        private ImageView pad, star, diamond, star1, diamond1, star2, diamond2;

//    frame
        private int frHeight, frWidth, padHeight, padWidth;

//    screen
        private int screenHeight, screenWidth;

//    pos
        private float padX,padY;
        private  float starX, starY, star1X, star1Y, star2X, star2Y;
        private float diamondX, diamondY, diamond1X, diamond1Y, diamond2X, diamond2Y;

//    score
        private int score;

//    timer
        private Timer timer = new Timer();
        private Handler handler = new Handler();

        //    stats
        private boolean act_flg = false;
        private boolean str_flag = false;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pond);

            tes = findViewById(R.id.usert);
            scr = findViewById(R.id.scr);
            start = findViewById(R.id.start);
            pad = findViewById(R.id.pad);
            star = findViewById(R.id.star);
            diamond = findViewById(R.id.diamond);
            star1 = findViewById(R.id.star1);
            diamond1 = findViewById(R.id.diamond1);
            star2 = findViewById(R.id.star2);
            diamond2 = findViewById(R.id.diamond2);

            String user = getIntent().getStringExtra("name");
            tes.setText(user);

//        screen size
            WindowManager windowManager = getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            screenHeight = size.y;
            screenWidth = size.x;



//        set position
            star.setX(-80.0f);
            star.setY(-80.0f);
            diamond.setX(-80.0f);
            diamond.setY(-80.0f);
            star1.setX(-80.0f);
            star1.setY(-80.0f);
            diamond1.setX(-80.0f);
            diamond1.setY(-80.0f);
            star2.setX(-80.0f);
            star2.setY(-80.0f);
            diamond2.setX(-80.0f);
            diamond2.setY(-80.0f);

            scr.setText("Your Score: " + score);

        }

        public void changePos(){

//        collision detection
            collision();

//        star
            starX -= 14;
            if(starX < 0){
                starX = screenWidth + 20;
                starY = (float)Math.floor(Math.random() * (frHeight - star.getHeight()));
            }
            star.setX(starX);
            star.setY(starY);

//        diamond
            diamondX -= 18;
            if(diamondX < 0){
                diamondX = screenWidth + 30;
                diamondY = (float)Math.floor(Math.random() * (frHeight - diamond.getHeight()));
            }
            diamond.setX(diamondX);
            diamond.setY(diamondY);

            //        star1
            star1X += 14;
            if(star1X > screenWidth){
                star1X =   -(screenWidth);
                star1Y = (float)Math.floor(Math.random() * (frHeight - star1.getHeight()));
            }
            star1.setX(star1X);
            star1.setY(star1Y);

//        diamond1
            diamond1X += 16;
            if(diamond1X > screenWidth){
                diamond1X = -screenWidth - 10;
                diamond1Y = (float)Math.floor(Math.random() * (screenHeight - diamond1.getHeight()));
            }
            diamond1.setX(diamond1X);
            diamond1.setY(diamond1Y);

            //        star2
            star2Y += 14;
            if(star2Y > screenHeight){
                star2Y = -screenHeight;
                star2X = (float)Math.floor(Math.random() * (screenHeight - star2.getWidth()));
            }
            star2.setX(star2X);
            star2.setY(star2Y);

//        diamond2
            diamond2Y += 20;
            if(diamond2Y > screenHeight){
                diamond2Y = -screenHeight;
                diamond2X = (float)Math.floor(Math.random() * (frWidth - diamond2.getWidth()));
            }
            diamond2.setX(diamond2X);
            diamond2.setY(diamond2Y);

            pad.setX(padX);
            pad.setY(padY);

            scr.setText("Your Score: " + score);
        }

        private void collision() {
//        star
            float starCX = starX + star.getWidth() / 2.0f;
            float starCY = starY + star.getHeight() / 2.0f;

            if (padX<=starCX && starCX<=padX+padWidth&&padY<=starCY&&starCY<=padY+padHeight) {
                starX = -10000f;
                star.setY(starX);
                score += 1;
            }
//        diamond
            float diamondCX = diamondX + diamond.getWidth() / 2.0f;
            float diamondCY = diamondY + diamond.getHeight() / 2.0f;

            if (padX<=diamondCX && diamondCX<=padX+padWidth&&padY<=diamondCY&&diamondCY<=padY+padHeight) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                Intent i = new Intent(getApplicationContext(), PondResultActivity.class);
                i.putExtra("name", tes.getText().toString());
                i.putExtra("score", score);
                startActivity(i);
            }
            //        star1
            float star1CX = star1X + star1.getWidth() / 2.0f;
            float star1CY = star1Y + star1.getHeight() / 2.0f;

            if(padX<=star1CX && star1CX<=padX+padWidth&&padY<=star1CY&&star1CY<=padY+padHeight){
                star1X = 10000f;
                star1.setY(star1X);
                score += 1;
            }

//        diamond1
            float diamond1CX = diamond1X + diamond1.getWidth() / 2.0f;
            float diamond1CY = diamond1Y + diamond1.getHeight() / 2.0f;

            if(padX<=diamond1CX && diamond1CX<=padX+padWidth&&padY<=diamond1CY&&diamond1CY<=padY+padHeight){
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                Intent i = new Intent(getApplicationContext(), PondResultActivity.class);
                i.putExtra("name", tes.getText().toString());
                i.putExtra("score", score);
                startActivity(i);
            }
            //        star2
            float star2CX = star2X + star2.getWidth() / 2.0f;
            float star2CY = star2Y + star2.getHeight() / 2.0f;

            if(padX<=star2CX && star2CX<=padX+padWidth&&padY<=star2CY&&star2CY<=padY+padHeight){
                star2Y = 10000f;
                star2.setY(star2Y);
                score += 1;
            }

//        diamond2
            float diamond2CX = diamond2X + diamond2.getWidth() / 2.0f;
            float diamond2CY = diamond2Y + diamond2.getHeight() / 2.0f;

            if(padX<=diamond2CX && diamond2CX<=padX+padWidth&&padY<=diamond2CY&&diamond2CY<=padY+padHeight){
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                Intent i = new Intent(getApplicationContext(), PondResultActivity.class);
                i.putExtra("name", tes.getText().toString());
                i.putExtra("score", score);
                startActivity(i);
            }

        }


        @Override
        public boolean onTouchEvent(MotionEvent event) {

            if (!str_flag) {
                str_flag = true;
                start.setVisibility(View.GONE);

//            fr
                FrameLayout frameLayout = findViewById(R.id.fr);
                frHeight = frameLayout.getHeight();
                frWidth = frameLayout.getWidth();

//            pad
                padX = pad.getX();
                padY = pad.getY();
                padHeight = pad.getHeight();
                padWidth = pad.getWidth();

//            timer
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                changePos();
                            }
                        });
                    }
                }, 0 ,20);

            } else {
                padX = event.getX() - 50;
                padY = event.getY() - 300;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                }


            }
            return false;

        }
    }
