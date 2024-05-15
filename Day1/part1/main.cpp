#include <cctype>
#include <cstdlib>
#include<iostream>
#include <string>
using namespace std;

int main(){
	string s;
	int sum = 0;
	while(getline(cin,s)){
		char first_digit = '0';
		char second_digit = '0';
		for(char c : s){
			if(isdigit(c)){
				first_digit = c;
				break;
			}
		}
		for(int i = s.size(); i > 0; i--){
			if(isdigit(s[i])){
				second_digit = s[i];
				break;
			}
		}

		cout<<atoi(string({first_digit,second_digit}).c_str())<<endl;
		sum += atoi(string({first_digit,second_digit}).c_str());
	}
	cout<<sum;
}
