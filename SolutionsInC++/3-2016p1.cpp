#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include "Utility.h"

using namespace std;


int main()
{
	ifstream infile;
	infile.open("DATA10.txt"); //change
	for (int testcase = 0; testcase < 3; testcase++) {//change
		try {
			double n;
			infile >> n;
			int s;
			infile >> s;
		
			//shivansh answer 8/10
			/*
			int totalFaces = n*s;
			double probability = ((s - 1)*1.0) / s;//1 - ((1.0*n) / (1.0*totalFaces));
			double sum = totalFaces;
			int iterations = 0;
			//cout << testcase << endl;
			while (sum > 0){
				//cout << iterations << " " << sum << endl;
				sum = floor(sum*probability);
				iterations++;
			}*/
			
			//george answer 6/10
			/*
			double probability = 0;
			int iterations = 0;
			while (n - probability >0.5) {
				//cout << iterations<< " "<<n<<" "<< probability << " " << (n - probability) << endl;
				probability += (n - probability)*(1.0 / (s));
				iterations++;
			}
			*/

			
			//simulation
			srand(time(NULL));
			int totalIterations = 0;
			int trials = 100000;
			for (int i = 0; i < trials; i++) {
				int dice = n;
				while (dice > 0) {
					totalIterations++;
					for (int d = 0; d < dice; d++) {
						//srand(time(NULL));
						if ((rand()%s)==1) {
							dice--;
						}
					}
				}
			}
			int iterations = (int)ceil(totalIterations*1.0 / trials);
			//cout << totalIterations<<endl;


			cout << iterations << endl;
		}
		catch (int e) {
			cout << "Test case had exception" << endl;
		}
	}

	system("pause");
}