package com.houarizegai.listviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.houarizegai.listviewsample.model.ListItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editDesc;

    private MyCustomAdapter myAdapter;
    private ArrayList listData = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editDesc = findViewById(R.id.editDesc);

        // List View init
        listData.add(new ListItem("Java", "Very cool language i use it in many things like making desktop app and more.."));
        listData.add(new ListItem("Javascript", "It this good language"));
        listData.add(new ListItem("Python", "It this one of the language"));

        myAdapter = new MyCustomAdapter(listData);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtName = view.findViewById(R.id.txtName);
                TextView txtDescription = view.findViewById(R.id.txtDescription);

                Toast.makeText(getApplicationContext(), txtName.getText() + " : " + txtDescription.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onAdd(View view) {
        listData.add(new ListItem(editName.getText().toString(), editDesc.getText().toString()));
        myAdapter.notifyDataSetChanged();

        editName.setText(null);
        editDesc.setText(null);
    }

    class MyCustomAdapter extends BaseAdapter {

        private ArrayList<ListItem> items;

        public MyCustomAdapter(ArrayList<ListItem> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public String getItem(int position) {
            if(position < 0)
                return null;

            return items.get(position).getName();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.row_view, null);

            TextView txtName = view.findViewById(R.id.txtName);
            TextView txtDescription = view.findViewById(R.id.txtDescription);

            txtName.setText(items.get(position).getName());
            txtDescription.setText(items.get(position).getDescription());

            return view;
        }
    }
}
