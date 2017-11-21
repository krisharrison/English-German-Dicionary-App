/*
 * This is the controller for the Dictionary GUI.
 */
package finalproject;

//IMPORTS
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *  Final Project
 * Thursday, August 10, 2017
 * @author Kris Harrison
 * 
 */
public class DictionaryController {
    //create dictionary object. Dictioanry variable _dictionary
    Dictionary _dictionary = new Dictionary();
    //Declare field varibales
    @FXML private TextField _txtEnglish;
    @FXML private TextField _txtGerman;
    @FXML private TextField _txtSearchDelete;
    @FXML private RadioButton _radioGerman;
    @FXML private RadioButton _radioEnglish;
    @FXML private Label _lblDisplayWords;
   
    //Stores a dictionary object
    public void inItData(Dictionary dictionary){
        _dictionary = dictionary;
    }
    
    @FXML private void Intialize(){
        
    }
    /**
     * onAction for the add button from the dictionary window.
     * Adds entries to the ArrayList _dictionary and to a file.
     */
    @FXML
    private void onAdd(){
        _dictionary.addWord(_txtEnglish.getText(), _txtGerman.getText());
        
        
        Scanner reader = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            String info = _txtEnglish.getText() +"|"+_txtGerman.getText() + "\n";
            
            File file = new File(MainController.filePath);
            
            if(!file.exists()){
                file.createNewFile();
            }
            
              fw = new FileWriter(file.getAbsoluteFile(),true);
              bw = new BufferedWriter(fw);
            
              bw.write(info);
              
              
        }
        catch(IOException e){
            _lblDisplayWords.setText("Please enter a valid word");
            e.printStackTrace();
        }
        finally{
            try {

		if (bw != null)
		    bw.close();

	        if (fw != null)
		    fw.close();
	        } 
                catch (IOException ex) {
                    ex.printStackTrace();

            }
        }
        _txtEnglish.clear();
        _txtGerman.clear();
    }
    /**
     * OnAction for the delete button from the Dictionary window.
     * Deletes data from a file and ArrayList _dictionary.
     */
    @FXML
    private void onDelete(){
        
        Scanner reader = null;
        File file = new File(MainController.filePath);
        ArrayList <String> lines = new ArrayList<>();
        try{
            
            reader = new Scanner(file);
            while(reader.hasNext()){
                
                String record = reader.next();
                String [] fields = record.split("\\|");
                if(!(fields[0].equals(_txtSearchDelete.getText()) || fields[1].equals(_txtSearchDelete.getText()))){
                    lines.add(record);
                }
                 
            }
   
            
        }
        catch(FileNotFoundException e){
            _lblDisplayWords.setText("Please enter a valid word");
            e.printStackTrace();
        }
        finally{
            if(reader != null){
                reader.close();
            }
        }
        
         
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
     
            if(!file.exists()){
                file.createNewFile();
            }
            
              fw = new FileWriter(file.getAbsoluteFile(),false);
              bw = new BufferedWriter(fw);
              
            for(String line : lines){
                  bw.write(line + "\n");
            }
        }
        catch(IOException e){
            _lblDisplayWords.setText("Please enter a valid word");
            e.printStackTrace();
        }
        finally{
            try {

		if (bw != null)
		    bw.close();

	        if (fw != null)
		    fw.close();
	        } 
                catch (IOException ex) {
                    ex.printStackTrace();

            }
        }
        _txtSearchDelete.clear();
        
    }      
    /**
     * OnAction for the search button from the dictionary window.
     * Allows you how to Translate a German or English word stored in a text file
     */    
    @FXML
    private void onTranslate(){
        /*if(_radioGerman.isSelected()){
        _dictionary.searchWord(_txtSearchDelete.getText(),_radioGerman.isSelected());
        }
        else{
            _dictionary.searchWord(_txtSearchDelete.getText(),_radioEnglish.isSelected());
        }*/
        
        File file = new File(MainController.filePath);
        Scanner reader = null;
        try{
            reader = new Scanner(file);
            while(reader.hasNext()){
                String record = reader.next();
                String [] fields = record.split("\\|");
                if(_txtSearchDelete.getText().equals(fields[0])){
                    _lblDisplayWords.setText(fields[1]);
                    
                    break;
                }
                if(_txtSearchDelete.getText().equals(fields[1])){
                    _lblDisplayWords.setText(fields[0]); 
                    break;
                }
             
            }
        }
        catch(IOException e){
            _lblDisplayWords.setText("Please enter a valid word");
            e.printStackTrace();
        }
        finally{
            if(reader != null){
                reader.close();
            }
        }
        _txtSearchDelete.clear();
    }
    /**
     * OnAction for the display button. Displays all the data for from a text file.
     */
    @FXML private voCid onDisplayDict(){
        Scanner reader = null;
        //Pass the file path that's stored in the variable FilePath found in the MainCtroller class
        File file = new File(MainController.filePath);
        try{
            
            reader = new Scanner(file);
            String record = "";
            while(reader.hasNext()){
                record += reader.next() + "\n";
                //Displays all the data from the dictionary to _lblDisplayWords
                _lblDisplayWords.setText(record);
            }
        }
        catch(IOException e){
            _lblDisplayWords.setText("Error!");
            e.printStackTrace();
        }
        finally{
            if(reader != null){
                reader.close();
            }
        }
    }
    /**
     * OnAction for the button Main Menu. Allows you to access the main menu.
     * @param event 
     */
    @FXML 
    private void onMainMenu(ActionEvent event){
        
        ((Stage)_lblDisplayWords.getScene().getWindow()).close();
        
        
    }
}

