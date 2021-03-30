#https://www.acmicpc.net/problem/14003
#https://www.acmicpc.net/problem/14003
#https://www.acmicpc.net/problem/14003
#https://www.acmicpc.net/problem/14003
#https://www.acmicpc.net/problem/14003

#LIS 종결
import sys
def bin(L,value):
    s = 0
    e = len(L)
    while s < e:
        m = int((s+e)/2)
        if value > L[m]:
            s = m+1
        else:
            e = m
    return s
if __name__ == "__main__":
    a = int(sys.stdin.readline())
    space = list(map(int,sys.stdin.readline().split()))
    LIS = [space[0]]
    LISCOUNT = [0]
    Index = 0
    n1space = space[1:]
    for i in n1space:
        state = LIS[-1]
        if state < i:
            LIS.append(i)
            Index = len(LIS)-1
            LISCOUNT.append(Index)
        else:
            Index = bin(LIS,i)
            LIS[Index] = i
            LISCOUNT.append(Index)
    ans1 = len(LIS) #갯수 답
    ans2 = []
    point = ans1-1
    for i in range(len(LISCOUNT)-1,-1,-1):
        if LISCOUNT[i] == point:
            ans2.append(space[i])
            point -= 1
    print(ans1)
    for i in range(len(ans2)-1,-1,-1):
        print(ans2[i], end= ' ')