package day7CRUDApp.service;


import day7CRUDApp.dao.MysqlHelper;
import day7CRUDApp.entity.Contact;
import day7CRUDApp.entity.DBResult;
import day7CRUDApp.exception.RecordNotFoundException;
import org.apache.log4j.Logger;

import java.util.List;

public class DBService {

    private static DBService instance;
    private static final Logger logger = Logger.getLogger(DBService.class);

    private DBService(){  }

    synchronized public static DBService getInstance(){
        if(instance == null)
            instance = new DBService();
        return instance;
    }

    public DBResult addContact(Contact contact){

        return MysqlHelper.getInstance().addContact(contact);

    }

    public DBResult updateContact(Contact contact){
        return MysqlHelper.getInstance().updateContact(contact);
    }

    public DBResult getContactWithName(String name){

        DBResult dbResult = MysqlHelper.getInstance().getContactWithName(name);

        return dbResult;
    }

    public String deleteContact(String name){

        if(name == null)
            return "Name is undefined";
        else
            return MysqlHelper.getInstance().deleteContact(name);

    }

    public DBResult getContacts(){


        DBResult dbResult = MysqlHelper.getInstance().getContacts();
        if(!dbResult.isSuccessful())
            return dbResult;

        if(((List<Contact>)dbResult.getResult()).isEmpty()){
            dbResult.setMessage("Contacts table has no record!");
            dbResult.setSuccessful(false);
        }

        return dbResult;
    }



}
