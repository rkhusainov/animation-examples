package com.khusainov.rinat.animationdemo;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class ConstraintLayoutAnimationActivity extends AppCompatActivity {

    private View mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_animation);

        mLayout = findViewById(R.id.start);

        findViewById(R.id.android_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initAnimation();
            }
        });
    }

    private void initAnimation() {
        ConstraintSet set = new ConstraintSet();
        set.clone(this, R.layout.activity_constraint_layout_animation_end);

        ChangeBounds trans = new ChangeBounds();
        trans.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        trans.setDuration(5000);

        TransitionManager.beginDelayedTransition((ViewGroup) mLayout, trans);
        set.applyTo((ConstraintLayout) mLayout);
    }
}
