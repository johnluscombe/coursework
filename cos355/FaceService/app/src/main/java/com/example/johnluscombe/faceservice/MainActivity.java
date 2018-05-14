package com.example.johnluscombe.faceservice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView greeting;
    private Uri image_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greeting = (TextView)findViewById(R.id.greeting);

        Intent intent = getIntent();
        if (intent.getAction().matches(Intent.ACTION_SEND)) {
            image_uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
            new FacePlusPlusTask().execute();
        }

    }

    private class FacePlusPlusTask extends AsyncTask<Void, Void, DetectionData> {

        @Override
        protected void onPostExecute(DetectionData detectionData) {
            super.onPostExecute(detectionData);

            String age = detectionData.faces[0].attributes.age.value;
            String gender = detectionData.faces[0].attributes.gender.value;
            String ethnicity = detectionData.faces[0].attributes.ethnicity.value;

            greeting.setText(String.format("%s, %s, %s", age, gender, ethnicity));
        }

        @Override
        protected DetectionData doInBackground(Void... params) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api-us.faceplusplus.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            FaceService service = retrofit.create(FaceService.class);

            String encoded_image;

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), image_uri);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                encoded_image = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            RequestBody key = RequestBody.create(null, "3i9xBpooem3N8FxaT-WZJphj_wUNsoft");
            RequestBody secret = RequestBody.create(null, "iK_BqBiDHbw8kMNEMcrKDb9xK_9bAi1h");
            //RequestBody url = RequestBody.create(
            //        null, "http://i2.mirror.co.uk/incoming/article5423743.ece/ALTERNATES/s615b/MOST-BEAUTIFUL-FACES.jpg"
            //);
            RequestBody image_base64 = RequestBody.create(null, encoded_image);
            RequestBody attributes = RequestBody.create(null, "gender,age,ethnicity");

            Call<DetectionData> request = service.detect(key, secret, image_base64, attributes);

            DetectionData detectionResults = null;

            try {
                Response<DetectionData> info = request.execute();
                detectionResults = info.body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return detectionResults;
        }
    }
}
