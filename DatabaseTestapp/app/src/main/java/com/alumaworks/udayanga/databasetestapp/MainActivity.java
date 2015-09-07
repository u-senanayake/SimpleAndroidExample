package com.alumaworks.udayanga.databasetestapp;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    EditText friend1,friend2;
    TextView show1,show2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friend1=(EditText)findViewById(R.id.friend1);
        friend2=(EditText)findViewById(R.id.friend2);
        show1=(TextView)findViewById(R.id.show1);
        show2=(TextView)findViewById(R.id.show2);

    }
    public void onAddButtonClick(View view){
        String name1=friend1.getText().toString();
        String name2=friend1.getText().toString();
        FriendHelper friendHelper = new FriendHelper(getApplicationContext());
        friendHelper.addFriend(name1,name2);
        Toast.makeText(getApplicationContext(), "Name saved successfully", Toast.LENGTH_SHORT).show();

    }
    public void onGetButtonClick(View view){
        List<String> friends = new ArrayList<String>();
        FriendHelper friendHelper = new FriendHelper(getApplicationContext());
        friends = friendHelper.getFriends();
        show1.setText(friends.toString());

    }
    public void onexportButtonClick(View view){
        if(isExternalStorageWritable()){

            List<String> friends = new ArrayList<String>();
            FriendHelper friendHelper = new FriendHelper(getApplicationContext());
            friends = friendHelper.getFriends();

            File downloadFolder = getDownloadDir();
            File file = new File(downloadFolder, "friends123.txt");

            OutputStream outputStream = null;

            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(friends.toString().getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(outputStream != null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }


    }
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public File getDownloadDir() {
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "friends");
        if (!file.mkdirs()) {
            Log.e("FILES", "Directory not created");
        }
        return file;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
