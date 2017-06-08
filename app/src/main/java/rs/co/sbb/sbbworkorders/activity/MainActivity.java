package rs.co.sbb.sbbworkorders.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import rs.co.sbb.sbbworkorders.R;
import rs.co.sbb.sbbworkorders.utils.SaveSharedPreference;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView idText = (TextView) findViewById(R.id.id_number);
        idText.setText("Ulogovan si kao predrag tasicuser1");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } */
        if (id == R.id.nav_manage) {

        }
        if(id == R.id.nav_logout){
            logout();
        }

        /*} else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {

        AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);

        alertDlg.setMessage("Da li ste sigurni da zelite da se izlogujete?");

        alertDlg.setCancelable(false); // We avoid that the dialong can be cancelled, forcing the user to choose one of the options

        alertDlg.setPositiveButton("Da", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface d, int id) {

                        System.out.println("--->Pritisnuto YES dugme");

                        //String sessionId = SaveSharedPreference.getSessionId(MainActivity.this);

                        //Toast.makeText(MainActivity.this,"Session="+sessionId,Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(i);

                       /* HttpClientWS clientWS = new HttpClientWS(MainActivity.this);

                        RequestParams params = new RequestParams();

                        params.put("sessionid",sessionId);

                        clientWS.logout(sessionId);

                        SharedPreferences preferences = SaveSharedPreference.getSharedPreferences(MainActivity.this);
                        SharedPreferences.Editor editor = preferences.edit();

                        editor.clear();
                        editor.commit();

                        stopService(new Intent(MainActivity.this,LocationService.class));*/

                    }

                }

        );

        alertDlg.setNegativeButton("Ne", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                // We do nothing
            }

        });

        alertDlg.create().show();
    }

}
