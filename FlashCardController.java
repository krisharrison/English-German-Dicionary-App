import java.io.IOException;
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
 */
public class FlashCardController {
    //Declaring field variables
    @FXML private TextField _txtAnswer;
    @FXML private Button _btnPrevious;
    @FXML private Button _btnNext;
    @FXML private Label _lblMessage;
    @FXML private Label _lblGermanWord;
    //Creating a field variable from a dictionary object
    Dictionary _dictionary = new Dictionary();
    private int _index;
    @FXML private void Intialize(){
    }
    /**
     * This method stores information from the dictionary class,
     * initializes index to 0, and sets the label _lblGeramnWord
     * @param dictionary 
     */
    public void inItData(Dictionary dictionary){
        this._dictionary = dictionary;
        setIndex(0);
        setLabel();
    }
    /**
     * This method sets the index
     * @param index 
     */
    private void setIndex(int index){
        this._index = index;
    }
    /**
     * This method sets the label _lblGermanWord
     */
    @FXML 
    private void setLabel(){
        System.out.println(_lblGermanWord);
        System.out.println(_dictionary);
        _lblGermanWord.setText(_dictionary.getIndex(_index).getGerman());
    }
    /**
     * This method is the onAction for the button next
     * It accesses the next index in the array _Dictionary
     */
    @FXML
    private void onNext(){
       _index++;
       setLabel();
       _lblMessage.setText("");
        _txtAnswer.clear();
    }
    /**
     * This method is the onAction for the button previous
     * It accesses the previous index in the array _Dictionary
     */
    @FXML
    private void onPrevious(){
        _index--;
        setLabel();
        _lblMessage.setText("");
        _txtAnswer.clear();
        
    }
    /**
     * This method is the OnAction for the button  Check Answer
     * It displays whether or not the answer is correct and sets it to
     * the label _lblMessage
     */
    @FXML void onCheckAnswer(){
 
        if(_txtAnswer.getText().equals(_dictionary.getIndex(_index).getEnglish())){
            _lblMessage.setText("Correct!");
        }
        else{
            _lblMessage.setText("Incorrect! Please try again!");
        }
         
    }

    /**
     * This method is the onAction for the button MainMenu. It allows you to access
     * the main menu form the Flash Card screen.
     * @param event 
     */
    @FXML 
    private void onMainMenu(ActionEvent event){
        //try{
            ((Stage)_lblMessage.getScene().getWindow()).close();
            
        
    }
}
