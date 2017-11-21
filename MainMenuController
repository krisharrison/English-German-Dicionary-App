/*
 *Main menu controller/Window
 */
package finalproject;
//IMPORTS
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *  Final Project
 * Thursday, August 10, 2017
 * @author Kris Harrison
 * 
 */
public class MainMenuController {
    //field variables
    @FXML private Button _btnDictionary;
    @FXML private Button _btnFlashCards;
    @FXML private Button _btnLogout;
    @FXML private Label _lblError;
    private Dictionary _dictionary;
    
    
    @FXML private void Initialize(){
        
        
    }
    
    /**
     * This method stores a dictionary object
     * @param dictionary 
     */
    @FXML public void inItData(Dictionary dictionary){
        _dictionary = dictionary;
    }
    /**
     * OnAction for the dictionary button.
     * @param event 
     */
    @FXML
    public void onDictionary(ActionEvent event){
        
        Scanner reader = null;
        try{
            //Load Dictionary.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dictionary.fxml"));
            AnchorPane root = fxmlLoader.load();
            
            //This allows the DictionaryController to access information in the dictionary class
            ((DictionaryController)fxmlLoader.getController()).inItData(_dictionary);
            
            Scene secondScene = new Scene(root,600,600);
            secondScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage thirdStage = new Stage();
            thirdStage.setScene(secondScene);
            
            thirdStage.initOwner(((Node)event.getSource()).getScene().getWindow());
            thirdStage.initModality(Modality.WINDOW_MODAL);
            
            thirdStage.showAndWait();
            }
            catch(IOException e){
                _lblError.setText("Erro! Dictionary could not load!");
                e.printStackTrace();
            }
            finally{
            if(reader != null){
                reader.close();
            }
        }
    }
    /**
     * OnAction for the flash cards button
     * @param event 
     */
    @FXML
    public void onFlashCards(ActionEvent event){
        Scanner reader = null;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FlashCards.fxml"));
            AnchorPane root = fxmlLoader.load();
            
            //Allows FlashCardController to access information in the Dictionary class.
            ((FlashCardController)fxmlLoader.getController()).inItData(_dictionary);
            
            Scene secondScene = new Scene(root,600,600);
            secondScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage thirdStage = new Stage();
            thirdStage.setScene(secondScene);
            
            thirdStage.initOwner(((Node)event.getSource()).getScene().getWindow());
            thirdStage.initModality(Modality.WINDOW_MODAL);
            
            thirdStage.showAndWait();
            }
            catch(IOException e){
                _lblError.setText("Erro! Flash Cards could not load!");
                e.printStackTrace();
            }
            finally{
            if(reader != null){
                reader.close();
            }
        }
        
    }
    /**
     * This method loads the log-in window
     * @param event 
     */
    @FXML
    public void onLogOut(ActionEvent event){
        
        ((Stage)_btnLogout.getScene().getWindow()).close();

        _lblError.setText("");
        }
    
}
