package com.androidbytes.appshortcuts.view;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.androidbytes.appshortcuts.R;

import java.util.Arrays;

public class DynamicShortcutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_shortcut);

        findViewById(R.id.btn_change_rank).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_change_rank:
                ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
                ShortcutInfo blogShortcut = new ShortcutInfo.Builder(this, "blog_shortcut")
                        .setRank(1)
                        .build();

                ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(this, "dynamic_shortcut")
                        .setRank(0)
                        .build();

                shortcutManager.updateShortcuts(Arrays.asList(blogShortcut, dynamicShortcut));
                break;
        }
    }
}
