package com.amarjefferson.codeabout.java.gui.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * File Name: HelloWorldFx.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.javafx
 * Class: HelloWorldFx
 *
 */
public class HelloWorldFx extends Application {
	Label lblHello;
	Button btnHello;
	Scene sceneHome;
	GridPane rootHome;
	
	/**
	 * 
	 */
	public HelloWorldFx() {
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
	}


	/* (non-Javadoc)
	 * @see javafx.application.Application#init()
	 * Runs on launcher thread
	 */
	@Override
	public void init() throws Exception {
		super.init();    // this method does nothing
	}


	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * Runs on application thread
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
        // Root container
        rootHome = new GridPane();
        // Put rootHome container in middle of scene
        rootHome.setAlignment(Pos.CENTER);
        // Sets spacing between controls in GridPane
        rootHome.setHgap(10);
        rootHome.setVgap(10);

        // Add components to rootHome
        lblHello = new Label("");
        rootHome.add(lblHello, 0, 1);
        btnHello = new Button();
        btnHello.setText("Say 'Hello World'");
        btnHello.setOnAction(event -> lblHello.setText("Hello World!"));
        rootHome.add(btnHello, 0, 0);

        // Create a Scene using the rootHome
        sceneHome = new Scene(rootHome, 300, 250);

        // Display the primary stage
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(sceneHome);
        primaryStage.show();
	}


	/* (non-Javadoc)
	 * @see javafx.application.Application#stop()
	 * Runs on application thread
	 */
	@Override
	public void stop() throws Exception {
		super.stop();    // this method does nothing
	}

}
