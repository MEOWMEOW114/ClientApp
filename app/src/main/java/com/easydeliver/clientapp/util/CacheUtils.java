package com.easydeliver.clientapp.util;

/**
 * Created by tomlee on 30/11/15.
 */
public class CacheUtils {


//    public static Set<String> getCookies(Context context){
//        return PreferenceManager.getDefaultSharedPreferences(context).getStringSet(Constants.SHAREDPREF_CACHE_COOKIE, null);
//    }
//
//    ////
//    public static void putAuthToken(Context context, String  authToken){
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        sharedPref
//                .edit()
//                .putString(Constants.SHAREDPREF_CACHE_TOKEN,
//                        authToken)
//                .commit();
//
//    }
//
//
//    public static String getAuthToken(Context context){
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        return sharedPref.getString(Constants.SHAREDPREF_CACHE_TOKEN, null);
//
//    }
//
//
//    ///// about submit order
//    //////////////////////////////////////////
//
//
//    public static void putCurrentComment(Context context, Comment submitInvoice) {
//
//        Gson gson = new Gson();
//        String json = gson.toJson(submitInvoice);
//
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        sharedPref.edit()
//                .putString(Constants.SHAREDRE_FEEDME_SEE_COMMENT, json)
//                .commit();
//
//    }
//
//
//
//    public static Comment getCurrentComment(Context context) {
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        Gson gson = new Gson();
//        String json = sharedPref.getString(Constants.SHAREDRE_FEEDME_SEE_COMMENT, null);
//        Type type = new TypeToken<Comment>() {
//        }.getType();
//        Comment arrayList = gson.fromJson(json, type);
//
//        return arrayList;
//    }
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public static void putCurrentUser(Context context, FeedmeUser submitInvoice) {
//
//        Gson gson = new Gson();
//        String json = gson.toJson(submitInvoice);
//
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        sharedPref.edit()
//                .putString(Constants.SHAREDRE_FEEDME_USER, json)
//                .commit();
//
//    }
//
//
//
//    public static FeedmeUser getCurrentUser(Context context) {
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        Gson gson = new Gson();
//        String json = sharedPref.getString(Constants.SHAREDRE_FEEDME_USER, null);
//        Type type = new TypeToken<FeedmeUser>() {
//        }.getType();
//        FeedmeUser arrayList = gson.fromJson(json, type);
//
//        return arrayList;
//    }
//
//    //////////////////////////////////////////
//
//    public static void putCategoryChoiceList(Context context, List<Category> categoryChoiceList) {
//
//        Gson gson = new Gson();
//        String json = gson.toJson(categoryChoiceList);
//
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        sharedPref.edit()
//                .putString(Constants.SHAREDRE_CAT_LISTR, json)
//                .commit();
//
//    }
//
//    public static List<Category> getCategoryChoiceList(Context context) {
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        Gson gson = new Gson();
//        String json = sharedPref.getString(Constants.SHAREDRE_CAT_LISTR, null);
//        Type type = new TypeToken<List<Category>>() {
//        }.getType();
//        List<Category> arrayList = gson.fromJson(json, type);
//
//        return arrayList;
//    }
//
////////////////////////////////////////////
//
//    public static void putCuisineChoiceList(Context context, List<Cuisine> categoryChoiceList) {
//
//        Gson gson = new Gson();
//        String json = gson.toJson(categoryChoiceList);
//
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        sharedPref.edit()
//                .putString(Constants.SHAREDRE_CUS_LISTR, json)
//                .commit();
//
//    }
//
//    public static List<Cuisine> getCuisineChoiceList(Context context) {
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        Gson gson = new Gson();
//        String json = sharedPref.getString(Constants.SHAREDRE_CUS_LISTR, null);
//        Type type = new TypeToken<List<Cuisine>>() {
//        }.getType();
//        List<Cuisine> arrayList = gson.fromJson(json, type);
//
//        return arrayList;
//    }
//
//
//    //////////////////////////////////////////
//
//    public static void putDistrictChoiceList(Context context, List<District> categoryChoiceList) {
//
//        Gson gson = new Gson();
//        String json = gson.toJson(categoryChoiceList);
//
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        sharedPref.edit()
//                .putString(Constants.SHAREDRE_DISTRICT_LISTR, json)
//                .commit();
//
//    }
//
//    public static List<District> getDistrictChoiceList(Context context) {
//        SharedPreferences sharedPref = context.getSharedPreferences(Constants.SHAREDPREF_CACHE, 0);
//        Gson gson = new Gson();
//        String json = sharedPref.getString(Constants.SHAREDRE_DISTRICT_LISTR, null);
//        Type type = new TypeToken<List<District>>() {
//        }.getType();
//        List<District> arrayList = gson.fromJson(json, type);
//
//        return arrayList;
//    }

}
