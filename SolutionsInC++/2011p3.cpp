#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main()
{
	string key;
	getline(cin, key);
	for (int q = 0; q < 5; q++) {
		string decode;
		getline(cin, decode);
		for (int c = decode.length() - 1; c >= 0; c--) {
			int index = c + 1;
			int newIndex = (index + (key[c% key.length()] - 'A') /*+1-1*/) % decode.length();
			char hold = decode[c];
			decode[c] = decode[newIndex];
			decode[newIndex] = hold;
			//cout << decode << endl;
		}
		cout << decode << endl;
	}

	system("pause");//remove
}
