package com.houarizegai.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuItemBack) {
            Toast.makeText(this, "Back is clicked!", Toast.LENGTH_LONG).show();
        } else if(id == R.id.menuItemAdd) {
            Toast.makeText(this, "Add is clicked!", Toast.LENGTH_LONG).show();
        } else if(id == R.id.menuItemExit) {
            Toast.makeText(this, "Exit was clicked!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
