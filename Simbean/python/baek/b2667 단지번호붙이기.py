import sys
import collections
#https://www.acmicpc.net/problem/2667
def dfs(i,j,cnt):
    i1 = [1,0,-1,0]
    j1 = [0,1,0,-1]
    for w in range(4):
        ii = i+i1[w]
        jj = j +j1[w]
        if 0<=ii< A and 0<=jj<A and visit[ii][jj] == 0 and N[ii][jj] == '1':
            cnt += 1
            visit[ii][jj] =1
            cnt = dfs(ii,jj,cnt)
    return cnt
if __name__ == "__main__":
    A = int(sys.stdin.readline())
    N = []
    ans = []
    visit= [[0 for _ in range(A)] for i in range(A)]
    for i in range(A):
        N.append(list(sys.stdin.readline().rstrip()))
    for i in range(A):
        for j in range(A):
            if N[i][j] == '1' and visit[i][j] == 0:
                visit[i][j] = 1
                a = dfs(i,j,1)
                ans.append(a)
    ans.sort()
    print(len(ans))
    for i in ans:
        print(i)

