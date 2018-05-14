package com.example.johnluscombe.lovecalculator;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String first_name;
    String last_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCalculateLoveButton();
    }

    private void setCalculateLoveButton() {
        Button calculateLoveButton = (Button)findViewById(R.id.calculateLoveButton);
        calculateLoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoveTask().execute();
            }
        });
    }

    private void setMemberVariables() {
        first_name = ((EditText)findViewById(R.id.firstName)).getText().toString();
        last_name = ((EditText)findViewById(R.id.lastName)).getText().toString();
    }

    private class LoveTask extends AsyncTask<Void, Void, LoveData> {

        @Override
        protected void onPostExecute(LoveData loveData) {
            super.onPostExecute(loveData);

            String fname = loveData.fname;
            String lname = loveData.sname;
            String percentage = loveData.percentage;
            String result = loveData.result;

            Intent intent = new Intent(getApplicationContext(), LoveActivity.class);
            intent.putExtra("first_name", fname);
            intent.putExtra("last_name", lname);
            intent.putExtra("percentage", percentage);
            intent.putExtra("result", result);
            startActivity(intent);
        }

        @Override
        protected LoveData doInBackground(Void... params) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://love-calculator.p.mashape.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            LoveService service = retrofit.create(LoveService.class);
            setMemberVariables();
            Call<LoveData> request = service.detect(first_name, last_name);

            LoveData loveData = null;

            try {
                Response<LoveData> info = request.execute();
                loveData = info.body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return loveData;
        }
    }
}
