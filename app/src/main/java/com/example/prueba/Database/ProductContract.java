package com.example.prueba.Database;

import android.provider.BaseColumns;

public class ProductContract {
    public static abstract class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "product";

        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String PRICE = "price";
        public static final String LOCATION = "location";

    }
}
