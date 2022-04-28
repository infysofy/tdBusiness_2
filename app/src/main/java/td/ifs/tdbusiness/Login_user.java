package td.ifs.tdbusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import td.ifs.tdbusiness.POJOModel.LoginModel;
import td.ifs.tdbusiness.RestrofitApi.myApi;
import td.ifs.tdbusiness.javac_sqllite.MydbAdapter_tkt;

public class Login_user extends AppCompatActivity {
    EditText tdofc_uid, tdofc_pwd;
    Button tdofc_login;
    ProgressDialog pDialog;
    String id,nms,img,area,ls,ls1,doc;
    MydbAdapter_tkt db=new MydbAdapter_tkt(Login_user.this);
    String Base_URL="http://api.thyrodiab.in/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        tdofc_uid = (EditText) findViewById(R.id.tdofc_uid);
        tdofc_pwd = (EditText) findViewById(R.id.tdofc_pwd);
        tdofc_login = (Button) findViewById(R.id.btn_tdofc_login);



        tdofc_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid = tdofc_uid.getText().toString();
                String pwd = tdofc_pwd.getText().toString();
                Process(uid,pwd);
    }

    public void Process(String uid,String pwd)
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi api=retrofit.create(myApi.class);

       LoginModel ls=new LoginModel();
        Call<LoginModel> call=api.postdata(uid, pwd);

        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if(response.isSuccessful())
                {
                    LoginModel obj=response.body();
                    db.insertuserDetails(obj.getId(), obj.getNm(), obj.getImg(),obj.getArea(),obj.getLog_stst(),obj.getDoc());
                    Toast.makeText(Login_user.this,"Login Succesful:"+obj.getNm()+"("+obj.getId()+")", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(Login_user.this, dashboard.class);
                    startActivity(in);
                }
                else
                {
                    Toast.makeText(Login_user.this,"Login Failed: Check UserId and Password.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(Login_user.this,"Login Failed: with Error :"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        //   Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG);

    }
        });
    }

            private void displayLoader()
            {
                pDialog = new ProgressDialog(Login_user.this);
                pDialog.setMessage("Log in.. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(false);
                pDialog.show();

            }

        }

