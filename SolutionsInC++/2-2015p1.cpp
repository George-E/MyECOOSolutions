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

	for (int y = 0; y < 2; y++) {//change to 10
		try {
			string command;
			getline(infile, command);
			if (command == "encode") {
				vector<string> words;
				string line;
				getline(infile, line);
				istringstream iss(line);
				int longestwordlength = 0;
				do{
					string sub;
					iss >> sub;
					if (sub != "")
						words.push_back(sub);
					longestwordlength = max(longestwordlength, (int)sub.length());
				} while (iss);

				int pos = 0;
				string encoded = "";
				while (pos < longestwordlength) {
					for (int p = 0; p < words.size(); p++) {
						if (words[p].size() > pos) {
							encoded += words[p][pos];
						}
					}
					pos++;
				}

				pos = 0;
				for (int p = 0; p < words.size(); p++) {
					int size = words[p].size();
					cout << encoded.substr(pos,size) << " ";
					pos += size;
				}
				cout << endl;

			}
			else {
				vector<string> encodedwords;
				string line;
				getline(infile, line);
				istringstream iss(line);
				int longestwordlength = 0;
				do{
					string sub;
					iss >> sub;
					if (sub != "")
						encodedwords.push_back(sub);
					longestwordlength = max(longestwordlength, (int)sub.length());
				} while (iss);
				line.erase(remove_if(line.begin(), line.end(), isspace), line.end());

				vector<string> words(encodedwords.size(), "");

				int pos = 0;
				int actualPos = 0;
				while (pos < longestwordlength) {
					for (int p = 0; p < encodedwords.size(); p++) {
						if (encodedwords[p].size() > pos) {
							words[p] += line[actualPos];
							actualPos++;
						}
					}
					pos++;
				}

				for (int p = 0; p < words.size(); p++) {
					cout << words[p] << " ";
				}
				cout << endl;

			}
		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}

	std::system("pause");
}