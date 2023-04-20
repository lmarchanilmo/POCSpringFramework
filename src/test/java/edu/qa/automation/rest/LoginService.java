package edu.qa.automation.rest;

import edu.qa.automation.rest.login.Credentials;
import edu.qa.automation.rest.login.ResponseLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("AMSuite/Sessions/Login")
    Call<ResponseLogin> login(@Body Credentials credentials);

}
