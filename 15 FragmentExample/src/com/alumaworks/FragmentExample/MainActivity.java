package com.alumaworks.FragmentExample;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import  android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
   public void Fragment(View view){
        Fragment fragment;
       if(view==findViewById(R.id.button)){
            fragment=new Fragment1();
           FragmentManager fragmentManager=getFragmentManager();
           FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
           fragmentTransaction.replace(R.id.fragment,fragment);
            fragmentTransaction.commit();
       }
       if(view==findViewById(R.id.button2)){
            fragment=new Fragment2();
           FragmentManager fragmentManager=getFragmentManager();
           FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
           fragmentTransaction.replace(R.id.fragment,fragment);
           fragmentTransaction.commit();
       }
    }
}
