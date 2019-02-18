package com.google.android.systemui.elmyra.actions;

import android.content.ContentResolver;
import android.content.pm.ActivityInfo;
import android.os.UserHandle;
import android.provider.Settings;

public class LongSqueezeCustomApp extends ShortSqueezeCustomApp {

    @Override
    protected void setPackage(String packageName, String friendlyAppString) {
        final ContentResolver resolver = getContentResolver();
        Settings.Secure.putStringForUser(resolver,
                Settings.Secure.LONG_SQUEEZE_CUSTOM_APP, packageName,
                UserHandle.USER_CURRENT);
        Settings.Secure.putStringForUser(resolver,
                Settings.Secure.LONG_SQUEEZE_CUSTOM_APP_FR_NAME, friendlyAppString,
                UserHandle.USER_CURRENT);
    }

    @Override
    protected void setPackageActivity(ActivityInfo ai) {
        final ContentResolver resolver = getContentResolver();
        Settings.Secure.putStringForUser(
                resolver, Settings.Secure.LONG_SQUEEZE_CUSTOM_ACTIVITY,
                ai != null ? ai.name : "NONE",
                UserHandle.USER_CURRENT);
    }
}
