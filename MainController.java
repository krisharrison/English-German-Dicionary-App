/*
 * This class is the GUI for the Login Window.
 */
package finalproject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class MainController{
        //Field variables
        @FXML private TextField _txtUserName;
        @FXML private TextField _txtAcctID;
        @FXML private Label _lblAcctExist;
        @FXML private Button _btnNewAcct;
        public static String filePath;
    
 
    @FXML private void Initialize(){
   
    }
    /**
     * OnAction for the button Log In
     * @param event 
     */
    @FXML
    public void onLogIN(ActionEvent event){
        
        //read the accounts file
        //check that the user inputed name/id are in this file.
        //if they are, load that file.
        //    tom|23434|tomDictionary.txt
        //    jeremy|23555|jeremyDictionary.txt
       // All account info is kept the users.txt file.
        
        
        Scanner reader = null;
        try{
        File file = new File("users.txt");
        reader = new Scanner(file);
        String record="";
        String[] fields={};
        //set start to false
        boolean start = false;
        while(reader.hasNext()){
           record = reader.next();
            System.out.println(record);
            fields = record.split("\\|");
            
            //if the users username and account Id exists in users.txt
            if(fields[0].equals(_txtUserName.getText()) && fields[1].equals(_txtAcctID.getText())){
                //If condition is met assign the boolean value of true to the variable start
                // break out of the loop
                start =true;
                break;
            }  
         }
        //If Start is true load Main menu controller/window
        if(start){
            //launch stage with argument of fields[2]
            // Field[2] of every line list name of every dictionary text file attached to specific userName
            //And account ID
            filePath = fields[2];
            Dictionary dictionary = new Dictionary();
            //call readDictFile
            readDictFile(dictionary,fields[2]);
            try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            AnchorPane root = fxmlLoader.load();
            
            //Allows MainMenuController to access information in the Dictionary class
            ((MainMenuController)fxmlLoader.getController()).inItData(dictionary);
            
            Scene scene = new Scene(root,600,600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            
            secondStage.initOwner(((Node)event.getSource()).getScene().getWindow());
            secondStage.initModality(Modality.WINDOW_MODAL);
            
           ((Stage)_txtUserName.getScene().getWindow()).hide();
           _txtUserName.clear();
           _txtAcctID.clear();
           _lblAcctExist.setText("");
            secondStage.showAndWait();
            ((Stage)_txtUserName.getScene().getWindow()).show();
            }
            
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
        else{   
                //else display this message to the label _lblAcctExist
                _lblAcctExist.setText("Sorry. Account does not exist. Please Create New account");
         }
            
        }
        catch(FileNotFoundException error){
            error.printStackTrace();
        }
        finally{
            if(reader != null){
                reader.close();
            }
        }
         
    }
    
    /**
     * This method populates the dictionary from requested user name and account at log in.
     * @param dictionary
     * @param fileName 
     */
    public void readDictFile(Dictionary dictionary, String fileName){
        Scanner reader = null;
        //File name is taken from fields[2] of the users.txt file
        File file = new File(fileName);
        //if file does not exist create file.
        if(!file.exists()){
            try{
           file.createNewFile();
            }catch(IOException ioe){
                _lblAcctExist.setText("Please enter a valid user name and account ID");
            }
        }
        //Populate dictionary with words by reading the file from the requested dictionary.
        try{
            
            reader = new Scanner(file);
            while(reader.hasNext()){
                String record = reader.next();
                String [] fields = record.split("\\|");
                dictionary.addWord(fields[0], fields[1]);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        finally{
            if(reader != null){
                reader.close();
            }
        }
        
        _txtUserName.clear();
        _txtAcctID.clear();
    }/**
     * OnAction for the create account button.
     * Appends new accounts created to users.txt file.
     */
    @FXML public void onCreateAcct(){
        //read users.txt
        Scanner reader = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            /*Appends username and account ID and created a unique name for the dictionary txt file
            attached to the account by combining the user name and account ID. E.g if the user entered
            "kris" for the username and "1234" for the account Id. The name of the dictionary attached to the
            account would be "kris1234"
            */
            String info =_txtUserName.getText() + "|" + _txtAcctID.getText() + "|"
                    + _txtUserName.getText() + _txtAcctID.getText() + ".txt" + "\n";
            File file = new File("users.txt");
            
            if(!file.exists()){
                file.createNewFile();
            }
            
              fw = new FileWriter(file.getAbsoluteFile(),true);
              bw = new BufferedWriter(fw);
            
              bw.write(info);
              
              _txtUserName.clear();
              _txtAcctID.clear();
              
        }
        catch(IOException e){
            
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
    }
    
   
}
