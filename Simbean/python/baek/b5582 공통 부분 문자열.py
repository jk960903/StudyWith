# This is a sample Python script.
import sys
# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

#https://www.acmicpc.net/problem/5582
def LCS(N1,N2):
    ans = 0
    T = [[0 for i in range(len(N2)+1)] for j in range(len(N1)+ 1)]
    for i in range(1, len(N1)+1):
        for j in range(1,len(N2)+1):
            if N1[i-1] == N2[j-1]:
                T[i][j] = T[i-1][j-1]+1
                if T[i][j] > ans:
                    ans = T[i][j]
    return ans
# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    N1 = input()
    N2 = input()
    ans= LCS(N1,N2)
    print(ans)
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
