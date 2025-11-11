package com.urbanease.ecommerce;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Initialize RecyclerView using findViewById
        recyclerView = findViewById(R.id.recycler_view_products);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Create hardcoded product list
        products = new ArrayList<>();
        
        // Add 8 products as specified
        products.add(new Product(
            "1",
            "Wireless Headphones",
            "",
            79.99,
            "Premium noise-cancelling headphones",
            "Experience crystal clear audio with active noise cancellation, 40-hour battery life, and superior comfort for all-day listening."
        ));

        products.add(new Product(
            "2",
            "Smart Watch",
            "",
            199.99,
            "Fitness tracking smartwatch",
            "Track your fitness goals with heart rate monitoring, GPS tracking, and comprehensive health metrics in a stylish design."
        ));

        products.add(new Product(
            "3",
            "Laptop Stand",
            "",
            34.99,
            "Ergonomic aluminum stand",
            "Improve your posture with this adjustable laptop stand featuring premium aluminum construction and ventilation design."
        ));

        products.add(new Product(
            "4",
            "USB-C Hub",
            "",
            49.99,
            "7-in-1 connectivity hub",
            "Expand your laptop with multiple ports including HDMI, USB 3.0, SD card reader, and USB-C power delivery."
        ));

        products.add(new Product(
            "5",
            "Mechanical Keyboard",
            "",
            129.99,
            "RGB backlit gaming keyboard",
            "Enjoy tactile feedback with premium switches, customizable RGB lighting, and durable construction for gaming and productivity."
        ));

        products.add(new Product(
            "6",
            "Wireless Mouse",
            "",
            39.99,
            "Ergonomic wireless mouse",
            "Comfortable design with precision tracking, programmable buttons, and long-lasting battery life for effortless navigation."
        ));

        products.add(new Product(
            "7",
            "4K Monitor",
            "",
            299.99,
            "27-inch 4K display",
            "Stunning visual clarity for work and entertainment with 4K resolution, HDR support, and ultra-thin bezels."
        ));

        products.add(new Product(
            "8",
            "HD Webcam",
            "",
            89.99,
            "1080p streaming webcam",
            "Professional video quality for meetings and streaming with 1080p resolution, autofocus, and built-in noise-cancelling microphone."
        ));

        // Set up adapter
        productAdapter = new ProductAdapter(this, products);
        recyclerView.setAdapter(productAdapter);
    }
}
