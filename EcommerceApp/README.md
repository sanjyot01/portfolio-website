# eCommerce Android Application

## Overview
This is a foundational Android eCommerce application built with Java, featuring Material Design principles and responsive layouts for both portrait and landscape orientations.

## Features

### 1. MainActivity
- Company logo placeholder (ImageView)
- "Get Started" button for navigation to LoginActivity
- Responsive layouts for portrait and landscape modes
- Material Design styling

### 2. LoginActivity
- Email input field with validation
  - Checks for empty email
  - Validates email format using Android Patterns
- Password input field with masking
  - Password toggle visibility feature
  - Minimum 6 characters validation
- "Login" button with validation
- "Sign Up" button (placeholder for future functionality)
- Responsive layouts for portrait and landscape modes
- Back navigation support

### 3. ProductActivity
- RecyclerView displaying product list
- Custom Toolbar/ActionBar
- Sample product data with 5 products
- CardView-based product items
- "Add to Cart" functionality (Toast messages)
- Responsive layouts for portrait and landscape modes
- Empty state handling
- Back navigation support

### 4. Product Model
The `Product.java` model class includes:
- `String name` - Product name
- `String imageUrl` - URL for product image
- `double price` - Product price
- `String shortDescription` - Brief product description
- `String fullDescription` - Detailed product description
- `int quantity` - Available stock quantity

## Technical Stack

### Dependencies
- **AndroidX AppCompat** (1.6.1) - Backward compatibility
- **AndroidX Core** (1.12.0) - Core Android utilities
- **Material Design Components** (1.10.0) - Material Design widgets
- **ConstraintLayout** (2.1.4) - Flexible layouts
- **RecyclerView** (1.3.2) - Efficient list display
- **CardView** (1.0.0) - Material card containers
- **Firebase Authentication** (BOM 32.5.0) - User authentication
- **Firebase Analytics** - App analytics

### Build Configuration
- **compileSdk**: 34
- **minSdk**: 24 (Android 7.0)
- **targetSdk**: 34
- **Java Version**: 1.8

## Project Structure
```
EcommerceApp/
├── app/
│   ├── build.gradle                          # App-level dependencies
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml           # App manifest
│           ├── java/com/ecommerce/app/
│           │   ├── MainActivity.java         # Landing screen
│           │   ├── LoginActivity.java        # Login screen
│           │   ├── ProductActivity.java      # Product list screen
│           │   ├── ProductAdapter.java       # RecyclerView adapter
│           │   └── Product.java              # Product model
│           └── res/
│               ├── layout/                   # Portrait layouts
│               │   ├── activity_main.xml
│               │   ├── activity_login.xml
│               │   ├── activity_product.xml
│               │   └── item_product.xml
│               ├── layout-land/              # Landscape layouts
│               │   ├── activity_main.xml
│               │   ├── activity_login.xml
│               │   └── activity_product.xml
│               └── values/
│                   ├── strings.xml           # String resources
│                   ├── colors.xml            # Color palette
│                   └── styles.xml            # App themes
├── build.gradle                              # Project-level build config
├── settings.gradle                           # Project settings
└── gradle/wrapper/                           # Gradle wrapper
```

## Navigation Flow
1. **MainActivity** → "Get Started" button → **LoginActivity**
2. **LoginActivity** → "Login" button (after validation) → **ProductActivity**
3. All activities support back navigation via ActionBar

## Design Principles

### Material Design
- Material Design Components for UI elements
- Material Card for product items
- Material TextInputLayout for form fields
- Elevation and shadows for depth
- Material color palette (Purple/Teal theme)

### Responsive Design
- Portrait and landscape layouts for all activities
- ConstraintLayout for flexible positioning
- ScrollView for content that may overflow
- Adaptive spacing and sizing

### Validation
- Email validation using Android Patterns
- Password length validation (minimum 6 characters)
- Real-time error display using TextInputLayout
- User feedback via Toast messages

## Setup Instructions

### Prerequisites
- Android Studio (latest version)
- Android SDK (API 24+)
- Java Development Kit (JDK 8+)

### Building the App
1. Clone the repository
2. Open the `EcommerceApp` folder in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or physical device

### Firebase Setup (Optional)
To enable Firebase Authentication:
1. Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
2. Download `google-services.json`
3. Place it in the `app/` directory
4. Firebase Authentication and Analytics will be ready to use

## Future Enhancements
- Implement Firebase Authentication for actual login
- Add Sign Up functionality
- Product detail view
- Shopping cart functionality
- Checkout process
- User profile management
- Product search and filtering
- Image loading with Glide/Picasso
- Database integration for products
- Payment gateway integration

## Notes
- This is a foundational structure for an eCommerce app
- Some features (Sign Up, actual authentication) are placeholders
- Product images use placeholders (android drawable icons)
- Sample data is hardcoded in ProductActivity
- All layouts support both portrait and landscape orientations

## Author
Created as a foundational Android eCommerce application demonstrating:
- Proper project structure
- Activity navigation with Intents
- Form validation
- RecyclerView implementation
- Material Design principles
- Responsive layouts
