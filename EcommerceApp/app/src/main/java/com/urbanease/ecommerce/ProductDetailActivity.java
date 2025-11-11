package com.urbanease.ecommerce;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName;
    private TextView productPrice;
    private TextView productFullDesc;
    private EditText quantityInput;
    private Button addToCartBtn;
    private Button goToCartBtn;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Get product from intent
        product = (Product) getIntent().getSerializableExtra("product");

        // Initialize views using findViewById
        productImage = findViewById(R.id.detail_product_image);
        productName = findViewById(R.id.detail_product_name);
        productPrice = findViewById(R.id.detail_product_price);
        productFullDesc = findViewById(R.id.detail_product_full_desc);
        quantityInput = findViewById(R.id.detail_quantity_input);
        addToCartBtn = findViewById(R.id.detail_btn_add_to_cart);
        goToCartBtn = findViewById(R.id.detail_btn_go_to_cart);

        // Bind product data to UI
        if (product != null) {
            productName.setText(product.getName());
            productPrice.setText("$" + String.format("%.2f", product.getPrice()));
            productFullDesc.setText(product.getFullDescription());

            // Set placeholder image with color based on product id
            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.RECTANGLE);
            
            // Different color for each product
            int[] colors = {
                Color.parseColor("#FF5722"), // Deep Orange
                Color.parseColor("#2196F3"), // Blue
                Color.parseColor("#4CAF50"), // Green
                Color.parseColor("#9C27B0"), // Purple
                Color.parseColor("#FF9800"), // Orange
                Color.parseColor("#00BCD4"), // Cyan
                Color.parseColor("#E91E63"), // Pink
                Color.parseColor("#009688")  // Teal
            };
            
            try {
                int productId = Integer.parseInt(product.getId());
                drawable.setColor(colors[(productId - 1) % 8]);
            } catch (NumberFormatException e) {
                drawable.setColor(colors[0]);
            }
            
            productImage.setBackground(drawable);
        }

        // Set default quantity
        quantityInput.setText("1");

        // Add to Cart button click listener
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = quantityInput.getText().toString();
                if (product != null) {
                    Toast.makeText(ProductDetailActivity.this, 
                        quantity + "x " + product.getName() + " added to cart", 
                        Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Go to Cart button click listener
        goToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductDetailActivity.this, 
                    "Cart view will be implemented later", 
                    Toast.LENGTH_SHORT).show();
            }
        });
    }
}
