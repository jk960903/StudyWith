import sys
global n
#https://www.acmicpc.net/problem/19623
def bin(index,value):
    s = index
    e = len(n)
    while s < e:
        m = (s+e)//2
        if n[m][0] < value:
            s = m+1
        else:
            e = m
    return s


if __name__ == '__main__':
    T = int(sys.stdin.readline())
    n = []
    for i in range(T):
        n.append(list(map(int,sys.stdin.readline().split())))
    n.sort(key = lambda x: x[0])
    C = [0 for i in range(len(n)+1)]
    C[-2] = n[-1][2]
    n.append([2**31,2**31,0])
    for i in range(len(n)-3,-1,-1):
        if n[i][1] > n[i+1][0]:
            index = bin(i,n[i][1])
            C[i] = max(C[index]+ n[i][2],C[i+1])
        else:
            C[i] = C[i+1] + n[i][2]
    print(C[0])