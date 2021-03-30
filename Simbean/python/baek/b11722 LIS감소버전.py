#https://www.acmicpc.net/problem/11722
#LIS 감소버전

import sys
def bin(L,value):
    s = 0
    e = len(L)
    while s < e:
        p = L[int((s+e)/2)]
        if value < p:
            s = int((s+e)/2)+1
        else:
            e = int((s+e)/2)
    L[s] = value
    return L
if __name__ == "__main__":
    a = int(sys.stdin.readline())
    space = list(map(int,sys.stdin.readline().split()))
    LIS = [space[0]]
    space = space[1:]
    for i in space:
        state = LIS[-1]
        if state > i:
            LIS.append(i)
        else:
            LIS = bin(LIS,i)
    print(len(LIS))
