package com.vimukthigunasekara.convertor;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button btnShowPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowPopup = (Button) findViewById(R.id.btnInfo);
    }

    public void Lengthclick(View view) {
        Intent i = new Intent(this,Length.class);
        startActivity(i);
    }

    public void CurrencyClick(View view) {
        Intent i = new Intent(this,Currency.class);
        startActivity(i);
    }

    public void infoClick(View view) {
        displayPopupWindow(view);
    }

        private void displayPopupWindow(View anchorView) {
            PopupWindow popup = new PopupWindow(MainActivity.this);
            View layout = getLayoutInflater().inflate(R.layout.popup_content, null);
            popup.setContentView(layout);
            // Set content width and height
            popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
            popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
            // Closes the popup window when touch outside of it - when looses focus
            popup.setOutsideTouchable(true);
            popup.setFocusable(true);
            // Show anchored to button
            popup.setBackgroundDrawable(new BitmapDrawable());
            popup.showAsDropDown(anchorView);
        }
}
