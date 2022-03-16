/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML
    void doTranslate(ActionEvent event) {
    	String input = txtParola.getText().toLowerCase();
    	if (this.model.verifica(input) == false) {
    		this.txtRisultato.setText("Puoi inserire solo i caratteri [a-zA-Z].");
    		return;
    	}
    	String[] array = input.split(" ");
    	String risultato;
    	if (array.length == 1) {
    		// tradurre la parola inserita
    		risultato = this.model.traduci(array[0]);
        	this.txtParola.clear(); 
    	}
    	else if (array.length == 2) {
    		// aggiungere la coppia di parole
    		risultato = this.model.aggiungi(array[0], array[1]);
        	this.txtParola.clear(); 
    	}
    	else {
    		risultato = "Inserimento non valido. Hai due opzioni:\n" +
    					"- Inserire una parola e tradurla\n" +
    					"- Aggiungere una nuova traduzione al dizionario\n" +
    					"  <parola aliena> <traduzione> (separate da uno spazio)";
    	}
    	this.txtRisultato.appendText(risultato + "\n");
    }
    
    @FXML
    void doClearText(ActionEvent event) {
    	txtRisultato.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}
