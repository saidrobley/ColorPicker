package com.saidrobley.colorpicker;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

//public class MainActivity extends Activity implements NumberPicker.OnValueChangeListener {
public class MainActivity extends Activity {
    private NumberPicker red;
    private NumberPicker green;
    private NumberPicker blue;
    private TextView tv1;
    private TextView tv2;
    private TextView tv5;
    private TextView tv6;
    private String color1Hex;
    // private String x2;
    private String color1Saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv5 = (TextView) findViewById(R.id.textView5);
        //  tv6 = (TextView) findViewById(R.id.textView6);


        red = (NumberPicker) findViewById(R.id.numberPicker1);
        green = (NumberPicker) findViewById(R.id.numberPicker2);
        blue = (NumberPicker) findViewById(R.id.numberPicker3);

        red.setMaxValue(255);
        red.setMinValue(0);
        red.setValue(251);
        // red.setOnValueChangedListener(this);


        green.setMaxValue(255);
        green.setMinValue(0);
        green.setValue(165);
        // green.setOnValueChangedListener(this);

        blue.setMaxValue(255);
        blue.setMinValue(0);
        blue.setValue(165);

        tv1.setBackgroundColor(Color.parseColor("#FBA5A5"));

        tv5.setText("#FBA5A5");
        color1Saved = tv5.getText() + "";


        red.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                tv1.setBackgroundColor(Color.rgb(newVal, green.getValue(), blue.getValue()));

                int rd = newVal;
                int gr = green.getValue();
                int bl = blue.getValue();
                String totHex = ConvertHex(rd, gr, bl);
                // tv2.setText("#" + totHex.toUpperCase());
                tv5.setText("#" + totHex.toUpperCase());

            }
        });


        green.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                // do something here
                tv1.setBackgroundColor(Color.rgb(red.getValue(), newVal, blue.getValue()));
                int rd = red.getValue();
                int gr = newVal;
                int bl = blue.getValue();
                String totHex = ConvertHex(rd, gr, bl);
                tv5.setText("#" + totHex.toUpperCase());

            }
        });



        blue.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                tv1.setBackgroundColor(Color.rgb(red.getValue(), green.getValue(), newVal));
                int rd = red.getValue();
                int gr = green.getValue();
                int bl = newVal;

                String totHex = ConvertHex(rd, gr, bl);
                //  tv2.setText("#" + totHex.toUpperCase());
                tv5.setText("#" + totHex.toUpperCase());

            }
        });





    }

    public String ConvertHex(int rd, int gr, int bl){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb1.append(Integer.toHexString(rd));
        sb2.append(Integer.toHexString(gr));
        sb3.append(Integer.toHexString(bl));

        if (sb1.length() < 2) {
            sb1.insert(0, '0'); // pad with leading zero if needed

        }
        String redString = sb1.toString();


        if (sb2.length() < 2) {
            sb2.insert(0, '0'); // pad with leading zero if needed

        }
        String greenString = sb2.toString();

        if (sb3.length() < 2) {
            sb3.insert(0, '0'); // pad with leading zero if needed

        }
        String blueString = sb3.toString();

        String totHex = redString + greenString + blueString;
        return totHex;

    }


}


