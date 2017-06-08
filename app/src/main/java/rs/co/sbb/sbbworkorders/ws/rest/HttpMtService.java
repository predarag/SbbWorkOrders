package rs.co.sbb.sbbworkorders.ws.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rs.co.sbb.sbbworkorders.entity.response.GetWoResponse;
import rs.co.sbb.sbbworkorders.entity.response.LoginResponse;

/**
 * Created by Predrag.Tasic on 6/7/2017.
 */

public interface HttpMtService {

    @GET("logIn")
    Call<LoginResponse> login(@Query("user")String username,@Query("pass")String password);

    @GET("getWO")
    Call<GetWoResponse> getWoResponse(@Query("workOrder")String workOrder);
}
