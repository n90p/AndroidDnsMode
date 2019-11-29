package com.nxzero.dnsmode;

import android.app.*;
import android.system.*;

import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.*;

import static de.robv.android.xposed.XposedHelpers.*;

public final class XposedInit implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) {
        if (BuildConfig.APPLICATION_ID.equals(lpparam.packageName)) {
        } else {
            findAndHookConstructor(Application.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws ErrnoException {
                    Os.setenv("ANDROID_DNS_MODE", "local", true);
                    XposedBridge.log(String.format("%s: ANDROID_DNS_MODE=%s", lpparam.packageName, System.getenv("ANDROID_DNS_MODE")));
                }
            });
        }
    }
}