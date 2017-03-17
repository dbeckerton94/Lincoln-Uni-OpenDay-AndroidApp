package com.example.computing.lincolnopenday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
    Database helper = new Database(this); // Call Database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onSignUpClick(View v) {
        if (v.getId() == R.id.ButtonSignup) {
            EditText name = (EditText) findViewById(R.id.Inputname); // Name
            EditText email = (EditText) findViewById(R.id.Inputemail); // Email
            EditText uname = (EditText) findViewById(R.id.Inputusername); // Username
            EditText pass1 = (EditText) findViewById(R.id.Inputpassword1); // Password
            EditText pass2 = (EditText) findViewById(R.id.Inputpassword2); // Password Check

            //Error Handel
            if (name.getText().toString().equals("") || email.getText().toString().equals("")  || uname.getText().toString().equals("") || pass1.getText().toString().equals("")
                    || pass2.getText().toString().equals(""))
            {
                Toast pass = Toast.makeText(Register.this, "Please Fill in all fields!", Toast.LENGTH_SHORT);
                pass.show();
                ;
            } else {


                // Strings to Database
                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                String unamestr = uname.getText().toString();
                String pass1str = pass1.getText().toString();
                String pass2str = pass2.getText().toString();
                String colourset = "o";

                // Checks Users Passwords Match
                if (!pass1str.equals(pass2str)) {
                    //Error Handel Passwords Do Not Math
                    Toast pass = Toast.makeText(Register.this, "Your Passwords Do Not Match, Try Again!", Toast.LENGTH_SHORT);
                    pass.show();
                } else {
                    // Contacts The Database with new user
                    Contact c = new Contact();
                    c.setName(namestr);
                    c.setEmail(emailstr);
                    c.setUname(unamestr);
                    c.setPass(pass1str);
                    c.setColour(colourset);

                    //Displays Message to Know user has completed sign in process
                    helper.insertContact(c);
                    Toast pass = Toast.makeText(Register.this, "You Have Registered!", Toast.LENGTH_SHORT);
                    pass.show();
                    Intent b = new Intent(Register.this, LoginScreen.class);
                    startActivity(b);
                }

            }

        }

    }
}
