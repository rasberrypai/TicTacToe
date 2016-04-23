import java.awt.Color;
import java.awt.Dimension;
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
	private int dimensions = 333;
	private final int DELAY = 50; // make this higher if you want it to be slower
	private Timer timer;
	public Window(){
        setBackground(Color.black);
        setPreferredSize(new Dimension(dimensions, dimensions));
        timer = new Timer(DELAY, this);
			timer.start();
	}
	private void won(Graphics g){
		
	}
	private void drawAll(Graphics g){
		board(g);
		for(int i = 0; i < Run.tok.size(); i++) {
			Run.tok.get(i).chaR(g);
		}
		won(g);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawAll(g);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	private void board(Graphics g){
		g.setColor(Color.white);
		g.fillRect(111, 8, 5, 320);
		g.fillRect(222, 8, 5, 320);
		g.fillRect(8, 111, 320, 5);
		g.fillRect(8, 222, 320, 5);
	}
}
