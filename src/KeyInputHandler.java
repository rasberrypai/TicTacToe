import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

public class KeyInputHandler extends MouseAdapter {
	private int mouseX;
	private int mouseY;
	private int k;
	public byte[][] xoLoc = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
	
	public void mouseClicked(MouseEvent e){
		k = e.getButton();
		if (k == MouseEvent.BUTTON1 && Run.mode == null || e.getButton() == MouseEvent.BUTTON1 && Run.mode == "players" || e.getButton() == MouseEvent.BUTTON1 && Run.mode == "cpu" && Run.turn % 2 != 0) {
			mouseX = e.getX();
			mouseY = e.getY();
			if(Run.mode == null){
				if(mouseY >= 0 && mouseY <= 165){
					Run.mode = "players";
				} else if(mouseY >= 167 && mouseY <= 333){
					Run.mode = "cpu";
				}
			} else {
				check();
			}
		} else if (Run.mode == "cpu" && Run.turn % 2 == 0){
			mouseX = 334;
			mouseY = 334;
			new Level2CPU();
			check();
		}
	}
	public void check(){
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 0 && mouseY <= 110 || Run.finCpuLoc == 1  && Run.turn % 2 == 0){
				if(xoLoc[0][0] == 0){
					Run.tok.add(new Token(5, 5, 0, 0));
					Run.turn++;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 0 && mouseY <= 110 || Run.finCpuLoc == 2 && Run.turn % 2 == 0){
				if(xoLoc[1][0] == 0){
					Run.tok.add(new Token(116, 5, 1, 0));
					Run.turn++;	
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 0 && mouseY <= 110 || Run.finCpuLoc == 3 && Run.turn % 2 == 0){
				if(xoLoc[2][0] == 0){
					Run.tok.add(new Token(227, 5, 2, 0));
					Run.turn++;
				}
			}
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 112 && mouseY <= 221 || Run.finCpuLoc == 4 && Run.turn % 2 == 0){
				if(xoLoc[0][1] == 0){
					Run.tok.add(new Token(5, 116, 0, 1));
					Run.turn++;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 112 && mouseY <= 221 || Run.finCpuLoc == 5 && Run.turn % 2 == 0){
				if(xoLoc[1][1] == 0){
					Run.tok.add(new Token(116, 116, 1, 1));
					Run.turn++;
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 112 && mouseY <= 221 || Run.finCpuLoc == 6 && Run.turn % 2 == 0){
				if(xoLoc[2][1] == 0){
					Run.tok.add(new Token(227, 116, 2, 1));
					Run.turn++;
				}
			}
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 223 && mouseY <= 333 || Run.finCpuLoc == 7 && Run.turn % 2 == 0){
				if(xoLoc[0][2] == 0){
					Run.tok.add(new Token(5, 227, 0 , 2));
					Run.turn++;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 223 && mouseY <= 333 || Run.finCpuLoc == 8 && Run.turn % 2 == 0){
				if(xoLoc[1][2] == 0){
					Run.tok.add(new Token(116, 227, 1, 2));
					Run.turn++;
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 223 && mouseY <= 333 || Run.finCpuLoc == 9 && Run.turn % 2 == 0){
				if(xoLoc[2][2] == 0){
					Run.tok.add(new Token(227, 227, 2, 2));	
					Run.turn++;
				}
			}
	}
}