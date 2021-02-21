package com.example.lab51;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView receiver_msg;
    Button send_button2;
    Button back_button2;
    ImageView receive_image;
    EditText send_text2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        send_button2 = findViewById(R.id.button2);
        back_button2 = findViewById(R.id.button3);
        receive_image = findViewById(R.id.imageView);
        send_text2 = (EditText)findViewById(R.id.editTextTextPersonName2);
        receiver_msg = (TextView)findViewById(R.id.editTextTextPersonName2);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String str = intent.getStringExtra("message_key");
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
        // display the string into textView
        receiver_msg.setText(str);
        receive_image.setImageBitmap(bitmap);
        back_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
        send_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                // get the value which input by user in EditText
                // and convert it to string
                String str = send_text2.getText().toString();

                // Create the Intent object of this class Context() to Second_activity class
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                // now by putExtra method put the value in key, value pair
                // key is message_key by this key we will receive the value, and put the string

                intent.putExtra("message_key", str);

                // start the Intent
                startActivity(intent);
            }
        });
    }
}