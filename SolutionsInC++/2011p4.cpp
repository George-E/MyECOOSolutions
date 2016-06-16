#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Point {
private:
	double xval, yval;
public:
	// Constructor uses default arguments to allow calling with zero, one,
	// or two values.
	Point(double x = 0.0, double y = 0.0) {
		xval = x;
		yval = y;
	}

	// Extractors.
	double x() { return xval; }
	double y() { return yval; }

};

int main()
{
	for (int q = 0; q < 5; q++) {
		int p;
		cin >> p;
		vector < Point > trees;
		for (int t = 0; t < p; t++) {
			int x, y;
			cin >> x >> y;
			trees.push_back(Point (x, y));
		}

	}

	system("pause");//remove
}
