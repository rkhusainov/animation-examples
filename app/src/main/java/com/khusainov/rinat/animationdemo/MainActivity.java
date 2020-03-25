package com.khusainov.rinat.animationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import com.khusainov.rinat.animationdemo.shared_element_transition.SharedElementFragmentContainerActivity;
import com.khusainov.rinat.animationdemo.shared_element_transition.SharedElementTransitionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handleClick(R.id.vector_drawable, AnimatedVectorDrawableActivity.class);
        handleClick(R.id.transition, TransitionApiActivity.class);
        handleClick(R.id.constraint_animation, ConstraintLayoutAnimationActivity.class);
        handleClick(R.id.shared_element_transition_activity, SharedElementTransitionActivity.class);
        handleClick(R.id.shared_element_transition_fragment, SharedElementFragmentContainerActivity.class);
        handleClick(R.id.motion_layout_button, MotionLayoutActivity.class);
    }

    private void handleClick(@IdRes int viewId, final Class<? extends Activity> activityClass) {
        findViewById(viewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, activityClass));
            }
        });
    }
}
