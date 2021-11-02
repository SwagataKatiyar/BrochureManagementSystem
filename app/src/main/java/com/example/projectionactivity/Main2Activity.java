package com.example.projectionactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Main2Activity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle MactionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView registor= (TextView) findViewById(R.id.registor);
        Button button = (Button) findViewById(R.id.button2);
        registor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);

            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.mdrawerLayout);

        MactionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(MactionBarDrawerToggle);
        MactionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view= (NavigationView)findViewById(R.id.nv);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=  menuItem.getItemId();
                if(id==R.id.nav_item_one)
                {
                    Toast.makeText(Main2Activity.this, "yay", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }



    public boolean onOptionsItemSelected(MenuItem item) {
        return MactionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


}


