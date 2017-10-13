package com.ufs.tep.sgr_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Index extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Bundle b = new Bundle();
        b.putInt("mode", 1);

        Utils.openFragment(getSupportFragmentManager(), new SelecionarMesa(), b);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (!Utils.toBack.empty())
                Utils.openFragment(getSupportFragmentManager(), Utils.toBack.pop(), Utils.fragmentData.pop());
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Bundle b;
        SelecionarMesa sm;

        switch (item.getItemId()) {
            case R.id.nav_inicio:
                b = new Bundle();
                b.putInt("mode", 1);

                Utils.openFragment(getSupportFragmentManager(), new SelecionarMesa(), b);
                break;
            case R.id.nav_perfil:
                Utils.backToStart();
                Utils.openFragment(getSupportFragmentManager(), new Perfil(), null);
                break;
            case R.id.nav_settings:
                Utils.backToStart();
                Utils.openFragment(getSupportFragmentManager(), new Config(), null);
                break;
            case R.id.nav_listarMesas:
                b = new Bundle();
                b.putInt("mode", 0);

                Utils.backToStart();
                Utils.openFragment(getSupportFragmentManager(), new SelecionarMesa(), b);
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
