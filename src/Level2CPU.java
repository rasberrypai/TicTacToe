
public class Level2CPU {
	private int sum;
	private boolean xCanWin;
	private boolean oCanWin;
	private boolean oDidWin;
	private byte[][] tempLoc = Run.input.xoLoc;
	private boolean bBlock = false;
	private boolean bCenter = false;
	private boolean bExcept = false;
	private boolean bCorner = false;
	private boolean other = false;
	private boolean didWork = false;
	public Level2CPU(){
		oWin();
		if(bBlock){
			block();
		}
		if(bCenter){
			center();
		}
		if(bExcept){
			exception();
		}
		if(bCorner){
			corner();
		}
		if(other){
			otherBoxes();
		}
	}
	public void oWin(){
		tempLoc = Run.input.xoLoc;
		check();
		if(oCanWin){
			for(int ii = 0; ii < 3; ii++){
				for(int i = 0; i < 3; i++){
					if(tempLoc[i][ii] == 0){	
						tempLoc[i][ii] = 4;
						check();
						if(oDidWin){
							find(i,ii);
							didWork = true;
						}
						tempLoc[i][ii] = 0;
					}
				}
			}
		}
		if(!didWork){
			bBlock = true;
		}
	}
	public void block(){
		tempLoc = Run.input.xoLoc;
		check();
		if(xCanWin && !oCanWin){			
			for(int ii = 0; ii < 3; ii++){
				for(int i = 0; i < 3; i++){
					if(tempLoc[i][ii] == 0){	
						tempLoc[i][ii] = 4;
						check();
						tempLoc[i][ii] = 0;
						if(!xCanWin){
							find(i,ii);
							didWork = true;
						}
					}
				}
			}
		}
		if(!didWork){
			bCenter = true;
		}
	}
	public void center(){
		tempLoc = Run.input.xoLoc;
		if(tempLoc[1][1] == 0){
			Run.finCpuLoc = 5;
			didWork = true;
		}
		if(!didWork){
			bExcept = true;
		}
	}
	public void exception(){
		tempLoc = Run.input.xoLoc;
		if(tempLoc[0][2] == 1 && tempLoc[1][1] == 4 && tempLoc[0][2] == 1){
			didWork = true;
			other = true;
		}
		if(!didWork){
			bCorner = true;
		}
	}
	public void corner(){
		tempLoc = Run.input.xoLoc;
		//0,0 ; 2,0 ; 0,2 ; 2,2
		if(tempLoc[0][0] == 0){
			Run.finCpuLoc = 1;
			didWork = true;
		} else if(tempLoc[2][0] == 0){
			Run.finCpuLoc = 3;
			didWork = true;
		} else if(tempLoc[0][2] == 0){
			Run.finCpuLoc = 7;
			didWork = true;
		} else if(tempLoc[2][2] == 0){
			Run.finCpuLoc = 9;
			didWork = true;
		}
		if(!didWork){
			other = true;
		}
	}
	public void otherBoxes(){
		tempLoc = Run.input.xoLoc;
		//0,0 ; 2,0 ; 0,2 ; 2,2
		if(tempLoc[1][0] == 0){
			Run.finCpuLoc = 2;
		} else if(tempLoc[0][1] == 0){
			Run.finCpuLoc = 4;
		} else if(tempLoc[2][1] == 0){
			Run.finCpuLoc = 6;
		} else if(tempLoc[1][2] == 0){
			Run.finCpuLoc = 8;
		}
	}
	public void check(){
		xCanWin = false;
		oCanWin = false;
		oDidWin = false;
		for(int ii = 0; ii < 3; ii ++){	
			//checks rows
			for(int i = 0; i < 3; i++){
				sum += tempLoc[i][ii];
			}
			if(sum == 2){
				xCanWin = true;
			} else if(sum == 8){
				oCanWin = true;
			} else if(sum == 12){
				oDidWin = true;
			}
			sum = 0;
			
		} //checks column
		for(int ii = 0; ii < 3; ii ++){	
			for(int i = 0; i < 3; i++){
				sum += tempLoc[ii][i];
			}
			if(sum == 2){
				xCanWin = true;
			} else if(sum == 8){
				oCanWin = true;
			} else if(sum == 12){
				oDidWin = true;
			}
			sum = 0;
		}
		// checks diagonal '\'
		for(int i = 0; i < 3; i++){
			sum += tempLoc[i][i];
		}
		if(sum == 2){
			xCanWin = true;
		} else if(sum == 8){
			oCanWin = true;
		} else if(sum == 12){
			oDidWin = true;
		}
		sum = 0;
		sum += tempLoc[0][2];
		sum += tempLoc[1][1];
		sum += tempLoc[2][0];
		if(sum == 2){
			xCanWin = true;
		} else if(sum == 8){
			oCanWin = true;
		} else if(sum == 12){
			oDidWin = true;
		}
		sum = 0;
	}
	private void find(int i, int ii){
		if(i == 0 && ii == 0){
			Run.finCpuLoc = 1;
			i=3;
			ii=3;
		} else if(i == 1 && ii == 0){
			Run.finCpuLoc = 2;
			i=3;
			ii=3;
		} else if(i == 2 && ii == 0){
			Run.finCpuLoc = 3;
			i=3;
			ii=3;
		} else if(i == 0 && ii == 1){
			Run.finCpuLoc = 4;
			i=3;
			ii=3;
		} else if(i == 1 && ii == 1){
			Run.finCpuLoc = 5;
			i=3;
			ii=3;
		} else if(i == 2 && ii == 1){
			Run.finCpuLoc = 6;
			i=3;
			ii=3;
		} else if(i == 0 && ii == 2){
			Run.finCpuLoc = 7;
			i=3;
			ii=3;
		} else if(i == 1 && ii == 2){
			Run.finCpuLoc = 8;
			i=3;
			ii=3;
		} else if(i == 2 && ii == 2){
			Run.finCpuLoc = 9;
			i=3;
			ii=3;
		}
	}
}
