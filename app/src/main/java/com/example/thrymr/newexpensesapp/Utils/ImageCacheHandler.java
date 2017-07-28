package com.example.thrymr.newexpensesapp.Utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.thrymr.newexpensesapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageCacheHandler {

    public static ImageCacheHandler instance;

    private Context mContext;
    private ContextWrapper contextWrapper;
    private File directory;

    private Bitmap bitmap = null;

    private ImageCacheHandler(Context context) {

        mContext = context;
        contextWrapper = new ContextWrapper(mContext);
        directory = contextWrapper.getDir("image_cache", Context.MODE_PRIVATE);

    }

    public static ImageCacheHandler getInstance(Context context) {
        if (instance == null)
            instance = new ImageCacheHandler(context);
        return instance;

    }

    public void setImage(final ImageView imageView, final String userId, String imageURL) {
        bitmap = findImageFromMemory(userId);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            Picasso.with(mContext)
                    .load(imageURL)
                    .placeholder(R.drawable.loading)   // optional
                    .error(R.drawable.shrikant)
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            try {
                                saveImageToMemory(userId, ((BitmapDrawable) imageView.getDrawable()).getBitmap());
                                bitmap = findImageFromMemory(userId);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onError() {

                        }
                    });

        }


      /*  final String fileName = userId;
        bitmap = findImageFromMemory(fileName);
        //imageView.setImageResource(R.drawable.gurudwar);
        if (bitmap != null) {
            Log.d("Imagecachehandler", "bitmap file" + bitmap.getByteCount());
            imageView.setImageBitmap(bitmap);
        } else {
            new DownloadImageAsync(fileName, new DownloadCallback() {
                @Override
                public void downloadFinished(boolean status) {

                    if (status) {

                        bitmap = findImageFromMemory(fileName);

                        if (bitmap != null) {
                            imageView.setImageBitmap(bitmap);
                        }


                    }
                }
            }).execute(imageURL);

        }*/

    }

    public void setImageFit(final ImageView imageView, final String userId, String imageURL) {
        bitmap = findImageFromMemory(userId);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            Picasso.with(mContext)
                    .load(imageURL)
                    .placeholder(R.drawable.loading)   // optional
                    .error(R.drawable.shrikant)
                    .fit()
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            try {
                                saveImageToMemory(userId, ((BitmapDrawable) imageView.getDrawable()).getBitmap());
                                bitmap = findImageFromMemory(userId);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onError() {

                        }
                    });

        }


      /*  final String fileName = userId;
        bitmap = findImageFromMemory(fileName);
        //imageView.setImageResource(R.drawable.gurudwar);
        if (bitmap != null) {
            Log.d("Imagecachehandler", "bitmap file" + bitmap.getByteCount());
            imageView.setImageBitmap(bitmap);
        } else {
            new DownloadImageAsync(fileName, new DownloadCallback() {
                @Override
                public void downloadFinished(boolean status) {

                    if (status) {

                        bitmap = findImageFromMemory(fileName);

                        if (bitmap != null) {
                            imageView.setImageBitmap(bitmap);
                        }


                    }
                }
            }).execute(imageURL);

        }*/

    }

    /**
     * Method to save image to the memory
     *
     * @param name   name with which the image should be saved
     * @param bitmap bitmap of the image
     * @return returns true if the operation is successful
     * @throws IOException
     */
    private boolean saveImageToMemory(String name, Bitmap bitmap) throws IOException {

        FileOutputStream fileOutputStream = null;

        try {
            File image = new File(directory, name + ".jpeg");
            fileOutputStream = new FileOutputStream(image);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (fileOutputStream != null)
                fileOutputStream.close();
        }
    }


    private Bitmap findImageFromMemory(String userId) {

        if (userId != null) {
            try {
                File file = new File(directory, userId + ".jpeg");
                Log.d("ImageID", file + "");
                if (file.exists()) {

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    return BitmapFactory.decodeStream(new FileInputStream(file), null, options);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * Callback interface which need to be implemented by the calling method
     */
    private interface DownloadCallback {
        public void downloadFinished(boolean status);
    }

    /**
     * Asynctask to download the image from the specified url
     */
    private class DownloadImageAsync extends AsyncTask<String, Void, Boolean> {

        String fileName;
        DownloadCallback downloadCallback;

        public DownloadImageAsync(String fileName, DownloadCallback callback) {
            // TODO Auto-generated constructor stub
            this.fileName = fileName;
            downloadCallback = callback;
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                InputStream is = new URL(params[0]).openStream();
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                if (bitmap != null) {
                    saveImageToMemory(fileName, bitmap);
                }

                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {

            downloadCallback.downloadFinished(result);
        }

    }

}
