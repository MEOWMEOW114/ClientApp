package com.easydeliver.clientapp.util.camera;

/**
 * Created by tomlee on 10/2/16.
 */

import android.net.Uri;

import java.util.Date;

public  interface CameraIntentHelperCallback {
    void onPhotoUriFound(Date dateCameraIntentStarted, Uri photoUri, int rotateXDegrees);

    void deletePhotoWithUri(Uri photoUri);

    void onSdCardNotMounted();

    void onCanceled();

    void onCouldNotTakePhoto();

    void onPhotoUriNotFound();

    void logException(Exception e);
}