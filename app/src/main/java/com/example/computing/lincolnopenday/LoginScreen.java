package com.example.computing.lincolnopenday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends Activity {
    // Connect to Datavase
    Database helper = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_screen, menu);
        return true;
    }
    // Buttons
    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.Blogin)
        {
            // Check Authentification
            EditText a = (EditText)findViewById(R.id.TFusername); // Username
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFpassword); // Password
            String pass = b.getText().toString();
            String password = helper.searchPass(str); // Databse Helper

            // Password Check
            if(pass.equals(password))
            {
                Intent i = new Intent(LoginScreen.this, Mainmenu.class);
                i.putExtra("Username",str);
                startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(LoginScreen.this , "Your Username and password don't match!" , Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        if(v.getId() == R.id.Bsignup)
    {
        Intent i = new Intent(LoginScreen.this, Register.class);
        startActivity(i);
    }
        if(v.getId() == R.id.forgotpass)
        {
            Intent i = new Intent(LoginScreen.this, forgot.class);
            startActivity(i);
        }
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
