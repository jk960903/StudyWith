#include <iostream>
#include <string>
#include <queue>
using namespace std;
//https://www.acmicpc.net/problem/16953
int main() {
	long A;
	long B;
	long S, E;
	long index;
	cin >> A >> B;
	queue<vector<int>> v;
	vector<int> v2;
	v2.push_back(1);
	v2.push_back(B);
	v.push(v2);
	while (1) {
		v2.clear();
		if (v.empty()) {
			cout << -1;
			break;
		}
		S = v.front()[1];
		index = v.front()[0];
		v.pop();
		if (S == A) {
			cout << index;
			break;
		}
		v2.push_back(index + 1);
		E = S / 2;
		if (S % 2 == 0 && E >= A) {
			v2.push_back(S / 2);
			v.push(v2);
			v2.pop_back();
		}
		E = int(S / 10);
		if (S % 10 == 1 && E >= A) {
			v2.push_back(int(S / 10));
			v.push(v2);
		}
		//cout<<(S) <<' ' << index<<endl;
	}
}