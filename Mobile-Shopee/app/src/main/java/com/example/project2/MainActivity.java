package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    ArrayList<SmartPhone> smartPhones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generate List of Smartphones to display
        createSmartPhones();

        mListView = findViewById(R.id.phonelist);
        CustomAdapter customAdapter = new CustomAdapter();
        mListView.setAdapter(customAdapter);
        registerForContextMenu(mListView);

        //
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                displayProductImage(i);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        //TODO AUto-generated method stub
        super.onCreateContextMenu(menu,v,menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.phone_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.phoneSpec: displayProductSpecifications(info.position); break;
            case R.id.phoneEnlarge: displayProductImage(info.position); break;
            case R.id.phoneWebsite: displayWebsite(info.position); break;
        }
        return super.onContextItemSelected(item);
    }

    //Method to create a list of Smart Phone Objects and populate it with data
    public void createSmartPhones(){
        SmartPhone phone1 = new SmartPhone("Xiaomi Redmi Note 8 Pro",6, 2, 219.99,1,64,6.53,"Xiaomi", 200,"1080x2340", "Android", 4500, 20, 64, R.drawable.image4,"https://m.gsmarena.com/xiaomi_redmi_note_8_pro-9812.php");
        smartPhones.add(phone1);
        SmartPhone phone2 = new SmartPhone("Oppo K5", 6,2,265,2,128,6.4,"Oppo",180,"1080x2340", "Android", 4000, 32, 64, R.drawable.image5, "https://www.gsmarena.com/oppo_k5-9907.php");
        smartPhones.add(phone2);
        SmartPhone phone3 = new SmartPhone("Google Pixel 3",4,4,338.99,3,64,5.5,"Google",148,"1080x2160","Android",2915,8,12.2,R.drawable.image1,"https://www.gsmarena.com/google_pixel_3-9256.php");
        smartPhones.add(phone3);
        SmartPhone phone4 = new SmartPhone("Apple IPhone X",3,3,529.95,4,64,5.8,"Apple",174,"1125x2436","IOS",2716,7,12,R.drawable.image2,"https://www.gsmarena.com/apple_iphone_x-8858.php");
        smartPhones.add(phone4);
        SmartPhone phone5 = new SmartPhone("One Plus 7 Pro",12,4,569.99,5,256,6.67,"One Plus",206,"1440x3120","Android",4000,16,48,R.drawable.image3,"https://www.gsmarena.com/oneplus_7_pro-9689.php");
        smartPhones.add(phone5);
        SmartPhone phone6 = new SmartPhone("Samsung Galaxy S10e",8,4,524.89,6,256,5.8,"Samsung",150,"1080x2280","Android",3100,10,12,R.drawable.image6,"https://www.gsmarena.com/samsung_galaxy_s10e-9537.php");
        smartPhones.add(phone6);
        SmartPhone phone7 = new SmartPhone("Motorola Moto G7",4,4,299.99,7,64,6.2,"Motorola",172,"180x2270","Android",3000,8,12,R.drawable.image7,"https://www.gsmarena.com/motorola_moto_g7-9357.php");
        smartPhones.add(phone7);
        SmartPhone phone8 = new SmartPhone("LG G5",4,4,331,8,32,5.3,"LG",159,"1440x2560","Android",2800,8,16,R.drawable.image8,"https://www.gsmarena.com/lg_g5-7815.php");
        smartPhones.add(phone8);
        SmartPhone phone9 = new SmartPhone("Nokia 9",6,4,584.85,9,128,5.99,"Nokia",172,"1440x2880","Android",3320,20,60,R.drawable.image9,"https://www.gsmarena.com/nokia_9_pureview-8867.php");
        smartPhones.add(phone9);
        SmartPhone phone10 = new SmartPhone("Asus Zenfone 6",8,4,499.99,10,256,6.4,"Asus",190,"1080x2340","Android",5000,48,48,R.drawable.image10,"https://www.gsmarena.com/asus_zenfone_6_zs630kl-9698.php");
        smartPhones.add(phone10);
        SmartPhone phone11 = new SmartPhone("Honor 10",8,4,309,11,128,5.84,"Honor",153,"1080x2280","Android",3400,24,16,R.drawable.image11,"https://www.gsmarena.com/honor_10-9157.php");
        smartPhones.add(phone11);
    }

    //Method to start Product Image Activity
    public void displayProductImage(int position){
        Intent intent = new Intent(MainActivity.this,ProductImagectivity.class);
        intent.putExtra("smartPhone",smartPhones.get(position));
        startActivity(intent);
    }

    public void displayProductSpecifications(int position){
        Intent intent = new Intent(MainActivity.this,ProductDetailsActivity.class);
        intent.putExtra("smartPhone",smartPhones.get(position));
        startActivity(intent);
    }

    public void displayWebsite(int position){
        Intent urlIntent = new Intent();
        urlIntent.setAction(Intent.ACTION_VIEW);
        Uri phoneUrl = Uri.parse(smartPhones.get(position).getUrl());
        urlIntent.setData(phoneUrl);
        startActivity(urlIntent);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return smartPhones.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View vW  = getLayoutInflater().inflate(R.layout.phonelist, null);
            ImageView mImageView = vW.findViewById(R.id.imageView);
            TextView mPhoneText = vW.findViewById(R.id.phonename);
            TextView mPhoneDesc = vW.findViewById(R.id.phonedesc);

            mImageView.setImageResource(smartPhones.get(i).getPhoneImage());
            mPhoneText.setText(smartPhones.get(i).getName());
            mPhoneDesc.setText("Display: " + smartPhones.get(i).getScreenSize() + "\" Price:$" + smartPhones.get(i).getPrice());
            return vW;
        }
    }
}
