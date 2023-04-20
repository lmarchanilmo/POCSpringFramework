package edu.qa.automation.preconditions;

import edu.qa.automation.rest.Person;
import edu.qa.automation.rest.RestManager;
import edu.qa.automation.rest.person.DeletePersonResponse;
import edu.qa.automation.rest.person.GetPersonRequest;
import edu.qa.automation.rest.person.GetPersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class RemoveExistingPerson extends Precondition{

    @Autowired
    public RemoveExistingPerson(RestManager restManager) {
        super(restManager);
    }

    @Override
    public void resolve(Map<String, Object> data) throws IOException {

        GetPersonRequest getPersonRequest = new GetPersonRequest();
        getPersonRequest.completeData = true;
        getPersonRequest.length = 1;
        getPersonRequest.type = 0;
        getPersonRequest.start = 0;
        getPersonRequest.withoutPendingApproval = false;
        getPersonRequest.order = "visitEnterpriseName desc";
        getPersonRequest.search = data.get("criteria").toString();
        Person personService = restManager.getBuilder().create(Person.class);
        Response<GetPersonResponse> getPersonResponse = personService.getPerson(getPersonRequest).execute();

        assert getPersonResponse.body() != null;
        List<Integer> list = new ArrayList<Integer>();
        if(getPersonResponse.body().data.size()!=0)
            list.add(getPersonResponse.body().data.get(0).id);

        Response<DeletePersonResponse> deletePersonResponse = personService.deletePerson(list).execute();
        assert Objects.requireNonNull(deletePersonResponse.body()).data;
    }
}
