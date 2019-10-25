package com.houarizegai.listviewproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.houarizegai.listviewproducts.model.Product;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProduct = findViewById(R.id.listViewProduct);

        List<Product> products = Arrays.asList(
                new Product("Galaxy S7", "700$", R.drawable.phone1),
                new Product("Sony Z3", "400$", R.drawable.phone2),
                new Product("Galaxy S8", "800$", R.drawable.phone3),
                new Product("Nokia", "467$", R.drawable.phone4)
        );

        ProductAdapter productAdapter = new ProductAdapter(products);
        listViewProduct.setAdapter(productAdapter);
    }

    class ProductAdapter extends BaseAdapter {

        List<Product> products;

        public ProductAdapter(List<Product> products) {
            this.products = products;
        }

        @Override
        public int getCount() {
            return products.size();
        }

        @Override
        public Object getItem(int position) {
            return products.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product_list_view, null);

            TextView txtName = view.findViewById(R.id.txtName);
            TextView txtCost = view.findViewById(R.id.txtCost);
            ImageView img = view.findViewById(R.id.img);
            Button btnDetails = view.findViewById(R.id.btnDetails);

            txtName.setText(products.get(position).getName());
            txtCost.setText(products.get(position).getCost());
            img.setImageResource(products.get(position).getImg());

            btnDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), products.get(position).getName(), Toast.LENGTH_LONG).show();
                }
            });

            return view;
        }
    }
}
