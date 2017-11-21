/*
 * This class allows you to add, delete and search entries to, from and in the
 * dictionary
 */
package finalproject;


import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *  Final Project
 * Thursday, August 10, 2017
 * @author Kris Harrison
 * 
 */
public class Dictionary{
    // Creating an ArrayList of object Entry
    ArrayList <Entry> _words = new ArrayList <>();
    
    /**
     * Returns a particular index of the ArrayList _words
     * @param index
     * @return _words.get(index)
     */
    public Entry getIndex(int index){
        return _words.get(index);
    }
    /**
     * Allows you to add entries in the ArrayList _dictionary
     * @param word
     * @param germanWord 
     */
    public void addWord(String word, String germanWord){
        if(isValidWord(word) && isValidWord(germanWord)){
          _words.add(new Entry(word, germanWord));
        }
        else{
            throw new InputMismatchException("Error!. Please enter a valid word");
        }
    }
    /**
     * Allows you to delete entries from the ArrayList _dictionary
     * @param word
     * @param choice 
     */
    public void deleteWord(String word, boolean choice){
        _words.remove(searchWord(word, choice));
        
    }
    /**
     * This method allows you to search for an entry with the ArrayList _dictionary
     * @param word
     * @param choice
     * @return term
     */
    public Entry searchWord(String word, boolean choice){
        if(isValidWord(word)){
            if(choice) {
                for(Entry term : _words){
                    if(word.equals(term.getEnglish())){
                        return term;
                    }
                }
            }
            else {
               for(Entry term : _words){
                    if(word.equals(term.getGerman())){
                        return term;
                    }
                } 
            }
        }
        return null;
    }
    /**
     * Checks of a word is valid or invalid
     * @param word
     * @return true or false
     */
    public boolean isValidWord(String word){
        char[] chars = word.toCharArray();
        
        for(char c: chars){
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
  
     
}
