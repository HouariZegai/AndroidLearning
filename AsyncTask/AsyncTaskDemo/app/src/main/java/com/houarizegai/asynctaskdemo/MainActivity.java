package com.houarizegai.asynctaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String END_POINT = "http://192.168.1.37:8080";

    private TextView txtData;
    private EditText editHost, editName, editComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = findViewById(R.id.txtData);
        editHost = findViewById(R.id.editHost);
        editName = findViewById(R.id.editName);
        editComment = findViewById(R.id.editComment);
    }

    public void onPost(View view) {
        StringBuilder url = new StringBuilder();

        if(editHost.getText() != null && !editHost.getText().toString().isEmpty()) {
            url.append("http://").append(editHost.getText().toString().trim());
        } else {
            url.append(END_POINT);
        }

        url.append("/add?name=").append(editName.getText().toString())
                .append("&comment=").append(editComment.getText().toString()).toString();

        new MyAsyncTask().execute(url.toString());
    }

    public void onLoad(View view) {
        StringBuilder url = new StringBuilder();

        if(editHost.getText() != null && !editHost.getText().toString().isEmpty()) {
            url.append("http://").append(editHost.getText().toString().trim());
        } else {
            url.append(END_POINT);
        }

        url.append("/comments");
        new MyAsyncTask().execute(url.toString());
    }

    public class MyAsyncTask extends AsyncTask<String, String, String> {

        private String newsData;

        @Override
        protected void onPreExecute() {
            newsData = "";
        }

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Try connect to the server..");
            try {
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                publishProgress("Start read buffer..");
                newsData = inputStreamToString(in);
                in.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                publishProgress("Cannot connect to the server..");
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            txtData.setText(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            txtData.setText(newsData);
            editName.setText(null);
            editComment.setText(null);
        }
    }

    private static String inputStreamToString(InputStream in) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        StringBuilder strBuilder = new StringBuilder();

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                strBuilder.append(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return strBuilder.toString();
    }
}
