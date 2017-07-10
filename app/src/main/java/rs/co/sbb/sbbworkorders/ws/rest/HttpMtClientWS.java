package rs.co.sbb.sbbworkorders.ws.rest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cz.msebera.android.httpclient.Header;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rs.co.sbb.sbbworkorders.entity.response.GetWoResponse;
import rs.co.sbb.sbbworkorders.entity.response.LoginResponse;
import rs.co.sbb.sbbworkorders.utils.SaveSharedPreference;
import rs.co.sbb.sbbworkorders.ws.rest.config.MTRestWSConfig;

/**
 * Created by Predrag.Tasic on 6/6/2017.
 */

public class HttpMtClientWS {

    private Context context;
    Retrofit retrofit;
    LoginResponse loginResponse = new LoginResponse();


    private OkHttpClient clientAuth = new OkHttpClient().newBuilder().addInterceptor(
            new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();

                   Request.Builder builder = request.newBuilder().header("Authorization", Credentials.basic(MTRestWSConfig.user,MTRestWSConfig.pass));

                    Request newRequest = builder.build();
                    return chain.proceed(newRequest);
                }
            }
    ).build();

    public HttpMtClientWS(Context context)
    {
        Log.i("HttpMtClientWS","kreiram instancu");
        this.context = context;


        retrofit = new Retrofit.Builder().
                client(clientAuth).
                baseUrl(MTRestWSConfig.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }



    public Call<LoginResponse> login(String username, String password){

        Log.i("login","usao sa parametrima: "+username+" "+password);

        HttpMtService service = retrofit.create(HttpMtService.class);

        Call<LoginResponse> call = service.login(username,password);

        Log.i("login",call.request().url().toString());

        return  call;

    }


    public Call<GetWoResponse> getWoResponse(String transactionNo){

        Log.i("getWoResponse","usao sa paremetrom: "+transactionNo);

        HttpMtService service = retrofit.create(HttpMtService.class);

        Call<GetWoResponse> call = service.getWoResponse(transactionNo);

        Log.i("getWoResponse",call.request().url().toString());

        return  call;
    }

}
