#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include <regex>

using namespace std;

string intToChar26(int num, int size){
	double div = num / 26;
	if (div < 1) {
		string answer = "";
		char p = (char)('a'  + num);
		answer += p;
		if (size == 2)
			answer = "a" + answer;
		return(answer);
	}
	else {
		int firstVal = (int)(floor(div));
		int secondVal = num-firstVal*26;
		//cout << firstVal <<" "<<secondVal<<" "<<div << endl;
		char sec = (char)('a' + secondVal);
		char fir = (char)('a' + firstVal);
		string answer = "";
		answer += fir;
		answer += sec;
		return (answer);
	}
}

int char26ToInt(string chars)
{
	if (chars.length() == 1) {
		int digit = chars[0] - 'a';
		return digit;
	}
	else {
		int digit1 = chars[1] - 'a';
		int digit2 = chars[0] - 'a';

		return (digit2 * 26 + digit1);
	}
}

int main()
{
	ifstream infile;
	infile.open("DATA21.txt"); //change

	for (int testcase = 0; testcase < 10; testcase++) {//change to 10
		try {
			long key;
			infile >> key;
			string line;
			getline(infile, line);
			getline(infile, line);
			//cout << line << endl;
			regex e(" ");
			if (regex_search(line, e)) {//if true, encode; flase, decode
				vector<string> words;
				istringstream iss(line);
				do{
					string sub;
					iss >> sub;
					if (sub != "")
						words.push_back(sub);
				} while (iss);
				string start = "";
				start += intToChar26(words.size(), 2);
				for (int y = 0; y < words.size(); y++) {
					start += intToChar26(words[y].length(), 1);
				}
				string output = "";
				regex_replace(back_inserter(output), line.begin(), line.end(), e, "");//removes spaces
				output = start + output;
				int runningTotal = 0;
				for (int c = output.length() - 1; c >= 0; c--) {
					int current = output[c] - 'a';
					long newC = (key + current + runningTotal) % 26;
					output[c] = (char)(newC + 'a');
					runningTotal += current;
				}
				cout << output << endl;
			}
			else {
				int runningTotal = 0;
				for (int c = line.length() - 1; c >= 0; c--) {
					//cout << line[c] << endl;
					int current = line[c] - 'a';
					//cout << current << endl;
					long newC = (current - key - runningTotal) % 26;
					//cout << newC<< endl;
					if (newC < 0)
						newC = 26 + newC;
					//cout << newC << endl;
					line[c] = (char)(newC + 'a');
					//cout << line[c] << endl;
					runningTotal += newC;
				}
				//cout << line << endl;
				int numWords = char26ToInt(line.substr(0, 2));
				//cout << numWords << endl;
				vector<int> wordLengths;
				for (int w = 0; w < numWords; w++) {
					wordLengths.push_back(char26ToInt(line.substr(2+w, 1)));
					//cout << wordLengths[w] << endl;
				}
				string output = "";
				int pos = 2 + numWords;
				for (int w = 0; w < numWords; w++) {
					output += line.substr(pos,wordLengths[w])+ " ";
					pos += wordLengths[w];
				}
				cout << output << endl;

			}
		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}

	system("pause");
}