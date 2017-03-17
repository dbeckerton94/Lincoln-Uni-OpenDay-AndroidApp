package com.example.computing.lincolnopenday;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    //Initilise
    private Button scanBtn;
    private TextView formatTxt, contentTxt;
    //Connect to Database
    Database helper = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanBtn = (Button) findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        scanBtn.setOnClickListener(this);

        String username = getIntent().getStringExtra("Username");
        String colour = helper.getcolour(username);
        TextView tv13 = (TextView) findViewById(R.id.colourb);
        tv13.setText(colour);

        // Colour Choice

        if (colour.equals("grey")) {
            AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout1);
            mealLayout1.setBackgroundColor(Color.GRAY);
        }
        if (colour.equals("blue")) {
            AbsoluteLayout mealLayout1 = (AbsoluteLayout) findViewById(R.id.meallayout1);
            mealLayout1.setBackgroundColor(Color.rgb(106, 90, 205));
        }


    }
    public void onClick(View v){
        if(v.getId()==R.id.scan_button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText(" " + scanFormat);
            contentTxt.setText(" " + scanContent);
        }

        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
        String scanContent = scanningResult.getContents();
        if (scanContent.equals("AAD"))
        {
            ImageView imageView2 = (ImageView) findViewById(R.id.imageView8);
            imageView2.setImageResource(R.drawable.find);
            TextView tv1 = (TextView) findViewById(R.id.textView3);
            tv1.setText("Your are at The AAD building, located on the map above with the yellow star");
        }
        if (scanContent.equals("MHT"))
        {
            ImageView imageView2 = (ImageView) findViewById(R.id.imageView8);
            imageView2.setImageResource(R.drawable.find1);
            TextView tv1 = (TextView) findViewById(R.id.textView3);
            tv1.setText("Your are at The MHT building, located on the map above with the yellow star");
        }



    }
}