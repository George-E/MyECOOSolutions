#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
using namespace std;

bool isBlack(int R, int C, int f) {
	R--;
	C--;
	int evens = 0;
	if ((R / f) % 2 == 0)
		evens++;
	if ((C / f) % 2 == 0)
		evens++;
	return (evens % 2 == 0);
}

int main()
{
	ifstream infile;
	infile.open("DATA20.txt"); //change
	for (int t = 0; t < 2; t++) {
		int N; infile >> N;
		int rowVals[5];
		int colVals[5];
		for (int i = 0; i < 5; i++) {
			infile >> rowVals[i] >> colVals[i];
		}
		bool black[5]{};

		for (int f = 1; f <= sqrt(N); f++) {
			
			
			if( f == sqrt(N)) {

				// << f << endl;
				for (int l = 0; l < 5; l++) {
					if (isBlack( rowVals[l], colVals[l], f)) {
						black[l] = !black[l];
					}
				}
			}
			else if(N%f == 0) {

				//cout << f << endl;
				//cout << N / f << endl;


				for (int l = 0; l < 5; l++) {
					if (isBlack( rowVals[l], colVals[l], f)) {
						black[l] = !black[l];
					}

					if (isBlack(rowVals[l], colVals[l], N / f)) {
						black[l] = !black[l];
					}
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			cout << ((black[i]) ? "B" : "G");
		}
		cout << endl;

	}

	system("pause");
}