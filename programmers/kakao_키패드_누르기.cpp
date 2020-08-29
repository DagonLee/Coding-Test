#include <iostream>
#include <string>
#include <vector>
#include <cmath>
using namespace std;

string solution(vector<int> numbers, string hand) {
	string answer = "";
	int l_y;
	int l_x;
	int r_y;
	int r_x;

	l_y = 3;
	l_x = 0;
	r_y = 3;
	r_x = 2;	
	for(int i = 0; i < numbers.size(); i++)
	{
		if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7)
		{
			answer += 'L';
			l_y = (numbers[i] - 1) / 3;
			l_x = 0;
		}
		else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9)
		{
			answer += 'R';
			r_y = (numbers[i] - 3) / 3;
			r_x = 2;
		}
		else
		{
			int n_y = numbers[i];
			if(n_y == 0)
			{
				n_y = 3;
			}
			else
			{
				n_y = (n_y) / 3;
			}
			int n_x = 1;
			double l_dis = abs(l_y - n_y) + abs(l_x - n_x);
			double r_dis = abs(r_y - n_y) + abs(r_x - n_x);
			if(l_dis > r_dis)
			{
				answer += 'R';
				r_x = n_x;
				r_y = n_y;
			}
			else if(r_dis > l_dis)
			{
				answer += 'L';
				l_x = n_x;
				l_y = n_y;
			}
			else
			{
				if (hand == "left")
				{
					answer += 'L';
					l_x = n_x;
					l_y = n_y;
				}
				else if( hand == "right")
				{	
					answer += 'R';
					r_x = n_x;
					r_y = n_y;
				}
			}
		}
	}
	return answer;
}
int main()
{
	vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	string hand = "right";
	cout << solution(nums, hand);
}
