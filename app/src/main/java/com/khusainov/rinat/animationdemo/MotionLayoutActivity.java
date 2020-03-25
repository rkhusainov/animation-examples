package com.khusainov.rinat.animationdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

public class MotionLayoutActivity extends AppCompatActivity {

    private MotionLayout mMotionLayout;
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_layout);

        mMotionLayout = findViewById(R.id.motion_layout);
        mSeekBar = findViewById(R.id.seekbar);

        mMotionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
                // Update seekBar value
                mSeekBar.setProgress(Math.round(progress * 100));
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                if (currentId == R.id.ending_set) {
                    // Return animation to the start position
                    mMotionLayout.transitionToStart();
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {
            }
        });
    }

    public void start(View view) {
        mMotionLayout.transitionToEnd();
    }
}
