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
	infile.open("DATA11.txt"); //change

	for (int testcase = 0; testcase < 10; testcase++) {//change
		try {
			string x;
			getline(infile, x);
			int lpl = 1;
			for (int j = x.length() - 1; j >= 1; j--)
			{
				bool isPalindrome = true;
				for (int k = 0; k <= j / 2; k++)
				{
					if (x[k] != x[j - k])
					{
						isPalindrome = false;
						break;
					}
				}

				if (isPalindrome)
				{
					lpl = j + 1;
					break;
				}
			}
			int rpl = 1;
			for (int j = 0; j < x.length(); j++)
			{
				bool isPalindrome = true;
				for (int k = 0; k <= (x.length() - j) / 2; k++)
				{
					if (x[x.length() - 1 - k] != x[j + k])
					{
						isPalindrome = false;
						break;
					}
				}

				if (isPalindrome)
				{
					rpl = x.length() - j;
					break;
				}
			}

			cout << (x.length() - max(lpl, rpl)) << endl;
		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}

	system("pause");
}