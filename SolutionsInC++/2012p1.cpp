#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>

using namespace std;

string formatNum(double num) {
	stringstream stream;
	stream << fixed << setprecision(3) << num;
	return stream.str().substr(1, 4);
}

int main()
{
	ifstream infile;
	infile.open("DATA10.txt");

	string line;
	getline(infile, line);
	cout << line << endl;
	for (int i = 0; i < 20; i++) {
		cout << "=";
	}
	cout << endl;

	int atbatsT = 0, onebasehitsT = 0, twobasehitsT = 0, threebasehitsT = 0, homerunsT = 0, totalhitsT = 0;

	for (int i = 0; i < 10; i++) {
		string name;
		infile >> name;
		int gameplayed, atbats, runs, totalhits, twobasehits, threebasehits, homeruns;
		infile >> gameplayed >> atbats >> runs >> totalhits >> twobasehits >> threebasehits >> homeruns;
		double battingaverage = (double)totalhits / atbats;
		int onebasehits = totalhits - twobasehits - threebasehits - homeruns;
		double sluggingaverage = (onebasehits + 2 * twobasehits + 3 * threebasehits + 4 * homeruns) / (double)atbats;

		totalhitsT += totalhits;
		atbatsT += atbats;
		onebasehitsT += onebasehits;
		twobasehitsT += twobasehits;
		threebasehitsT += threebasehits;
		homerunsT += homeruns;

		//cout << battingaverage << " " << sluggingaverage;
		cout << name << ": " << formatNum(battingaverage) << " " << formatNum(sluggingaverage) << endl;
	}

	double battingaverageT = (double)totalhitsT / atbatsT;
	double sluggingaverageT = (onebasehitsT + 2 * twobasehitsT + 3 * threebasehitsT + 4 * homerunsT) / (double)atbatsT;

	for (int i = 0; i < 20; i++) {
		cout << "=";
	}
	cout << endl;

	cout << ("Big 10 Av: " + formatNum(battingaverageT) + " " + formatNum(sluggingaverageT)) << endl;

	system("pause");//remove
}