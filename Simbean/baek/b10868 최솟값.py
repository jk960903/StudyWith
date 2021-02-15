#https://www.acmicpc.net/problem/10868
import sys
import math

global arr
def st(a,index,S,E):
    #print(a,arr,index,S,E)
    if S == E:
        arr[index] = a[S]
        return arr[index]
    else:
        arr[index] = st(a,index*2 + 1,int((S+E)/2)+1,E)
        clone = st(a,index*2,S,int((S+E)/2))
        if clone < arr[index]:
            arr[index] = clone
        return arr[index]
def arrsearch(index,L,R,S,E):
    global minL
    if L > E or R < S:
        return 0
    if S >= L and E <= R:
        #print(L, R, S, E,index)
        if minL > arr[index]:
            minL = arr[index]
    else:
        arrsearch(index*2,L,R,S,int((S+E)/2))
        arrsearch(index*2+1,L,R,int((S+E)/2)+1,E)
if __name__ == "__main__":
    global minL,arr
    N = list(map(int, sys.stdin.readline().split()))
    a = ['_']
    for i in range(N[0]):
        a.append(int(sys.stdin.readline()))
    a = a[:]
    d = math.log2(N[0])
    deep = 2 ** math.ceil(d)
    arr = ['_' for i in range(deep*2)]
    st(a,1,1,N[0])
    for i in range(N[1]):
        minL = 10000000001
        M = list(map(int,sys.stdin.readline().split()))
        #print(M)
        arrsearch(1,M[0],M[1],1,N[0])
        print(minL)