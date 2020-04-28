package com.amarjefferson.codeabout.java.gui.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * File Name: CalculatorFx.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.javafx
 * Class: CalculatorFx
 *
 */
public class CalculatorFx extends Application {
	   private TextField txtNumber1,
	   					 txtNumber2,
	   					 txtResult;
	   private Button btnAdd,
	   				  btnSubtract,
	   				  btnMultiply,
	   				  btnDivide,
	   				  btnClear;
	   private Label lblEquals,
	   				 lblOp;
	   private GridPane root;
	   private DropShadow aShadow;		

	   private CalculatorFxModel calcModel;

	   private String operation;
	   private String alertTitle;
	   private String alertMessage;
	   private boolean inpError;

	/**
	 * 
	 */
	public CalculatorFx() {
		aShadow = new DropShadow();
		aShadow.setColor(Color.STEELBLUE);
		calcModel = new CalculatorFxModel();
		alertTitle = "Processing Input Values";
		alertMessage = "Please input a valid number";
		inpError = false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
	}


	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
        // Root container
        root = new GridPane();
        // Put rootHome container in middle of scene
        root.setAlignment(Pos.CENTER);
        // Sets spacing between controls in GridPane
        root.setHgap(10);
        root.setVgap(10);

        // Create the controls and add to GridPane
        btnAdd = new Button("+");
        btnAdd.setPrefWidth(70);
        btnAdd.setOnAction(anEvent -> handleAdd(anEvent));
        root.add(btnAdd, 2, 0);

        btnSubtract = new Button("-");
        btnSubtract.setPrefWidth(70);
        btnSubtract.setOnAction(anEvent -> handleSubtract(anEvent));
        root.add(btnSubtract, 2, 1);

        btnMultiply = new Button("*");
        btnMultiply.setPrefWidth(70);
        btnMultiply.setOnAction(anEvent -> handleMultiply(anEvent));
        root.add(btnMultiply, 2, 2);

        btnDivide = new Button("/");
        btnDivide.setPrefWidth(70);
        btnDivide.setOnAction(anEvent -> handleDivide(anEvent));
        root.add(btnDivide, 2, 3);

        txtNumber1 = new TextField();
        txtNumber1.setPromptText("Number 1");
        txtNumber1.setPrefWidth(150);
        root.add(txtNumber1, 1, 0);
 
        txtNumber2 = new TextField();
        txtNumber2.setPromptText("Number 2");
        txtNumber2.setPrefWidth(150);
        root.add(txtNumber2, 1, 1);

        txtResult = new TextField("");
        txtResult.setPromptText("Result");
        txtResult.setPrefWidth(150);
        txtResult.setEditable(false);
        txtResult.setStyle("-fx-border-color: #1E90FF;"); //apply ccs style to label
        root.add(txtResult, 1, 2);
       
        btnClear = new Button("Clear");
        btnClear.setPrefWidth(150);
        btnClear.setOnAction(anEvent -> handleClear(anEvent));
        root.add(btnClear, 1, 3);

        lblOp = new Label();
        lblOp.setText("");
        lblOp.setPrefWidth(15);
        root.add(lblOp, 0, 1);


        lblEquals = new Label();
        lblEquals.setText("=");
        lblEquals.setPrefWidth(15);
        root.add(lblEquals, 0, 2);

        // Create a Scene using the rootHome
        Scene scene = new Scene(root, 300, 250);

        // Display the primary stage
        primaryStage.setTitle("CalcFx");
        primaryStage.setScene(scene);
        primaryStage.show();
	}


	// display alert
	private void displayAlert(String aTitle, String aHeader, String aMessage) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(aTitle);
        alert.setHeaderText(aHeader);
        alert.setContentText(aMessage);
        alert.showAndWait();
	}


	// display results
	private void displayResult(String strResult) {
      txtResult.setText(strResult);
      txtResult.setEffect(aShadow);
      lblOp.setText(operation);
	}


	// process TextField input
	private double getInput(TextField aTextField) {
        if(!calcModel.checkInput(aTextField.getText(), aTextField.getPromptText())) {
        	displayAlert(alertTitle, calcModel.getAlertHeader(), alertMessage);
        	aTextField.setText("");
        	inpError = true;
        	return Double.MIN_VALUE;
        }

        inpError = false;
        return Double.parseDouble(aTextField.getText());
	}


	// process button actions
	public void handleClear(ActionEvent anEvent) {
        txtNumber1.setText("");
        txtNumber2.setText("");
        txtResult.setText("");
        txtResult.setEffect(null);
        lblOp.setText("");
        calcModel.clear();
        return;
    }
	

	// process Add button
	public void handleAdd(ActionEvent anEvent) {
		operation = "+";
        //read numbers from textfields
        calcModel.setNumber1(getInput(txtNumber1));
        calcModel.setNumber2(getInput(txtNumber2));
        if(!inpError)
        	displayResult(calcModel.add().resultAsString());
    }


	// process Subtract button
	public void handleSubtract(ActionEvent anEvent) {
		operation = "-";
        //read numbers from textfields
        calcModel.setNumber1(getInput(txtNumber1));
        calcModel.setNumber2(getInput(txtNumber2));
        if(!inpError)
        	displayResult(calcModel.subtract().resultAsString());
    }


	// process Multiply button
	public void handleMultiply(ActionEvent anEvent) {
		operation = "*";
        //read numbers from textfields
        calcModel.setNumber1(getInput(txtNumber1));
        calcModel.setNumber2(getInput(txtNumber2));
        if(!inpError)
        	displayResult(calcModel.multiply().resultAsString());
    }


	// process Divide button
	public void handleDivide(ActionEvent anEvent) {
		operation = "/";
        //read numbers from textfields
        calcModel.setNumber1(getInput(txtNumber1));
        calcModel.setNumber2(getInput(txtNumber2));
        if(!inpError)
        	displayResult(calcModel.divide().resultAsString());
    }

}

