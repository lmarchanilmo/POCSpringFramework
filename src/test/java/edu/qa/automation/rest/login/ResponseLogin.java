package edu.qa.automation.rest.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ResponseLogin {
    public int id;
    public String name;
    public String lastname;
    public String email;
    public String userName;
    public String token;
    @JsonProperty("permits")
    public Permits mypermits;
    public ArrayList<Integer> products;
}