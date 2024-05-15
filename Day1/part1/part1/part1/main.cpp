#include <cctype>
#include <cstdio>
#include <cstdlib>
#include<iostream>
#include <fstream>
#include <iterator>
#include <string>

using namespace std;

int main(){
	std::fstream input;
	std::fstream result;
	input.open("input.txt");
	result.open("result.txt");
	char c;
	char first = '\0', second='\0';
	while(input.get(c) && !input.eof()){
		if(c=='\n'){
			if(first != '\0' && second != '\0'){
				result << first << second << endl;
				first = '\0';
				second = '\0';
				continue;
			}
			if(second == '\0') {
				result << first<<first<< endl;
				first = '\0';
				second = '\0';
				continue;
			}
		}
		if(isdigit(c)){
			if(first == '\0'){
				first = c;
				continue;
			}
			second= c;
			continue;
		}
	}
	input.close();
	result.close();
	result.open("result.txt");
	int sum =0;
	string line;
	while(getline(result, line)){
		cout << line << endl;
		sum += atoi(line.c_str());
	}
	result.close();
	cout << sum <<endl;
	return 0;
}
