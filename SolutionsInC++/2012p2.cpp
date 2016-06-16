#include <iostream>
#include <string>
#include <vector>
#include <fstream>

using namespace std;

string getReverseOfDNA(string original, bool reverseOrder) {

	string clone = original + "";

	size_t pos = original.find("T");
	while (pos != string::npos) {
		clone.replace(pos, 1, "A");
		if (pos == original.length() - 1)
			break;
		pos = original.find("T", pos+1);
	}


	 pos = original.find("A");
	while (pos != string::npos) {
		if (reverseOrder)
			clone.replace(pos, 1, "T");
		else
			clone.replace(pos, 1, "U");
		if (pos == original.length() - 1)
			break;
		pos = original.find("A", pos + 1);
	}

	 pos = original.find("C");
	while (pos != string::npos) {
		clone.replace(pos, 1, "G");
		if (pos == original.length() - 1)
			break;
		pos = original.find("C", pos + 1);
	}
	
	 pos = original.find("G");
	while (pos != string::npos) {
		clone.replace(pos, 1, "C");
		if (pos == original.length() - 1)
			break;
		pos = original.find("G", pos + 1);
	}

	if (reverseOrder) {
		string final = "";
		for (int i = clone.length() - 1; i >= 0; i--) {
			final += clone[i];
		}
		return final;
	}
	else {
		return clone;
	}
	
}

int main()
{
	ifstream infile;
	infile.open("DATA20.txt");

	for (int p = 0; p < 5; p++) {
		string line;
		getline(infile, line);
		int start = line.find("TATAAT") + 10;

		for (int c = start; c < line.length()-2; c++)  {

			for (int length = 6; length <= (line.length()-c-1)/2; length++)  {

				string firstHalf = line.substr(c, length);
				string secondHalf = getReverseOfDNA(firstHalf, true);

				for (int c2 = c + length; c2 < line.length() - length; c2++)  {
					//cout << c << endl;
					if (secondHalf == line.substr(c2, length)) {
						//cout << ":)" << endl;
						cout << getReverseOfDNA(line.substr(start, c - start),false) << endl;
						//cout << ":)" << endl;
						goto exitloop;
					}
					
				}
			}
		}

	exitloop:
		cout << "";
	}
	system("pause");//remove
}