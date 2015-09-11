package com.example.andremion.animatedicons;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    private AnimatedVectorDrawable mMenuDrawable;
    private AnimatedVectorDrawable mBackDrawable;
    private boolean mMenuFlag;

    private AnimatedVectorDrawable mAddDrawable;
    private AnimatedVectorDrawable mCheckDrawable;
    private boolean mFabFlag;

    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_vector);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mMenuDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_menu_animatable);
        mBackDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_back_animatable);
        mAddDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_add_animatable);
        mCheckDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_check_animatable);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            menuClick();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void menuClick() {
        if (mMenuFlag) {
            getSupportActionBar().setHomeAsUpIndicator(mBackDrawable);
            mBackDrawable.start();
        } else {
            getSupportActionBar().setHomeAsUpIndicator(mMenuDrawable);
            mMenuDrawable.start();
        }
        mMenuFlag = !mMenuFlag;
    }

    public void fabClick(View view) {
        if (mFabFlag) {
            mFloatingActionButton.setImageDrawable(mCheckDrawable);
            mCheckDrawable.start();
        } else {
            mFloatingActionButton.setImageDrawable(mAddDrawable);
            mAddDrawable.start();
        }
        mFabFlag = !mFabFlag;
    }
}