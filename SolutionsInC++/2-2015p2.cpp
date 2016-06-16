#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>

using namespace std;

int R, C;
int b[30][30];
int removed = 0;

bool solve();

void swap(int r1, int c1, int r2, int c2) {
	int swap = b[r1][c1];
	b[r1][c1] = b[r2][c2];
	b[r2][c2] = swap;
}

void setrow(int r, int c1, int c2, int val) {
	for (int c = c1; c <= c2; c++) {
		b[r][c] = val;
	}
}

void setcol(int c, int r1, int r2, int val) {
	for (int r = r1; r <= r2; r++) {
		b[r][c] = val;
	}
}

void removedTagged() {
	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			if (b[r][c] > 9) {
				b[r][c] = -1;
			}
		}
	}
}

bool checkRowSwitch(int r1, int c1) {
	bool removedSomething = false;
	int type = b[r1][c1], posR1 = -1;
	int typeOpp = (type == 0) ? 1 : 0;

	if (r1 >1) {
		for (int r = r1; r >= 0; r--) {
			if (b[r][c1]%10 == type )  posR1 = r;
			else break;
		}
	}
	if (posR1> -1  && r1 - posR1 > 1) {
		removedSomething = true;
		removed += 1+ r1 - posR1;
		setcol(c1, posR1, r1, type+10);

	}

	int posR2 = -1;
	if (r1 < R - 3) {
		for (int r = r1 + 1; r < R; r++) {
			if (b[r][c1] % 10 != type)  posR2 = r;
			else break;
		}
	}
	if (posR2> -1 && posR2 - r1 - 1 > 1) {
		removedSomething = true;
		removed += posR2 - r1;
		setcol(c1, r1 + 1, posR2, typeOpp+10);
	}

	int posC1s, posC1e;
	for (int c = c1; c >= 0; c--) {
		if (b[r1][c] % 10 == type) posC1s = c;
		else break;
	}
	for (int c = c1; c < C; c++) {
		if (b[r1][c] % 10 == type) posC1e = c;
		else break;
	}
	if (posC1e - posC1s > 1) {
		removedSomething = true;
		removed += 1+ posC1e - posC1s;
		setrow(r1, posC1s, posC1e, type+10);
	}

	int posC2s, posC2e;
	for (int c = c1; c >= 0; c--) {
		if (b[r1 + 1][c] % 10 != type) posC2s = c;
		else break;
	}
	for (int c = c1; c < C; c++) {
		if (b[r1 + 1][c] % 10 != type) posC2e = c;
		else break;
	}
	if (posC2e - posC2s > 1) {
		removedSomething = true;
		removed += 1+posC2e - posC2s;
		setrow(r1 + 1, posC2s, posC2e, typeOpp+10);
	}

	removedTagged();
	if (removedSomething)
		if (solve())
			return true;

	if (posR1> -1 && r1 - posR1 > 1) {
		setcol(c1, posR1, r1, type);
		removed -= 1 + r1 - posR1;
	}
	if (posR2> -1 && posR2 - r1 - 1 > 1) {
		setcol(c1, r1 + 1, posR2, typeOpp);
		removed -= posR2 - r1;
	}
	if (posC1e - posC1s > 1) {
		setrow(r1, posC1s, posC1e, type);
		removed -= 1 + posC1e - posC1s;
	}
	if (posC2e - posC2s > 1) {
		removed -= 1 + posC2e - posC2s;
		setrow(r1 + 1, posC2s, posC2e, typeOpp);
	}

	return false;
}


bool checkColSwitch(int r1, int c1) {
	bool removedSomething = false;
	int type = b[r1][c1], posC1 = -1;
	int typeOpp = (type == 0) ? 1 : 0;

	if (c1 >1) {
		for (int c = c1; c >= 0; c--) {
			if (b[r1][c] % 10 == type)  posC1 = c;
			else break;
		}
	}
	if (posC1> -1 && c1 - posC1 > 1) {
		removedSomething = true;
		removed += 1 + c1 - posC1;
		setrow(r1, posC1, c1, type +10);
	}

	int posC2 = -1;
	if (c1 < C - 3) {
		for (int c = c1 + 1; c < C; c++) {
			if (b[r1][c] % 10 != type)  posC2 = c;
			else break;
		}
	}
	if (posC2> -1 && posC2 - c1 - 1 > 1) {
		removedSomething = true;
		removed += posC2 - c1;
		setrow(r1, c1 + 1, posC2, typeOpp+10);
	}

	int posR1s, posR1e;
	for (int r = r1; r >= 0; r--) {
		if (b[r][c1] % 10 == type) posR1s = r;
		else break;
	}
	for (int r = r1; r < R; r++) {
		if (b[r][c1] % 10 == type) posR1e = r;
		else break;
	}
	if (posR1e - posR1s > 1) {
		removedSomething = true;
		removed += 1 + posR1e - posR1s;
		setcol(c1, posR1s, posR1e, type+10);
	}

	int posR2s, posR2e;
	for (int r = r1; r >= 0; r--) {
		if (b[r][c1 + 1] % 10 != type) posR2s = r;
		else break;
	}
	for (int r = r1; r < R; r++) {
		if (b[r][c1 + 1] % 10 != type) posR2e = r;
		else break;
	}
	if (posR2e - posR2s > 1) {
		removedSomething = true;
		removed += 1 + posR2e - posR2s;
		setcol(c1 + 1, posR2s, posR2e, typeOpp+10);
	}

	removedTagged();
	if (removedSomething)
		if (solve())
			return true;

	if (posC1> -1 && c1 - posC1 > 1) {
		setrow(r1, posC1, c1, type);
		removed -= 1 + c1 - posC1;
	}
	if (posC2> -1 && posC2 - c1 - 1 > 1) {
		setrow(r1, c1 + 1, posC2, typeOpp);
		removed -= posC2 - c1;
	}
	if (posR1e - posR1s > 1) {
		setcol(c1, posR1s, posR1e, type);
		removed -= 1 + posR1e - posR1s;
	}
	if (posR2e - posR2s > 1) {
		removed -= 1 + posR2e - posR2s;
		setcol(c1 + 1, posR2s, posR2e, typeOpp);
	}

	return false;
}

bool solve() {
	if (removed == R*C) return true;
	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			if (b[r][c] == -1) continue;
			if (c + 1 < C && b[r][c + 1] != -1 && b[r][c + 1] != b[r][c]) {
				swap(r, c, r, c + 1);
				if (checkColSwitch(r, c)) {
					return true;
				}
				swap(r, c+1, r, c);
			}
			if (r + 1 < R && b[r + 1][c] > -1 && b[r+1][c] != b[r][c]) {
				swap(r, c, r+1, c);
				if (checkRowSwitch(r, c)) {
					return true;
				}
				swap(r, c, r+1, c);
			}
		}
	}
	return false;
}


int main()
{
	ifstream infile;
	infile.open("DATA20.txt"); //change

	for (int testcase = 0; testcase < 1; testcase++) {//change
		try {
			infile >> R >> C;
			for (int board = 0; board < 5; board++) {
				for (int r = 0; r < R; r++) {
					string line; infile >> line;
					for (int c = 0; c < C; c++) {
						b[r][c] = (line[c]=='X')?1:0;
					}
				}
				cout << ((solve())?"S":"N");

			}
			cout << endl;
		} catch (int e) {
			cout << "Test case had exception";
		}
	}

	system("pause");
}