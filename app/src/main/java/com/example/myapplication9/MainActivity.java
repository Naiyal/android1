package com.example.myapplication9;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    CalendarView dp;
    Button btn;

    EditText et ;
    EditText et_phone;
    Button btn_phone;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        dp = findViewById(R.id.ui_dp_date);
        et = findViewById(R.id.ui_et_name);
        et_phone = findViewById(R.id.ui_et_phone);
        btn_phone = findViewById(R.id.ui_btn_phone);

        dp.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getBaseContext(), "year "+year+" ,month "+(month+1)+" ,day "+dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity2.class);
                intent.putExtra("user_name",et.getText().toString());
                startActivity(intent);
            }
        });

        btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inter_phone = new Intent();
                String phone =  et_phone.getText().toString();
                inter_phone.setAction(Intent.ACTION_DIAL);
                //Universal Resource Identifier URI
                Uri uri = Uri.parse("tel:"+phone);
                inter_phone.setData(uri);
                startActivity(inter_phone);
            }
        });



    }
}