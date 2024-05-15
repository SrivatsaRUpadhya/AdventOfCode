#include <cstdlib>
#include<iostream>
using namespace std;

// helper to get the next set
string get_next_set(string &str){
	int pos_semi_colon = str.find_first_of(';');
	if(pos_semi_colon != -1){
		string t = str.substr(0,pos_semi_colon);
		str = str.substr(pos_semi_colon + 1);
		return t;
	}
	else return str; 
}

int main(){
	string s;
	int game_id_sum = 0;
	while(getline(cin,s)){
		int min_r = 0, min_g = 0, min_b = 0;
		int powerset = 0;
		// get the game id
		int pos_colon = s.find_first_of(':');
		int j = pos_colon - 1;
		while(isdigit(s[j])) j--;
		int game_id = atoi(s.substr(j + 1,pos_colon - 1 - j).c_str());

		//get the sets
		s = s.substr(pos_colon + 1);

		// check if each of the sets is valid
		while(s != ""){
			string set = get_next_set(s);
			int pos;
			if((pos = set.find("red")) && pos != -1){
				int j = pos - 2;
				while(isdigit(set[j])) j--;
				int red_count = atoi(set.substr(j + 1,pos-2 - j).c_str());
				//cout<<"red_count:"<<red_count<<endl;
				min_r = max(min_r, red_count);
			}
			if((pos = set.find("green")) && pos != -1){
				int j = pos - 2;
				while(isdigit(set[j])) j--;
				int green_count = atoi(set.substr(j + 1,pos-2 - j).c_str());
				//cout<<"green_count:"<<green_count<<endl;
				min_g = max(min_g, green_count);
			}
			if((pos = set.find("blue")) && pos != -1){
				int j = pos - 2;
				while(isdigit(set[j])) j--;
				int blue_count = atoi(set.substr(j + 1,pos-2 - j).c_str());
				//cout<<"blue_count:"<<blue_count<<endl;
				min_b = max(min_b, blue_count);
			}

			// if the set is the last set, then break
			if(set == s) s = "";
		}
		powerset = min_r * min_g * min_b;
		cout<<powerset<<endl;
		game_id_sum += powerset;

	}
	cout<<game_id_sum;
}
