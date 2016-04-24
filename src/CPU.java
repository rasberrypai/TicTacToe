
public class CPU {
	private int sum;
	private boolean xDidWin;
	private boolean oDidWin;
	private byte[][] tempLoc = Run.input.xoLoc;
	private byte[][] tempPerc = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
	private int points;
	private int turn = 1;
	private int choice;
	public CPU(){
		calc();
		chooseHigh();
	}
	private void chooseHigh(){
		for( int ii = 0; ii < 3; ii++){
			for(int i = 0; i < 3; ii++){
				if(choice < tempPerc[i][ii]){
					choice = tempPerc[i][ii];
					Run.finCpuLoc = (i+1)*(i+1);
				}
			}
		}
	}
	public void calc(){
		for(int ii = 0; ii < 3; ii++){
			for( int i = 0; i < 3; i++){
				if(tempLoc[i][ii] == 0){
					tempLoc[i][ii] = (byte)turn;
					canWin();
					if(turn == 1){
						turn++;
					} else if(turn == 2){
						turn--;
					}
					tempPerc[i][ii] = (byte) points;
				}
				
			}
		}
	}
	public void canWin(){
		cpuAdd();
		if(xDidWin && turn == 1){
			points-=10;
		} else if(oDidWin && turn == 2){
			points+=10;
		}
	}
	private void cpuAdd(){
		for(int ii = 0; ii < 3; ii ++){	
			//checks rows
			for(int i = 0; i < 3; i++){
				sum += tempLoc[i][ii];
			}
			if(sum == 3){
				xDidWin = true;
			} else if(sum == 12){
				oDidWin = true;
			}
			sum = 0;
			//checks column
			for(int i = 0; i < 3; i++){
				sum += tempLoc[ii][i];
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
			sum += tempLoc[i][i];
		}
		if(sum == 3){
			xDidWin = true;
		} else if(sum == 12){
			oDidWin = true;
		}
		sum = 0;
	}
}
