package com.example.victor.currencyconverter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import junit.framework.TestCase;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    private double m_euroValue = 1.13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textDollar = (TextView) findViewById(R.id.textDollar);
        final TextView textEuro = (TextView) findViewById(R.id.textEuro);
        final TextView textWc = (TextView) findViewById(R.id.textWc);
        final TextView textC = (TextView) findViewById(R.id.textC);
        final TextView textNc = (TextView) findViewById(R.id.textNc);
        final TextView textEuroWc = (TextView) findViewById(R.id.textEuroWc);
        final TextView textDollarWc = (TextView) findViewById(R.id.textDollarWc);
        final TextView textConvertedDollar = (TextView) findViewById(R.id.textConvertedDollar);
        final TextView textConvertedEuro = (TextView) findViewById(R.id.textConvertedEuro);
        final EditText editDollar = (EditText) findViewById(R.id.editDollar);
        final EditText editEuro = (EditText) findViewById(R.id.editEuro);
        final EditText editCommission = (EditText) findViewById(R.id.editCommission);
        final CheckBox checkCommission = (CheckBox) findViewById(R.id.checkCommission);

        editEuro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {

                    textConvertedDollar.setText("");

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
        editEuro.setText("1", TextView.BufferType.EDITABLE);
        textConvertedDollar.setText("1.13");
        editDollar.setVisibility(View.VISIBLE);
        textWc.setVisibility(View.INVISIBLE);
        textEuroWc.setVisibility(View.INVISIBLE);
        textDollarWc.setVisibility(View.INVISIBLE);
        editCommission.setVisibility(View.INVISIBLE);
        editCommission.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==0){
                    textWc.setVisibility(View.INVISIBLE);
                    textEuroWc.setVisibility(View.INVISIBLE);
                    textDollarWc.setVisibility(View.INVISIBLE);
                    editCommission.setVisibility(View.INVISIBLE);
                }else{

                    if (Double.parseDouble(editCommission.getText().toString()) > 0) {
                        textWc.setVisibility(View.VISIBLE);
                        textEuroWc.setVisibility(View.VISIBLE);
                        textDollarWc.setVisibility(View.VISIBLE);
                        editCommission.setVisibility(View.VISIBLE);
                        if(editDollar.getText().length()>0){
                            textEuroWc.setText(String.valueOf(Double.parseDouble(textConvertedEuro.getText().toString())+Double.parseDouble(textConvertedEuro.getText().toString()) * Double.parseDouble(editCommission.getText().toString())/100));
                        }
                        if(editEuro.getText().length()>0){
                            textDollarWc.setText(String.valueOf(Double.parseDouble(textConvertedDollar.getText().toString())+Double.parseDouble(textConvertedDollar.getText().toString())* Double.parseDouble(editCommission.getText().toString())/100));
                        }


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
                    textWc.setVisibility(View.VISIBLE);
                    textEuroWc.setVisibility(View.VISIBLE);
                    textDollarWc.setVisibility(View.VISIBLE);
                    editCommission.setVisibility(View.VISIBLE);
                    if(editCommission.getText().length()>0){
                        if(editDollar.getText().length()>0){
                            textEuroWc.setText(String.valueOf(Double.parseDouble(textConvertedDollar.getText().toString())+Double.parseDouble(textConvertedDollar.getText().toString()) * Double.parseDouble(editCommission.getText().toString())/100));
                        }
                        if(editEuro.getText().length()>0){
                            textDollarWc.setText(String.valueOf(Double.parseDouble(textConvertedEuro.getText().toString())+Double.parseDouble(textConvertedEuro.getText().toString())  * Double.parseDouble(editCommission.getText().toString())/100));
                        }
                    }

                }else{
                    textWc.setVisibility(View.INVISIBLE);
                    textEuroWc.setVisibility(View.INVISIBLE);
                    textDollarWc.setVisibility(View.INVISIBLE);
                    editCommission.setVisibility(View.INVISIBLE);
                }
            }
        });


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

