import sys
#https://www.acmicpc.net/problem/10972

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    M = list(map(int,sys.stdin.readline().split()))
    for i in range(N-1,0,-1):
        if M[i] > M[i-1]:
            s = i-1
            break
    try:
        for i in range(N-1,s,-1):
            if M[s] < M[i]:
                temp = M[i]
                M[i] = M[s]
                M[s] = temp
                break
        p = M[s+1:]
        p.sort()
        M = M[:s+1] + p
        for i in M:
            print(i,end=' ')
    except NameError:
        print(-1)