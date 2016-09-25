package com.majorproject.ckaa.travelwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverterActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Spinner spinnerCurrency;
    private Button convertBtn;
    private EditText inputCurrency;
    private TextView displayCurrency;
    public double currencyRate = 0.0;
    public double input = 0.0;
    public double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addListenerOnButton();
        //addListenerOnSpinnerItemSelection();
    }

    public void addItemsOnSpinner2() {

        spinnerCurrency = (Spinner) findViewById(R.id.spinnerCurrency);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinnerCurrency = (Spinner) findViewById(R.id.spinnerCurrency);
        spinnerCurrency.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton() {

        spinnerCurrency = (Spinner) findViewById(R.id.spinnerCurrency);
        convertBtn = (Button) findViewById(R.id.btnConvert);
        inputCurrency = (EditText) findViewById(R.id.inputcurrency);
        displayCurrency = (TextView) findViewById(R.id.displayCurrency);


        convertBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (String.valueOf(spinnerCurrency.getSelectedItem())) {
                    case "US Dollar (107.54)":
                        currencyRate = 107.54;
                        break;
                    case "European Euro (121.42)":
                        currencyRate = 121.42;
                        break;
                    case "UK Pound Sterling (142.31)":
                        currencyRate = 142.31;
                        break;
                    case "Japanese Yen (10.71)":
                        currencyRate = 10.71;
                        break;
                    case "Indian Rupees (1.60)":
                        currencyRate = 1.60;
                        break;
                    default:
                        currencyRate = 0.0;
                        break;

                }

                input = Double.valueOf(String.valueOf(inputCurrency.getText()));
                result = input * currencyRate;
                displayCurrency.setText("Nepali Rs. " + result);


//                Toast.makeText(MainActivity.this,
//                        "OnClickListener : " +
//                                "\nSpinner 1 : "+ String.valueOf(spinnerCurrency.getSelectedItem()) +
//                        Toast.LENGTH_SHORT).show();
            }

        });
    }

}









