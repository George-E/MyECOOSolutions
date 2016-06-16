#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main()
{
	for (int i = 0; i < 5; i++) {
		string word;
		cin >> word;

		cout << "* ";
		for (int c = 0; c < word.length(); c++) {
			cout << word[c] << " ";
		}
		cout << "*" << endl;

		for (int c = 0; c < word.length(); c++) {
			cout << word[word.length() - 1 - c] << " ";
			for (int c = 0; c < word.length(); c++) {
				cout << "* ";
			}
			cout << word[c] << endl;
		}

		cout << "* ";
		for (int c = 0; c < word.length(); c++) {
			cout << word[word.length() - 1 - c] << " ";
		}
		cout << "*" << endl;

	}
	system("pause");//remove
}
