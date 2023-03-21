package com.example.schoolproject.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolproject.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class AppConstant {

    public static String IS_DARK_MODE_ON = "no";

    public static String TOKEN = "token";
    public static String IS_LOGIN = "is_login";
    public static String PREVIOUS_STARTED = "prev_started";
    public static String LANGUAGE = "user_language";
    public static String NAME = "name";
    public static String EMAIL = "email";
    public static String PASSWORD = "password";

    public static boolean isOnline(final Context ctx) {
        if (ctx != null) {
            final ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    final NetworkInfo ni = cm.getActiveNetworkInfo();
                    Network activeNetwork = cm.getActiveNetwork();
                    NetworkCapabilities caps = cm.getNetworkCapabilities(activeNetwork);
                    if (caps != null) {
                        boolean vpnInUse = caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN);
                        if (vpnInUse) {
                            Toast.makeText(ctx, ctx.getString(R.string.vpn), Toast.LENGTH_SHORT).show();
                            return false;
                        } else {
                            if (ni != null) {
                                if (ni.isConnectedOrConnecting()) {
                                    return true;
                                } else {
                                    Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                                    return false;
                                }
                            } else {
                                Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        }
                    } else {
                        Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                        return false;
                    }

                } else {
                    NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_VPN);
                    if (networkInfo != null) {
                        if (networkInfo.isConnectedOrConnecting()) {
                            Toast.makeText(ctx, "Please disconnect VPN and try again.", Toast.LENGTH_SHORT).show();
                            return false;
                        } else {
                            final NetworkInfo ni = cm.getActiveNetworkInfo();
                            if (ni != null) {
                                if (ni.isConnectedOrConnecting()) {
                                    return true;
                                } else {
                                    Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                                    return false;
                                }
                            } else {
                                Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        }
                    } else {
                        Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());
        return time;
    }

    public static void setLanguage(Context activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("LANGUAGE_SETTING", Context.MODE_PRIVATE);
        String languageToLoad;
        if (sharedPreferences.getString(com.example.schoolproject.helper.AppConstant.LANGUAGE, "en").equalsIgnoreCase("en")) {
            languageToLoad = "en"; // your language
        } else {
            languageToLoad = "gu";
        }
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        activity.getResources().updateConfiguration(config,
                activity.getResources().getDisplayMetrics());
    }

    public static File getFileFromUri(Context context, Uri uri) {
        File file = null;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            String path = context.getFilesDir().getAbsolutePath() + File.separator + "default";
            OutputStream outFile = null;
            file = new File(path, String.valueOf("tmp" + System.currentTimeMillis()) + "kdahconnect.jpg");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            outFile = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 30, outFile);
            outFile.flush();
            outFile.close();
        } catch (Exception e) {
            Log.d("DATA", e.getMessage());
        }
        return file;
    }

        public static void runLayoutAnimation(RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animaion_from_scale);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

}
