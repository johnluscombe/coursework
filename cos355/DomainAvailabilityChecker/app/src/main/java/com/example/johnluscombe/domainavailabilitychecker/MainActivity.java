package com.example.johnluscombe.domainavailabilitychecker;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String domainJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCheckDomainButton();
    }

    private void setCheckDomainButton() {
        Button checkDomainButton = (Button)findViewById(R.id.checkDomainButton);
        checkDomainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DomainTask().execute();
            }
        });
    }

    private void setMemberVariables() {
        String domain = ((EditText)findViewById(R.id.domain)).getText().toString();
        try {
            domainJSON = new JSONObject().put("domain", domain).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private class DomainTask extends AsyncTask<Void, Void, DomainData> {
        @Override
        protected void onPostExecute(DomainData domainData) {
            super.onPostExecute(domainData);

            boolean available = domainData.available;

            Intent intent = new Intent(getApplicationContext(), DomainActivity.class);
            intent.putExtra("available", available);
            startActivity(intent);
        }

        @Override
        protected DomainData doInBackground(Void... params) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://domainstatus.p.mashape.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            DomainService service = retrofit.create(DomainService.class);
            setMemberVariables();
            RequestBody domainRequestBody = RequestBody.create(null, domainJSON);
            Call<DomainData> request = service.check(domainRequestBody);

            DomainData domainResults = null;

            try {
                Response<DomainData> info = request.execute();
                domainResults = info.body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return domainResults;
        }
    }
}
