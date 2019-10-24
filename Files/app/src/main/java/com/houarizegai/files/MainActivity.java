package com.houarizegai.files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt = findViewById(R.id.editTxt);
    }

    public void onSave(View view) {
        try {
            FileOutputStream out = this.openFileOutput("test.txt", this.MODE_PRIVATE);
            String content = editTxt.getText().toString();

            out.write(content.getBytes());
            out.close();

            Toast.makeText(this, "Success saved!", Toast.LENGTH_LONG).show();
            editTxt.setText(null);
        } catch(IOException ioe) {
            editTxt.setText(ioe.getMessage());
        }
    }

    public void onLoad(View view) {
        try {
            FileInputStream in = this.openFileInput("test.txt");

            StringBuilder content = new StringBuilder();
            int i = 0;

            while((i = in.read()) != -1) {
                content.append((char) i);
            }
            in.close();

            editTxt.setText(content.toString());
        } catch(IOException ioe) {
            editTxt.setText(ioe.getMessage());
        }
    }

}
