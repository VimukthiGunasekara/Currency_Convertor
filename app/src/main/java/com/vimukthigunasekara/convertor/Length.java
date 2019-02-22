package com.vimukthigunasekara.convertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.icu.util.Currency;

import java.util.ArrayList;
import java.util.List;

public class Length extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    private Button BtnConvert;
    private double multiplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        addItemsOnSpinner01();
        addItemsOnSpinner02();
    }

    public void addItemsOnSpinner01() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Meter");
        list.add("KiloMeter");
        list.add("Centimeter");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinner02() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("Meter");
        list.add("KiloMeter");
        list.add("Centimeter");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void ConvertClick(View view) {

        TextView textOne = findViewById(R.id.txtOne);
        TextView textTwo = findViewById(R.id.txtTwo);

        String TextOne = textOne.getText().toString();
        double TEXTONE = Double.parseDouble(TextOne);

        if (TextOne == ""){
            Toast.makeText(this, "TextBox Cannot Be Null", Toast.LENGTH_SHORT).show();
        }
        else {
            double FinalTEXTONE = TEXTONE*180;
            textTwo.setText( "" + FinalTEXTONE);
        }
    }

    public enum Unit {
        INCH,
        CENTIMETER,
        FOOT,
        YARD,
        METER,
        MILE,
        KILOMETER;

        // Helper method to convert text to one of the above constants
        public static Unit fromString(String text) {
            if (text != null) {
                for (Unit unit : Unit.values()) {
                    if (text.equalsIgnoreCase(unit.toString())) {
                        return unit;
                    }
                }
            }

            throw new IllegalArgumentException("Cannot find a value for " + text);
        }
    }

    public Length(Unit from, Unit to) {
        double constant = 1;
        // Set the multiplier, else if fromUnit = toUnit, then it is 1
        switch (from) {
            case INCH:
                if (to == Unit.CENTIMETER) {
                    constant = 2.54;
                } else if (to == Unit.FOOT) {
                    constant = 0.0833333;
                } else if (to == Unit.YARD) {
                    constant = 0.0277778;
                } else if (to == Unit.METER) {
                    constant = 0.0254;
                } else if (to == Unit.MILE) {
                    constant = 1.5783e-5;
                } else if (to == Unit.KILOMETER) {
                    constant = 2.54e-5;
                }
                break;
            case CENTIMETER:
                if (to == Unit.INCH) {
                    constant = 0.393701;
                } else if (to == Unit.FOOT) {
                    constant = 0.0328084;
                } else if (to == Unit.YARD) {
                    constant = 0.0109361;
                } else if (to == Unit.METER) {
                    constant = 0.01;
                } else if (to == Unit.MILE) {
                    constant = 6.2137e-6;
                } else if (to == Unit.KILOMETER) {
                    constant = 1e-5;
                }
                break;
            case FOOT:
                if (to == Unit.INCH) {
                    constant = 12;
                } else if (to == Unit.CENTIMETER) {
                    constant = 30.48;
                } else if (to == Unit.YARD) {
                    constant = 0.333333;
                } else if (to == Unit.METER) {
                    constant = 0.3048;
                } else if (to == Unit.MILE) {
                    constant = 0.000189394;
                } else if (to == Unit.KILOMETER) {
                    constant = 0.0003048;
                }
                break;
            case YARD:
                if (to == Unit.INCH) {
                    constant = 36;
                } else if (to == Unit.CENTIMETER) {
                    constant = 91.44;
                } else if (to == Unit.FOOT) {
                    constant = 3;
                } else if (to == Unit.METER) {
                    constant = 0.9144;
                } else if (to == Unit.MILE) {
                    constant = 0.000568182;
                } else if (to == Unit.KILOMETER) {
                    constant = 0.0009144;
                }
                break;
            case METER:
                if (to == Unit.INCH) {
                    constant = 39.3701;
                } else if (to == Unit.CENTIMETER) {
                    constant = 100;
                } else if (to == Unit.FOOT) {
                    constant = 3.28084;
                } else if (to == Unit.YARD) {
                    constant = 1.09361;
                } else if (to == Unit.MILE) {
                    constant = 0.000621371;
                } else if (to == Unit.KILOMETER) {
                    constant = 0.001;
                }
                break;
            case MILE:
                if (to == Unit.INCH) {
                    constant = 63360;
                } else if (to == Unit.CENTIMETER) {
                    constant = 160934;
                } else if (to == Unit.FOOT) {
                    constant = 5280;
                } else if (to == Unit.YARD) {
                    constant = 1760;
                } else if (to == Unit.METER) {
                    constant = 1609.34;
                } else if (to == Unit.KILOMETER) {
                    constant = 1.60934;
                }
                break;
            case KILOMETER:
                if (to == Unit.INCH) {
                    constant = 39370.1;
                } else if (to == Unit.CENTIMETER) {
                    constant = 100000;
                } else if (to == Unit.FOOT) {
                    constant = 3280.84;
                } else if (to == Unit.YARD) {
                    constant = 1093.61;
                } else if (to == Unit.METER) {
                    constant = 1000;
                } else if (to == Unit.MILE) {
                    constant = 0.621371;
                }
                break;
        }

        multiplier = constant;
    }
    // Convert the unit!
    public double convert(double input) {
        return input * multiplier;
    }
}
