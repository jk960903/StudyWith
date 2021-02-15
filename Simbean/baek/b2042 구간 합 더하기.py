#https://www.acmicpc.net/problem/2042
import sys
import math
global arr
"""
def st(arr):
    d = math.log2(N[0])
    deep = 2 ** math.ceil(d)
    leng = 2 ** math.floor(d)
    deq = collections.deque([])
    L = 0
    R = math.ceil(len(arr)/2)
    if deep == leng:
        initarr = ['_' for i in range(deep)]
    else:
        initarr= ['_' for i in range(deep+leng)]
    #초기 위치 =================================
    for i in range(len(arr)-leng):
        if i%2 == 0:
            initarr[leng+L] = arr.popleft()
            initarr[leng+L+1] = arr.popleft()
            initarr[int(L/2)] = initarr[leng+L] + initarr[leng+L+1]
            L+=2
        else:
            initarr[leng+R] = arr.popleft()
            initarr[leng+R+1] = arr.popleft()
            initarr[int(R/2)] = initarr[leng+R] + initarr[leng+R+1]
            R+=2
    for i in range(leng):
        if initarr[i] != '_':
            continue
        else:
            initarr[i] = arr.popleft()
    #print(initarr)
    # 부분합===========================
    starr = []
    #print(starr)
    index = leng
    i = 0
    while index >= 2:
        if index <= i:
            i = 0
            initarr = starr[:] + initarr[:]
            starr = []
            index = math.floor(index/2)
        starr.append(initarr[i] + initarr[i+1])
        i += 2
    return initarr"""
def st(a,index,S,E):
    #print(a,arr,index,S,E)
    if S == E:
        arr[index] = a[S]
        return arr[index]
    else:
        arr[index] = st(a,index*2,S,int((S+E)/2)) + st(a,index*2 + 1,int((S+E)/2)+1,E)
        return arr[index]
def arrsearch(arr,index,L,R,S,E):
    if L > E or R < S:
        return 0
    if S >= L and E <= R:
        #print(L, R, S, E)
        return arr[index]
    return arrsearch(arr,index*2,L,R,S,int((S+E)/2)) + arrsearch(arr,index*2+1,L,R,int((S+E)/2)+1,E)

def arrchange(arr,ast,ain,index,S,E):
    if index < S or index > E:
        return arr
   # print(arr,ast,ain,index,S,E)
    arr[ast] -= ain
    if S != E:
        arrchange(arr,ast*2,ain,index,S,int((S+E)/2))
        arrchange(arr, ast * 2+1, ain, index,int((S + E) / 2)+1,E)

if __name__ == "__main__":
    N = list(map(int, sys.stdin.readline().split()))
    a = ['_']
    for i in range(N[0]):
        a.append(int(sys.stdin.readline()))
    a = a[:]
    d = math.log2(N[0])
    deep = 2 ** math.ceil(d)
    arr = ['_' for i in range(deep*2)]
    st(a,arr,1,1,N[0])
    #print(arr)
    for i in range(N[1]+N[2]):
        M = list(map(int, sys.stdin.readline().split()))
        if M[0] == 1:
            d = a[M[1]]-M[2]
            a[M[1]] = M[2]
            arrchange(arr,1,d,M[1],1,N[0])
        elif M[0] == 2:
            print(arrsearch(arr, 1, M[1], M[2], 1, N[0]))