import java.io.*;
import java.util.*;

public class r3 {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA31.txt"));
			for (int i = 0; i < 5; i++) {// change to 5
				String lineOne = in.nextLine();
				String[] clues = new String[lineOne.length()];
				int[][] mines = new int[lineOne.length()][lineOne.length()];
				int numClues = 0;
				clues[0] = lineOne;
				numClues += (lineOne.replace("-", "").length());
				//System.out.println(numClues);
				for (int n = 1; n < lineOne.length(); n++) {
					clues[n] = in.nextLine();
					numClues += (clues[n].replace("-", "").length());
					//System.out.println(numClues);
					
				}
				//System.out.println(numClues);
				while (numClues > 0) {
					
					for (int r = 0; r < lineOne.length(); r++) {
						
						for (int c = 0; c < lineOne.length(); c++) {
							int test = numClues;
							int clue = 0;
							//System.out.println(clues[r].charAt(c));
							if ((int)clues[r].charAt(c) != (int)'-') {

								clue = Integer.parseInt(Character
										.toString(clues[r].charAt(c)));
								int numMines = 0;
								int numOpen = 0;
								int[] area = new int[9];
								Arrays.fill(area, -1);
								if (r != 0 && c != 0)
									area[0] = mines[r - 1][c - 1];
								if (r != 0)
									area[1] = mines[r - 1][c];
								if (r != 0 && c != lineOne.length() - 1)
									area[2] = mines[r - 1][c + 1];
								if (c != 0)
									area[3] = mines[r][c - 1];
								area[4] = mines[r][c];
								if (c != lineOne.length() - 1)
									area[5] = mines[r][c + 1];
								if (r != lineOne.length() - 1 && c != 0)
									area[6] = mines[r + 1][c - 1];
								if (r != lineOne.length() - 1)
									area[7] = mines[r + 1][c];
								if (r != lineOne.length() - 1
										&& c != lineOne.length() - 1)
									area[8] = mines[r + 1][c + 1];
								for (int y = 0; y < 9; y++) {
									if (area[y] == 1)
										numMines++;
									else if (area[y] == 0) 
										numOpen++;
								}
								
								if (clue == numMines) {
									if (numOpen > 0) {
										for (int y = 0; y < 9; y++) {
											if (area[y] == 0) {
												switch (y) {
												case 0:
													mines[r - 1][c - 1] = 2;
													break;
												case 1:
													mines[r - 1][c] = 2;
													break;
												case 2:
													mines[r - 1][c + 1] = 2;
													break;
												case 3:
													mines[r][c - 1] = 2;
													break;
												case 4:
													mines[r][c] = 2;
													break;
												case 5:
													mines[r][c + 1] = 2;
													break;
												case 6:
													mines[r + 1][c - 1] = 2;
													break;
												case 7:
													mines[r + 1][c] = 2;
													break;
												case 8:
													mines[r + 1][c + 1] = 2;
													break;
												}
											}
										}
										
									}
									clues[r] = clues[r].substring(0, c) + '-'
											+ clues[r].substring(c + 1);
									numClues--;
									//System.out.println(clue + ": " +numClues);
								} 
								else if (numOpen == clue - numMines) {
									for (int y = 0; y < 9; y++) {
										if (area[y] == 0) {
											switch (y) {
											case 0:
												mines[r - 1][c - 1] = 1;
												break;
											case 1:
												mines[r - 1][c] = 1;
												break;
											case 2:
												mines[r - 1][c + 1] = 1;
												break;
											case 3:
												mines[r][c - 1] = 1;
												break;
											case 4:
												mines[r][c] = 1;
												break;
											case 5:
												mines[r][c + 1] = 1;
												break;
											case 6:
												mines[r + 1][c - 1] = 1;
												break;
											case 7:
												mines[r + 1][c] = 1;
												break;
											case 8:
												mines[r + 1][c + 1] = 1;
												break;
											}
										
										}
									}
									clues[r] = clues[r].substring(0, c)
												+ '-'
												+ clues[r].substring(c + 1);
										numClues--;	
										//System.out.println(clue + ": " +numClues);
								}
							}
						
						/*
							if (test != numClues) {
								System.out.println(clue);
						for (int y = 0; y < lineOne.length(); y++) {
							for (int p = 0; p < lineOne.length(); p++) {
								if (mines[y][p] ==1)
								System.out.print('M');
								else if (mines[y][p] ==2)
									System.out.print('S');	
								else
									System.out.print('-');
							}
							System.out.println(numClues);
						}
							}
						*/
						}
					}
				}
				for (int r = 0; r < lineOne.length(); r++) {
					for (int c = 0; c < lineOne.length(); c++) {
						if (mines[r][c] ==1)
						System.out.print('M');
						else
							System.out.print('.');	
					}
					System.out.println();
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
