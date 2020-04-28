package com.amarjefferson.codeabout.java.gui.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * File Name: JavaFxDemo.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.javafx
 * Class: JavaFxDemo
 *
 */
public class JavaFxDemo extends Application {

	private static final double DEFAULT_FONT_SIZE = 12.0;
	private static final double MIN_FONT_SIZE = 6.0;
	private static final double MAX_FONT_SIZE = 72.0;
	private static final double SCENE_WIDTH = 1000.0;
	private static final double SCENE_HEIGHT = 700.0;
	private static final double NODE_WIDTH = 500.0;
	private static final double NODE_HEIGHT = 300.0;
	private static final double SLIDER_WIDTH = 450.0;
	private static final double SLIDER_HEIGHT = 50.0;
	private static final double SLIDER_MAJOR_TICK = 6.0;
	private static final double CANVAS_WIDTH = 300.0;
	private static final double CANVAS_HEIGHT = 300.0;
	private static final double HGAP = 10.0;
	private static final double VGAP = 10.0;
	private static final double PADDING = 10.0;

	Stage primaryStage;
	Scene aScene;
	BorderPane rootNode;
	FlowPane centerNode;
	ScrollPane scrollTextArea;

	private java.net.URL openURL;
	private java.net.URL saveURL;
	private java.net.URL yellowURL;
	private java.net.URL redURL;
	private java.net.URL blueURL;
	private java.net.URL onURL;
	private java.net.URL offURL;
	private java.net.URL ajcURL;
	private java.net.URL jeffersonURL;
	
