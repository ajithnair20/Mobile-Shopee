package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent intent = getIntent();
        final SmartPhone phone = (SmartPhone) intent.getSerializableExtra("smartPhone");

        TextView title = findViewById(R.id.phoneTitle);
        ImageView img = findViewById(R.id.phoneImg);
        TextView weight = findViewById(R.id.phoneWeight);
        TextView screenSize = findViewById(R.id.phoneScreenSize);
        TextView resolution = findViewById(R.id.phoneResolution);
        TextView os = findViewById(R.id.phoneOS);
        TextView ram = findViewById(R.id.phoneRAM);
        TextView storage = findViewById(R.id.phoneStorage);
        TextView frontCam = findViewById(R.id.phoneFrontCamera);
        TextView rearCam = findViewById(R.id.phoneRearCamera);
        TextView battery = findViewById(R.id.phoneBattery);
        TextView price = findViewById(R.id.phonePrice);

        title.setText(phone.getName());
        img.setImageResource(phone.getPhoneImage());
        weight.setText(Double.toString(phone.getWeight()) + " g");
        screenSize.setText(Double.toString(phone.getScreenSize()) + "\"");
        resolution.setText(phone.getResolution() + " pixels");
        os.setText(phone.getPlatform());
        ram.setText(Integer.toString(phone.getRam()) + " GB");
        storage.setText(Integer.toString(phone.getStorage()) + " GB");
        frontCam.setText(Double.toString(phone.getFrontCamera()) + " MP");
        rearCam.setText(Double.toString(phone.getRearCamera()) + " MP");
        battery.setText(Integer.toString(phone.getBattery()) + " mAh");
        price.setText("$" + Double.toString(phone.getPrice()));
    }
}
