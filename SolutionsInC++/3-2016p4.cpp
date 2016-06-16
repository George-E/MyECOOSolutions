#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include "Utility.h"

using namespace std;


int main()
{
	ifstream infile;
	infile.open("DATA40.txt"); //change

	ofstream outfile;
	outfile.open("solution.txt");
	for (int testcase = 0; testcase < 10; testcase++) {//change
		try {
			//outfile << "test" << endl;
		}
		catch (int e) {
			outfile << "Test case had exception" <<endl;
		}
	}
	outfile.close();
	system("pause");
}