package com.example.leanne.capstonedesign_1_;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by imsuyeon on 16. 4. 2..
 */
public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(R.anim.animation_enter_left2right, R.anim.animation_leave_left2right);
    }
}
