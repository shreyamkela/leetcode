//CODE ONLY CORRECT FOR HALF OF THE PERMUTATIONS. OTHER HALF PERMUTATIONS GET REPEATED
// For eg foe size = 4 there should be 4x3x2x1=25 total permutations but onle 12 found and other 12 are just the same as the first 12 


#include <iostream>
#include <vector>
using namespace std;

void permutation(vector<vector<int> > &o, vector<int> &nums, int &count);

int main() {

vector<int> a{1,2,3,4,5};
vector<vector<int> > b;
int count = a.size()-1;
permutation(b, a, count);


for(unsigned int i=0; i<b.size(); i++) {
	cout<<"{";
	for(unsigned int j=0; j<b[i].size(); j++) {
		if(j!=b[i].size()-1) cout<<b[i][j]<<",";
		else cout<<b[i][j];

	}
	cout<<"}"<<endl;
}


}

void permutation(vector<vector<int> > &o, vector<int> &nums, int &count) {

//	First find out the factorail of size of vector nums. This is the number of different permutations possible. Therefore these many times our loop has to run
//	Now we interchange 2 elements with each iteration.
//	For [6,7,8,9], start with selecting 1st element i.e 6 as base element and interchange 1st and 2nd = [7,6,8,9]
//	Now in 2nd iteration, interchange 1st which is now 7 and 3rd [8,6,7,9]
//	Now in 3rd iteration, interchange 1st which is now 8 and 4rth [9,6,7,8]
//	Now in 4th iteration, interchange 1st which is now 9 and 2nd again (as max size is 4) = [6,9,7,8]
//	Now in 5th iteration, interchange 1st which is now 6 and 3rd = [7,9,6,8]
//	This continues till (n-1)th iteration

	unsigned int fact=nums.size();
	int temp,k=1;
	for(int i = nums.size()-1; i>1; i--) fact*=i;
	cout << fact;
	o.push_back(nums); //We can push a vector into a vector of vector directly
	for(unsigned int j = 1; j<fact; j++) {
		cout<<j<<k<<endl;
		temp = nums[0];
		nums[0] = nums[k];
		nums[k] = temp;
		o.push_back(nums);
		k++;
		if(k==nums.size()) k=1; //when k> max size, make k start from 1 again
	}


}

