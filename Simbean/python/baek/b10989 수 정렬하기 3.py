#https://www.acmicpc.net/problem/10989
import sys

if __name__ == "__main__":
    TC = int(sys.stdin.readline())
    Table = [0 for i in range(10001)]
    for i in range(TC):
        N = int(sys.stdin.readline())
        Table[N] += 1
    for i in range(10001):
        while Table[i] > 0 :
            sys.stdout.write(str(i)+ '\n')
            Table[i] -= 1