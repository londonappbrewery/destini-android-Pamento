package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
            appdateView();
        } else {
            mStoryIndex = 1;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 1 || mStoryIndex == 2) mStoryIndex = 3;
                else mStoryIndex = 6;
                appdateView();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 1) mStoryIndex = 2;
                else if (mStoryIndex == 2) mStoryIndex = 4;
                else mStoryIndex = 6;
                appdateView();
            }
        });

    }

    private void appdateView() {
        switch (mStoryIndex) {
            case 2:
                mStoryTextView.setText(R.string.T2_Story);
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
                break;
            case 3:
                mStoryTextView.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mTopButton.setText(R.string.T3_Ans2);
                break;
            case 4:
                mStoryTextView.setText(R.string.T4_End);
                mTopButton.setVisibility(View.GONE);
                mBottomButton.setVisibility(View.GONE);
                break;
            case 5:
                mStoryTextView.setText(R.string.T5_End);
                mTopButton.setVisibility(View.GONE);
                mBottomButton.setVisibility(View.GONE);
                break;
            case 6:
                mStoryTextView.setText(R.string.T6_End);
                mTopButton.setVisibility(View.GONE);
                mBottomButton.setVisibility(View.GONE);
                break;
            default:
                mStoryTextView.setText(R.string.T1_Story);
                mTopButton.setText(R.string.T1_Ans1);
                mBottomButton.setText(R.string.T1_Ans2);
                break;

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndex", mStoryIndex);
    }
    //    public static int getResId(String resName, Class<?> c) {
//
//        try {
//            Field idField = c.getDeclaredField(resName);
//            return idField.getInt(idField);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return -1;
//        }
//    }
}
