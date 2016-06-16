#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
using namespace std;

string prizes[] {"?", "$1", "$2", "$5", "$10", "$50", "$100", "$1000", "$10 000", "$500 000", "$1 000 000" };

int main()
{
	ifstream infile;
	infile.open("DATA10.txt"); //change

	for (int y = 0; y < 1; y++) {
		int count[11]{};
		for (int i = 0; i < 9; i++) {
			string icon;
			getline(infile, icon);
			//cout << icon << endl;
			for (int p = 0; p < 11; p++) {
				if (prizes[p] == (icon)) {
					count[p]++;
					break;
				}
			}
		}


		bool printed = false;
		for (int p = 1; p < 11; p++) {
			if (3 - count[p] <= count[0]) {
				cout << prizes[p] << " ";
				printed = true;
			}
		}
		if (!printed) {
			cout << "No Prizes Possible";
		}
		cout << endl;

	}
	
	std::system("pause");
}