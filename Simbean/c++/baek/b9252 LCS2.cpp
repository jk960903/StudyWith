#include <iostream>
#include <string.h>
using namespace std;
int space[1001][1001] = { 0, };
//https://www.acmicpc.net/problem/9252
int b9252(char* str1, char* str2) {
	for (int i = 1; i < strlen(str1) + 1; i++) {
		for (int j = 1; j < strlen(str2) + 1; j++) {
			if (space[i - 1][j] > space[i][j - 1]) {
				space[i][j] = space[i - 1][j];
			}
			else {
				space[i][j] = space[i][j - 1];
			}
			if (str1[i - 1] == str2[j - 1]) {
				space[i][j] = space[i - 1][j - 1] + 1;
			}
		}
	}
	return 0;
}
int main() {
	char str1[1001];
	char str2[1001];
	cin >> str1;
	cin >> str2;
	b9252(str1, str2);
	cout << space[strlen(str1)][strlen(str2)];
	string L = "";
	cout << endl;
	int a = strlen(str1);
	int b = strlen(str2);
	while (space[a][b] != 0)
	{
		if (space[a][b] == space[a][b - 1]) {
			b -= 1;
		}
		else if (space[a][b] == space[a - 1][b]) {
			a -= 1;
		}
		else if (space[a][b] - 1 == space[a - 1][b - 1]) {
			a -= 1;
			b -= 1;
			L = str1[a] + L;
		}
	}
	cout << L << endl;
}
