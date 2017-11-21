/*
 * This class allows you to store the field[2] of the data stored in users.txt
 */
package finalproject;

/**
 *  Final Project
 * Thursday, August 10, 2017
 * @author Kris Harrison
 * 
 */
public class MainMenu {
    
    //field variables
    public String _filePath;
    
    //non-default constructor
    public MainMenu(String filePath){
        this._filePath= filePath;
    }
    
    /**
     * toString method
     * @return _filePath
     */
    @Override
    public String toString(){
        return _filePath;
    }
    
    
    
}
