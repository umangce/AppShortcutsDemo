package com.androidbytes.appshortcuts.view;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidbytes.appshortcuts.R;
import com.androidbytes.appshortcuts.common.constants.Constants;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        ShortcutInfo blogShortcut = new ShortcutInfo.Builder(this, "blog_shortcut")
                .setShortLabel("My Blog")
                .setLongLabel("Open My Blog on Medium.com")
                .setRank(0)
                .setIcon(Icon.createWithResource(this, R.drawable.medium_icon))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.BLOG_URL)))
                .build();

        ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(this, "dynamic_shortcut")
                .setShortLabel("Dynamic")
                .setLongLabel("Dynamic Shortcut")
                .setRank(0)
                .setIntent(new Intent(Constants.DYNAMIC_SHORTCUT_ACTIVITY_ACTION))
                .build();

        shortcutManager.setDynamicShortcuts(Arrays.asList(blogShortcut, dynamicShortcut));

  //      List<ShortcutInfo> staticShortcuts = shortcutManager.getManifestShortcuts();
//        Log.d("TAG", staticShortcuts.get(0).getShortLabel().toString());
//        List<ShortcutInfo> dynamicShortcuts = shortcutManager.getDynamicShortcuts();
//        ShortcutInfo shortcutInfo = dynamicShortcuts.get(0);

    }
}
