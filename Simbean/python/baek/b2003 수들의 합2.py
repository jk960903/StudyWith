import sys
#https://www.acmicpc.net/problem/2003
if __name__ == "__main__":
    N = list(map(int,sys.stdin.readline().split()))
    M = list(map(int,sys.stdin.readline().split()))
    ans = 0
    count = 0
    Iindex = 0 #increase
    Dindex = 0 #decrease
    M.append(-1)
    while True:
        if M[Iindex] != -1:
            if ans < N[1]:
                ans += M[Iindex]
                Iindex += 1
        if M[Dindex] != -1:
            if M[Iindex] == -1 and ans < N[1]:
                break
            if ans > N[1]:
                ans -= M[Dindex]
                Dindex += 1
            elif ans == N[1]:
                count += 1
                ans -= M[Dindex]
                Dindex += 1
                if M[Iindex] == -1:
                    break
        if Iindex == Dindex == N[0]:
            break
        #print(Iindex,Dindex)
    print(count)

