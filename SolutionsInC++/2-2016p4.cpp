#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>

using namespace std;

enum MoveType {Generic, Hop, Skip, Jump};

struct PossibLocs
{
	vector<int[2]> locs;
};

int main()
{
	ifstream infile;
	infile.open("DATA40.txt"); //change

	for (int testcase = 0; testcase < 10; testcase++) {//change
		try {
			int w; int l;
			infile >> w; infile >> l;
			string line;
			getline(infile, line);

			char** grid = new char*[w];
			for (int i = 0; i < w; i++)
			{
				grid[i] = new char[l];
			}

			int h[2]; int s[2]; int j[2]; int c[2]; int t[2]; int f[2];

			for (int x = 0; x < l; x++)
			{
				getline(infile, line);
				for (int y = 0; y < w; y++)
				{
					grid[y][x] = line[y];
					if (line[y] == 'h')
					{
						h[0] = x;
						h[1] = y;
					}
					else if (line[y] == 's')
					{
						s[0] = x;
						s[1] = y;
					}
					else if (line[y] == 'j')
					{
						j[0] = x;
						j[1] = y;
					}
					else if (line[y] == 'C')
					{
						c[0] = x;
						c[1] = y;
					}
					else if (line[y] == 'T')
					{
						t[0] = x;
						t[1] = y;
					}
					else if (line[y] == 'F')
					{
						f[0] = x;
						f[1] = y;
					}
				}
			}

			PossibLocs**** possibilitiesGrid = new PossibLocs***[w];
			for (int x = 0; x < w; x++)
			{
				possibilitiesGrid[x] = new PossibLocs**[l];
				for (int y = 0; y < l; y++)
				{
					possibilitiesGrid[x][y] = new PossibLocs*[4];
				}
			}

			for (int y = 0; y < l; y++)
			{
				for (int x = 0; x < w; x++)
				{
					possibilitiesGrid[x][y][MoveType::Generic] = new PossibLocs();
				}
			}
			for (int y = 0; y < l; y++)
			{
				for (int x = 0; x < w; x++)
				{
					if (x != 0 && (((grid[x - 1][y] == '.' || grid[x - 1][y] == 'j' || grid[x - 1][y] == 's') && (grid[x - 1][y - 1] == '#' || grid[x - 1][y - 1] == '=')) || grid[x - 1][y] == '#'))
					{

					}
				}
			}
		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}

	system("pause");
}