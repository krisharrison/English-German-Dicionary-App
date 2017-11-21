/*
 *This holds and allows other classes to access or set account information
 * 
 */
package finalproject;

/**
 *  Final Project
 * Thursday, August 10, 2017
 * @author Kris Harrison
 */
public class Account {
    //declare field variables
    private String _acctName;
    private int _acctID;
    //Create a dictionary object
    Dictionary dictionary = new Dictionary();
   
    /**
     * This is a non-default constructor
     * @param acctName
     * @param acctID 
     */
    public Account(String acctName, int acctID){
        this._acctName = acctName;
        this._acctID = acctID;
    }
    /**
     * This method sets the account name
     * @param acctName 
     */
    
    public void setAccntName(String acctName){
        _acctName = acctName;
    }
    /**
     * This method returns account name
     * @return _acctName
     */
    public String getAccntName(){
       return _acctName;
    }
    /**
     * This account sets account ID
     * @param acctID 
     */
    public void setAccntID(int acctID){
        _acctID = acctID;
    }
    /**
     * This account gets account ID
     * @return _acctID
     */
    public int getAccntID(){
        return _acctID;
    }
    /**
     * This method overrides toString Method
     * @return 
     */
    @Override
    public String toString(){
        return "Account Name: " + _acctName + " " +  "Account ID: " + _acctID;
    }
}
