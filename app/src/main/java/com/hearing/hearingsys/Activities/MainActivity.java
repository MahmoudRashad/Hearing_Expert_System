package com.hearing.hearingsys.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.hearing.hearingsys.Fragment.LoginFragments.Login_Fragmet;
import com.hearing.hearingsys.Fragment.LoginFragments.Regist_Fragment;
import com.hearing.hearingsys.Fragment.LoginFragments.Splash_Fragment;
import com.hearing.hearingsys.R;
import com.hearing.hearingsys.Sql.DatabaseHelper;

import static com.hearing.hearingsys.AppContext.databaseHelper;

public class MainActivity extends AppCompatActivity {


    public static boolean login_flag=false ,splash_flag=true, regist_flag =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper= new DatabaseHelper(this);
        if (splash_flag) {
            Splash_Fragment splash_fragment = new Splash_Fragment();
            getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.contentView, splash_fragment).commit();
        }

        if (login_flag) {
            Login_Fragmet login_fragmet = new Login_Fragmet();
            getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.contentView, login_fragmet).commit();
        }

        if (regist_flag) {
            Regist_Fragment regist_fragment = new Regist_Fragment();
            getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.contentView, regist_fragment).commit();
        }


    }



    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 2 ){
            getSupportFragmentManager().popBackStack();
        } else {
            finish();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
