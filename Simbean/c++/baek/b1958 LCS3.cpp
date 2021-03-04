#include <iostream>
#include <string.h>
using namespace std;
int space[101][101][101] = { 0, };
//https://www.acmicpc.net/problem/1958
int b1958(char* str1, char* str2, char* str3) {
	int max;
	for (int i = 1; i < strlen(str1) + 1; i++) {
		for (int j = 1; j < strlen(str2) + 1; j++) {
			for (int k = 1; k < strlen(str3) + 1; k++) {
				max = 0;
				if (str1[i - 1] == str2[j - 1] && str2[j - 1] == str3[k - 1]) {
					space[i][j][k] = space[i - 1][j - 1][k - 1] + 1;
				}
				else {
					if (max < space[i - 1][j][k]) max = space[i - 1][j][k];
					if (max < space[i][j - 1][k]) max = space[i][j - 1][k];
					if (max < space[i][j][k - 1]) max = space[i][j][k - 1];
					space[i][j][k] = max;
				}
			}
		}
	}
	return 0;
}
int main() {
	char str1[101];
	char str2[101];
	char str3[101];
	cin >> str1;
	cin >> str2;
	cin >> str3;
	b1958(str1, str2, str3);
	cout << space[strlen(str1)][strlen(str2)][strlen(str3)];
}