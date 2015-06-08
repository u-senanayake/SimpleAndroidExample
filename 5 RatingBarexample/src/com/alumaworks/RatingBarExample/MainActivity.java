package com.alumaworks.RatingBarExample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static RatingBar ratingBar;
    private static Button button;
    private static TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListnerForRatingBar();
        onButtonClickListner();
    }
    public void ListnerForRatingBar(){
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        textView=(TextView)findViewById(R.id.textView);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText(String.valueOf(rating));
            }
        });
    }
    public void onButtonClickListner(){
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,String.valueOf(ratingBar.getRating()),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
