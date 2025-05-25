package model;

public class User {
    protected String sName;
    protected int iId;

    public User(String sName, int iId){
        this.sName = sName;
        this.iId = iId;
    }

    public String getName(){
        return sName;
    }

    public int getId(){
        return iId;
    }
}
