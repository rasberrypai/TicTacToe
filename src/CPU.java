
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
			for(int i = 0; i < 3; i++){
				if(choice < tempPerc[i][ii]){
					choice = tempPerc[i][ii];
					Run.finCpuLoc = (i+1)*(ii+1);
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
															for(int fiveii = 0; fiveii < 3; fiveii++){
																for( int fivei = 0; fivei < 3; fivei++){
																	if(tempLoc[fivei][fiveii] == 0){
																		tempLoc[fivei][fiveii] = (byte)turn;
																		canWin();
																		if(turn == 4){
																			turn=1;
																		} else if(turn == 1){
																			turn=4;
																		}
																		for(int sxii = 0; sxii < 3; sxii++){
																			for( int sxi = 0; sxi < 3; sxi++){
																				if(tempLoc[sxi][sxii] == 0){
																					tempLoc[sxi][sxii] = (byte)turn;
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
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
						System.out.println(i);
						System.out.println(ii);
						System.out.println(turn);
						System.out.println(points);
						tempPerc[i][ii] = (byte) points;
						points = 0;
					}
					
				}
			}
	}
	public void canWin(){
		cpuAdd();
		if(xDidWin && turn == 2){
			points-=10;
		} else if(oDidWin && turn == 1){
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
