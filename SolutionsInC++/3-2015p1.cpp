#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>

using namespace std;


int main()
{
	ifstream infile;
	infile.open("DATA10.txt"); //change

	for (int testcase = 0; testcase < 5; testcase++) {//change
		try {
			string num;
			infile >> num;
			string output="";
			for (int i = 0; num.length() > 0; i++) {
				if (num.length() > 1 && i >= stoi(num.substr(num.length() - 2))) {
					output = num.substr(num.length() - 2) + " " + output;
					num = num.substr(0, num.length() - 2);
				} else if (i >= stoi(num.substr(num.length() - 1))) {
					output = num.substr(num.length() - 1) + " " + output;
					num = num.substr(0, num.length() - 1);
				} else {
					output = "0 " + output;
				}

			}
			cout << output <<endl;
		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}

	system("pause");
}