	ListView<String> transportList;
	TextField tfStatus;
	Label lblSlider;
	Label aBanner;
	TextField aTextField;
	TextArea aTextArea;
	double fontSize = DEFAULT_FONT_SIZE;
	GraphicsContext gc;
	Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.BLACK };
	int colorIdx = 0;

	double glowValue = 0.5;
	Glow aGlow = new Glow(glowValue);
	
	boolean hasInnerShadow = false;
	InnerShadow anInnerShadow = new InnerShadow(10.0, Color.AZURE);
	
	boolean hasDropShadow = false;
	DropShadow aDropShadow = new DropShadow();
	
	boolean hasLighting = false;
	Lighting aLighting = new Lighting();
	
	boolean hasReflection = false;
	Reflection aReflection = new Reflection();

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
		this.primaryStage = primaryStage;		
		primaryStage.setTitle("Learning JavaFx");  // set the stage title

		rootNode = createTopNode(primaryStage);
		this.saveURL = getClass().getResource("/icons/save_16.png");
		this.openURL = getClass().getResource("/icons/folder-open_16.png");
		this.yellowURL = getClass().getResource("/icons/yellow-ball.gif");
		this.redURL = getClass().getResource("/icons/red-ball.gif");
		this.blueURL = getClass().getResource("/icons/blue-ball.gif");
		this.onURL = getClass().getResource("/icons/add_16.png");
		this.offURL = getClass().getResource("/icons/delete_16.png");

		// setup ToolBar
		Button btnSave = createButton("Save!", saveURL.toString(), ContentDisplay.LEFT, anEvent -> tfStatus.setText("Save!"));
		Button btnOpen = createButton("Open!", openURL.toString(), ContentDisplay.LEFT, anEvent -> tfStatus.setText("Open!"));
		Button btnRed = createButton("Stroked", redURL.toString(), ContentDisplay.LEFT, new StrokedAction());
		Button btnYellow = createButton("Filled", yellowURL.toString(), ContentDisplay.LEFT, new FilledAction());
		Button btnBlue = createButton("All", blueURL.toString(), ContentDisplay.LEFT, new AllCanvasAction());

		ToggleButton btnToggle = createToggleButton("On", "Off", onURL.toString(), offURL.toString());

		aTextField = new TextField();
		aTextField.setPromptText("Input your name and press Enter");
		aTextField.setPrefColumnCount(40);
		aTextField.setOnAction(anEvent -> {
							   aBanner.setText("Java Fx Demo for " + aTextField.getText());
							   aTextField.setText("");
							   });

		this.ajcURL = getClass().getResource("/icons/ajc_iconS.png");
		ImageView ajcLogo = new ImageView(ajcURL.toString());

		ToolBar aToolBar = new ToolBar(ajcLogo, new Separator(),
									   btnSave, btnOpen, new Separator(),
									   btnToggle, new Separator(),
									   btnRed, btnYellow, btnBlue, new Separator(),
									   aTextField);
		// setup Menubar
		MenuBar mb = createMenuNode();
		VBox topArea = new VBox();
		topArea.getChildren().addAll(aToolBar, mb);
		rootNode.setTop(topArea);

		// create status bar
		tfStatus = new TextField();
		tfStatus = new TextField();
		tfStatus.setPromptText("Status Bar");
		tfStatus.setPrefColumnCount(40);
		tfStatus.setEditable(false);
		rootNode.setBottom(tfStatus);

		// create TreeView
		FlowPane treeNode = createTreeNode();
		rootNode.setLeft(treeNode);

		// create FlowPane for center area
		centerNode = createCenterNode(primaryStage, Orientation.VERTICAL);

		Separator aSeparator = new Separator();
		aSeparator.setPrefWidth(200.0);

		// create a sliderBox
		lblSlider = createImageLabel("Set font size", false, "");
		Slider aSlider = createSlider();
		HBox sliderBox = new HBox();
		sliderBox.setAlignment(Pos.CENTER_LEFT);
		sliderBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		sliderBox.setSpacing(HGAP);
		sliderBox.setStyle("-fx-background-color: #ffffcc;");
		sliderBox.getChildren().addAll(lblSlider, aSlider);

		VBox radioButtonsBox = createRadioButtonsBox();
		VBox checkBoxesBox = createCheckBoxesBox();
		VBox listViewBox = createListViewBox();
		VBox comboBoxBox = createComboboxBox();

		// create a TextArea with ScrollPane
		aTextArea = new TextArea();
		aTextArea.setEditable(false);
		scrollTextArea = new ScrollPane(aTextArea);
		scrollTextArea.setPrefViewportWidth(150);
		scrollTextArea.setPrefViewportHeight(90);

		HBox selectionUI = new HBox();
		selectionUI.getChildren().addAll(listViewBox, radioButtonsBox, checkBoxesBox,
										 comboBoxBox, scrollTextArea);

		HBox graphicsBox = new HBox();
		graphicsBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		graphicsBox.setSpacing(HGAP);
		graphicsBox.setStyle("-fx-background-color: #ffffcc;");
		graphicsBox.setAlignment(Pos.CENTER_LEFT);

		// Create a canvas and save the GraphicsContext
		Canvas aCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc = aCanvas.getGraphicsContext2D();
		drawFilledElements(gc, DEFAULT_FONT_SIZE);
		drawStrokedElements(gc);
		ScrollPane scrollCanvas = new ScrollPane(aCanvas);
		scrollCanvas.setPrefViewportWidth(250);
		scrollCanvas.setPrefViewportHeight(175);
		scrollCanvas.setPannable(true);

		// createan imageview node
		this.jeffersonURL = getClass().getResource("/images/jefferson.bmp");
		ImageView anImageView = new ImageView(jeffersonURL.toString());
		graphicsBox.getChildren().addAll(scrollCanvas, anImageView);

		// add components to centerNode
		centerNode.getChildren().add(sliderBox);
