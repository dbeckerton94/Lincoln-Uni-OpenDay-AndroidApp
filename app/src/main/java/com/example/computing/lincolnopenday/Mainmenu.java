package com.example.computing.lincolnopenday;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.TextView;

public class Mainmenu extends Activity {
    // Database
    Database helper = new Database(this);
    String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        //Display Username
        String username = getIntent().getStringExtra("Username");
        user_name = username;
        TextView tv = (TextView) findViewById(R.id.displayfullname);
        tv.setText(helper.getName(username));

        //Get Colour
        String colour = helper.getcolour(username);
        TextView tv13 = (TextView) findViewById(R.id.colourb);
        tv13.setText(colour);

        //Colour Choice
        if (colour.equals("grey")) {
            AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout1);
            mealLayout1.setBackgroundColor(Color.GRAY);
        }
        if (colour.equals("blue")) {
            AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout1);
            mealLayout1.setBackgroundColor(Color.rgb(106,90,205));
        }
    }
    // Buttons to Navigate
    public void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.settingbutton:
                Intent a = new Intent(Mainmenu.this, Settings.class);
                a.putExtra("Username", user_name);
                startActivity(a);
                break;
            case R.id.imageaccom:
                Intent b = new Intent(Mainmenu.this, DropDownMenu.class);
                b.putExtra("Username", user_name);
                startActivity(b);
                break;
            case R.id.imageday:
                Intent c = new Intent(Mainmenu.this, Openday.class);
                c.putExtra("Username", user_name);
                startActivity(c);
                break;
            case R.id.imagenews:
                Intent d = new Intent(Mainmenu.this, TwitterFeedActivity.class);
                d.putExtra("Username", user_name);
                startActivity(d);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mainmenu, menu);
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
