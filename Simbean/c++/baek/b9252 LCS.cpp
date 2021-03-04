#include <iostream>
#include <string.h>
using namespace std;
int space[1001][1001] = { 0, };
//https://www.acmicpc.net/problem/9251
int b9251(char* str1, char* str2) {
	int flag = 0;
	int p = 0;
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
		flag = 0;
	}
	//for (int i = 0; i < strlen(str1)+1; i++) {
	//	for (int j = 0; j < strlen(str2)+1; j++) {
	//		cout << space[i][j];
	//	}
	//	cout << endl;
	//}
	return 0;
}
int main() {
	char str1[1001];
	char str2[1001];
	cin >> str1;
	cin >> str2;
	b9251(str1, str2);
	cout << space[strlen(str1)][strlen(str2)];
}