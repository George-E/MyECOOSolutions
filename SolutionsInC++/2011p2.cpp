#include <iostream>
#include <string>
#include <vector>

using namespace std;

string legend[] { 
"xooooo",
"xoxooo",
"xxoooo",
"xxoxoo",
"xooxoo",
"xxxooo",
"xxxxoo",
"xoxxoo",
"oxxooo",
"oxxxoo",
"xoooxo",
"xoxoxo",
"xxooxo",
"xxoxxo",
"xooxxo",
"xxxoxo",
"xxxxxo",
"xoxxxo",
"oxxoxo",
"oxxxxo",
"xoooxx",
"xoxoxx",
"oxxxox",
"xxooxx",
"xxoxxx",
"xooxxx",
"oooooo"
};

int main()
{
	for (int q = 0; q < 5; q++) {
		string a, b, c;
		cin >> a >> b >> c;
		for (int i = 0; i < a.length(); i += 2) {
			string sequence = a.substr(i, 2) + b.substr(i, 2) + c.substr(i, 2);
			for (int c = 0; c < 27; c++) {
				if (sequence == legend[c]) {
					if (c == 26) {
						cout << " ";
					}
					else {
						cout << ((char)('a' + c));
					}
				}
			}
		}
		cout << endl;
	}

	system("pause");//remove
}
