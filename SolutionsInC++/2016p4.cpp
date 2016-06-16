#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
using namespace std;

int dist(int x, int y) {
	return (x*x + y*y);
}

string formatNum(double num) {
	stringstream stream;
	stream << fixed << setprecision(1) << num;
	return stream.str();
}
int main()
{
	ifstream infile;
	infile.open("DATA41.txt"); //change

	for (int p = 0; p < 10; p++) { //change
		try {
			//cout << "begin";//remove
			int dCount = 0; int total = 0;
			int cx; infile >> cx;
			int cy; infile >> cy;

			vector<pair<int, int>> demo;
			vector<pair<int, int>> repu;
			for (int i = 0; i < 100; i++)
			{
				int hx; infile >> hx;
				int hy; infile >> hy;

				char a; infile >> a;
				if (a == 'D')
				{
					demo.push_back(make_pair(hx, hy));
				}
				else
				{
					repu.push_back(make_pair(hx, hy));
				}
			}

			// << "checkpoint 1";//remove
			for (int dy = -50; dy <= 50; dy++)
			{
				for (int dx = -50; dx <= 50; dx++)
				{
					if (dist(abs(dx), abs(dy)) <= 50*50)
					{
						total++;
						int tx = cx + dx; int ty = cy + dy;
						double f = -1; vector<bool> fa;
						double s = -1; vector<bool> sa;
						double t = -1; vector<bool> ta;
						//cout << "checkpoint 2";//remove
						for (int i = 0; i < repu.size(); i++)
						{
							int nDist = dist(abs(tx - repu[i].first), abs(ty - repu[i].second));
							//cout << i << " " << tx << " " << ty << " " << repu[i].first << " " << repu[i].second << " " << nDist << endl;
							if (nDist < f || f == -1)
							{
								t = s;
								s = f;
								f = nDist;

								ta = sa;
								sa = fa;
								fa.clear(); fa.push_back(true);
							}
							else if (nDist == f)
							{
								fa.push_back(true);
							}
							else if (nDist < s || s == -1)
							{
								t = s;
								s = nDist;

								ta = sa;
								sa.clear(); sa.push_back(true);
							}
							else if (nDist == s)
							{
								sa.push_back(true);
							}
							else if (nDist < t || t == -1)
							{
								t = nDist;

								ta.clear(); ta.push_back(true);
							}
							else if (nDist == t)
							{
								ta.push_back(true);
							}
						}
						//	cout << "checkpoint 3";//remove
						for (int i = 0; i < demo.size(); i++)
						{
							double nDist = dist(abs(tx - demo[i].first), abs(ty - demo[i].second));
							if (nDist < f)
							{
								t = s;
								s = f;
								f = nDist;

								ta = sa;
								sa = fa;
								fa.clear(); fa.push_back(false);
							}
							else if (nDist == f)
							{
								fa.push_back(false);
							}
							else if (nDist < s)
							{
								t = s;
								s = nDist;

								ta = sa;
								sa.clear(); sa.push_back(false);
							}
							else if (nDist == s)
							{
								sa.push_back(false);
							}
							else if (nDist < t)
							{
								t = nDist;

								ta.clear(); ta.push_back(false);
							}
							else if (nDist == t)
							{
								ta.push_back(false);
							}
						}
						//////////////////////
						/*for (int i = 0; i < fa.size(); i++) {
							cout << fa[i] << " ";
						}
						cout << endl;
						for (int i = 0; i < sa.size(); i++) {
							cout << sa[i] << " ";
						}
						cout << endl;
						for (int i = 0; i < ta.size(); i++) {
							cout << ta[i] << " ";
						}
						cout << endl;*/
						////////////////////////////
						int b = 0;
						int counter = 0;
						//while (counter < 3 && b != 0) {
						for (int i = 0; i < fa.size(); i++)
						{
							counter++;
							if (fa[i])
							{
								b++;
							}
							else
							{
								b--;
							}

						}
						if (counter < 3) {
							for (int i = 0; i < sa.size(); i++)
							{
								counter++;
								if (sa[i])
								{
									b++;
								}
								else
								{
									b--;
								}

							}
						}
						if (counter < 3) {
							for (int i = 0; i < ta.size(); i++)
							{
								counter++;
								if (ta[i])
								{
									b++;
								}
								else
								{
									b--;
								}

							}
						}

						//cout << b << endl;;
						if (b <= 0)
						{
							dCount++;
							//cout << "new decont..." << dCount << endl;
						}
						//}
					}
				}
			}
			cout << formatNum((dCount / (double)total)*100) << endl;
			//cout << dCount << endl;
			//cout << total << endl;
		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}


	system("pause");
}