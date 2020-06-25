package kniffelFrieder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

 
public class KniffelController extends WindowAdapter implements ActionListener, KeyListener, WindowListener {
	
	private JMenuItem menuNew, menuExit;
	private JButton newGame;
	private JButton exit;
	private boolean gameOngoing = false;
		
/*
	JRadioButton radioButtonOption1;
	JRadioButton radioButtonOption2;
*/	
	private KniffelWindow window;
	
	public KniffelController(KniffelWindow window) {
		this.window = window;
		
		menuNew = window.getMenuNew();
		menuNew.addActionListener(this);
		
		menuExit = window.getMenuExit();
		menuExit.addActionListener(this);
		
		newGame = window.getNewGameButton();
		newGame.addActionListener(this);
		
		exit = window.getExitButton();
		exit.addActionListener(this);
/*			
		radioButtonOption1 = window.getRadioButtonOption1();
		radioButtonOption1.addActionListener(this);
		
		radioButtonOption2 = window.getRadioButtonOption2();
		radioButtonOption2.addActionListener(this);
*/		
		
		window.addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			gameOngoing = false;
			System.out.println("gameOngoing = false");
		} else if  (e.getSource() == exit || e.getSource() == menuExit) {
			closeDialog();
		}		
	}
	
	public void closeDialog() {
		if (!gameOngoing) {
			System.out.println("No ongoing game, exiting...");
			System.exit(0);
		} else {
			int result = JOptionPane.showOptionDialog(
					window, 
					"Das Spiel ist noch im Gange. Dennoch beenden?", 
					"Programm beenden", 
					JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					new String[] { "Beenden", "Abbrechen" }, 
					JOptionPane.NO_OPTION
			);
			switch (result) {
			case 0:
				System.exit(0);
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		gameOngoing = true;
		System.out.println("keyPressed: gameOngoing = true");
	}
	
	@Override
	public void keyReleased(KeyEvent e) { }
	
	@Override
	public void keyTyped(KeyEvent e) { }
	
	@Override
	public void windowClosing(WindowEvent e) {
		closeDialog();
	}
	/*
	@Override
	public void windowOpened(WindowEvent e) { }
	
	@Override
	public void windowClosed(WindowEvent e) { }
	
	@Override
	public void windowIconified(WindowEvent e) { }
	
	@Override
	public void windowDeiconified(WindowEvent e) { }
	
	@Override
	public void windowActivated(WindowEvent e) { }
	
	@Override
	public void windowDeactivated(WindowEvent e) { }
*/
}
