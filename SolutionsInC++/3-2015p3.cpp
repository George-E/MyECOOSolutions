#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>

using namespace std;

int middle = 0, width = 0, lanes = 0;
vector<string> traffic;

bool carInFrontNextIteration(int iterations, int fromTop) {
	fromTop--;
	iterations++;
	if (((lanes-fromTop) % 2) -1 == 0) { //left
		return((traffic[fromTop][(middle+iterations)%width]) == '*');
	}
	else { //right
		int tempPos = (middle - iterations) % width;
		if (tempPos >= 0) {
			return((traffic[fromTop][tempPos]) == '*');
		}
		else {
			return((traffic[fromTop][width+tempPos]) == '*');
		}
	}
}

bool carHitMeNextIteration(int iterations, int fromTop) {
	iterations++;
	if (fromTop ==lanes) {
		return false;
	}
	if (((lanes - fromTop) % 2) - 1 == 0) { //left
		return((traffic[fromTop][(middle + iterations) % width]) == '*');
	}
	else { //right
		int tempPos = (middle - iterations) % width;
		if (tempPos >= 0) {
			return((traffic[fromTop][tempPos]) == '*');
		}
		else {
			return((traffic[fromTop][width + tempPos]) == '*');
		}
	}
}

int main()
{
	ifstream infile;
	infile.open("DATA32.txt"); //change

	for (int testcase = 0; testcase < 10; testcase++) {//change
		try {
			infile >> lanes >> width;
			middle = width / 2;
			string line; getline(infile, line); 
			traffic.clear();
			for (int i = 0; i < lanes; i++) {
				getline(infile, line);
				traffic.push_back(line);
			}

			int min = -1;//no point in checking past first successful find b/c first in firrst out will find min as first success
			vector<int> pos;
			vector<int> iterations;
			pos.push_back(lanes);
			iterations.push_back(0);

			long index = 0;
			while (pos.size() > index) {
				//cout << pos.size() << " " << iterations[index] << " " << pos[index] << endl;
				//if (iterations[index]>21)
					//system("pause");
				if (pos[index] == lanes && iterations[index] >= width) {
					index++;
					//pos.erase(pos.begin());
					//iterations.erase(iterations.begin());
					continue;
				}
				if (!carInFrontNextIteration(iterations[index], pos[index])) {
					bool test = true;
					for (int p = iterations.size() - 1; p >= 0 && iterations[p] == iterations[index] + 1; p--) {
						if (pos[p] == pos[index]-1) {
							test = false;
						}
					}
					if (test) {
						pos.push_back(pos[index] - 1);
						iterations.push_back(iterations[index] + 1);
						if (pos[index] - 1 == 0) {
							min = iterations[index] + 2;
							break;
						}
					}
				}
				if (!carHitMeNextIteration(iterations[index], pos[index])) {
					bool test = true;
					for (int p = iterations.size() - 1; p >= 0 && iterations[p] == iterations[index] + 1; p--) {
						if (pos[p] == pos[index]) {
							test = false;
						}
					}
					if (test) {
						pos.push_back(pos[index]);
						iterations.push_back(iterations[index] + 1);
					}
				}
				index++;
				//.erase(pos.begin());
				//iterations.erase(iterations.begin());
			}

			if (min > -1)
				cout << min << endl;
			else
				cout << "Not Possible " << endl;

		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}

	system("pause");
}