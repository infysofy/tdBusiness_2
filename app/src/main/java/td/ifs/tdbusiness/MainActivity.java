package td.ifs.tdbusiness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import com.bumptech.glide.Glide;

import td.ifs.tdbusiness.javac_sqllite.MydbAdapter_tkt;

public class MainActivity extends AppCompatActivity {
    Button id;
    int SPLASH_TIME=3000;
    String Resule=null;
    MydbAdapter_tkt db=new MydbAdapter_tkt(MainActivity.this);
    //ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkAuth();
    }
    public  void checkAuth()
    {
        boolean r=db.checkUser();
        if(r==false)
        {
            Intent in = new Intent(MainActivity.this, Login_user.class);
            startActivity(in);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in = new Intent(MainActivity.this, dashboard.class);
                    startActivity(in);
                    finish();
                }
            }, SPLASH_TIME);
        }
    }
    public void ShowGif(View view) {
        ImageView imageView = findViewById(R.id.imgView);
        Glide.with(this).load(R.drawable.tenor).into(imageView);
    }
    @Override
    public void onBackPressed() {
        // Simply Do noting!
    }
 
}
