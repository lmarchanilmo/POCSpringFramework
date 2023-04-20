package edu.qa.automation.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.qa.automation.rest.login.Credentials;
import edu.qa.automation.rest.login.ResponseLogin;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
@PropertySource({
        "classpath:config/${environment}.properties"
})
public class RestManager {


    @Value("${rest.url}")
    private String restUrl;

    @Value("${email}")
    private String email;

    @Value("${password}")
    private String password;

    private String token;

    @PostConstruct
    public void setup() throws IOException {
        this.token = getToken();
    }

    public Retrofit getBuilder(){

        OkHttpClient client = getCLientBuilder().build();

        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
        Gson gson = new GsonBuilder()
                .setDateFormat(dateFormat)
                .create();

        return new Retrofit.Builder()
                .baseUrl(restUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    private OkHttpClient.Builder getCLientBuilder(){

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS);

        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request;
                request = chain.request().newBuilder().addHeader("Authorization", String.format("Bearer %s", token)).build();
                return chain.proceed(request);
            }
        });

        return okHttpClient;


    }

    private String getToken() throws IOException {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(restUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        LoginService loginService = builder.create(LoginService.class);
        Credentials credentials = new Credentials();
        credentials.email = email;
        credentials.password = password;
        retrofit2.Response<ResponseLogin> responseLogin = loginService.login(credentials).execute();
        assert responseLogin.body() != null;
        return responseLogin.body().token;
    }
}
