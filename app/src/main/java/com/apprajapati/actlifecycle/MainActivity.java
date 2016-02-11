package com.apprajapati.actlifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



        // Use these as keys when you're saving state between reconfigurations
        private static final String RESTART_KEY = "restart";
        private static final String RESUME_KEY = "resume";
        private static final String START_KEY = "start";
        private static final String CREATE_KEY = "create";

        private static final String STOP_KEY = "stop";
        private static final String PAUSE_KEY = "pause";
        private static final String DESTROY_KEY = "destroy";

        // String for LogCat documentation
        private final static String TAG = "Lab-ActivityOne";

        // Lifecycle counters

        // TODO:
        private int mCreate =0;
        private int mRestart=0;
        private int mStart=0;
        private int mResume=0;

        private int mDestroy=0;
        private int mStop = 0;
        private int mPause = 0;

        // Create variables named
        // mCreate, mRestart, mStart and mResume
        // to count calls to onCreate(), onRestart(), onStart() and
        // onResume(). These variables should not be defined as static.

        // You will need to increment these variables' values when their
        // corresponding lifecycle methods get called.

        // TODO: Create variables for each of the TextViews
        TextView mTvCreate;
        TextView mTvRestart;
        TextView mTvStart;
        TextView mTvResume;

        TextView mTvStop;
        TextView mTvDestroy;
        TextView mTvPause;
        // named mTvCreate, mTvRestart, mTvStart, mTvResume.
        // for displaying the current count of each counter variable

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // TODO: Assign the appropriate TextViews to the TextView variables
            // Hint: Access the TextView by calling Activity's findViewById()
            // textView1 = (TextView) findViewById(R.id.textView1);

            mTvCreate = (TextView)  findViewById(R.id.create);
            mTvRestart = (TextView)  findViewById(R.id.restart);
            mTvStart = (TextView)  findViewById(R.id.start);
            mTvResume = (TextView)  findViewById(R.id.resume);

            mTvStop = (TextView) findViewById(R.id.stop);
            mTvDestroy = (TextView) findViewById(R.id.destroy);
            mTvPause = (TextView) findViewById(R.id.pause);

            Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
            launchActivityTwoButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO:
                    // Launch Activity Two
                    // Hint: use Context's startActivity() method
                    // Create an intent stating which Activity you would like to
                    // start
                    Intent intent = null;
                    intent = new Intent(getApplicationContext(), ActivityTwo.class);

                    // Verify that the intent will resolve to an activity
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                    // Launch the Activity using the intent

                }
            });

            // Has previous state been saved?
            if (savedInstanceState != null) {

                // TODO:
                // Restore value of counters from saved state
                // Only need 4 lines of code, one for every count variable

                mCreate = savedInstanceState.getInt(CREATE_KEY);
                mRestart = savedInstanceState.getInt(RESTART_KEY);
                mStart = savedInstanceState.getInt(START_KEY);
                mResume = savedInstanceState.getInt(RESUME_KEY);

                mStop = savedInstanceState.getInt(STOP_KEY);
                mPause = savedInstanceState.getInt(PAUSE_KEY);
                mDestroy = savedInstanceState.getInt(DESTROY_KEY);


            }

            // Emit LogCat message
            Log.i(TAG, "Entered the onCreate() method");

            // TODO:
            // Update the appropriate count variable
            mCreate++;
            // Update the user interface via the displayCounts() method
            displayCounts();

        }

        // Lifecycle callback overrides

        @Override
        public void onStart() {
            super.onStart();

            // Emit LogCat message
            Log.i(TAG, "Entered the onStart() method");

            // TODO:
            mStart++;
            // Update the appropriate count variable
            // Update the user interface
            displayCounts();

        }

        @Override
        public void onResume() {
            super.onResume();

            // Emit LogCat message
            Log.i(TAG, "Entered the onResume() method");

            // TODO:
            // Update the appropriate count variable
            mResume++;
            // Update the user interface
            displayCounts();
        }

        @Override
        public void onPause() {
            super.onPause();

            // Emit LogCat message
            Log.i(TAG, "Entered the onPause() method");
            mPause++;
            displayCounts();
        }

        @Override
        public void onStop() {

            super.onStop();
            mStop++;
            displayCounts();
            // Emit LogCat message
            Log.i(TAG, "Entered the onStop() method");
            Log.i(TAG,"YES IT DOES");

        }

        @Override
        public void onRestart() {
            super.onRestart();

            // Emit LogCat message
            Log.i(TAG, "Entered the onRestart() method");

            // TODO:
            mRestart++;
            // Update the appropriate count variable
            // Update the user interface
            displayCounts();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();

            // Emit LogCat message
            Log.i(TAG, "Entered the onDestroy() method");
            Log.i(TAG, "---- DONE FULL CYCLE ----");
            mDestroy++;
            displayCounts();
        }




        @Override
        protected void onSaveInstanceState(Bundle savedInstanceState) {

            savedInstanceState.putInt(CREATE_KEY, mCreate);
            savedInstanceState.putInt(RESTART_KEY, mRestart);
            savedInstanceState.putInt(START_KEY, mStart);
            savedInstanceState.putInt(RESUME_KEY, mResume);
            savedInstanceState.putInt(STOP_KEY,mStop);
            savedInstanceState.putInt(PAUSE_KEY,mPause);
            savedInstanceState.putInt(DESTROY_KEY,mDestroy);
        }


        public void displayCounts() {

            // TODO - uncomment these lines

            mTvCreate.setText("onCreate() calls: " + mCreate);
            mTvStart.setText("onStart() calls: " + mStart);
            mTvResume.setText("onResume() calls: " + mResume);
            mTvRestart.setText("onRestart() calls: " + mRestart);
            mTvPause.setText("onPause() calls: " + mPause);
            mTvStop.setText("onStop() calls: " + mStop);
            mTvDestroy.setText("onDestroy() calls: " + mDestroy);


        }


    }

