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
	int target_r = 12, target_g = 13, target_b = 14;
	int game_id_sum = 0;
	while(getline(cin,s)){
		// get the game id
		int pos_colon = s.find_first_of(':');
		int j = pos_colon - 1;
		while(isdigit(s[j])) j--;
		int game_id = atoi(s.substr(j + 1,pos_colon - 1 - j).c_str());

		//get the sets
		s = s.substr(pos_colon + 1);
		bool is_Ok = true;

		// check if each of the sets is valid
		while(s != ""){
			string set = get_next_set(s);
			int pos;
			if((pos = set.find("red")) && pos != -1){
				int j = pos - 2;
				while(isdigit(set[j])) j--;
				int red_count = atoi(set.substr(j + 1,pos-2 - j).c_str());
				//cout<<"red_count:"<<red_count<<endl;
				if(red_count > target_r){
					is_Ok = false;
					break;
				}
			}
			if((pos = set.find("green")) && pos != -1){
				int j = pos - 2;
				while(isdigit(set[j])) j--;
				int green_count = atoi(set.substr(j + 1,pos-2 - j).c_str());
				//cout<<"green_count:"<<green_count<<endl;
				if(green_count > target_g){
					is_Ok = false;
					break;
				}
			}
			if((pos = set.find("blue")) && pos != -1){
				int j = pos - 2;
				while(isdigit(set[j])) j--;
				int blue_count = atoi(set.substr(j + 1,pos-2 - j).c_str());
				//cout<<"blue_count:"<<blue_count<<endl;
				if(blue_count > target_b){
					is_Ok = false;
					break;
				}
			}

			// if the set is the last set, then break
			if(set == s) s = "";
		}
		if(is_Ok){
			game_id_sum += game_id;
		}
	}
	cout<<game_id_sum;
}
