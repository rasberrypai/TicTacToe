
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


public class Run extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Window win = new Window();
	public static int turn = 1;
	public static int location = 0;
	public static ArrayList<Token> tok = new ArrayList<Token>();
	public static KeyInputHandler input = new KeyInputHandler();
	public Run() {
        add(win);
        addMouseListener(input);
        
        setResizable(false);
        pack();
        
        setTitle("Tic-Tac-Toe");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new Run();
                ex.setVisible(true); 
            }
        });
    }
}

