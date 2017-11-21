/*
 * This class holds the entrys of German and engish words.
 */
package finalproject;

/**
 *  Final Project
 * Thursday, August 10, 2017
 * @author Kris Harrison
 * @author KH
 */
public class Entry {
    //field variables
    private String _english;
    private String _german;
    
    /**
     * Non-default constructor
     * @param english
     * @param german 
     */
    public Entry(String english, String german){
        this._english = english;
        this._german = german;  
    }
    /**
     * This method sets the English entry
     * @param english 
     */
    public void setEnglish(String english){
        _english = english;
    }
    /**
     * This method returns the English word entry
     * @return _english
     */
    public String getEnglish(){
        return _english;
    }
    /**
     * This method sets the German word entry
     * @param german 
     */
    public void setGerman(String german){
        _german = german;
    }
    /**
     * This method returns the German word entry
     * @return _german
     */
    public String getGerman(){
        return _german;
    }
}
