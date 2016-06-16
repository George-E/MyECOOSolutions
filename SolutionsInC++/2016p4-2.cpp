#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>
using namespace std;


bool sortTL(vector<int> one, vector<int> two) {
	return one[2] <= two[2];
}

double dist(int x, int y) {
	return sqrt(x*x + y*y);
}

string formatNum(double num) {
	stringstream stream;
	stream << fixed << setprecision(1) << num;
	return stream.str();
}


struct Dot {
public:
	int x;
	int y;
	float dist;
};
		
 bool SortFunc(Dot* o1, Dot* o2) {
		return o1->dist < o2->dist;
	}


std::vector<Dot*> arr;




int main()
{

	for (int x = 0; x <= 400; x++) {
		for (int y = (x == 0 ? 1 : x); y <= 400; y++) {
			Dot* d = new Dot();
			d->x = x;
			d->y = y;
			d->dist = (x*x + y*y);
			arr.push_back(d);
			//cout << x << " " << y << endl;
		}
	}

	sort(arr.begin(), arr.end(), SortFunc);
	

	ifstream infile;
	infile.open("DATA41.txt"); //change

	for (int p = 0; p < 10; p++) { //change
		try {

			//cout << "begin";//remove
			int dCount = 0; int total = 0;
			int cx; infile >> cx;
			int cy; infile >> cy;
			cx += 200; cy += 200;

			int grid[401][401] {};
			for (int i = 0; i < 100; i++)//change to 100
			{
				//cout << i << endl;
				int hx; infile >> hx;
				int hy; infile >> hy;

				char a; infile >> a;
				if (a == 'D')
				{
					grid[hx+200][hy+200] = 1;
				}
				else
				{
					grid[hx + 200][hy + 200] = 2;
				}
			}

			
			// << "checkpoint 1";//remove
			for (int dy = -50; dy <= 50; dy++)
			{
				for (int dx = -50; dx <= 50; dx++)
				{
					//cout << dx << endl;
					if (dist(abs(dx), abs(dy)) <= 50*50 && grid[cx + dx][cy + dy] == 0)
					{
						total++;

					//	cout << total << endl;
						int xpos = cx + dx;
						int ypos = cy + dy;

						int closeD = 0;
						int closeR = 0;

						int counter = 0;

						int lastDist = 0;

						for (int l = 0; l < arr.size() ; l++) {

							if ((closeD + closeR) >= 3) {
								if (lastDist != arr[l]->dist) {
									break;
								}
							}
							lastDist = arr[l]->dist;

							counter++;
							int val = grid[xpos + arr[l]->x][ypos + arr[l]->y];
							if (val == 1)
								closeD++;
							if (val == 2)
								closeR++;

							if (arr[l]->x != 0) {
								val = grid[xpos + -1 * arr[l]->x][ypos + arr[l]->y];
								if (val == 1)
									closeD++;
								if (val == 2)
									closeR++;
							}

							if (arr[l]->y != 0) {
								val = grid[xpos + arr[l]->x][ypos + -1 * arr[l]->y];
								if (val == 1)
									closeD++;
								if (val == 2)
									closeR++;
							}

							if (arr[l]->y != 0 && arr[l]->x != 0) {
								val = grid[xpos + -1 * arr[l]->x][ypos + -1 * arr[l]->y];
								if (val == 1)
									closeD++;
								if (val == 2)
									closeR++;
							}

							if (arr[l]->x != arr[l]->y) {
								 val = grid[xpos + arr[l]->y][ypos + arr[l]->x];
								if (val == 1)
									closeD++;
								if (val == 2)
									closeR++;

								if (arr[l]->y != 0) {
									val = grid[xpos + -1 * arr[l]->y][ypos + arr[l]->x];
									if (val == 1)
										closeD++;
									if (val == 2)
										closeR++;
								}

								if (arr[l]->x != 0) {
									val = grid[xpos + arr[l]->y][ypos + -1 * arr[l]->x];
									if (val == 1)
										closeD++;
									if (val == 2)
										closeR++;
								}

								if (arr[l]->y != 0 && arr[l]->x != 0) {
									val = grid[xpos + -1 * arr[l]->y][ypos + -1 * arr[l]->x];
									if (val == 1)
										closeD++;
									if (val == 2)
										closeR++;
								}

							}
						}

						//cout << counter << " " << arr.size() << endl;
						//cout << closeD << " " << closeR << endl;
						if (closeD >= closeR) {
							dCount++;
						}

					}
				}
			}
			cout << formatNum((dCount / (double)total) * 100) << endl;
			//cout << dCount << endl;
			//cout << total << endl;
		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}
	
	
	system("pause");
}