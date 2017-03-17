package com.example.computing.lincolnopenday;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Activity {
    Database helper = new Database(this);
    public TextView tv13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final String username = getIntent().getStringExtra("Username");
        String colour = helper.getcolour(username);
        TextView tv13 = (TextView) findViewById(R.id.tv14);
        tv13.setText(colour);


        if (colour.equals("grey")) {
            AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout);
            mealLayout1.setBackgroundColor(Color.GRAY);
            View b = findViewById(R.id.changeTheme);
            b.setVisibility(View.GONE);
        }
        if (colour.equals("blue")) {
            AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout);
            mealLayout1.setBackgroundColor(Color.rgb(106, 90, 205));
            View b = findViewById(R.id.button1);
            b.setVisibility(View.GONE);
        }
    }
    public void onButtonClick(View v) {
        if (v.getId() == R.id.Changepass) {
            EditText passwordchange = (EditText) findViewById(R.id.inputnewpass); // Name

            if (passwordchange.getText().toString().equals("")) {
                Toast pass = Toast.makeText(Settings.this, "Please Fill in the field to change your password", Toast.LENGTH_SHORT);
                pass.show();
                ;
            } else {

                String msg2 = String.valueOf(passwordchange.getText());
                final String username = getIntent().getStringExtra("Username");
                helper.editpassword(username, msg2);
                Toast pass = Toast.makeText(Settings.this, "Your Password has been Changed", Toast.LENGTH_SHORT);
                pass.show();
            }
        }
            if (v.getId() == R.id.logoutofaccount) {
                Intent e = new Intent(Settings.this, LoginScreen.class);
                Toast pass1 = Toast.makeText(Settings.this, "You have Logged-out", Toast.LENGTH_SHORT);
                pass1.show();
                startActivity(e);
            }
            if (v.getId() == R.id.changeTheme) {
                String colourset = "grey";
                final String username = getIntent().getStringExtra("Username");
                helper.editcolour(username, colourset);
                AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout);
                mealLayout1.setBackgroundColor(Color.GRAY);
                View b = findViewById(R.id.changeTheme);
                b.setVisibility(View.GONE);
                View a = findViewById(R.id.button1);
                a.setVisibility(View.VISIBLE);
                Toast pass1 = Toast.makeText(Settings.this, "Background changed, Logout to Apply change", Toast.LENGTH_SHORT);
                pass1.show();

            }
            if (v.getId() == R.id.button1) {

                String colourset = "blue";
                final String username = getIntent().getStringExtra("Username");
                helper.editcolour(username, colourset);
                AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout);
                mealLayout1.setBackgroundColor(Color.rgb(106, 90, 205));
                View b = findViewById(R.id.button1);
                b.setVisibility(View.GONE);
                View a = findViewById(R.id.changeTheme);
                a.setVisibility(View.VISIBLE);
                Toast pass1 = Toast.makeText(Settings.this, "Background changed, Logout to Apply change", Toast.LENGTH_SHORT);
                pass1.show();

            }
    }

}









