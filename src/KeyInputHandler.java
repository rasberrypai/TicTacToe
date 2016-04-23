import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeyInputHandler extends MouseAdapter {
	private int mouseX;
	private int mouseY;
	public boolean one = false;
	public boolean two = false;
	public boolean three = false;
	public boolean four = false;
	public boolean five = false;
	public boolean six = false;
	public boolean seven = false;
	public boolean eight = false;
	public boolean nine = false;
	public void mouseClicked(MouseEvent e){
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseX = e.getX();
			mouseY = e.getY();
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 0 && mouseY <= 110){
				if(one){
					
				} else {
					Run.tok.add(new Token(5, 5));
					Run.turn++;
					one = true;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 0 && mouseY <= 110){
				if(two){
									
				} else {
					Run.tok.add(new Token(116, 5));
					Run.turn++;
					two = true;
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 0 && mouseY <= 110){
				if(three){
					
				} else {
					Run.tok.add(new Token(227, 5));
					Run.turn++;
					three = true;
				}
			}
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 112 && mouseY <= 221){
				if(four){
					
				} else {
					Run.tok.add(new Token(5, 116));
					Run.turn++;
					four = true;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 112 && mouseY <= 221){
				if(five){
					
				} else {
					Run.tok.add(new Token(116, 116));
					Run.turn++;
					five = true;
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 112 && mouseY <= 221){
				if(six){
					
				} else {
					Run.tok.add(new Token(227, 116));
					Run.turn++;
					six = true;
				}
			}
			if(mouseX >= 0 && mouseX <= 110 && mouseY >= 223 && mouseY <= 333){
				if(seven){
					
				} else {
					Run.tok.add(new Token(5, 227));
					Run.turn++;
					seven = true;
				}
			}
			if(mouseX >= 112 && mouseX <= 221 && mouseY >= 223 && mouseY <= 333){
				if(eight){
					
				} else {
					Run.tok.add(new Token(116, 227));
					Run.turn++;
					eight = true;
				}
			}
			if(mouseX >= 223 && mouseX <= 332 && mouseY >= 223 && mouseY <= 333){
				if(nine){
					
				} else {
					Run.tok.add(new Token(227, 227));
					Run.turn++;
					nine = true;
				}
			}
		}
	}
}