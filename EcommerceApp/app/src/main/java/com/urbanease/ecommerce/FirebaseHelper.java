package com.urbanease.ecommerce;

import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class FirebaseHelper {
    
    public static void seedProducts(FirebaseFirestore db, Runnable onComplete) {
        // 8 unique products for Firestore database
        Product[] products = {
            new Product("1", "Wireless Headphones", "", 79.99, 
                "Premium noise-cancelling headphones", 
                "Experience crystal clear audio with active noise cancellation technology. 40-hour battery life, comfortable over-ear design, and premium sound quality for music lovers and professionals.", 
                50),
            
            new Product("2", "Smart Watch", "", 199.99, 
                "Fitness tracking smartwatch", 
                "Track your fitness goals with heart rate monitoring, GPS tracking, sleep analysis, and smartphone notifications. Water-resistant design with 7-day battery life.", 
                30),
            
            new Product("3", "Laptop Stand", "", 34.99, 
                "Ergonomic aluminum stand", 
                "Improve your posture with this adjustable laptop stand made from premium aluminum. Compatible with all laptop sizes, featuring heat dissipation design and cable management.", 
                100),
            
            new Product("4", "USB-C Hub", "", 49.99, 
                "7-in-1 connectivity hub", 
                "Expand your laptop connectivity with multiple ports including HDMI 4K output, USB 3.0, SD card reader, and 100W power delivery. Compact and portable design.", 
                75),
            
            new Product("5", "Mechanical Keyboard", "", 129.99, 
                "RGB backlit gaming keyboard", 
                "Enjoy tactile feedback with premium mechanical switches, customizable RGB lighting, and programmable macro keys. Built for gamers and typists who demand the best.", 
                40),
            
            new Product("6", "Wireless Mouse", "", 39.99, 
                "Ergonomic wireless mouse", 
                "Comfortable design with precision tracking, programmable buttons, and long battery life. Works on any surface with adjustable DPI settings up to 3200.", 
                80),
            
            new Product("7", "4K Monitor", "", 299.99, 
                "27-inch 4K display", 
                "Stunning visual clarity with 4K UHD resolution, HDR support, and vibrant colors. Perfect for content creation, gaming, and professional work with multiple input options.", 
                25),
            
            new Product("8", "HD Webcam", "", 89.99, 
                "1080p streaming webcam", 
                "Professional video quality for meetings and streaming with auto-focus, light correction, and dual microphones. Plug-and-play USB connection with tripod mount.", 
                60)
        };
        
        int[] completed = {0};
        for (Product product : products) {
            Map<String, Object> productMap = new HashMap<>();
            productMap.put("name", product.getName());
            productMap.put("imageUrl", product.getImageUrl());
            productMap.put("price", product.getPrice());
            productMap.put("shortDescription", product.getShortDescription());
            productMap.put("fullDescription", product.getFullDescription());
            productMap.put("stockQuantity", product.getStockQuantity());
            
            db.collection("products")
                .document(product.getId())
                .set(productMap)
                .addOnCompleteListener(task -> {
                    completed[0]++;
                    if (completed[0] == products.length && onComplete != null) {
                        onComplete.run();
                    }
                });
        }
    }
}