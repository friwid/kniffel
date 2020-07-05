package kniffelFrieder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

public class KniffelWindowALT extends JFrame {
	
	private JMenuItem menuNew, menuExit;	
	private JButton newGame;
	private JButton exit;
	
	private JTable kniffelTable;
    private JTextField rowField, columnField, valueField;
/*
	private JTextArea textArea;
	JRadioButton radioButtonOption1;
	JRadioButton radioButtonOption2;
	
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 1000;

	private static final int ROWS = 5;
	private static final int COLUMNS = 30;
*/	
   
	KniffelWindowALT() {
		
		super("Kniffel");
	//	setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		JMenu fileMenu = new JMenu("Datei");
		menuNew = new JMenuItem("Neues Spiel");
		fileMenu.add(menuNew);
		fileMenu.addSeparator();
		menuExit = new JMenuItem("Beenden");
		fileMenu.add(menuExit);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		
		setJMenuBar(menuBar);
		
		setLayout(new BorderLayout());
		
		TableModel kniffelData = new KniffelTableControllerALT(kniffelData);
		kniffelTable = new JTable(kniffelData);
		kniffelTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		add( new JScrollPane( kniffelTable ), BorderLayout.CENTER );
		
		
		JPanel left = new JPanel();
		left.setLayout( new FlowLayout() );
		
		JPanel kniffelTable = new JPanel();
		kniffelTable.setLayout( new FlowLayout() );
		left.add( kniffelTable );
		
		add( left, BorderLayout.WEST );
/*	
		textArea = new JTextArea(ROWS, COLUMNS);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
*/		
		JPanel southMenu = new JPanel();
		southMenu.setLayout(new BorderLayout());
		
		JLabel optionLabel = new JLabel("testtest", JLabel.CENTER);
		southMenu.add(optionLabel, BorderLayout.NORTH);
		
		JPanel options = new JPanel();
		options.setLayout(new FlowLayout());
/*	
		ButtonGroup radioButtonsTest = new ButtonGroup();
		radioButtonOption1 = new JRadioButton("RadioButton1", true);
		radioButtonsTest.add(radioButtonOption1);
		saveOptions.add(radioButtonOption1);
		radioButtonOption2 = new JRadioButton("RadioButton2");
		radioButtonsTest.add(radioButtonOption2);
		saveOptions.add(radioButtonOption2);
*/
	
		
		southMenu.add(options, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		newGame = new JButton("Neues Spiel");
		buttons.add(newGame);
		
		exit = new JButton("Beenden");
		buttons.add(exit);
		
		southMenu.add(buttons, BorderLayout.SOUTH);
		add(southMenu, BorderLayout.SOUTH);
		
		
		pack();	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		/*
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				
				}
			}
		);
		*/
	}
	
	public JMenuItem getMenuNew() {
		return menuNew;
	}
	
	public JMenuItem getMenuExit() {
		return menuExit;
	}
	
	public JButton getNewGameButton() {
		return newGame;
	}
	
	public JButton getExitButton() {
		return exit;
	}
	
	public JTable getKniffelTable() {
		return kniffelTable;
	}
/*	
	public JRadioButton getRadioButtonOption1() {
		return radioButtonOption1;
	}
	
	public JRadioButton getRadioButtonOption2() {
		return radioButtonOption2;
	}
*/
	public static void main(String[] args) {
		KniffelWindowALT window = new KniffelWindowALT();
		new KniffelControllerALT(window);
		window.setVisible(true);

	}

}
