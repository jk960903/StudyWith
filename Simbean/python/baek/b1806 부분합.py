import sys
#https://www.acmicpc.net/problem/1806

if __name__ == "__main__":
    N = list(map(int,sys.stdin.readline().split()))
    M = list(map(int,sys.stdin.readline().split()))
    ans = 0
    length = N[0]+1
    Iindex = 0 #increase
    Dindex = 0 #decrease

    while True:
        try:
            if ans < N[1]:
                ans += M[Iindex]
                Iindex += 1
            elif ans >= N[1]:
                while ans >= N[1]:
                    ans -= M[Dindex]
                    Dindex += 1
                    #print(Iindex,Dindex,ans)
                length = min(length, Iindex-Dindex+1)
        except IndexError:
            while ans >= N[1]:
                ans -= M[Dindex]
                Dindex += 1
                #print(Iindex, Dindex, ans)
                length = min(length, Iindex - Dindex+1)
            break
        #print(Iindex,Dindex,ans)
    #print(length)
    if length == N[0] + 1:
        length = 0
    print(length)