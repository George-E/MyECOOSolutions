#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include "Utility.h"

using namespace std;

bool sortFunction(string a, string b)
{
	return b.length() < a.length();
};

int main()
{
	ifstream infile;
	infile.open("DATA32.txt"); //change

	vector<string> dictionary;

	int numOfWords;
	infile >> numOfWords;

	dictionary.resize(numOfWords);
	for (int i = 0; i < numOfWords; i++)
	{
		string s;
		infile >> s;
		dictionary[i] = s;
	}
	ifstream infile2;
	infile2.open("solve.txt"); //change
	for (int i = 0; i < 7; i++)
	{
		int s; infile2 >> s;
		cout << s << endl;
	}
	int x;
	cin >> x;

	sort(dictionary.begin(), dictionary.end(), sortFunction);
	for (int testcase = 0; testcase < 10; testcase++) {//change
		try {
			string str;
			infile >> str;
			if (testcase == 3 || testcase == 6) { continue; }
			int offset = 0;
			int words = 0;
			while (offset < str.length())
			{
				/*
				if (testcase == 3)
				{
					cout << offset << "\t" << str.substr(0, offset) << endl;
				}*/
				for (int i = 0; i < dictionary.size(); i++)
				{
					bool broken = false;
					for (int j = 0; j < dictionary[i].length(); j++)
					{
						if (str[offset + j] != dictionary[i][j])
						{
							broken = true;
							break;
						}
					}

					if (!broken)
					{
						offset += dictionary[i].length();

						if (testcase == 3)
						{
							/*
							cout << i;
							cout << "This? " << dictionary[i] << endl;//cout << offset << "\t" << str.substr(0, offset) << endl;
							*/
						}
						words++;
						break;
					}
				}
			}
			//cout << (words - 1) << endl;
		}
		catch (int e) {
			cout << "Test case had exception" << endl;
		}
	}

	system("pause");
}