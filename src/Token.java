import java.awt.Graphics;

public class Token {
	private int x;
	private int y;
	private int turn = Run.turn;
	public Token(int xx, int yy){
		x = xx;
		y = yy;
	}
	public void chaR(Graphics g){
		if(turn % 2 == 0){
			g.drawOval(x, y, 101, 101);
		} else {
			g.drawLine(x, y, x + 101, y + 101);
			g.drawLine(x + 101, y, x, y + 101);
		}
	}
}
