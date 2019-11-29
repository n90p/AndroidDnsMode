package com.nxzero.dnsmode;

import android.os.*;
import android.preference.*;
import android.util.*;

public final class MainActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        finish();
    }
}