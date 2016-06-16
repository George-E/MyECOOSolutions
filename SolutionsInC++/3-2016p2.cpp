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
	infile.open("DATA21.txt"); //change

	for (int testcase = 0; testcase < 10; testcase++) {//change
		try {
			int b, h;
			infile >> b >> h;
			long double ratio = h * 1.0 / b;
		

			vector<string> colors;
			string line; getline(infile, line); getline(infile, line);
			istringstream iss(line);
			do{
				string sub;
				iss >> sub;
				if (sub != "")
					colors.push_back(sub);
			} while (iss);
			
			vector<vector<int>> triangles;
			vector<vector<int>> rectangles;
			int numShapes; infile >> numShapes;
			for (int i = 0; i < numShapes; i++) {
				char type; infile >> type;
				if (type == 'T') {
					vector<int> vals;
					int val;
					for (int y = 0; y < 3; y++) {
						infile >> val;
						vals.push_back(val);
					}
					triangles.push_back(vals);
				}
				else {//rec
					vector<int> vals;
					int val;
					for (int y = 0; y < 4; y++) {
						infile >> val;
						vals.push_back(val);
					}
					if (vals[2] < 0) {
						vals[2] *= -1;
						vals[0] -= vals[2]*b;
					}
					if (vals[3] < 0) {
						vals[3] *= -1;
						vals[1] -= vals[3]*h;
					}
					vals[2] = vals[0] + vals[2]*b;
					vals[3] = vals[1] + vals[3]*h;
					rectangles.push_back(vals);
				}
			}
			
			vector<vector<int>> points;
			for (int i = 0; i < 500; i++) {//change to 500
				vector<int> vals;
				int val;
				for (int y = 0; y < 2; y++) {
					infile >> val;
					vals.push_back(val);
				}
				vals.push_back(0);
				points.push_back(vals);
			}
			
			for (int i = 0; i < rectangles.size(); i++) {
				for (int p = 0; p < points.size(); p++) {
					if (points[p][0] >= rectangles[i][0] && points[p][1] >= rectangles[i][1] && points[p][0] <= rectangles[i][2] && points[p][1] <= rectangles[i][3]) {
						points[p][2]++;
						//cout << points[p][0] << " " << points[p][1] << " R " << i << " " << rectangles[i][0] << " " << rectangles[i][1] << " " << rectangles[i][2] << " " << rectangles[i][3] <<endl;
					}
				}
			}

			for (int i = 0; i < triangles.size(); i++) {
				
				if (triangles[i][2] > 0) {
					//cout << i << endl;
					int rightV = triangles[i][0] + triangles[i][2] * b;
					//cout << rightV << endl;
					for (int p = 0; p < points.size(); p++) {
						//cout << p << " " << points[p][0] <<" " << points[p][1]<< endl;
						if (points[p][0] >= triangles[i][0] && points[p][0] <= rightV) {
							//cout << "cool1" <<endl;
							//cout << (points[p][1] >= triangles[i][1]) << " " << (points[p][1] <= triangles[i][1] + ratio*(rightV - points[p][0])) << endl;
							//cout << (triangles[i][1] + ratio*(rightV - points[p][0])) << endl;
							if (points[p][1] >= triangles[i][1] && points[p][1]-0.1 <= triangles[i][1]+ratio*(rightV - points[p][0])) {

								//cout << "cool2" << endl;
								points[p][2]++;
								//cout << points[p][0] << " " << points[p][1] << " T " << i << endl;
							}
						}
					}
				}
				else {
					int leftV = triangles[i][0] - triangles[i][2] * b;
					for (int p = 0; p < points.size(); p++) {
						if (points[p][0] <= triangles[i][0] && points[p][0] >= leftV) {
							if (points[p][1] <= triangles[i][1] && points[p][1]+.1 >= triangles[i][1]-ratio*(points[p][0] - leftV)) {
								points[p][2]++;
								//cout << points[p][0] << " " << points[p][1] << " T " << i << endl;
							}
						}
					}
				}
				
			}

			int numColours = colors.size();
			vector<int> counts(numColours, 0);
			for (int i = 0; i < points.size(); i++) {
				counts[points[i][2] % numColours]++;
			}

			for (int i = 0; i < colors.size() - 1; i++) {
				for (int r = i+1; r < colors.size(); r++) {
					if (colors[i]==colors[r]) {
						counts[i] += counts[r];
						counts.erase(counts.begin() + r);
						colors.erase(colors.begin() + r);
						r--;
					}
				}
			}

			for (int i = 0; i < colors.size(); i++) {
				cout << colors[i] << ":" << counts[i] << " ";
			}
			cout << endl;
		}
		catch (int e) {
			cout << "Test case had exception";
		}
	}

	system("pause");
}