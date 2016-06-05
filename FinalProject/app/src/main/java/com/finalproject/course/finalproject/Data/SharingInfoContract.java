package com.finalproject.course.finalproject.Data;

import android.provider.BaseColumns;

/**
 * Sharing Information Contract : products, recipes and tips
 */
public class SharingInfoContract {

    //Products
        public  static  class ProductsEntry implements BaseColumns {
            public static  final String TABLE_NAME = "ProductsTBL";
            public static  final String PRODUCT_NAME = "product_name";
            public static  final String STORE_NAME = "store_name";
            public static  final String IMAGE = "image";
            public static  final String STORE_URL = "store_url";
            public static  final String CITY = "city";
            public static  final String STREET = "street";
            public static  final String HOUSE_NO = "house_no";
            public static  final String COMMENT = "comment";
            public static  final String PHONE = "phone";
            public static  final String DATE_MODIFIED = "date_modified";
    }
}