//		centerNode.getChildren().add(aSeparator);
		centerNode.getChildren().add(selectionUI);
		centerNode.getChildren().add(graphicsBox);
		ScrollPane scrollCenter = new ScrollPane(centerNode);

		rootNode.setCenter(scrollCenter);
		// create a Scene
		aScene = new Scene(rootNode, SCENE_WIDTH, SCENE_HEIGHT);
		// add the scene to the primary stage
		primaryStage.setScene(aScene);
		// show the primary stage
		primaryStage.show();
	}

	/**
	 * 
	 */
	private void drawFilledElements(GraphicsContext gc, double fontSize) {
		// Draw filled elements on the canvas.
     	gc.setFill(colors[colorIdx]);
		gc.fillOval(0, 0, 20, 20);
    	gc.fillRect(60, 150, 50, 150);
		gc.setFont(new Font(fontSize));
		gc.fillText("Hello Java Fx!", 60, 40);
	}

	/**
	 * 
	 */
	private void drawStrokedElements(GraphicsContext gc) {
		// Draw stroked elements on the canvas.
    	gc.setStroke(colors[colorIdx]);
    	gc.strokeLine(0, 0, 200, 200);
		gc.strokeOval(125, 125, 150, 150);
		gc.strokeRect(0, 60, 45, 150);
	}

	/**
	 * 
	 */
	private MenuBar createMenuNode() {
		// Create the menu bar.
		MenuBar mb = new MenuBar();
		// Create the File menu.
		Menu fileMenu = new Menu("File");
		MenuItem open = new MenuItem("Open", new ImageView(openURL.toExternalForm()));
		open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
		MenuItem save = new MenuItem("Save", new ImageView(saveURL.toExternalForm()));
		save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
		MenuItem exit = new MenuItem("Exit");
		exit.setAccelerator(KeyCombination.keyCombination("shortcut+X"));
		fileMenu.getItems().addAll(open, save, new SeparatorMenuItem(), exit);
		mb.getMenus().add(fileMenu);

		// Create the Actons menu.
		Menu actionsMenu = new Menu("Actions");

		// Create the Graphics submenu.
		Menu canvasMenu = new Menu("Canvas");
		MenuItem stroked = new MenuItem("Stroked Items", new ImageView(redURL.toExternalForm()));
		stroked.setOnAction(new StrokedAction());
		MenuItem filled = new MenuItem("Filled Items", new ImageView(yellowURL.toExternalForm()));
		filled.setOnAction(new FilledAction());
		MenuItem paintAll = new MenuItem("Paint All", new ImageView(blueURL.toExternalForm()));
		paintAll.setOnAction(new AllCanvasAction());
		canvasMenu.getItems().addAll(stroked, filled, paintAll);
		actionsMenu.getItems().add(canvasMenu);

		// Create the Priority submenu.
		Menu priorityMenu = new Menu("Priority");
		RadioMenuItem high = new RadioMenuItem("High");
		RadioMenuItem low = new RadioMenuItem("Low");
		// Create a toggle group and use it for the radio menu items.
		ToggleGroup tg = new ToggleGroup();
		high.setToggleGroup(tg);
		low.setToggleGroup(tg);
		// Select High priority for the default selection.
		high.setSelected(true);
		priorityMenu.getItems().addAll(high, low);
		actionsMenu.getItems().add(priorityMenu);

		// Add a separator.
		actionsMenu.getItems().add(new SeparatorMenuItem());

		// Create the Reset menu item.
		MenuItem reset = new MenuItem("Reset");
		actionsMenu.getItems().add(reset);
		// Add Options menu to the menu bar.
		mb.getMenus().add(actionsMenu);

		// Create the Help menu.
		Menu helpMenu = new Menu("Help");
		MenuItem about = new MenuItem("About");
		helpMenu.getItems().add(about);
		// Add Help menu to the menu bar.
		mb.getMenus().add(helpMenu);

		// Create one event handler that will handle menu action events.
		EventHandler<ActionEvent> MEHandler = ( anEvent -> {
			String name = ((MenuItem)anEvent.getTarget()).getText();

			// If Exit is chosen, the program is terminated.
			if(name.equals("Exit"))
				Platform.exit();

			tfStatus.setText( name + " selected");
			});

		// Set action event handlers for the menu items.
		open.setOnAction(MEHandler);
		save.setOnAction(MEHandler);
		exit.setOnAction(MEHandler);
		high.setOnAction(MEHandler);
		low.setOnAction(MEHandler);
		reset.setOnAction(MEHandler);
		about.setOnAction(MEHandler);
		
		return mb;
		}
	/**
	 * 
	 */
	private FlowPane createTreeNode() {
		FlowPane treeNode = new FlowPane(Orientation.VERTICAL, HGAP, VGAP);
		treeNode.setAlignment(Pos.TOP_LEFT);
		treeNode.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));  // top right bottom left

		TextField fullPath = new TextField();
		fullPath.setPromptText("Selected Path");
		fullPath.setEditable(false);
		fullPath.setPrefColumnCount(20);

		// Construct the tree, starting with the rootHome
		TreeItem<String> treeRoot = new TreeItem<>("Transport");
		treeRoot.setExpanded(true);

		TreeItem<String> trainsRoot = new TreeItem<>("Trains");
		TreeItem<String> train1 = new TreeItem<>("Shinkansen");
		TreeItem<String> train2 = new TreeItem<>("Orient Express");
		TreeItem<String> train3 = new TreeItem<>("California Gold");
		trainsRoot.getChildren().add(train1);
		trainsRoot.getChildren().add(train2);
		trainsRoot.getChildren().add(train3);
		treeRoot.getChildren().add(trainsRoot);
		
		TreeItem<String> carsRoot = new TreeItem<>("Cars");
		TreeItem<String> car1 = new TreeItem<>("Corvette");
		TreeItem<String> car2 = new TreeItem<>("Mustang");
		TreeItem<String> car3 = new TreeItem<>("Jeep Wrangler");
		carsRoot.getChildren().add(car1);
		carsRoot.getChildren().add(car2);
		carsRoot.getChildren().add(car3);
		treeRoot.getChildren().add(carsRoot);

		TreeItem<String> airplaneRoot = new TreeItem<>("Airplanes");
		TreeItem<String> airplane1 = new TreeItem<>("Boeing 787");
		TreeItem<String> airplane2 = new TreeItem<>("F-22 Raptor");
		TreeItem<String> airplane3 = new TreeItem<>("SR-71 Blackbird");
		airplaneRoot.getChildren().add(airplane1);
		airplaneRoot.getChildren().add(airplane2);
		airplaneRoot.getChildren().add(airplane3);
		treeRoot.getChildren().add(airplaneRoot);
		
		TreeItem<String> bicycleRoot = new TreeItem<>("Bicycles");
		treeRoot.getChildren().add(bicycleRoot);
		TreeItem<String> walkingRoot = new TreeItem<>("Walking");
		treeRoot.getChildren().add(walkingRoot);
		
		TreeView<String> transportTree = new TreeView<>(treeRoot);
		transportTree.setCellFactory(TextFieldTreeCell.forTreeView());
		transportTree.setEditable(true);
		MultipleSelectionModel<TreeItem<String>> selectionModel =
				transportTree.getSelectionModel();

		selectionModel.selectedItemProperty().addListener(
				(changed, oldVal, newVal) -> {
					String path = "";
					if(newVal != null) {
						path = newVal.getValue();
						TreeItem<String> tmp = newVal.getParent();
						while(tmp != null) {
						path = tmp.getValue() + " -> " + path;
						tmp = tmp.getParent();
						}
					}
					fullPath.setText(path);
					transportList.getSelectionModel().clearSelection();
					transportList.getSelectionModel().select(newVal.getValue());
					int index = transportList.getSelectionModel().getSelectedIndex();
					transportList.getFocusModel().focus(index);
					transportList.scrollTo(index);
				});

		treeNode.getChildren().addAll(fullPath, transportTree);
		return treeNode;
	}

	/**
	 * 
	 */
	private VBox createComboboxBox() {
		VBox comboBoxBox = new VBox();
		comboBoxBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		comboBoxBox.setSpacing(HGAP);
		comboBoxBox.setStyle("-fx-background-color: #ffffcc;");

		// Create an ObservableList of entries for the list view.
		ObservableList<String> transportTypes =
		FXCollections.observableArrayList( "Train", "Car", "Airplane", "Bicycle", "Walking" );
		// Create the list view.
		final ComboBox<String> transportList = new ComboBox<String>(transportTypes);
		transportList.setValue("Train");
		// set listener
		transportList.setOnAction(
				(anEvent) -> {
					showInTextArea("Combo Box: " + transportList.getValue() + "\n");
				});
		
		comboBoxBox.getChildren().add(transportList);
		return comboBoxBox;
	}

	/**
	 * 
	 */
	private VBox createListViewBox() {
		VBox listViewBox = new VBox();
		listViewBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		listViewBox.setSpacing(HGAP);
		listViewBox.setStyle("-fx-background-color: #ffffcc;");

		// Create an ObservableList of entries for the list view.
		ObservableList<String> transportTypes =
		FXCollections.observableArrayList( "Shinkansen", "Orient Express", "California Gold",
				                           "Corvette", "Mustang", "Jeep Wrangler",
				                           "Boeing 787", "F-22 Raptor", "SR-71 Blackbird");
		// Create the list view.
		transportList = new ListView<String>(transportTypes);
		transportList.setPrefSize(125.0, 140.0);
		// set listener
		MultipleSelectionModel<String> selectionModel =
				transportList.getSelectionModel();
		selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
		selectionModel.selectedItemProperty().addListener(
				(changed, oldVal, newVal) -> {
					String selectedItems = "";
					ObservableList<String> selected =
							transportList.getSelectionModel().getSelectedItems();
					// Display the selections
					for(int i=0; i < selected.size(); i++)
						selectedItems += selected.get(i) + "  ";
					showInTextArea("List Selection: [" + selectedItems.trim() + "]\n");
				}
				);
		
		listViewBox.getChildren().add(transportList);
		return listViewBox;
	}

	/**
	 * 
	 */
	private VBox createCheckBoxesBox() {
		VBox checkBoxesBox = new VBox();
		checkBoxesBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		checkBoxesBox.setSpacing(HGAP);
		checkBoxesBox.setStyle("-fx-background-color: #ffffcc;");
		// create checkboxes
		CheckBox cbTrain = createCheckBox("Train");
		CheckBox cbCar = createCheckBox("Car");
		CheckBox cbAirplane = createCheckBox("Airplane");
		CheckBox cbBicycle = createCheckBox("Bicycle");
		CheckBox cbWalking = createCheckBox("Walking");
		
		checkBoxesBox.getChildren().addAll(cbTrain, cbCar, cbAirplane, cbBicycle, cbWalking);
		return checkBoxesBox;
	}
	
	/**
	 * 
	 */
	private CheckBox createCheckBox(String str) {
		CheckBox btn = new CheckBox(str);
		btn.setAllowIndeterminate(true);
		btn.setOnAction(anEvent ->
		{
			if(btn.isIndeterminate())
				showInTextArea("Check Box: " + str + " indeterminate\n");
			else if(btn.isSelected())
				showInTextArea("Check Box: " + str + " selected\n");
			else
				showInTextArea("Check Box: " + str + " cleared\n");
		});
		return btn;
	}

	/**
	 * 
	 */
	private VBox createRadioButtonsBox() {
		VBox radioButtonsBox = new VBox();
		radioButtonsBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		radioButtonsBox.setSpacing(HGAP);
		radioButtonsBox.setStyle("-fx-background-color: #ffffcc;");
		// Create a toggle group.
		ToggleGroup tg = new ToggleGroup();
		// Add each button to a toggle group.
		RadioButton rbTrain = createRadioButton("Train", tg, anEvent -> showInTextArea("Radio button: Train\n"));
		RadioButton rbCar = createRadioButton("Car", tg, anEvent -> showInTextArea("Radio button: Car\n"));
		RadioButton rbPlane = createRadioButton("Airplane", tg, anEvent -> showInTextArea("Radio Button: Airplane\n"));
		RadioButton rbBicycle = createRadioButton("Bicycle", tg, anEvent -> showInTextArea("Radio Button: Bicycle\n"));
		RadioButton rbWalking = createRadioButton("Walking", tg, anEvent -> showInTextArea("Radio Button: Walking\n"));
		rbTrain.setSelected(true);  // set button to selected. No ActionEvent is generated
		
		radioButtonsBox.getChildren().addAll(rbTrain, rbCar, rbPlane, rbBicycle, rbWalking);
		return radioButtonsBox;
	}
	
	/**
	 * 
	 */
	private RadioButton createRadioButton(String str, ToggleGroup aGroup,
			                    EventHandler<ActionEvent> aHandler) {
		RadioButton btn = new RadioButton(str);
		btn.setToggleGroup(aGroup);
		btn.setOnAction(aHandler);
		return btn;
	}
	
	/**
	 * @return
	 */
	private ToggleButton createToggleButton(String strOn, String strOff,
											String onImagePath, String offImagePath) {
		ImageView toggleButtonOnImageView = new ImageView(onImagePath);
		ImageView toggleButtonOffImageView = new ImageView(offImagePath);
		ToggleButton btnToggle = new ToggleButton(strOff, toggleButtonOffImageView);
		btnToggle.setContentDisplay(ContentDisplay.RIGHT);
		btnToggle.setOnAction(anEvent -> {

			if(btnToggle.isSelected()) {
				btnToggle.setGraphic(toggleButtonOnImageView);
				btnToggle.setText(strOn);
				btnToggle.setEffect(aDropShadow);
				tfStatus.setText("The ToggleButton is " + strOn);
			} else {
				btnToggle.setGraphic(toggleButtonOffImageView);
				btnToggle.setText(strOff);
				btnToggle.setEffect(null);
				tfStatus.setText("The ToggleButton is " + strOff);
			}
		});
		return btnToggle;
	}

	/**
	 * 
	 */
	private Button createButton(String name, String imagePath, ContentDisplay iconPos,
			                    EventHandler<ActionEvent> aHandler) {
		ImageView helloButtonImageView = new ImageView(imagePath);
		Button btn = new Button(name, helloButtonImageView);
		btn.setContentDisplay(iconPos);
		btn.setOnAction(aHandler);
		return btn;
	}

	/**
	 * 
	 */
	private Slider createSlider() {
		Slider aSlider = new Slider(MIN_FONT_SIZE, MAX_FONT_SIZE, DEFAULT_FONT_SIZE);
//		aSlider.setMin(MIN_FONT_SIZE);
//		aSlider.setMax(MAX_FONT_SIZE);
//		aSlider.setValue(DEFAULT_FONT_SIZE);
		aSlider.setPrefSize(SLIDER_WIDTH, SLIDER_HEIGHT);
//		aSlider.prefWidthProperty().bind(centerNode.widthProperty().subtract(PADDING));
		aSlider.maxWidthProperty().bind(rootNode.widthProperty().subtract(PADDING));
		aSlider.setMajorTickUnit(SLIDER_MAJOR_TICK);
		aSlider.setShowTickMarks(true);
		aSlider.setShowTickLabels(true);
		aSlider.setSnapToTicks(true);
		aSlider.valueProperty().addListener(property ->
											{
												fontSize = aSlider.getValue();
												lblSlider.setFont( new Font(fontSize) );
											}
										   );
		return aSlider;
	}

	/**
	 * 
	 */
	private Label createImageLabel(String content, boolean withImage, String imagePath) {
		Label aLabel;
		if(withImage) {
			ImageView aLabelImageView = new ImageView(imagePath);
			aLabel = new Label(content, aLabelImageView);
		} else {
			aLabel = new Label(content);
		}

		aLabel.setFont(new Font(DEFAULT_FONT_SIZE));
		return aLabel;
	}

	/**
	 * @param primaryStage
	 */
	private BorderPane createTopNode(Stage primaryStage) {
		BorderPane rootNode = new BorderPane();
		rootNode.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));  // top right bottom left
		// set preferred size
		rootNode.prefWidthProperty().bind(primaryStage.widthProperty());
