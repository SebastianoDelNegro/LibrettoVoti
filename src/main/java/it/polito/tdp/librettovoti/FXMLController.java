package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.libretto;
import model.voto;

public class FXMLController {
	
	libretto model ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtVoto;

    @FXML
    private TextField txtData;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private DatePicker pickerEsame;
    
    public void setmodel(libretto model) {
    	this.model=model;
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	//controllo su tutti i dati per vedere se sono validi
    	String nomeEsame = txtNome.getText();
    	if(nomeEsame.length()==0) {
    		System.out.println("errore");
    		txtResult.setText("ERRORE");
    		return ; 
    	}
    	String voto=txtVoto.getText();
    	int votoint=0;
    	try {
    	 votoint = Integer.parseInt(voto);}
    	catch(NumberFormatException e ) {
    		txtResult.setText("ERRORE : il voto deve essere intero");
    		return; 
    	} 
    	if(votoint >30 || votoint<18) {
    		txtResult.setText("ERRORE : deve essere compreso tra 18 e 30");
    	}
    	
    	
    	//String data = txtData.getText();
    	//LocalDate datae;
    	//try {
    	//datae = LocalDate.parse(data);}
    	//catch(DateTimeParseException ev ) {
    		//txtResult.setText("ERRORE: data errata");
    		//return ; 
    	//}
    	
    	LocalDate datae = pickerEsame.getValue();
    	
    	
    	voto v = new voto(nomeEsame,votoint,datae);
    	model.add(v);
    	
    	txtResult.setText(model.toString());
    	txtNome.clear();
    	txtVoto.clear();
    	//txtData.clear();

    }

    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

