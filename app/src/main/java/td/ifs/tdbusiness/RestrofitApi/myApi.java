package td.ifs.tdbusiness.RestrofitApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import td.ifs.tdbusiness.POJOModel.LoginModel;

public interface myApi {

    @FormUrlEncoded
    @POST("androidapp/services.php?action=tdofc_userlogin")
    Call<LoginModel> postdata(@Field("uid") String uid, @Field("pwd") String pwd);
}
