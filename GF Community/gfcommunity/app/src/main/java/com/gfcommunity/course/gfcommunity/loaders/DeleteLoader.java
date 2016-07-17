package com.gfcommunity.course.gfcommunity.loaders;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.AsyncTaskLoader;

import com.gfcommunity.course.gfcommunity.data.products.ProductsContentProvider;

/**
 * Delete product/recipe by asyncTaskLoader
 */
public class DeleteLoader extends AsyncTaskLoader<Integer> {
    private Uri uri;
    private Context context;

    public DeleteLoader(Context context, Uri uri) {
        super(context);
        this.uri = uri;
        this.context = context;
    }

    @Override
    public Integer loadInBackground() {
        return context.getContentResolver().delete(uri, null, null);
    }
}
