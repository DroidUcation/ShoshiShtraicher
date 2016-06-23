package com.gfcommunity.course.gfcommunity.firebase.storage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.gfcommunity.course.gfcommunity.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;


public class UploadPostTask extends AsyncTask<Void, Void, Void> {
    private Context context;
    private OutputStream outFile;
    private String logTag = UploadPostTask.class.getName();
    private Bitmap bitmap;

    public UploadPostTask(OutputStream outFile, Bitmap bitmap, Context context) {
        this.context = context;
        this.outFile = outFile;
        this.bitmap = bitmap;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Void doInBackground(Void... params) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://" + context.getString(R.string.google_storage_bucket));

        // Create a child reference imagesRef now points to "images"
        StorageReference imagesRef = storageRef.child("images");
        StorageReference productRef = storageRef.child("images/product.jpg"); //TODO: add timestamp for unique
        //byte[] data = ((ByteArrayOutputStream) outFile).toByteArray();



        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = productRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.e(logTag, "Failed to upload image to firebase storage");
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //taskSnapshot.getMetadata(); contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
            }
        });
        return null;
    }
}
