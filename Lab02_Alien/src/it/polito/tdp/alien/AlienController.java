package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	private Map<String, String> parole = new HashMap<String, String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtMessaggi;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String parola []= this.txtWord.getText().split(" ");
    	
    	if (parola.length == 2) {
    		if (!parola[0].matches("[a-zA-Z]+") || !parola[1].matches("[a-zA-Z]+")) {
    			this.txtMessaggi.appendText("Devi inserire una parola!\n");
    			throw new InvalidParameterException("Devi inserire una parola!\n");
    		}
    		parole.put(parola[0].toLowerCase(), parola[1].toLowerCase());
    		txtMessaggi.appendText("Aggiunta nuova parola al dizionario\n");
    	}
    	else if (parola.length == 1) {
    		if (!parola[0].matches("[a-zA-Z]+")) {
    			this.txtMessaggi.appendText("Devi inserire una parola!\n");
    			throw new InvalidParameterException("Devi inserire una parola!\n");
    		}
    		String traduzione = parole.get(parola[0].toLowerCase());
    		if (traduzione == null) {
    			this.txtMessaggi.appendText("La parola inserita non e' conteuta nel dizionario\n");
    		}
    			else {
    				this.txtMessaggi.appendText("La traduzione e': "+traduzione+"\n");
    		}
    	}
    	this.txtWord.clear();
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtMessaggi != null : "fx:id=\"txtMessaggi\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
