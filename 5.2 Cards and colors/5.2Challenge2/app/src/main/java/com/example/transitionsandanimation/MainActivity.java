package com.example.transitionsandanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static final String ANIMATION = "Animation";
    public static final String EXPLODE_ANIMATION = "Explode Animation";
    public static final String FADE_TRANSITION = "Fade Transition";
    ImageView mYellowSquare;
    ImageView mGreenAndroid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYellowSquare = findViewById(R.id.image_square);
        mGreenAndroid = findViewById(R.id.image_android);

        if (getIntent().hasExtra(ANIMATION)) {
            switch (getIntent().getStringExtra(ANIMATION)) {
                case EXPLODE_ANIMATION:
                    Explode explode = new Explode();
                    getWindow().setEnterTransition(explode);
                    break;
                case FADE_TRANSITION:
                    Fade fade = new Fade();
                    getWindow().setEnterTransition(fade);
                    break;
                default: break;
            }
        }

    }


    public void animationsAndTransitions(View view) {
        switch (view.getId()) {
            case R.id.image_circle:
                Intent intent = new Intent(this, MainActivity.class);
                Explode explode = new Explode();
                explode.setDuration(400);
                getWindow().setExitTransition(explode);
                intent.putExtra(ANIMATION, EXPLODE_ANIMATION);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, options.toBundle());
                finishAffinity();
                break;

            case R.id.image_line:
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.putExtra(ANIMATION, FADE_TRANSITION);
                Fade fade = new Fade();
                fade.setDuration(400);
                getWindow().setExitTransition(fade);
                startActivity(intent2,
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                finishAffinity();
                break;

            case R.id.image_square:
                Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                mYellowSquare.startAnimation(rotateAnimation);
                break;

            case R.id.image_android:
                Intent intent3 = new Intent(MainActivity.this, SecondActivity.class);
                ActivityOptions options2 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        Pair.create(mGreenAndroid, "swap_shared_transition_android_icon"),
                        Pair.create(mYellowSquare, "swap_shared_transition_square")
                );
                startActivity(intent3, options2.toBundle());
                finishAffinity();
                break;

            default:
                break;
        }
    }

}
