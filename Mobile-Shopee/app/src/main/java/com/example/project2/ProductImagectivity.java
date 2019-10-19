package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProductImagectivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_imagectivity);

        Intent intent = getIntent();
        final SmartPhone phone = (SmartPhone) intent.getSerializableExtra("smartPhone");

        ImageView img = findViewById(R.id.phoneImage);
        img.setImageResource(phone.getPhoneImage());

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlIntent = new Intent();
                urlIntent.setAction(Intent.ACTION_VIEW);
                Uri phoneUrl = Uri.parse(phone.getUrl());
                urlIntent.setData(phoneUrl);
                startActivity(urlIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }
}
