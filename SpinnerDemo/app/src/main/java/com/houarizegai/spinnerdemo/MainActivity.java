package com.houarizegai.spinnerdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.houarizegai.spinnerdemo.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPlanets;
    private TextView txtSelectedSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPlanets = findViewById(R.id.spinnerPlanets);
        txtSelectedSpinner = findViewById(R.id.txtSelectedSpinner);

//        createSimpleSpinner();
        createCustomeSpinner();
    }

    private void createSimpleSpinner() {
        final List<String> spinnerData = Arrays.asList("Software", "Enginner", "Mathematic", "Electric");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerData);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPlanets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtSelectedSpinner.setText(String.format("Index: %d, Item: %s", position, spinnerData.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerPlanets.setSelection(0);
            }
        });

        spinnerPlanets.setAdapter(spinnerAdapter);
    }

    private void createCustomeSpinner() {
        final List<Product> spinnerData = Arrays.asList(
                new Product("Iphone 7", "IT's a very nice phone.", R.drawable.phone1),
                new Product("Galaxy J7 Pro", "IT's a very good phone.", R.drawable.phone2),
                new Product("Nokia", "IT's a very good phone.", R.drawable.phone3),
                new Product("Y7 Prime 2019", "IT's a very cool phone.", R.drawable.phone4)
        );
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this, R.layout.spinner_row, spinnerData);
        spinnerPlanets.setAdapter(spinnerAdapter);
    }

    class SpinnerAdapter extends ArrayAdapter<Product> {
        private List<Product> productList;
        private LayoutInflater inflater;

        public SpinnerAdapter(Context context, int resource, List<Product> productList) {
            super(context, resource, productList);
            this.productList = productList;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = inflater.inflate(R.layout.spinner_row, parent, false);

            ImageView img = itemView.findViewById(R.id.img);
            TextView txtName = itemView.findViewById(R.id.txtName);
            TextView txtDetails = itemView.findViewById(R.id.txtDetails);

            Product item = productList.get(position);
            img.setImageResource(item.getImg());
            txtName.setText(item.getName());
            txtDetails.setText(item.getDetails());

            return itemView;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return getView(position, convertView, parent);
        }
    }
}
