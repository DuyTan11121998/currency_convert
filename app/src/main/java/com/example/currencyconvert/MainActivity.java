package com.example.currencyconvert;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    android.widget.Spinner spinner;
    EditText edt_in;
    TextView txt_out,txt_cur;
    ImageView img_out;
    ArrayList<Spinner> spinnerArrayList;
    SpinnerAdapter adapter;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        adapter = new SpinnerAdapter(this,R.layout.spinner_row,spinnerArrayList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                i=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        edt_in.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    img_out.setImageResource(spinnerArrayList.get(i).getImage());
                    txt_cur.setText(spinnerArrayList.get(i).getCurrency());
                    Double in = Double.parseDouble(edt_in.getText().toString());
                    Double out = in*spinnerArrayList.get(i).getRate();
                    if(out>9999999) {
                        txt_out.setText("maximum");
                        Toast.makeText(MainActivity.this, "Nhập nhỏ thôi", Toast.LENGTH_SHORT).show();
                    }
                    if(out>0.001&&out<9999999) txt_out.setText(out + "");
                    else txt_out.setText("");
                }
                catch (Exception e){
                    //
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                    //
            }
        });
    }

    private void anhxa() {
        spinner = findViewById(R.id.drop_down);
        spinnerArrayList= new ArrayList<>();
        edt_in  = findViewById(R.id.editText_input);
        txt_out = findViewById(R.id.textViewout);
        txt_cur =findViewById(R.id.textView_curr);
        img_out = findViewById(R.id.imageView_output);
        spinnerArrayList.add(new Spinner("USA",R.drawable.icon_usa,0.000043,"Đô"));
        spinnerArrayList.add(new Spinner("Viet Nam",R.drawable.icon_vietnam,1,"VNĐ"));
        spinnerArrayList.add(new Spinner("Malaysia",R.drawable.icon_malaysia,0.00018,"Ringgit"));
        spinnerArrayList.add(new Spinner("France",R.drawable.icon_france,0.000039,"Euro"));
        spinnerArrayList.add(new Spinner("Korea",R.drawable.icon_korea,0.05015,"Won"));
        spinnerArrayList.add(new Spinner("Japan",R.drawable.icon_japan,0.004687,"Yen"));
        spinnerArrayList.add(new Spinner("China",R.drawable.icon_china,0.0030,"Yuan"));
    }
}
