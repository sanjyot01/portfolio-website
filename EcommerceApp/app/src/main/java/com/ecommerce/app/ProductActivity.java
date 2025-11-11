package com.ecommerce.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private TextView tvNoProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.products);
        }

        // Initialize views
        recyclerView = findViewById(R.id.recycler_view_products);
        tvNoProducts = findViewById(R.id.tv_no_products);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Initialize product list with sample data
        productList = new ArrayList<>();
        loadSampleProducts();

        // Set up adapter
        productAdapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(productAdapter);

        // Show/hide empty message
        updateEmptyView();
    }

    private void loadSampleProducts() {
        // Sample products for demonstration
        productList.add(new Product(
            "Wireless Headphones",
            "https://via.placeholder.com/150",
            79.99,
            "Premium wireless headphones with noise cancellation",
            "High-quality wireless headphones featuring active noise cancellation, " +
            "40-hour battery life, and superior sound quality.",
            15
        ));

        productList.add(new Product(
            "Smartphone",
            "https://via.placeholder.com/150",
            699.99,
            "Latest flagship smartphone with advanced features",
            "Powerful smartphone with 5G connectivity, triple camera system, " +
            "and all-day battery life.",
            8
        ));

        productList.add(new Product(
            "Laptop",
            "https://via.placeholder.com/150",
            1299.99,
            "High-performance laptop for professionals",
            "Premium laptop featuring the latest processor, 16GB RAM, " +
            "512GB SSD, and stunning display.",
            5
        ));

        productList.add(new Product(
            "Smart Watch",
            "https://via.placeholder.com/150",
            249.99,
            "Feature-rich smartwatch with health tracking",
            "Advanced smartwatch with heart rate monitoring, GPS, " +
            "and multiple sport modes.",
            20
        ));

        productList.add(new Product(
            "Tablet",
            "https://via.placeholder.com/150",
            449.99,
            "Versatile tablet for work and entertainment",
            "Powerful tablet with large display, stylus support, " +
            "and long battery life.",
            12
        ));
    }

    private void updateEmptyView() {
        if (productList.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            tvNoProducts.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            tvNoProducts.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
