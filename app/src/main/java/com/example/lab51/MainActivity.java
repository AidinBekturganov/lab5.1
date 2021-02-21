package com.example.lab51;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        // define the variable
        Button send_button;
        Button back_button;
        TextView receiver_msg1;
        ImageView image;
        EditText send_text;
        Button send_image_button;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            send_button = (Button)findViewById(R.id.button);
            send_image_button = (Button)findViewById(R.id.button5);
            image = (ImageView)findViewById(R.id.imageView3);
            back_button = (Button)findViewById(R.id.button4);
            send_text = (EditText)findViewById(R.id.editTextTextPersonName);

            // add the OnClickListener in sender button
            // after clicked this button following Instruction will run

            receiver_msg1 = (TextView)findViewById(R.id.editTextTextPersonName);

            // create the get Intent object
            Intent intent = getIntent();

            // receive the value by getStringExtra() method
            // and key must be same which is send by first activity
            String str = intent.getStringExtra("message_key");

            // display the string into textView
            receiver_msg1.setText(str);

            back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                }
            });

            send_image_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get the value which input by user in EditText
                    // and convert it to string
                    String str = send_text.getText().toString();
                    image.buildDrawingCache();
                    Bitmap bitmap = image.getDrawingCache();


                    // Create the Intent object of this class Context() to Second_activity class
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                    // now by putExtra method put the value in key, value pair
                    // key is message_key by this key we will receive the value, and put the string

                    intent.putExtra("BitmapImage", bitmap);

                    // start the Intent
                    startActivity(intent);
                }
            });

            send_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    // get the value which input by user in EditText
                    // and convert it to string
                    String str = send_text.getText().toString();

                    // Create the Intent object of this class Context() to Second_activity class
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                    // now by putExtra method put the value in key, value pair
                    // key is message_key by this key we will receive the value, and put the string

                    intent.putExtra("message_key", str);

                    // start the Intent
                    startActivity(intent);
                }
            });
        }

}