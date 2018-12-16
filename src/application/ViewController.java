package application;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
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
	@FXML
	private DatePicker picker;
	@FXML
	private Button speichern;
	@FXML
	private TextField dataAdress;

	Main main;

	private int staerke;
	private LocalDate date;
	private final String saveFail = "-fx-border-color: red;\n" + "-fx-border-width: 3;\n";
	private final String saveSuccessfull = "-fx-border-color: blue;\n" + "-fx-border-width: 3;\n";
	private final int DATA_ADRESS_INDEX = 14;

	// TODO: batch-Datei fuer Onedrive starten vll bei Programmschließen oder
	// TODO: speichern + Dateipfadleiste funktionell machen
	// TODO: p1a-p3e nur Zahlen von 0-24, aktivitaet nur zahlen generell
	// TODO: rote Error-borders für diese Felder bis saved + Error-sounds

	public void setMain(Main main) {

		this.main = main;

		sta1.setDisable(true);
		sta2.setDisable(true);
		sta3.setDisable(true);

		picker.setOnAction(event -> {
			date = picker.getValue();
			speichern.setStyle(null);
		});

		// BufferedReader reader = new BufferedReader(new FileReader(new File("")))

	}

	public void handleSpeichern() {

		if (!(date == null)) {
			try {
				double p1aValue;

				// Schlafstunden der einzelnen Phasen + Gesamtschlaf
				double p1Value = 0;
				double p2Value = 0;
				double p3Value = 0;
				double schlafGesamt;

				if (!p1a.getText().equals("") && !p1e.getText().equals("")) {
					p1Value = Double.parseDouble(p1e.getText()) - Double.parseDouble(p1a.getText());
				}
				if (!p2a.getText().equals("") && !p2e.getText().equals("")) {
					p2Value = Double.parseDouble(p2e.getText()) - Double.parseDouble(p2a.getText());
				}
				if (!p3a.getText().equals("") && !p3e.getText().equals("")) {
					p3Value = Double.parseDouble(p3e.getText()) - Double.parseDouble(p3a.getText());
				}

				schlafGesamt = p1Value + p2Value + p3Value;

				// Wenn Aktivitaetsfeld leer dann 0
				String activity;
				if (aktivitaet.getText().equals("")) {
					activity = "0";
				} else {
					activity = aktivitaet.getText();
				}

				// Felder fuer Substanzen
				int gValue = (g.isSelected() ? 1 : 0);
				int aValue = (a.isSelected() ? 1 : 0);
				int mValue = (m.isSelected() ? 1 : 0);
				int lgValue = (lg.isSelected() ? 1 : 0);
				int rValue = (r.isSelected() ? 1 : 0);
				int sValue = (s.isSelected() ? 1 : 0);
				int pValue = (p.isSelected() ? 1 : 0);
				int oneValue = (one.isSelected() ? 1 : 0);
				int kValue = (k.isSelected() ? 1 : 0);
				int tValue = (t.isSelected() ? 1 : 0);

				/*
				 * ein oder zwei Parameter, 2. (true) damit Sachen angehaengt werden statt zu
				 * ersetzen
				 */
				FileWriter fileWriter = new FileWriter("C:\\Users\\ichju\\Desktop\\data.csv", true);

				fileWriter.append(date.toString() + "," + schlafGesamt + "," + gValue + "," + aValue + "," + mValue
						+ "," + lgValue + "," + rValue + "," + sValue + "," + pValue + "," + oneValue + "," + kValue
						+ "," + tValue + "," + activity + "," + String.valueOf(staerke) + "," + "\n");

				fileWriter.flush();
				fileWriter.close();
				speichern.setStyle(saveSuccessfull);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			speichern.setStyle(saveFail);
		}
	}

	@FXML
	public void handleNein() {
		staerke = 0;

		sta1.setSelected(false);
		sta2.setSelected(false);
		sta3.setSelected(false);

		sta1.setDisable(true);
		sta2.setDisable(true);
		sta3.setDisable(true);
	}

	@FXML
	public void handleJa() {
		sta1.setDisable(false);
		sta2.setDisable(false);
		sta3.setDisable(false);
	}

	@FXML
	public void handleSta1() {
		staerke = 1;
	}

	@FXML
	public void handleSta2() {
		staerke = 2;
	}

	@FXML
	public void handleSta3() {
		staerke = 3;
	}

}
