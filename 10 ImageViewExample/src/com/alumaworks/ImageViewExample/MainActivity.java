package com.alumaworks.ImageViewExample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private static ImageView imageView;
    private static Button button;
    private int current_image_index;
    int[] image={R.mipmap.image,R.mipmap.blutooth,R.drawable.ic_launcher};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        onButtonclickListner();
    }
    public void onButtonclickListner(){
        imageView=(ImageView)findViewById(R.id.imageView);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index ++;
                current_image_index=current_image_index%image.length;
                imageView.setImageResource(image[current_image_index]);
            }
        });
    }
}
