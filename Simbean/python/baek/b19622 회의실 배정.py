#https://www.acmicpc.net/problem/19623
#https://www.acmicpc.net/problem/19622
import sys
if __name__ == '__main__':
    T = int(sys.stdin.readline())
    n = []
    ans = 0
    for i in range(T):
        n.append(list(map(int,sys.stdin.readline().split())))
    n.sort(key = lambda x: (x[1],x[0]))
    C = [0 for i in range(T+2)]
    C[0] = 0
    C[1] = 0
    C[2] = n[0][2]
    for i in range(1,len(n)):
        K = max(C[i],C[i-1])+n[i][2]
        C[i+2] = max(K,C[i+1])
    print(C[-1])
# See PyCharm help at https://www.jetbrains.com/help/pycharm/