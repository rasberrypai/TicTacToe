
public class CPU {
	private int finLoc = Run.finCpuLoc;
	private int sum;
	private boolean xDidWin;
	private boolean oDidWin;
	private byte[][] tempLoc = Run.input.xoLoc;
	private byte[][] tempPerc;
	private int points;
	private int turn = 1;
	public CPU(){
		
	}
	private void chooseHigh(){
		for( int i = 0; i < tempPerc.length; i++){
			
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
				}
				tempPerc[i][ii] = (byte) points;
			}
		}
	}
	public void canWin(){
		cpuAdd();
		if(xDidWin){
			points-=10;
		} else if(oDidWin){
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
