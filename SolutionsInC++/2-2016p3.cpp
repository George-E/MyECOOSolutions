#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>

using namespace std;

int b[100][100];

int main()
{
	ifstream infile;
	infile.open("DATA32.txt"); //change

	for (int testcase = 0; testcase < 10; testcase++) {//change to 10
		try {
			int S, L;
			infile >> S >> L;
			string line;
			getline(infile, line);
			for (int r = 0; r < S; r++) {
				getline(infile, line);
				for (int c = 0; c < S; c++) {
					if (line[c] == '.')
						b[r][c] = 0;
					if (line[c] == 'h')
						b[r][c] = 2;
					if (line[c] == 'm')
						b[r][c] = 1;
				}
			}
			int possible = 0;
			//horz
			for (int r = 0; r < S; r++) {
				for (int c = 0; c < S-L+1; c++) {
					//cout << possible << endl;
					//cout << r << " " << c << endl;
					bool bad = false;
					for (int p = 0; p < L; p++) {
						if (b[r][c + p] == 1) {
							bad = true;
							break;
						}
					}
					if (bad) continue;
					if (c > 0) {
						if (b[r][c - 1] == 2)
							continue;
					}
					if (c + L < S) {
						if (b[r][c + L] == 2)
							continue;
					}
					for (int c2 = c - 1; c2 <= c + L; c2++) {
						if (c2>=0 && c2 < S) {
							if (r > 0) {
								if (b[r - 1][c2] == 2) {
									bad = true;
									break;
								}
							}
							if (r+1<S) {
								if (b[r + 1][c2] == 2) {
									bad = true;
									break;
								}
							}
						}
					}
					if (bad) continue;
					possible++;
				}
			}

			//vert
			for (int r = 0; r < S-L+1; r++) {
				for (int c = 0; c < S; c++) {
					//cout << possible << endl;
					//cout << r << " " << c << endl;
					bool bad = false;
					for (int p = 0; p < L; p++) {
						if (b[r + p][c] == 1) {
							bad = true;
							break;
						}
					}
					if (bad) continue;
					if (r > 0) {
						if (b[r-1][c] == 2)
							continue;
					}
					if (r + L < S) {
						if (b[r+L][c] == 2)
							continue;
					}
					for (int r2 = r - 1; r2 <= r + L; r2++) {
						//cout << "loop2" << endl;
						if (r2>=0 && r2 < S) {
							if (c > 0) {
								if (b[r2][c-1] == 2) {
									bad = true;
									break;
								}
							}
							if (c + 1<S) {
								if (b[r2][c+1] == 2) {
									bad = true;
									break;
								}
							}
						}
					}
					if (bad) continue;
					possible++;
				}
			}

			cout << possible << endl;

		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}

	system("pause");
}