#include <iostream>
#include <string>
#include <vector>

using namespace std;

int stringToDec(string input) {
	int total = 0;
	for (int i = 0; i < 5; i++) {
		if (input[4 - i] != '.')
			total += pow(27, i) * (input[4 - i] - 'A' + 1);
	}
	return total;
}

string decToString(int input) {
	string total = "";
	while (input > 27) {
		int remainder = input % 27;
		input = floor(input / 27);
		if (remainder == 0) {
			total = "." + total;
		}
		else {
			total = (char)('A' + remainder -1) + total;
		}
	}
	if (input == 0) {
		total = "." + total;
	}
	else {
		total = (char)('A' + input - 1) + total;
	}
	while (total.length() < 5) {
		total = "." + total;
	}
	return total;
}

int main()
{
	for (int t = 0; t < 5; t++) {
		string key;
		cin >> key;
		int decKey = stringToDec(key.substr(0,5));
		//cout << "dec of key.." << decKey << endl;
		string cipherText;
		cin >> cipherText;
		string output = "";
		for (int x = 0; x < cipherText.length(); x += 5){
			//cout << "set of letters... " << cipherText.substr(x, 5)  << endl;
			int decCipher = stringToDec(cipherText.substr(x, 5));
			//cout << "dec of that... " << decCipher << endl;
			if (decCipher > decKey)
				output += decToString(decCipher - decKey);
			else
				output += decToString(decCipher + 14348907 - decKey);
		}

		while (output[output.length() - 1] == '.') {
			output = output.substr(0, output.length() - 1);
		}

		cout << output << endl;
	}
	system("pause");//remove
}
