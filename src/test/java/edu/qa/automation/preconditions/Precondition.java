package edu.qa.automation.preconditions;

import edu.qa.automation.rest.RestManager;

import java.io.IOException;
import java.util.Map;

public abstract class Precondition {

    protected RestManager restManager;
    public Precondition(RestManager restManager){
        this.restManager = restManager;
    }

    public abstract void resolve(Map<String, Object> data) throws IOException;
}
