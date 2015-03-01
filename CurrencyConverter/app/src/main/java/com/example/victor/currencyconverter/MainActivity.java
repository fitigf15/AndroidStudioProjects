package com.example.victor.currencyconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
    private double m_euroValue = 1.13; // will determine the euro-dollar conversion, counting the Dollar as 1 and the Euro as 1.13

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textEuroWc = (TextView) findViewById(R.id.textEuroWc); // will contain the converted value from Dollar to Euro applying a commission
        final TextView textDollarWc = (TextView) findViewById(R.id.textDollarWc); // will contain the converted value from Euro to Dollar applying a commission
        final TextView textConvertedDollar = (TextView) findViewById(R.id.textConvertedDollar); // will contain the converted value from Euro to Dollar
        final TextView textConvertedEuro = (TextView) findViewById(R.id.textConvertedEuro); // will contain the converted value from Dollar to Euro
        final EditText editDollar = (EditText) findViewById(R.id.editDollar); // will contain the value we want to convert from Dollar to Euro
        final EditText editEuro = (EditText) findViewById(R.id.editEuro); // will contain the value we want to convert from Euro to Dollar
        final EditText editCommission = (EditText) findViewById(R.id.editCommission); // will contain the commission we want to apply on the conversions
        final CheckBox checkCommission = (CheckBox) findViewById(R.id.checkCommission); // will determine if we want to apply a commission or not on our conversions
        final Switch switchEuroUsd = (Switch) findViewById(R.id.switchEurUsd); // will determine the focus on editEuro or editDollar

        //listeners explained on the wiki

        editEuro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {

                    textConvertedDollar.setText("");
                    textDollarWc.setText("");

                } else {
                    textConvertedDollar.setText(String.valueOf(Double.parseDouble(editEuro.getText().toString()) * m_euroValue));
                    if(editCommission.getText().length()>0){
                        textDollarWc.setText(String.valueOf(Double.parseDouble(textConvertedDollar.getText().toString())+Double.parseDouble(textConvertedDollar.getText().toString())* Double.parseDouble(editCommission.getText().toString())/100));
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editDollar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    textConvertedEuro.setText("");
                    textEuroWc.setText("");

                } else {
                    textConvertedEuro.setText(String.valueOf(Double.parseDouble(editDollar.getText().toString()) / m_euroValue));
                    if(editCommission.getText().length()>0){
                        textEuroWc.setText(String.valueOf(Double.parseDouble(textConvertedEuro.getText().toString())+Double.parseDouble(textConvertedEuro.getText().toString())* Double.parseDouble(editCommission.getText().toString())/100));
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editCommission.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==0 || !checkCommission.isChecked()){
                    textEuroWc.setVisibility(View.GONE);
                    textEuroWc.setText("", TextView.BufferType.EDITABLE);
                    textDollarWc.setVisibility(View.GONE);
                    textDollarWc.setText("", TextView.BufferType.EDITABLE);
                }else{

                    textEuroWc.setVisibility(View.VISIBLE);
                    textDollarWc.setVisibility(View.VISIBLE);
                    if(textConvertedEuro.getText().length()==0){
                        textEuroWc.setText("");

                    }else{
                        textEuroWc.setText(String.valueOf(Double.parseDouble(textConvertedEuro.getText().toString())+Double.parseDouble(textConvertedEuro.getText().toString()) * Double.parseDouble(editCommission.getText().toString())/100));

                    }
                    if(textConvertedDollar.getText().length()==0){
                        textDollarWc.setText("");
                    }else{
                        textDollarWc.setText(String.valueOf(Double.parseDouble(textConvertedDollar.getText().toString())+Double.parseDouble(textConvertedDollar.getText().toString())* Double.parseDouble(editCommission.getText().toString())/100));


                    }


                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        checkCommission.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editCommission.setVisibility(View.VISIBLE);
                    editCommission.requestFocus();
                    if(editCommission.getText().length()==0){
                        textEuroWc.setVisibility(View.GONE);
                        textEuroWc.setText("");
                        textDollarWc.setVisibility(View.GONE);
                        textDollarWc.setText("");
                    }else{
                        textEuroWc.setVisibility(View.VISIBLE);
                        textDollarWc.setVisibility(View.VISIBLE);
                        if(textConvertedEuro.getText().length()==0){
                            textEuroWc.setText("");

                        }else{
                            textEuroWc.setText(String.valueOf(Double.parseDouble(textConvertedEuro.getText().toString())+Double.parseDouble(textConvertedEuro.getText().toString()) * Double.parseDouble(editCommission.getText().toString())/100));

                        }
                        if(textConvertedDollar.getText().length()==0){
                            textDollarWc.setText("");
                        }else{
                            textDollarWc.setText(String.valueOf(Double.parseDouble(textConvertedDollar.getText().toString())+Double.parseDouble(textConvertedDollar.getText().toString())* Double.parseDouble(editCommission.getText().toString())/100));
                        }
                    }

                }else{
                    textEuroWc.setVisibility(View.GONE);
                    textEuroWc.setText("");
                    textDollarWc.setVisibility(View.GONE);
                    textDollarWc.setText("");
                    editCommission.setVisibility(View.GONE);


                }
            }
        });
        switchEuroUsd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editDollar.requestFocus();

                }else{
                    editEuro.requestFocus();
                }
            }
        });
        //some sample values for the user to let him get started with the app and let him know how does it work
        editEuro.setText("1", TextView.BufferType.EDITABLE);
        editDollar.setText("1", TextView.BufferType.EDITABLE);
        editCommission.setText("10", TextView.BufferType.EDITABLE);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

