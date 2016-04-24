package com.easydeliver.clientapp.util;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.math.BigDecimal;

/**
 * Created by tomlee on 14/12/15.
 */
public class Utils {



    /**
     * Intent to open the official Instagram app to the user's profile. If the Instagram app is not
     * installed then the Web Browser will be used.</p>
     *
     * Example usage:</p> {@code newInstagramProfileIntent(context.getPackageManager(),
     *     "http://instagram.com/jaredrummler");}</p>
     *
     * @param pm
     *            The {@link PackageManager}. You can find this class through
     *            .
     * @param url
     *            The URL to the user's Instagram profile.
     * @return The intent to open the Instagram app to the user's profile.
     */
    public static Intent newInstagramProfileIntent(PackageManager pm, String url) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            if (pm.getPackageInfo("com.instagram.android", 0) != null) {
                if (url.endsWith("/")) {
                    url = url.substring(0, url.length() - 1);
                }
                final String username = url.substring(url.lastIndexOf("/") + 1);
                // http://stackoverflow.com/questions/21505941/intent-to-open-instagram-user-profile-on-android
                intent.setData(Uri.parse("http://instagram.com/_u/" + username));
                intent.setPackage("com.instagram.android");
                return intent;
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        intent.setData(Uri.parse(url));
        return intent;
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
