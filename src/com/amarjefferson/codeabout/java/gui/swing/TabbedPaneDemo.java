package com.amarjefferson.codeabout.java.gui.swing;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;

/**
 * File Name: TabbedPaneDemo.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.swing
 * Class: TabbedPaneDemo
 *
 */
public class TabbedPaneDemo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 400;

	private JPanel plafPanel;
	private JTabbedPane tabbedPane;
	private Action yellowAction;
	private Action blueAction;
	private Action redAction;
	TextField tfStatus;
	
	private java.net.URL imageURL;
	

	/**
	 * @throws HeadlessException
	 */
	public TabbedPaneDemo() {
		super();
		// configure frame with border layout
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setTitle("TabbedPane Demo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		// setup buttonsPanel
		JPanel buttonsPanel = setupLookAndFeelButtonPanel();
		// setup action classes for toolbar buttons
		this.imageURL = getClass().getResource("/icons/yellow-ball.gif");
		this.yellowAction = new ColorAction("Yellow", createImageIcon(imageURL, "yellow"),
				                       Color.YELLOW, this.plafPanel, new Integer(KeyEvent.VK_Y));
		this.imageURL = getClass().getResource("/icons/blue-ball.gif");
		this.blueAction = new ColorAction("Blue", createImageIcon(imageURL, "blue"),
				                     Color.BLUE, this.plafPanel, new Integer(KeyEvent.VK_B));
		this.imageURL = getClass().getResource("/icons/red-ball.gif");
		this.redAction = new ColorAction("Red", createImageIcon(imageURL, "red"),
				                    Color.RED, this.plafPanel, new Integer(KeyEvent.VK_R));
		buttonsPanel.add(this.setupToolbar(), BorderLayout.NORTH);

		// setup TabbedPane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Buttons", buttonsPanel);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.addTab("Check Boxes", setupCheckBoxPanel());
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.addTab("Dropdown", setupComboBox());
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		tabbedPane.addTab("Tree & List", setupList());
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		tabbedPane.addChangeListener(anEvent -> {
	        JTabbedPane tb = (JTabbedPane)anEvent.getSource();
	        int index = tb.getSelectedIndex();
	        tfStatus.setText("Tab changed to: " + tb.getTitleAt(index));
		});

		// setup status TextField
		tfStatus = new TextField();
		tfStatus.setFocusable(false);
		tfStatus.setEditable(false);

		//add panels to frame
		this.setJMenuBar(createMenuBar());
		this.add(this.tabbedPane, BorderLayout.CENTER);
		this.add(tfStatus, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	private JPanel setupList() {
		// Create an array of cities.
		String Cities[] = { "New York", "Chicago", "Houston",
		"Denver", "Los Angeles", "Seattle",
		"London", "Paris", "New Delhi",
		"Hong Kong", "Tokyo", "Sydney" };
		
		JList<String> aList = new JList<String>(Cities);
		aList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		aList.addListSelectionListener(event -> {
			// Get the index of the changed item.
			int idx = aList.getSelectedIndex();
			// Display selection, if item was selected.
			if(idx != -1)
				tfStatus.setText("List selection: " + Cities[idx]);
			else // Otherwise, reprompt.
				tfStatus.setText("Choose a City");
			});

		JScrollPane aScrollPane = new JScrollPane(aList);
		aScrollPane.setPreferredSize(new Dimension(120, 180));

		// create a tree
		// Create rootHome node of tree.
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Cities");
		// Create subtree of cities by continent
		DefaultMutableTreeNode northAmerica = new DefaultMutableTreeNode("North America");
		root.add(northAmerica);
		DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("New York");
		northAmerica.add(a1);
		DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("Chicago");
		northAmerica.add(a2);
		DefaultMutableTreeNode a3 = new DefaultMutableTreeNode("Houston");
		northAmerica.add(a3);
		DefaultMutableTreeNode a4 = new DefaultMutableTreeNode("Denver");
		northAmerica.add(a4);
		DefaultMutableTreeNode a5 = new DefaultMutableTreeNode("Los Angeles");
		northAmerica.add(a5);
		DefaultMutableTreeNode a6 = new DefaultMutableTreeNode("Seattle");
		northAmerica.add(a6);
		DefaultMutableTreeNode europe = new DefaultMutableTreeNode("Europe");
		root.add(europe);
		DefaultMutableTreeNode e1 = new DefaultMutableTreeNode("London");
		europe.add(e1);
		DefaultMutableTreeNode e2 = new DefaultMutableTreeNode("Paris");
		europe.add(e2);
		DefaultMutableTreeNode asia = new DefaultMutableTreeNode("Asia");
		root.add(asia);
		DefaultMutableTreeNode as1 = new DefaultMutableTreeNode("New Delhi");
		asia.add(as1);
		DefaultMutableTreeNode as2 = new DefaultMutableTreeNode("Hong Kong");
		asia.add(as2);
		DefaultMutableTreeNode as3 = new DefaultMutableTreeNode("Tokyo");
		asia.add(as3);
		DefaultMutableTreeNode australia = new DefaultMutableTreeNode("Australia");
		root.add(australia);
		DefaultMutableTreeNode au1 = new DefaultMutableTreeNode("Sydney");
		australia.add(au1);
		// create tree
		JTree citiesTree = new JTree(root);
		citiesTree.addTreeSelectionListener(event -> {
			tfStatus.setText("Tree selection: " + event.getPath());
			aList.setSelectedValue(event.getPath().getLastPathComponent().toString(), true);
		});
		JScrollPane treeScroll = new JScrollPane(citiesTree);

		JPanel aPanel = new JPanel();
		aPanel.setLayout(new BorderLayout());	
		aPanel.setBorder(BorderFactory.createTitledBorder("Cities"));
		aPanel.add(treeScroll, BorderLayout.WEST);
		aPanel.add(aScrollPane, BorderLayout.CENTER);
		return aPanel;
	}

	private JMenuBar createMenuBar() {
		// Create the menu bar.
		JMenuBar jmb = new JMenuBar();
		ImageIcon icon;

		// Create the File menu.
		JMenu jmFile = new JMenu("File");
		this.imageURL = getClass().getResource("/icons/folder-open_16.png");
		icon = new ImageIcon(imageURL);
		JMenuItem jmiOpen = new JMenuItem("Open", icon);
		jmiOpen.addActionListener(event -> tfStatus.setText("Menu item: " + event.getActionCommand()));
		this.imageURL = getClass().getResource("/icons/save_16.png");
		icon = new ImageIcon(imageURL);
		JMenuItem jmiSave = new JMenuItem("Save", icon);
		jmiSave.addActionListener(event -> tfStatus.setText("Menu item: " + event.getActionCommand()));
		this.imageURL = getClass().getResource("/icons/print_16.png");
		icon = new ImageIcon(imageURL);
		JMenuItem jmiPrint = new JMenuItem("Print", icon);
		jmiPrint.addActionListener(event -> tfStatus.setText("Menu item: " + event.getActionCommand()));
		JMenuItem jmiExit = new JMenuItem("Exit");
		jmiExit.addActionListener(event -> System.exit(0));
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		jmFile.addSeparator();
		jmFile.add(jmiPrint);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);

		// Create the Options menu.
		JMenu jmOptions = new JMenu("Options");
		// Create the Colors submenu.
		JMenu jmColors = new JMenu("Colors");
		JRadioButtonMenuItem jmiBlue = new JRadioButtonMenuItem(blueAction);
		JRadioButtonMenuItem jmiRed = new JRadioButtonMenuItem(redAction);
		JRadioButtonMenuItem jmiYellow = new JRadioButtonMenuItem(yellowAction);
		jmColors.add(jmiBlue);
		jmColors.add(jmiRed);
		jmColors.add(jmiYellow);
		jmOptions.add(jmColors);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jmiBlue);
		bg.add(jmiRed);
		bg.add(jmiYellow);
		jmOptions.addSeparator();
		JCheckBoxMenuItem jmiSettings = new JCheckBoxMenuItem("Settings");
		jmiSettings.setSelected(true);
		jmiSettings.addActionListener(event -> tfStatus.setText("Menu item: " + event.getActionCommand()));
		jmOptions.add(jmiSettings);
		jmb.add(jmOptions);
		return jmb;
	}

	private JPanel setupCheckBoxPanel() {
		JPanel aPanel = new JPanel();
		JCheckBox cb1 = new JCheckBox("Red");
		cb1.addItemListener(anEvent -> {
			JCheckBox cb = (JCheckBox)anEvent.getItem();
			if(cb.isSelected())
				tfStatus.setText("You selected " + cb.getText());
			else
				tfStatus.setText("You cleared " + cb.getText());
		});
		aPanel.add(cb1);
		JCheckBox cb2 = new JCheckBox("Green");
		cb2.addItemListener(anEvent -> {
			JCheckBox cb = (JCheckBox)anEvent.getItem();
			if(cb.isSelected())
				tfStatus.setText("You selected " + cb.getText());
			else
				tfStatus.setText("You cleared " + cb.getText());
		});
		aPanel.add(cb2);
		JCheckBox cb3 = new JCheckBox("Blue");
		cb3.addItemListener(anEvent -> {
			JCheckBox cb = (JCheckBox)anEvent.getItem();
			if(cb.isSelected())
				tfStatus.setText("You selected " + cb.getText());
			else
				tfStatus.setText("You cleared " + cb.getText());
		});
		aPanel.add(cb3);

		aPanel.setBorder(BorderFactory.createTitledBorder("Colors"));
		return aPanel;
	}

	private JPanel setupComboBox() {
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("Vanilla");
		jcb.addItem("Chocolate");
		jcb.addItem("Strawberry");
		jcb.addActionListener(anEvent-> tfStatus.setText("You selected " + (String)jcb.getSelectedItem()));

		JPanel aPanel = new JPanel();
		aPanel.add(jcb);
		aPanel.setBorder(BorderFactory.createTitledBorder("Flavors"));
		return aPanel;
	}

	private JToolBar setupToolbar () {
		// configure tool bar
		JToolBar toolbar = new JToolBar();
		toolbar.setLayout(new FlowLayout());
		toolbar.setBackground(new Color(255, 255, 240));		
		toolbar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		// add toolbar buttons
		JButton aBtn = new JButton(yellowAction);
		aBtn.setFocusable(false);
		toolbar.add(aBtn);

		toolbar.addSeparator();
		aBtn = new JButton(blueAction);
		aBtn.setFocusable(false);
		toolbar.add(aBtn);

		toolbar.addSeparator();
		aBtn = new JButton(redAction);
		aBtn.setFocusable(false);
		toolbar.add(aBtn);

		toolbar.addSeparator();
		this.imageURL = getClass().getResource("/icons/delete_16.png");
		ImageIcon iconOff = new ImageIcon(imageURL);
		JToggleButton tBtn = new JToggleButton("Off", iconOff);
		tBtn.setFocusable(false);
		tBtn.addItemListener(event -> {
			if(tBtn.isSelected()) {
				this.imageURL = getClass().getResource("/icons/add_16.png");
				ImageIcon icon = new ImageIcon(imageURL);
				tBtn.setIcon(icon);
				tBtn.setText("On");
				tfStatus.setText("Button is on.");
			} else {
				this.imageURL = getClass().getResource("/icons/delete_16.png");
				ImageIcon icon = new ImageIcon(imageURL);
				tBtn.setIcon(icon);
				tBtn.setText("Off");
				tfStatus.setText("Button is off.");
			}
		});
		toolbar.add(tBtn);
		
		return toolbar;
	}

	private JPanel setupLookAndFeelButtonPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		// configure UI buttons panel for center of layout
		plafPanel = new JPanel();
		plafPanel.setLayout(new GridLayout(4, 4));
		plafPanel.setBackground(new Color(240, 240, 240));
		// add buttons for UI look and feel
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : infos)
			makeButton(info.getName(), info.getClassName(), plafPanel);

		mainPanel.add(plafPanel,BorderLayout.CENTER);
		return mainPanel;
	}

	/**
	 * Makes a button to change the pluggable look-and-feel.
	 * @param name the button name
	 * @param className the name of the look-and-feel class
	 */
	private void makeButton(String name, String className, JPanel aPanel)
	{
		// add button to panel
		JButton button = new JButton(name);
		aPanel.add(button);

		// set button action
		button.addActionListener(event -> {
			// button action: switch to the new look-and-feel
			try
			{
				UIManager.setLookAndFeel(className);
				SwingUtilities.updateComponentTreeUI(this);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		});
	}

	// define Action class for toolbar buttons
	public class ColorAction extends AbstractAction
	{
		private static final long serialVersionUID = 1L;

		/**
		 * Constructs a color action.
		 * @param name the name to show on the button
		 * @param icon the icon to display on the button
		 * @param c the background color
		 */
		public ColorAction(String name, Icon icon, Color c, JPanel target, Integer mnemonic)
		{
			super(name, icon);
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
			putValue("color", c);
			putValue("target", target);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(mnemonic, InputEvent.CTRL_DOWN_MASK));
		}

		public void actionPerformed(ActionEvent event)
		{
			Color c = (Color) getValue("color");
			JPanel aPanel = (JPanel)getValue("target");
			aPanel.setBackground(c);
		}
	}

	// Create an ImageIcon from the path of an image file
	public ImageIcon createImageIcon(java.net.URL imgURL, String description) {
	//	java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
	            return new ImageIcon(imgURL, description);
			}
			else {            
			    return null;
			}
	}
	
/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new TabbedPaneDemo());
	}

}
