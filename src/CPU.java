
public class CPU {
	private int sum;
	private boolean xDidWin;
	private boolean oDidWin;
	private byte[][] tempLoc = Run.input.xoLoc;
	private int constant = -999999;
	private int[][] tempPerc = {{constant, constant, constant}, {constant, constant, constant}, {constant, constant, constant}};
	private int points;
	private int turn = 1;
	private int choice = -999998;
	public CPU(){
		chooseHigh();
	}
	private void chooseHigh(){
		calc();
		for( int ii = 0; ii < 3; ii++){
			for(int i = 0; i < 3; i++){
				if(choice < tempPerc[i][ii]){
					choice = tempPerc[i][ii];
				}
				System.out.println(tempPerc[i][ii]);
			}
		}
		System.out.println("");
		for( int ii = 0; ii < 3; ii++){
			for(int i = 0; i < 3; i++){
				if(tempLoc[i][ii] == 0){
					if(choice == tempPerc[i][ii]){
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
			}
		}
		//System.out.println(Run.finCpuLoc);
	}
	public void calc(){
			for(int ii = 0; ii < 3; ii++){
				for( int i = 0; i < 3; i++){
					if(tempLoc[i][ii] == 0){
						tempLoc[i][ii] = (byte)turn;
						canWin();
						if(turn == 4){
							turn=1;
						} else if(turn == 1){
							turn=4;
						}
						for(int dii = 0; dii < 3; dii++){
							for( int di = 0; di < 3; di++){
								if(tempLoc[di][dii] == 0){
									tempLoc[di][dii] = (byte)turn;
									canWin();
									if(turn == 4){
										turn=1;
									} else if(turn == 1){
										turn=4;
									}
									for(int tii = 0; tii < 3; tii++){
										for( int ti = 0; ti < 3; ti++){
											if(tempLoc[ti][tii] == 0){
												tempLoc[ti][tii] = (byte)turn;
												canWin();
												if(turn == 4){
													turn=1;
												} else if(turn == 1){
													turn=4;
												}
												for(int fii = 0; fii < 3; fii++){
													for( int fi = 0; fi < 3; fi++){
														if(tempLoc[fi][fii] == 0){
															tempLoc[fi][fii] = (byte)turn;
															canWin();
															if(turn == 4){
																turn=1;
															} else if(turn == 1){
																turn=4;
															}
															for(int vii = 0; vii < 3; vii++){
																for( int vi = 0; vi < 3; vi++){
																	if(tempLoc[vi][vii] == 0){
																		tempLoc[vi][vii] = (byte)turn;
																		canWin();
																		if(turn == 4){
																			turn=1;
																		} else if(turn == 1){
																			turn=4;
																		}
																		for(int xii = 0; xii < 3; xii++){
																			for( int xi = 0; xi < 3; xi++){
																				if(tempLoc[xi][xii] == 0){
																					tempLoc[xi][xii] = (byte)turn;
																					canWin();
																					if(turn == 4){
																						turn=1;
																					} else if(turn == 1){
																						turn=4;
																					}
																					for(int sii = 0; sii < 3; sii++){
																						for( int si = 0; si < 3; si++){
																							if(tempLoc[si][sii] == 0){
																								tempLoc[si][sii] = (byte)turn;
																								canWin();
																								if(turn == 4){
																									turn=1;
																								} else if(turn == 1){
																									turn=4;
																								}
																								for(int eii = 0; eii < 3; eii++){
																									for( int ei = 0; ei < 3; ei++){
																										if(tempLoc[ei][eii] == 0){
																											tempLoc[ei][eii] = (byte)turn;
																											canWin();
																											if(turn == 4){
																												turn=1;
																											} else if(turn == 1){
																												turn=4;
																											}
																											tempLoc[ei][eii] = 0;
																										}
																									}
																								}
																								tempLoc[si][sii] = 0;
																							}
																						}
																					}
																					tempLoc[xi][xii] = 0;
																				}
																			}
																		}
																		tempLoc[vi][vii] = 0;
																	}
																}
															}
															tempLoc[fi][fii] = 0;
														}
													}
												}
												tempLoc[ti][tii] = 0;
											}
										}
									}
									tempLoc[di][dii] = 0;
								}
							}
						}
						tempPerc[i][ii] = points;
						points = 0;
						tempLoc[i][ii] = 0;
					}
					
				}
			}
	}
	public void canWin(){
		cpuAdd();
		if(xDidWin){
			points-=20;
		} else if(oDidWin){
			points+=10;
		}
	}
	private void cpuAdd(){
		xDidWin = false;
		oDidWin = false;
		for(int ii = 0; ii < 3; ii ++){	
			//checks rows
			for(int i = 0; i < 3; i++){
				sum += tempLoc[i][ii];
			}
			if(sum == 3){
				xDidWin = true;
				oDidWin = false;
			} else if(sum == 12){
				oDidWin = true;
				xDidWin = false;
			}
			sum = 0;
			//checks column
			for(int i = 0; i < 3; i++){
				sum += tempLoc[ii][i];
			}
			if(sum == 3){
				xDidWin = true;
				oDidWin = false;
			} else if(sum == 12){
				oDidWin = true;
				xDidWin = false;
			}
			sum = 0;
		}
		// checks diagonal '\'
		for(int i = 0; i < 3; i++){
			sum += tempLoc[i][i];
		}
		if(sum == 3){
			xDidWin = true;
			oDidWin = false;
		} else if(sum == 12){
			oDidWin = true;
			xDidWin = false;
		}
		sum = 0;
		sum += tempLoc[0][2];
		sum += tempLoc[1][1];
		sum += tempLoc[2][0];
		if(sum == 3){
			xDidWin = true;
			oDidWin = false;
		} else if(sum == 12){
			oDidWin = true;
			xDidWin = false;
		}
		sum = 0;
	} 
}
