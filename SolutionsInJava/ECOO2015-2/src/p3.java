import java.io.*;
import java.util.*;

public class p3 {

	static int leastMoves = -1;
	static int t = -1;
	static ArrayList<int[][]> list;
	static ArrayList<Integer> moveCount;
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA31.txt"));
			list = new ArrayList<int[][]>();
			moveCount = new ArrayList<Integer>();
			for (int test = 0; test < 10; test++) {//change to # test cases
				leastMoves = -1;
				list.clear();
				moveCount.clear();
				int n = in.nextInt();
				t = in.nextInt();
				int[][] setUp = new int[3][n];
				for(int i = 0; i < n; i++)
				{
					setUp[0][i] = i+1;
				}
				//1RecurTower(setUp, 0);
				List<int[][]> setUps = new ArrayList<int[][]>();
				List<Integer> movesList = new ArrayList<Integer>();
				List<int[]> past = new ArrayList<int[]>();
				setUps.add(setUp);
				movesList.add(0);
				past.add(new int[]{-1});
				//System.out.println(past.get(0));
				WhileOut:
				while(setUps.size() > 0)
				{
					//System.out.println(past.get(0));
					setUp = setUps.get(0);
					int moves = movesList.get(0);
					setUps.remove(0);
					movesList.remove(0);
					int[] myPast = past.get(0);
					past.remove(0);
					if (myPast.length > 1) {
					for (int h = 1; h< myPast.length; h+=2) {
						if (h >= myPast.length ) continue;
						if (myPast[h+1] != moveCount.get(myPast[h])) {
							//System.out.println(myPast[h] + " "  + moveCount.get(myPast[h]));
							moves -= Math.abs(myPast[h+1] - moveCount.get(myPast[h]));
							myPast[h+1] = moveCount.get(myPast[h]);
						}
					}

					//System.out.println(Arrays.toString(myPast));
			
					}
					
					
					
					if (leastMoves != -1) 
						if(leastMoves != moves)
							continue WhileOut;
					
						int x = hasMoveSet(setUp);
					
						if(x != -1)
						{
							if(moveCount.get(x) > moves) {
								moveCount.set(x, moves);
								//System.out.println(x + " "  + moves);
							}
							continue WhileOut;
						}
						else
						{
							int[] newPast = new int[myPast.length+2];
							
							for(int i = 0; i < myPast.length; i++)
							{
								newPast[i] = myPast[i];
							}
							newPast[myPast.length] = moveCount.size();
							newPast[myPast.length+1] = moves;
							myPast = newPast;
							list.add(setUp);
							moveCount.add(moves);
						}
						
						boolean valid = true;
						int last = setUp[2][0];
						if (last == 1) {
						for(int i = 1; i < setUp[2].length; i++)
						{
							if(setUp[2][i] == 0 || setUp[2][i] < last)
							{
								valid = false;
								break;
							}
							last = setUp[2][i];
						}
						} else {valid = false;}
						if(valid)
						{
							if(leastMoves > moves || leastMoves == -1)
							{
								leastMoves = moves;
								continue WhileOut;
							}
						}
						int[] tops = new int[3];
						Arrays.fill(tops, -1);
						for(int i = 0; i < 3; i++)
						{
							for(int j = 0; j < setUp[i].length; j++)
							{
								if(setUp[i][j] != 0)
								{
									tops[i] = j;
									break;
								}
							}
						}
						
						for(int i = 0; i < 3; i++)
						{
							if(tops[i] == -1)
							{continue;}
							
							for(int l = 0; l < 3; l++)
							{
								if(l != i) 
								{
									int[][] newSet = new int[3][0];
									for(int j = 0; j < 3; j++)
									{
										newSet[j] = setUp[j].clone();
									}
									
									if (tops[l] == -1) {
										newSet[l][setUp[0].length-1] = newSet[i][tops[i]];
										newSet[i][tops[i]] = 0;
										setUps.add(newSet);
										movesList.add(moves+1);
										past.add(myPast);
									}else if (Math.abs(setUp[l][tops[l]] - setUp[i][tops[i]]) <= t) {
										newSet[l][tops[l]-1] = newSet[i][tops[i]];
										newSet[i][tops[i]] = 0;
										setUps.add(newSet);
										movesList.add(moves+1);
										past.add(myPast);
									}
								}
							}
						}
				}
				
				System.out.println(leastMoves + " " + test);
			} 
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	static int hasMoveSet(int[][] setUp)
	{
		Loop:
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = 0; j < 3; j++)
			{
				for(int k = 0; k < setUp[0].length; k++)
				{
					if(setUp[j][k] != list.get(i)[j][k])
					{
						continue Loop;
					}
				}
			}
			return i;
		}
		return -1;
	}
}
