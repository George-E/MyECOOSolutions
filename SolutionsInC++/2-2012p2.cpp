#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include <regex>
using namespace std;


int main()
{
	/*while (true) {
		regex e("[a-t[^r-t]]");//, regex_constants::icase);
		//cout << ((regex_match(str, e)) ? "match" : "noMatch") << endl;
		//regex_seach(str, e);
		string str; cin >> str;
		//e.assign("e");
		cout << ((regex_match(str, e)) ? "match" : "noMatch") << endl;

	}*/
	/*	// regex_replace example
		#include <iostream>
		#include <string>
		#include <regex>
		#include <iterator>

		int main ()
		{
		std::string s ("there is a subsequence in the string\n");
		std::regex e ("\\b(sub)([^ ]*)");   // matches words beginning by "sub"

		// using string/c-string (3) version:
		std::cout << std::regex_replace (s,e,"sub-$2");

		// using range/c-string (6) version:
		std::string result;
		std::regex_replace (std::back_inserter(result), s.begin(), s.end(), e, "$2");
		std::cout << result;

		// with flags:
		std::cout << std::regex_replace (s,e,"$1 and $2",std::regex_constants::format_no_copy);
		std::cout << std::endl;

		return 0;
		}

		Output:
		there is a sub-sequence in the string
		there is a sequence in the string
		sub and sequence
		////////////////////////

		// match_results::position
		// * using smatch, a standard alias of match_results<string::iterator>
		#include <iostream>
		#include <string>
		#include <regex>


		int main ()
		{
		std::string s ("test subject");
		std::smatch m;
		std::regex e ("(sub)(.*)");

		std::regex_search ( s, m, e );

		for (unsigned i=0; i<m.size(); ++i) {
		std::cout << "match " << i << " (" << m[i] << ") ";
		std::cout << "at position " << m.position(i) << std::endl;
		}

		return 0;
		}

		Output:

		match 0 (subject) at position 5
		match 1 (sub) at position 5
		match 2 (ject) at position 8


	}*/
	ifstream infile;
	infile.open("DATA20.txt"); //change
	for (int testcase = 0; testcase < 3; testcase++) {//change
		try {
			string pass; getline(infile, pass);
			int score = 0;
			//length
			score += 4 * pass.length();
			//basic requirements
			int count = 0;
			regex e("[a-z]");
			if (regex_search(pass, e)) count++;
			e.assign("[A-Z]");
			if (regex_search(pass, e)) count++;
			e.assign("[:digit:]");
			if (regex_search(pass, e)) count++;
			e.assign("[^[:alnum:]]");
			if (regex_search(pass, e)) count ++ ;
			if (count >= 3) {
				if (pass.length() >= 8) score += 2;
				score += count * 2;
			}
			//Upper Case
			string result;
			e.assign("[A-Z]"); 
			regex_replace(back_inserter(result), pass.begin(), pass.end(), e, "");
			if (pass.length() > result.length()) {
				score += (result.length()) * 2;
			}
			//lower case
			result = "";
			e.assign("[a-z]");
			regex_replace(back_inserter(result), pass.begin(), pass.end(), e, "");
			if (pass.length() > result.length()) {
				score += ( result.length()) * 2;
			}
			//digits
			result = "";
			e.assign("[:digits:]");
			regex_replace(back_inserter(result), pass.begin(), pass.end(), e, "");
			if (pass.length() > result.length()) {
				score += 4*(pass.length() - result.length());
			}
			//symbols
			result = "";
			e.assign("[^[:alnum:]]");
			regex_replace(back_inserter(result), pass.begin(), pass.end(), e, "");
			score += 6 * (pass.length() - result.length());
			//middle digit and symbols
			e.assign("[^[:alpha:]]");
			for (int i = 1; i < pass.length()-1; i++) {
				if (regex_match(pass.substr(i, 1), e)) score += 2;
			}
			//only letters
			result = "";
			e.assign("[a-zA-Z]");
			regex_replace(back_inserter(result), pass.begin(), pass.end(), e, "");
			if (result.length()==0) {
				score -= pass.length();
			}
			//only digits
			result = "";
			e.assign("[0-9]");
			regex_replace(back_inserter(result), pass.begin(), pass.end(), e, "");
			if (result.length()==0) {
				score -= pass.length();
			}
			//consecutive lower, upper, or digit + seqential letters and sequential digits
			regex l("[a-z]");
			regex u("[A-Z]");
			regex d("[0-9]");
			int type = 0; int chain = 0;
			int longest1 = 0, longest2 = 0;
			for (int i = 0; i < pass.length(); i++) {
				int temptype = -1;
				if (regex_match(pass.substr(i, 1), l)) temptype = 1;
				else if (regex_match(pass.substr(i, 1), u)) temptype = 2;
				else if (regex_match(pass.substr(i, 1), d)) temptype = 3;
				if (temptype == type) {
					chain++;
				}
				else {
					if (chain>1) score -= 2 * (chain - 1);
					if (type < 3 && chain > longest1) {
						longest1 = chain;
					}
					if (type == 3 && chain > longest2) {
						longest2 = chain;
					}
					type = temptype;
					chain = 1;
				}
			}
			if (chain>1) score -= 2 * (chain - 1);
			if (type < 3 && chain > longest1) {
				longest1 = chain;
			}
			if (type == 3 && chain > longest2) {
				longest2 = chain;
			}
			if (longest1 > 2)
				score -= 3 * (longest1 - 2);
			if (longest2 > 2)
				score -= 3 * (longest2 - 2);
			
			if (score > 100) score = 100;
			if (score < 0) score = 0;
			if (score < 21)
				cout << "Very Weak (score = " << score << ")" << endl;
			else if (score < 21)
				cout << "Very Weak (score = " << score << ")" << endl;
			else if (score < 41)
				cout << "Weak (score = " << score << ")" << endl;
			else if (score < 61)
				cout << "Good (score = " << score << ")" << endl;
			else if (score < 81)
				cout << "Strong (score = " << score << ")" << endl;
			else 
				cout << "Very Strong (score = " << score << ")" << endl;
		}
		catch (...) {
			cout << "Test case had exception";
		}
	}

	std::system("pause");
}