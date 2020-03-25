package com.khusainov.rinat.animationdemo;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TransitionApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_api);

        final FrameLayout sceneRoot = findViewById(R.id.scene_root);
        final ImageView animatedImageView = findViewById(R.id.animated_image_view);

        animatedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TransitionManager.beginDelayedTransition(sceneRoot);

                ViewGroup.LayoutParams params = animatedImageView.getLayoutParams();
                int newSize = 500;
                params.width = newSize;
                params.height = newSize;
                animatedImageView.setLayoutParams(params);
            }
        });

        animatedImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Scene scene = Scene.getSceneForLayout(sceneRoot, R.layout.scene2, getBaseContext());
                TransitionSet set = new TransitionSet();
                set.addTransition(new Fade(Fade.OUT));
                set.addTransition(new ChangeBounds());
                set.addTransition(new Fade(Fade.IN));
                set.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
                set.setDuration(500);
                set.setInterpolator(new AccelerateDecelerateInterpolator());
                TransitionManager.go(scene, set);
                return true;
            }
        });
    }
}
