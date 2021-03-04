#include <iostream>
#include <string.h>
using namespace std;
//https://www.acmicpc.net/problem/2941
int b2941(char* str) {
	int cnt = 0;
	for (int i = 0; i < strlen(str); i++) {
		if (str[i] == 'c') {
			if (str[i + 1] == '=' || str[i + 1] == '-') {
				i += 1;
			}
		}
		else if (str[i] == 'd') {
			if (str[i + 1] == '-') {
				i += 1;
			}
			else if (str[i + 1] == 'z') {
				if (str[i + 2] == '=')
					i += 2;
			}
		}
		else if (str[i + 1] == 'j') {
			if (str[i] == 'n' || str[i] == 'l') {
				i += 1;
			}
		}
		else if (str[i + 1] == '=') {
			if (str[i] == 's' || str[i] == 'z') {
				i += 1;
			}
		}
		cnt += 1;
	}
	return cnt;
}
int main() {
	char str[105];
	fill(str, str + 105, '.');
	cin >> str;
	cout << b2941(str);
}