//		topNode.prefHeightProperty().bind(primaryStage.heightProperty());
		return rootNode;
	}

	/**
	 * @param primaryStage
	 */
	private FlowPane createCenterNode(Stage primaryStage, Orientation orient) {
		FlowPane centerNode = new FlowPane(orient, HGAP, VGAP);
		centerNode.setAlignment(Pos.TOP_LEFT);
		centerNode.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));  // top right bottom left
		// set preferred size
		centerNode.prefWidthProperty().bind(primaryStage.widthProperty());
		centerNode.prefHeightProperty().bind(primaryStage.heightProperty());
		return centerNode;
	}

	/**
	 * @param aStr
	 */
	private void showInTextArea(String aStr) {
		String str = aStr + aTextArea.getText();
		aTextArea.setText(str);
		scrollTextArea.setVvalue(scrollTextArea.getVmin());
		scrollTextArea.setHvalue(scrollTextArea.getHmin());
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#stop()
	 * Runs on application thread
	 */
	@Override
	public void stop() throws Exception {
		super.stop();    // this method does nothing
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
	}

	/*
	 * Constructor
	 * Runs on launcher thread
	 */
	public JavaFxDemo() {
	}

	public class StrokedAction implements EventHandler<ActionEvent> {

		/* (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent event) {
			gc.clearRect(0.0, 0.0, CANVAS_WIDTH, CANVAS_HEIGHT);
			drawStrokedElements(gc);
	    	colorIdx++;
	    	if(colorIdx == colors.length) colorIdx= 0;			
		}
		
	}

	public class FilledAction implements EventHandler<ActionEvent> {

		/* (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent event) {
			gc.clearRect(0.0, 0.0, CANVAS_WIDTH, CANVAS_HEIGHT);
			drawFilledElements(gc, fontSize);
        	colorIdx++;
        	if(colorIdx == colors.length) colorIdx= 0;
		}
		
	}

	public class AllCanvasAction implements EventHandler<ActionEvent> {

		/* (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent event) {
			gc.clearRect(0.0, 0.0, CANVAS_WIDTH, CANVAS_HEIGHT);
			drawStrokedElements(gc);
			drawFilledElements(gc, fontSize);
        	colorIdx++;
        	if(colorIdx == colors.length) colorIdx= 0;
		}
		
	}
}
