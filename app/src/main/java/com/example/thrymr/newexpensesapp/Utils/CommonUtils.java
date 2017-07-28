package com.example.thrymr.newexpensesapp.Utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thrymr.newexpensesapp.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommonUtils {
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    //Email Pattern
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static void launch(Context activity, Class className) {
        Intent intent = new Intent(activity, className);
        activity.startActivity(intent);
    }


    public static boolean isNotNull(String txt) {
        return !(txt != null && txt.trim().length() > 0);
    }


    public static boolean validate(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static ProgressDialog getProgressDialog(Context context) {
        if (context != null) {
            ProgressDialog prgDialog = new ProgressDialog(context);
            prgDialog.setProgress(0);
            prgDialog.setCancelable(false);
            prgDialog.setCanceledOnTouchOutside(false);
            prgDialog.setMax(100);
            return prgDialog;
        }
        return null;
    }


    public static boolean checkNetworkConnection(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLocationPermission(Activity context, String actionName) {
        if (ContextCompat.checkSelfPermission(context,
                actionName)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                    actionName)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(context,
                        new String[]{actionName},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(context,
                        new String[]{actionName},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }



    //image view decode file
    private static Bitmap decodeFile(File f) {
        try {
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

            final int REQUIRED_SIZE = 800;

            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE && o.outHeight / scale / 2 >= REQUIRED_SIZE)
                scale *= 2;

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Bitmap rotateImage(Bitmap bitmap, File fileName) {
        int rotateAngle = 0;
        ExifInterface ei = null;
        try {
            ei = new ExifInterface(fileName.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                rotateAngle = 90;
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                rotateAngle = 180;
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                rotateAngle = 270;
                break;
            case ExifInterface.ORIENTATION_NORMAL:
            default:
                break;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(rotateAngle);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix,
                true);
    }


    //Toast Message Display ...EMP 32
    public static void showToastMessage(Context context, String s) {
        if (context != null)
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

    }

    public static boolean edittextValidation(EditText editText, String message) {
        if (editText.getText().toString().trim().equalsIgnoreCase("")) {
            editText.setError(message);
            return false;
        }
        return true;
    }

    // Used to convert 24hr format to 12hr format with AM/PM values




    public static String imageAsByteArrayString(String selectedImagePath, ImageView ivpfUpload, boolean circleimage) {

        File imgFile = new File(selectedImagePath);

        Bitmap bitmap = CommonUtils.decodeFile(imgFile);
        Bitmap bitmap1 = rotateImage(bitmap, imgFile);

        if (circleimage) {
            Bitmap resized = Bitmap.createScaledBitmap(bitmap1, 200, 200, true);
            ivpfUpload.setImageBitmap(resized);
        } else {
            ivpfUpload.setVisibility(View.VISIBLE);
            ivpfUpload.setImageBitmap(bitmap1);
            ivpfUpload.getFitsSystemWindows();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

    }

    public static String imageAsByteArrayString(String selectedImagePath) {

        File imgFile = new File(selectedImagePath);

        Bitmap bitmap = CommonUtils.decodeFile(imgFile);
        Bitmap bitmap1 = rotateImage(bitmap, imgFile);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

    }

    public static void getActionBarView(ActionBar supportActionBar) {
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowCustomEnabled(false);
            supportActionBar.setDisplayShowTitleEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeButtonEnabled(true);
            supportActionBar.setHomeAsUpIndicator(R.drawable.left_arrow);
            supportActionBar.setDisplayUseLogoEnabled(true);
        }
    }





    public static File rotateImageAndStoreLocalFile(String pictureImagePath) {
        String filename = "permasol.png";
        File sd = Environment.getExternalStorageDirectory();
        File dest = new File(sd, filename);

        try {
            FileOutputStream out = new FileOutputStream(dest);
            CommonUtils.rotateImage(CommonUtils.decodeFile(new File(pictureImagePath)), new File(pictureImagePath)).compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dest;
    }

    public static String getAppVersion(Context context) {
        String version = "";

        try {

            version = Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException var2) {
        }

        return version;
    }
}
