package com.example.computing.lincolnopenday;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Openday extends AppCompatActivity {

    //Initilise
    EditText editTextCityName;
    TextView textViewResult;
    Database helper = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openday);
        editTextCityName = (EditText)findViewById(R.id.cityname);
        textViewResult = (TextView)findViewById(R.id.textweather);
        new OpenWeatherMapTask(editTextCityName.getText().toString(), textViewResult).execute();

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
    }
    private class OpenWeatherMapTask extends AsyncTask<Void, Void, String> {

        String cityName;
        TextView tvResult;

        String dummyAppid = "43f731e0e6e3a844ac57868b9325b259";
        String queryWeather = "http://api.openweathermap.org/data/2.5/weather?q=Lincoln,uk";
        String queryDummyKey = "&appid=" + dummyAppid;

        OpenWeatherMapTask(String cityName, TextView tvResult){
            this.cityName = cityName;
            this.tvResult = tvResult;
        }
        @Override
        protected String doInBackground(Void... params) {
            String result = "";
            String queryReturn;

            String query = null;
            try {
                query = queryWeather + URLEncoder.encode(cityName, "UTF-8") + queryDummyKey;
                queryReturn = sendQuery(query);
                result += ParseJSON(queryReturn);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                queryReturn = e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                queryReturn = e.getMessage();
            }
            final String finalQueryReturn = query + "\n\n" + queryReturn;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                }});
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            tvResult.setText(s);
        }
        private String sendQuery(String query) throws IOException {
            String result = "";

            URL searchURL = new URL(query);

            HttpURLConnection httpURLConnection = (HttpURLConnection)searchURL.openConnection();
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(
                        inputStreamReader,
                        8192);

                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();
            }
            return result;
        }
        private String ParseJSON(String json){
            String jsonResult = "";
            try {
                JSONObject JsonObject = new JSONObject(json);
                String cod = jsonHelperGetString(JsonObject, "cod");

                if(cod != null){
                    if(cod.equals("200")){

                        jsonResult += jsonHelperGetString(JsonObject, "name") ;
                        jsonResult += ", ";
                        JSONObject sys = jsonHelperGetJSONObject(JsonObject, "sys");
                        if(sys != null){
                            jsonResult += jsonHelperGetString(sys, "country") + "\n";
                        }
                        JSONArray weather = jsonHelperGetJSONArray(JsonObject, "weather");


                        if(weather != null){
                            for(int i=0; i<weather.length(); i++){
                                JSONObject thisWeather = weather.getJSONObject(i);
                                jsonResult += "weather " + ": ";
                                jsonResult += jsonHelperGetString(thisWeather, "description") + "\n";
                            }
                        }
                        JSONObject main = jsonHelperGetJSONObject(JsonObject, "main");
                        if(main != null){
                            jsonResult += "temp: " + jsonHelperGetString(main, "temp") + "\n";
                            jsonResult += "humidity: " + jsonHelperGetString(main, "humidity") + "\n";
                        }
                        JSONObject wind = jsonHelperGetJSONObject(JsonObject, "wind");
                        if(wind != null){
                            jsonResult += "Wind speed: " + jsonHelperGetString(wind, "speed") + "\n";
                        }
                    }else if(cod.equals("404")){
                        String message = jsonHelperGetString(JsonObject, "message");
                        jsonResult += "cod 404: " + message;
                    }
                }else{
                    jsonResult += "cod == null\n";
                }

            } catch (JSONException e) {
                e.printStackTrace();
                jsonResult += e.getMessage();
            }

            return jsonResult;
        }

        private String jsonHelperGetString(JSONObject obj, String k){
            String v = null;
            try {
                v = obj.getString(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return v;
        }

        private JSONObject jsonHelperGetJSONObject(JSONObject obj, String k){
            JSONObject o = null;

            try {
                o = obj.getJSONObject(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return o;
        }

        private JSONArray jsonHelperGetJSONArray(JSONObject obj, String k){
            JSONArray a = null;

            try {
                a = obj.getJSONArray(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return a;
        }
    }
    public void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.findbuild:
                Intent a = new Intent(Openday.this, MainActivity.class);
                startActivity(a);
                break;
            case R.id.parkbutton:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.google.com/maps/d/viewer?mid=zH05Eb-iAANU.k7RU_-iEN1tY&hl=en"));
                startActivity(intent);
                break;
        }
    }


        }



