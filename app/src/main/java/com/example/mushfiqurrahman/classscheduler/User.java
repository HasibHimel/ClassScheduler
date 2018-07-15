package com.example.mushfiqurrahman.classscheduler;

/**
 * Created by Mushfiqur Rahman on 3/15/2016.
 */
public class User {

    String name,username,password, session;

    public User(String name,String username,String password,String session){

        this.name = name;
        this.username = username;
        this.password = password;
        this.session = session;

    }

    public User(String name,String username,String password){

        this.name = name;
        this.username = username;
        this.password = password;

    }

    public User(String session){
        this.session = session;
    }

    public User(String username,String password){

        this.username = username;
        this.password = password;
    }


}
