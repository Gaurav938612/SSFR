package com.android.gaurav.myproject.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.gaurav.myproject.R;
import com.google.android.material.navigation.NavigationView;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    Toolbar mToolbar;

    public abstract int getLayoutId();
    public abstract String getPageTitle();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mToolbar=findViewById(R.id.toolbarId);
        mDrawerLayout=findViewById(R.id.drawerLayoutId);
        mNavigationView=findViewById(R.id.navigationId);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getPageTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,
                mDrawerLayout,mToolbar,R.string.open_navigation_drawer,R.string.close_navigation_drawer);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_drawer_menu,menu);
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        if(id== R.id.item1){
            Toast.makeText(this,"item 1 selected",Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.item2){
            Toast.makeText(this,"item 2 selected",Toast.LENGTH_SHORT).show();
        }
        else if(id== R.id.item3){
            Toast.makeText(this,"item 3 selected",Toast.LENGTH_SHORT).show();
        }
        else if(id== R.id.item4){
            Toast.makeText(this,"item 4 selected",Toast.LENGTH_SHORT).show();
        }
        else if(id== R.id.item5){
            Toast.makeText(this,"item 5 selected",Toast.LENGTH_SHORT).show();
        }
        else if(id== R.id.item6){
            Toast.makeText(this,"item 6 selected",Toast.LENGTH_SHORT).show();
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }
}
