package com.vimukthigunasekara.convertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Currency extends AppCompatActivity {

    private TextView USD, LKR, EURO, MALE, CAN, AUS, IND, CNY, SEK, PKR, GBP, RUB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
    }

    public void CCClick(View view) {
        USD = findViewById(R.id.txtUSD);
        LKR = findViewById(R.id.txtLKR);
        MALE = findViewById(R.id.txtMALA);
        EURO = findViewById(R.id.txtEURO);
        CAN = findViewById(R.id.txtCAN);
        AUS = findViewById(R.id.txtAUS);
        IND = findViewById(R.id.txtIND);
        CNY = findViewById(R.id.txtCNY);
        SEK = findViewById(R.id.txtSEK);
        PKR = findViewById(R.id.txtPKR);
        GBP = findViewById(R.id.txtGBP);
        RUB = findViewById(R.id.txtRUB);

        String usd = USD.getText().toString();
        double USD_Value = Double.parseDouble(usd);

        if(USD.getText().toString() != null){
            double LKR_Value = USD_Value * 179.49;
            LKR.setText("" + LKR_Value);

            double MALE_Value = USD_Value * 4.07;
            MALE.setText("" + MALE_Value);

            double EURO_Value = USD_Value * 0.88;
            EURO.setText("" + EURO_Value);

            double CAN_Value = USD_Value * 1.32;
            CAN.setText("" + CAN_Value);

            double AUS_Value = USD_Value * 1.41;
            AUS.setText("" + AUS_Value);

            double IND_Value = USD_Value * 71.19;
            IND.setText("" + IND_Value);

            double CNY_Value = USD_Value * 6.72;
            CNY.setText("" + CNY_Value);

            double SEK_Value = USD_Value * 9.37;
            SEK.setText("" + SEK_Value);

            double PKR_Value = USD_Value * 139.82;
            PKR.setText("" + PKR_Value);

            double GBP_Value = USD_Value * 0.76;
            GBP.setText("" + GBP_Value);

            double RUB_Value = USD_Value * 65.53;
            RUB.setText("" + RUB_Value);
        }else {
            Toast.makeText(this, "USD Value Cann't be Null", Toast.LENGTH_SHORT).show();
        }
    }
}
