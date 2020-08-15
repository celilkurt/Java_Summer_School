package service;

import org.apache.log4j.Logger;

public class AuthService {

    private static AuthService instance;
    private static final Logger logger = Logger.getLogger(AuthService.class);

    private AuthService(){}

    public static AuthService getInstance(){
        if(instance == null)
            instance = new AuthService();

        return instance;
    }

    public boolean auth(String name, String password){
        return DBHelper.getInstance().isUserExist(name,password);
    }

    public String signUp(String name, String password){

        return DBHelper.getInstance().createUser(name,password);
    }

}
