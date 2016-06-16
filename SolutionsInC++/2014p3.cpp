#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
using namespace std;


int main()
{
	ifstream infile;
	infile.open("DATA30.txt"); //change

	for (int y = 0; y < 2; y++) {
		string line1;
		getline(infile, line1);
		int field[line1.length][line1.length];


	}

	std::system("pause");
}