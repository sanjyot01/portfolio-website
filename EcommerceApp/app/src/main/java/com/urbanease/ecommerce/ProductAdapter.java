package com.urbanease.ecommerce;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    
    private Context context;
    private ArrayList<Product> productList;
    
    // Constructor
    public ProductAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;
    }
    
    // Inner ViewHolder class
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productPrice;
        TextView productShortDesc;
        Button addToCartBtn;
        MaterialCardView cardView;
        
        public ProductViewHolder(View itemView) {
            super(itemView);
            // Use findViewById for each widget
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productShortDesc = itemView.findViewById(R.id.product_short_desc);
            addToCartBtn = itemView.findViewById(R.id.btn_add_to_cart);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
    
    @Override
    public int getItemCount() {
        return productList.size();
    }
    
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the row layout
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.product_row, parent, false);
        return new ProductViewHolder(itemView);
    }
    
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        // Get product at this position
        Product product = productList.get(position);
        
        // Bind data to widgets
        holder.productName.setText(product.getName());
        holder.productPrice.setText("$" + String.format("%.2f", product.getPrice()));
        holder.productShortDesc.setText(product.getShortDescription());
        
        // Set placeholder image - create colored drawable based on position
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        
        // Different color for each product (cycle through 8 colors)
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
        drawable.setColor(colors[position % 8]);
        holder.productImage.setBackground(drawable);
        
        // Click on CardView -> go to ProductDetailActivity
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("product", product);
                context.startActivity(intent);
            }
        });
        
        // Click on Add to Cart button -> show Toast for now
        holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, product.getName() + " added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
