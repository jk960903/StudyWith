#include <string>
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int i;
vector<vector<int>> v;
void print(vector<vector<int>> a) {
	int j;
	for (i = 0; i < a.size();i++) {
		for (j = 0; j < a[i].size(); j++) {
			cout << a[i][j];
		}
		cout << endl;
	}
}

void print(vector<int> a) {
	int j;
	for (i = 0; i < a.size();i++) {
			cout << a[i] << ' ';
		}
	cout << endl;
}
vector<int> dfs(int a, vector<int> visit) {
	int point;
	vector<int>::iterator it;
	for (it = v[a-1].begin();it < v[a-1].end();it++) {
		if (find(visit.begin(), visit.end(), *it) == visit.end()) {
			visit.push_back(*it);
			visit = dfs(*it, visit);
		}
	}
	return visit;
}
vector<int> bfs(int s, int e, vector<int>visit) {
	vector<int>::iterator it;
	while (1) {
		for (i = s; i < e; i++) {
			for (it = v[visit[i] - 1].begin(); it < v[visit[i] - 1].end();it++) {
				if (find(visit.begin(), visit.end(), *it) == visit.end()) {
					visit.push_back(*it);
				}
			}
		}
		if (e == visit.size()) {
			break;
		}
		else {
			s = e;
			e = visit.size();
		}
	}
	return visit;
}
int main() {
	int a, b, c;
	int d, e;
	cin >> a;
	cin >> b;
	v.assign(a, vector<int>(0, 0));
	cin >> c;
	vector<int> visit;
	visit.push_back(c);
	for (i = 0;i < b;i++) {
		cin >> d >> e;
		v[d-1].push_back(e);
		v[e-1].push_back(d);
	}
	for (i = 0; i < v.size(); i++) {
		sort(v[i].begin(), v[i].end());
	}
	//print(v);
	visit = dfs(c, visit);
	print(visit);
	visit.clear();
	visit.push_back(c);
	visit = bfs(0, visit.size(), visit);
	print(visit);
}