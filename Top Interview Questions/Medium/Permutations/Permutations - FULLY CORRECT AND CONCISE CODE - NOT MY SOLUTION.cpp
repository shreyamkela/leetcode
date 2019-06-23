// Video to help understand code
// https://www.youtube.com/watch?v=AsxVqSKPo40
// https://www.youtube.com/watch?v=eUnNw2lR01M



#include <iostream>
#include <vector>
using namespace std;

void permutation(vector<vector<int> > &o, vector<int> nums, unsigned int i);

int main() {

vector<int> a{1};
vector<vector<int> > b;
unsigned int i=0;

permutation(b, a, i);
for(unsigned int i=0; i<b.size(); i++) {
	cout<<"{";
	for(unsigned int j=0; j<b[i].size(); j++) {
		if(j!=b[i].size()-1) cout<<b[i][j]<<",";
		else cout<<b[i][j];

	}
	cout<<"}"<<endl;
}


}

void permutation(vector<vector<int> > &o, vector<int> nums, unsigned int i) {
	if(i==nums.size()) { // base case
		o.push_back(nums);
		return;
	}

	for(unsigned int x=i;x<nums.size();x++){ //swap in the current position all the elements of the vector one by one, and then recurse in each case
		int temp;
		//swap from x with i then x with i+1 then x with i+2 and so on
		temp = nums[x];
		nums[x] = nums[i];
		nums[i] = temp;

		permutation(o, nums, i+1);

		//Backtracking
		temp = nums[x];
		nums[x] = nums[i];
		nums[i] = temp;
	}


}
