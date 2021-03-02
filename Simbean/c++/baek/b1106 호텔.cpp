#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

//https://www.acmicpc.net/problem/1106

int main(void) {
	int p, c;
	int st, cap;
	int i;
	vector<vector<int>> v;
	vector<int> m;
	cin >> p >> c;
	int* answer = (int*)malloc(sizeof(int) * 2000);
	fill(answer, answer + 2000, 1000*1000);
	answer[0] = 0;
	for (i = 0; i < c; i++) {
		cin >> st >> cap;
		m.push_back(st);
		m.push_back(cap);
		v.push_back(m);
		m.clear();
	}
	for (int j = 0; j < v.size(); j++) {
		for(i = v[j][1]; i<2000;i++){
			if (answer[i - v[j][1]] + v[j][0] < answer[i]) {
				answer[i] = answer[i - v[j][1]] + v[j][0];
			}
		}
	}
	int in = 1000 * 1000;
	for (i = p; i < 2000; i++) {
		in = min(answer[i], in);
	}
	cout << in << endl;
	free(answer);
}