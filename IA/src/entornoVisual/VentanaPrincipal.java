package entornoVisual;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal {

	private JFrame frame;
	private int DIMENSION= 2;
	JPanel squares[][] = new JPanel[DIMENSION][DIMENSION];
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmCreateBoard = new JMenuItem("Create board");
		mnMenu.add(mntmCreateBoard);
		
		//Inicio de creacion del tablero
		final JInternalFrame internalFrame = new JInternalFrame("Board");
		frame.getContentPane().add(internalFrame, BorderLayout.CENTER);
		internalFrame.setVisible(false);
		internalFrame.getContentPane().setLayout(new GridLayout(DIMENSION, DIMENSION));

		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				squares[i][j] = new JPanel();
				
				squares[i][j].addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent e) {
						JPanel s = (JPanel)e.getComponent();
						s.setBackground(Color.BLUE);
						s.repaint();
					} 
				});
				
				if ((i + j) % 2 == 0) {
					squares[i][j].setBackground(Color.black);
				} else {
					squares[i][j].setBackground(Color.white);
				}   
				internalFrame.getContentPane().add(squares[i][j]);
			}
		}
				
		internalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		internalFrame.setVisible(false);
			
		//Fin de creacion del tablero
		
		mntmCreateBoard.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				internalFrame.setVisible(true);
			}
		});
		
	}

}
