package edu.qa.automation.rest;

import edu.qa.automation.rest.person.DeletePersonResponse;
import edu.qa.automation.rest.person.GetPersonRequest;
import edu.qa.automation.rest.person.GetPersonResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.POST;

import java.util.List;

public interface Person {

    @POST("EasyAccess/Registers/GetRegisters")
    Call<GetPersonResponse> getPerson(@Body GetPersonRequest getPersonRequest);

    @HTTP(method = "DELETE", path = "EasyAccess/Registers/DeleteRegisters", hasBody = true)
    Call<DeletePersonResponse> deletePerson(@Body List<Integer> personIds);
}
