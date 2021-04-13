package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagrammi;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model anagramma;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInserisci"
    private TextField txtInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	try {
    		
    		String parola = txtInserisci.getText();
        	List<String> combinazioni = anagramma.doAnagramma(parola);
        	
        	for(String s: combinazioni) {
        		if(this.anagramma.isCorrect(s))
        			txtCorretti.appendText(s +"\n");
        		else
        			txtErrati.appendText(s +"\n");
        	}
    		
    	}catch(NullPointerException npe) {
    		txtCorretti.setText("Inserire una parola nel campo di testo.");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInserisci.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
     public void SetModel(Model anagramma) {
   		this.anagramma = anagramma;
   		txtCorretti.setStyle("-fx-font-family: monospace");
       	txtErrati.setStyle("-fx-font-family: monospace");
      }
    
    
}
