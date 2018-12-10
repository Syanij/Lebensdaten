package application;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ViewController {

	// View
	@FXML
	private Label tag;
	@FXML
	private Label monat;
	@FXML
	private Label jahr;
	@FXML
	private RadioButton ja;
	@FXML
	private RadioButton nein;
	@FXML
	private CheckBox g;
	@FXML
	private CheckBox a;
	@FXML
	private CheckBox m;
	@FXML
	private CheckBox p;
	@FXML
	private CheckBox one;
	@FXML
	private CheckBox lg;
	@FXML
	private CheckBox k;
	@FXML
	private CheckBox t;
	@FXML
	private CheckBox s;
	@FXML
	private CheckBox r;
	@FXML
	private TextField p1a;
	@FXML
	private TextField p2a;
	@FXML
	private TextField p3a;
	@FXML
	private TextField p1e;
	@FXML
	private TextField p2e;
	@FXML
	private TextField p3e;
	@FXML
	private TextField aktivitaet;
	@FXML
	private RadioButton sta1;
	@FXML
	private RadioButton sta2;
	@FXML
	private RadioButton sta3;

	Main main;

	public void setMain(Main main) {
		this.main = main;
	}

	// Datumseingabe
	@FXML
	public void handleDMinus() {

	}

	@FXML
	public void handleDPlus() {

	}

	@FXML
	public void handleMMinus() {

	}

	@FXML
	public void handleMPlus() {

	}

	@FXML
	public void handleYMinus() {

	}

	@FXML
	public void handleYPlus() {

	}

	@FXML
	public void handleSpeichern() {
		if (g.isSelected()) {
			g.setSelected(false);
		} else {
			g.setSelected(true);
		}
	}

}
