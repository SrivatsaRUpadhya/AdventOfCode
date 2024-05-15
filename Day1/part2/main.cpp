#include <algorithm>
#include <cctype>
#include <climits>
#include <cstdlib>
#include<iostream>
#include <unordered_map>
using namespace std;

int main(){
	unordered_map<string, char> num_map{
		{"one", '1'},
			{"two", '2'},
			{"three", '3'},
			{"four", '4'},
			{"five", '5'},
			{"six", '6'},
			{"seven", '7'},
			{"eight", '8'},
			{"nine", '9'}
	};

	int i, sum = 0;
	string inp;
	while(getline(cin,inp)){
		int pos_first_digit = INT_MAX, pos_first_al_num = INT_MAX;
		int pos_second_digit = INT_MIN, pos_second_al_num = INT_MIN;
		string f = "",l = "";
		i = 0;
		while(!isdigit(inp[i++]) && i <= inp.size());
		if(i <= inp.size()) {
			pos_first_digit = i - 1;
			f = inp[pos_first_digit];
		}

		for(auto s : num_map){
			int t = inp.find(s.first);
			if(t != -1){
				pos_first_al_num = min(pos_first_al_num, t);
				if(pos_first_al_num == t && pos_first_al_num < pos_first_digit) {
					f = s.second;
				}
			}
		}

		i = inp.size();
		while(!isdigit(inp[i--]) && i >= 0);
		if(i >= -1) {
			pos_second_digit = i + 1;
			l = inp[pos_second_digit];
		}
		for(auto s : num_map){
			int t = inp.rfind(s.first);
			if(t != -1){
				pos_second_al_num = max(pos_second_al_num, t);
				if(pos_second_al_num == t && pos_second_al_num > pos_second_digit) {
					l = s.second;
				}
			}
		}
		cout<<(f+l)<<endl;
		sum += atoi((f+l).c_str());
	}
	cout<<sum;
}
