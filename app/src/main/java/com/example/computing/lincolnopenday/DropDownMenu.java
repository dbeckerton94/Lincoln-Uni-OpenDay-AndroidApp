package com.example.computing.lincolnopenday;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu extends Activity implements OnItemSelectedListener {
    Database helper = new Database(this);
    public TextView tv12;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation);
        tv12 = (TextView)findViewById(R.id.buttonans);


        String username = getIntent().getStringExtra("Username");
        String colour = helper.getcolour(username);
        TextView tv13 = (TextView) findViewById(R.id.colourb);
        tv13.setText(colour);

        if (colour.equals("grey")) {
            AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout1);
            mealLayout1.setBackgroundColor(Color.GRAY);
        }
        if (colour.equals("blue")) {
            AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout1);
            mealLayout1.setBackgroundColor(Color.rgb(106,90,205));
        }

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // String Ans = spinner.getSelectedItem().toString();


        // Spinner click listener
        spinner.setOnItemSelectedListener(this);


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("On Campus");
        categories.add("Brayford Quay");
        categories.add("Hayes Wharf");
        categories.add("The Junxion");
        categories.add("Park Court");
        categories.add("The Pavilions");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        String Ans = spinner.getSelectedItem().toString();
        TextView tv12 = (TextView) findViewById(R.id.buttonans);
        tv12.setText(Ans);

    }
    // Item Selected on Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        String Ans = parent.getItemAtPosition(position).toString();
        TextView tv12 = (TextView) findViewById(R.id.buttonans);
        tv12.setText(Ans);

        if (item.equals("On Campus")) {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            TextView tv = (TextView) findViewById(R.id.accomname);
            tv.setText(item);
            ImageView imageView2 = (ImageView) findViewById(R.id.accomimage);
            imageView2.setImageResource(R.drawable.courtspic);
            TextView tv1 = (TextView) findViewById(R.id.accomdesc);
            tv1.setText("The Lincoln Courts is our stunning waterfront accommodation complex, situated on campus in the heart of the Student Village. Lincoln is among the top five UK universities for walkable distances around campus. As such, you will be minutes away from the University’s academic buildings, Student Support Centre and the Engine Shed and the city centre is just a short walk");
            Button b1 = (Button) findViewById(R.id.button2);
            b1.setClickable(true);
        }
        if (item.equals("Hayes Wharf")) {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            TextView tv = (TextView) findViewById(R.id.accomname);
            tv.setText(item);
            ImageView imageView2 = (ImageView) findViewById(R.id.accomimage);
            imageView2.setImageResource(R.drawable.warf);
            TextView tv1 = (TextView) findViewById(R.id.accomdesc);
            tv1.setText("Hayes Wharf is a purpose-built student residence overlooking the Brayford Pool campus. Its 224 en-suite bedrooms are provided in shared apartments of two to five bedrooms.");

        }


        if (item.equals("Brayford Quay")) {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            TextView tv = (TextView) findViewById(R.id.accomname);
            tv.setText(item);
            ImageView imageView2 = (ImageView) findViewById(R.id.accomimage);
            imageView2.setImageResource(R.drawable.rquay);
            TextView tv1 = (TextView) findViewById(R.id.accomdesc);

            tv1.setText("This development is situated opposite the University" + "on Brayford Wharf " +
                    "North and overlooks the waterfront." +
                    "Its 402 en-suite bedrooms are divided into six-bedroom apartments and studio apartments.");


        }
        if (item.equals("The Junxion")) {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            TextView tv = (TextView) findViewById(R.id.accomname);
            tv.setText(item);
            ImageView imageView2 = (ImageView) findViewById(R.id.accomimage);
            imageView2.setImageResource(R.drawable.junx);
            TextView tv1 = (TextView) findViewById(R.id.accomdesc);
            Intent i = new Intent(DropDownMenu.this, MapsActivity.class);
            tv1.setText("Located in the city centre, just opposite the university, The Junxion offers 569 en-suite bedrooms provided in four, five or six-bedroom apartments with fully fitted living areas.");
        }
        if (item.equals("Park Court")) {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            TextView tv = (TextView) findViewById(R.id.accomname);
            tv.setText(item);
            ImageView imageView2 = (ImageView) findViewById(R.id.accomimage);
            imageView2.setImageResource(R.drawable.park);
            TextView tv1 = (TextView) findViewById(R.id.accomdesc);
            tv1.setText("Located close to the Brayford Pool campus and a two-minute walk from the city centre, Park Court is a purpose built development offering 289 en-suite study bedrooms arranged as four and five-bedroom apartments with a shared fully fitted kitchen.");


        }
        if (item.equals("The Pavilions")) {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            TextView tv = (TextView) findViewById(R.id.accomname);
            tv.setText(item);
            ImageView imageView2 = (ImageView) findViewById(R.id.accomimage);
            imageView2.setImageResource(R.drawable.pav);
            TextView tv1 = (TextView) findViewById(R.id.accomdesc);
            tv1.setText("The Pavilions are adjacent to the University’s Sports and Recreation Centre. The accommodation provides 1,329 en-suite bedspaces ranging from self-contained studio flats to six-bedroom apartments which include leather sofas, 32” LCD televisions with free TV licence and Freeview.");

        }
    }
    // Buttons
    public void onButtonClick(View v) {
        if (v.getId() == R.id.button2) {

             if (tv12.getText().toString().equals("On Campus"))
             {
                 String username1;
                 username1 = tv12.getText().toString();
                 String user_1 = username1;
                 Intent i = new Intent(DropDownMenu.this, MapsActivity.class);
                 i.putExtra("Place", user_1);
                 startActivity(i);
            }
            if (tv12.getText().toString().equals("Hayes Wharf"))
            {
                String username1;
                username1 = tv12.getText().toString();
                String user_1 = username1;
                Intent i = new Intent(DropDownMenu.this, MapsActivity.class);
                i.putExtra("Place", user_1);
                startActivity(i);
            }
            if (tv12.getText().toString().equals("Brayford Quay"))
            {
                String username1;
                username1 = tv12.getText().toString();
                String user_1 = username1;
                Intent i = new Intent(DropDownMenu.this, MapsActivity.class);
                i.putExtra("Place", user_1);
                startActivity(i);
            }
            if (tv12.getText().toString().equals("The Junxion"))
            {
                String username1;
                username1 = tv12.getText().toString();
                String user_1 = username1;
                Intent i = new Intent(DropDownMenu.this, MapsActivity.class);
                i.putExtra("Place", user_1);
                startActivity(i);
            }
            if (tv12.getText().toString().equals("Park Court"))
            {
                String username1;
                username1 = tv12.getText().toString();
                String user_1 = username1;
                Intent i = new Intent(DropDownMenu.this, MapsActivity.class);
                i.putExtra("Place", user_1);
                startActivity(i);
            }
            if (tv12.getText().toString().equals("The Pavilions"))
            {
                String username1;
                username1 = tv12.getText().toString();
                String user_1 = username1;
                Intent i = new Intent(DropDownMenu.this, MapsActivity.class);
                i.putExtra("Place", user_1);
                startActivity(i);
            }
        }
        if(v.getId() == R.id.accomsite)
        {
            if (tv12.getText().toString().equals("The Pavilions"))
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.prodigy-living.co.uk/pavilion-house"));
                startActivity(intent);
            }
            if (tv12.getText().toString().equals("Park Court"))
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.touchstonestudentliving.co.uk/locations/lincoln/park-court/"));
                startActivity(intent);
            }
            if (tv12.getText().toString().equals("The Junxion"))
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.mezzino.co.uk/the_junxion.php"));
                startActivity(intent);
            }
            if (tv12.getText().toString().equals("Hayes Wharf"))
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.prodigy-living.co.uk/hayes-wharf-house"));
                startActivity(intent);
            }
            if (tv12.getText().toString().equals("Brayford Quay"))
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.wearehomesforstudents.com/property/brayfordquay/"));
                startActivity(intent);
            }
            if (tv12.getText().toString().equals("On Campus"))
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.lincoln.ac.uk/home/accommodation/oncampus/"));
                startActivity(intent);
            }




        }
        }

    public void onNothingSelected(AdapterView<?> arg0) {

    }



    }




