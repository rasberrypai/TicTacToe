import java.awt.Graphics;
import java.util.Random;

public class Token {
	private int x;
	private int y;
	private int ary;
	private int ary2;
	private int turn = Run.turn;
	public Token(int xx, int yy, int arry1, int arry2){
		x = xx;
		y = yy;
		ary = arry1;
		ary2 = arry2;
	}
	public void chaR(Graphics g){
			if(turn % 2 == 0){
				g.drawOval(x, y, 101, 101);
				Run.input.xoLoc[ary][ary2] = 4;
			} else {
				g.drawLine(x, y, x + 101, y + 101);
				g.drawLine(x + 101, y, x, y + 101);
				Run.input.xoLoc[ary][ary2] = 1;
			}
	}
}
