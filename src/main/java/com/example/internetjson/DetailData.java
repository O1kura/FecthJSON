package com.example.internetjson;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailData extends AppCompatActivity {
    private TextView nameView,usernameView,phoneView,emailView,addressView;
    private String personName,contactPhone,contactEmail,usernameName,address;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        personName = getIntent().getStringExtra("name");
        contactPhone = getIntent().getStringExtra("phone");
        contactEmail = getIntent().getStringExtra("email");
        usernameName = getIntent().getStringExtra("username");
        address = getIntent().getStringExtra("address");

        ImageView avatarView = findViewById(R.id.imageView2);
//        avatarView.setImageBitmap();
        nameView = findViewById(R.id.textView4);
        nameView.setText(personName);
        usernameView = findViewById(R.id.textView5);
        usernameView.setText(usernameName);
        phoneView = findViewById(R.id.textView7);
        phoneView.setText(contactPhone);
        emailView = findViewById(R.id.textView6);
        emailView.setText(contactEmail);
        addressView = findViewById(R.id.textView8);
        addressView.setText(address);


    }
}
