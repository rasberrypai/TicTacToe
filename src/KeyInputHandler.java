import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class KeyInputHandler extends MouseAdapter {
	private int mouseX;
	private int mouseY;
	/*public boolean one = false;
	public boolean two = false;
	public boolean three = false;
	public boolean four = false;
	public boolean five = false;
	public boolean six = false;
	public boolean seven = false;
	public boolean eight = false;
	public boolean nine = false; */
	public byte[][] xoLoc = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
	
	public void mouseClicked(MouseEvent e){
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseX = e.getX();
			mouseY = e.getY();
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 0 && mouseY <= 110){
				if(xoLoc[0][0] == 0){
					Run.tok.add(new Token(5, 5, 0, 0));
					Run.turn++;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 0 && mouseY <= 110){
				if(xoLoc[1][0] == 0){
					Run.tok.add(new Token(116, 5, 1, 0));
					Run.turn++;
					
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 0 && mouseY <= 110){
				if(xoLoc[2][0] == 0){
					Run.tok.add(new Token(227, 5, 2, 0));
					Run.turn++;
				}
			}
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 112 && mouseY <= 221){
				if(xoLoc[0][1] == 0){
					Run.tok.add(new Token(5, 116, 0, 1));
					Run.turn++;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 112 && mouseY <= 221){
				if(xoLoc[1][1] == 0){
					Run.tok.add(new Token(116, 116, 1, 1));
					Run.turn++;
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 112 && mouseY <= 221){
				if(xoLoc[2][1] == 0){
					Run.tok.add(new Token(227, 116, 2, 1));
					Run.turn++;
				}
			}
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 223 && mouseY <= 333){
				if(xoLoc[0][2] == 0){
					Run.tok.add(new Token(5, 227, 0 , 2));
					Run.turn++;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 223 && mouseY <= 333){
				if(xoLoc[1][2] == 0){
					Run.tok.add(new Token(116, 227, 1, 2));
					Run.turn++;
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 223 && mouseY <= 333){
				if(xoLoc[2][2] == 0){
					Run.tok.add(new Token(227, 227, 2, 2));
					Run.turn++;
				}
			}
		}
	}
}