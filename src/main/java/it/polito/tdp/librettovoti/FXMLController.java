package it.polito.tdp.librettovoti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label txtStatus;

    @FXML
    private TextField txtNome;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private TextArea txtVoti;

    @FXML
    void handleNuovoVoto(ActionEvent event) {
    	
    	String nome = txtNome.getText();
    	Integer punti = cmbPunti.getValue();
    	
    	//controlli
    	if(nome.equals("") || punti==null) {
    		txtStatus.setText("ERRORE: occorre inserire nome e voto!");
    		return;
    	}
    	
    	boolean ok = model.add(new Voto(nome, punti));
    	
    	if(ok) {
    		List<Voto> voti = model.getVoti();
    		txtVoti.clear();
    		txtVoti.appendText("Hai superato " +voti.size()+" esami\n");
    		for(Voto v : voti)
    			txtVoti.appendText(v.toString()+"\n");
    		
    		txtNome.clear();
    		cmbPunti.setValue(null);
    		txtStatus.setText("");    		
    	} else {
    		txtStatus.setText("ERRORE: esame già presente!");
    	}
    }
    
    public void setModel(Libretto model) {
    	this.model=model;
		List<Voto> voti = model.getVoti();
		txtVoti.clear();
		txtVoti.appendText("Hai superato " +voti.size()+" esami\n");
		for(Voto v : voti)
			txtVoti.appendText(v.toString()+"\n");
    }

    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbPunti != null : "fx:id=\"txtPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbPunti.getItems().clear();
        for(int i=18;i<31;i++) {
        	cmbPunti.getItems().add(i);
        }
    }

}
