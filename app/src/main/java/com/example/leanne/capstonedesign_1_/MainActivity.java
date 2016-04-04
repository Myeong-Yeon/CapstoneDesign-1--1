package com.example.leanne.capstonedesign_1_;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends ActionBarActivity {
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, SplashActivity.class));
        initView();
    }

    private void initView() {
        backPressCloseHandler = new BackPressCloseHandler(this);
        showFragment(0);
    }

    private void showFragment(int position) {
        Fragment fragment = new LoginActivity();
        FragmentManager fm = getFragmentManager();

        switch (position) {
            case 0:
                fragment = new LoginActivity();
                break;
            case 1:
                break;
        }
        fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }
}
