import sys
import collections
#https://www.acmicpc.net/problem/2606

if __name__ == "__main__":
    A = int(sys.stdin.readline())
    B = int(sys.stdin.readline())
    N = [[] for i in range(A+1)]
    visit= [0 for i in range(A+1)]
    visit[1] = 1
    for i in range(B):
        M = list(map(int,sys.stdin.readline().split()))
        N[M[0]].append(M[1])
        N[M[1]].append(M[0])
    q = collections.deque([1])
    cnt = 0
    while len(q) != 0:
        index = q.popleft()
        for i in N[index]:
            if visit[i] == 0:
                visit[i] = 1
                q.append(i)
                cnt += 1
    print(cnt)