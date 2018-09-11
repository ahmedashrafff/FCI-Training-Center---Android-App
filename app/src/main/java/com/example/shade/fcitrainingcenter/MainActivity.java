package com.example.shade.fcitrainingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    String name;
    String password;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.navigationdrawer);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        tabLayout=(TabLayout) findViewById(R.id.tablayout) ;
        viewPager=(ViewPager) findViewById(R.id.viewpager);

        navigationView.setNavigationItemSelectedListener(this);
        viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home).setText("Home");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_courses).setText("Courses");


        ActionBarDrawerToggle toggle  = new ActionBarDrawerToggle(this, drawerLayout , toolbar,R.string.openDrawer,R.string.closeDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


         Intent intent = getIntent();
         name=intent.getStringExtra("name");
         password=intent.getStringExtra("password");
         type=intent.getStringExtra("type");

        View header = navigationView.getHeaderView(0);

        TextView nameHeader=(TextView) header.findViewById(R.id.nameHeader);
        TextView typeHeader=(TextView) header.findViewById(R.id.typeHeader);

        nameHeader.setText(name);
        typeHeader.setText(type);




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id=item.getItemId();

       if(id==R.id.search)
       {
           Toast.makeText(getApplicationContext(),"item Search",Toast.LENGTH_LONG).show();
       }
      else if(id==R.id.notifications)
       {
           Toast.makeText(getApplicationContext(),"item Notifications",Toast.LENGTH_LONG).show();
       }

       return  super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.mycoursesmenu)
        {
            startActivity(new Intent(this, MyCourses.class));

        }

        else if(id==R.id.accountmenu)
        {
            Intent intent = new Intent(getBaseContext(),UserAccount.class);
            intent.putExtra("name",name);
            intent.putExtra("password",password);
            startActivity(intent);
        }

        else if(id==R.id.aboutus)
        {
            startActivity(new Intent(this, AboutUs.class));

        }

        else if(id==R.id.contactus)
        {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"here@there.ie"});
        //    intent.putExtra(Intent.EXTRA_CC, new String[] {"andy@whatever.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Contact App Developer");
            intent.putExtra(Intent.EXTRA_TEXT, "I would like to contact you because ...");

            try {

                startActivity(Intent.createChooser(intent, "How to send mail?"));
            } catch (android.content.ActivityNotFoundException ex) {
                //do something else
            }
        }

        else if(id==R.id.logoutmenu)
        {
            finish();
        }


        return true;

    }



    @Override
    public void onBackPressed()
    {
       if(this.drawerLayout.isDrawerOpen(GravityCompat.START))
        {drawerLayout.closeDrawer(GravityCompat.START);}
        else
            super.onBackPressed();


    }


}
