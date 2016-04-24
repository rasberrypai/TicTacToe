import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x = 5;
	private int y = 5;
	private boolean xDidWin = false;
	private boolean oDidWin = false;
	private int sum = 0;
	private int dimensions = 333;
	private final int DELAY = 50; // make this higher if you want it to be slower
	private Timer timer;
	public Window(){
        setBackground(Color.black);
        setPreferredSize(new Dimension(dimensions, dimensions));
        timer = new Timer(DELAY, this);
			timer.start();
	}
	private void choices(Graphics g){
		g.setColor(Color.white);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30)); 
		g.drawString("Two Players", 75, 100);
		g.drawLine(0, 166, 333, 166);
		g.drawLine(0, 167, 333, 167);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30)); 
		g.drawString("Computer", 90, 250);
	}		
	private void add(){
		for(int ii = 0; ii < 3; ii ++){	
			//checks rows
			for(int i = 0; i < 3; i++){
				sum += Run.input.xoLoc[i][ii];
			}
			if(sum == 3){
				xDidWin = true;
			} else if(sum == 12){
				oDidWin = true;
			}
			sum = 0;
			//checks column
			for(int i = 0; i < 3; i++){
				sum += Run.input.xoLoc[ii][i];
			}
			if(sum == 3){
				xDidWin = true;
			} else if(sum == 12){
				oDidWin = true;
			}
			sum = 0;
		}
		// checks diagonals
		for(int i = 0; i < 3; i++){
			sum += Run.input.xoLoc[i][i];
		}
		if(sum == 3){
			xDidWin = true;
		} else if(sum == 12){
			oDidWin = true;
		}
		sum = 0;
		sum += Run.input.xoLoc[0][2];
		sum += Run.input.xoLoc[1][1];
		sum += Run.input.xoLoc[2][0];
		if(sum == 3){
			xDidWin = true;
		} else if(sum == 12){
			oDidWin = true;
		}
		sum = 0;
	}
	private void won(Graphics g){
		if(xDidWin){
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30)); 
			g.drawString("Player One Won", 50, 150);
		} else if(oDidWin){
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30)); 
			g.drawString("Player Two Won", 50, 150);
		}
	}
	private void drawAll(Graphics g){
		g.setColor(Color.white);	
		if(oDidWin || xDidWin){
			won(g);
		} else {
			board(g);
			for(int i = 0; i < Run.tok.size(); i++) {
				Run.tok.get(i).chaR(g);
			}
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(Run.mode == null){
			choices(g);
		} else {
			drawAll(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		add();
		repaint();
	}
	private void board(Graphics g){
		
		g.fillRect(111, 8, 5, 320);
		g.fillRect(222, 8, 5, 320);
		g.fillRect(8, 111, 320, 5);
		g.fillRect(8, 222, 320, 5);
	}
}
