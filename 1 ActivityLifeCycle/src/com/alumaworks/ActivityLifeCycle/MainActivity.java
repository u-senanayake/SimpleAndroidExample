package com.alumaworks.ActivityLifeCycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static final String MY_TAG = "the_custom_message";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
     @Override
    protected void onStart() {
        super.onStart();
        Log.i(MY_TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MY_TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MY_TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MY_TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(MY_TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MY_TAG, "onDestroy");
    }

}