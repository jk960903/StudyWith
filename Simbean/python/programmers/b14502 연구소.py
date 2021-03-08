import sys
import copy
import collections
#https://www.acmicpc.net/problem/14502
#pypy3 3668ms python 시간초과
def bfsbfs(i,q2):
    w1 = [1,0,-1,0]
    w2 = [0,1,0,-1]
    a = copy.deepcopy(space)
    visit = [[0 for i in range(N[1])] for j in range(N[0])]
    safe = 0
    a[int(i[0] / N[1])][i[0] % N[1]] = 1
    a[int(i[1] / N[1])][i[1] % N[1]] = 1
    a[int(i[2] / N[1])][i[2] % N[1]] = 1
    while len(q2) != 0:
        w = q2.popleft()
        for j in range(4):
            if 0 <= w[0]+w1[j] < N[0] and 0 <= w[1]+w2[j] < N[1]:
                if a[w[0]+w1[j]][w[1]+w2[j]] == 0:
                    q2.append([w[0]+w1[j],w[1]+w2[j]])
                    a[w[0] + w1[j]][w[1] + w2[j]] = 2
    for i in range(N[0]):
        for j in range(N[1]):
            if a[i][j] == 0 :
                safe += 1
    return safe
def b13460():
    max = 0
    bfs = []
    for i in range(N[0]*N[1]):
        if space[int(i/N[1])][i%N[1]] != 0:
            continue
        for j in range(N[0] * N[1]):
            if space[int(j / N[1])][j % N[1]] != 0 or i==j:
                continue
            for k in range(N[0] * N[1]):
                if space[int(k / N[1])][k % N[1]] != 0 or i == k or j == k:
                    continue
                bfs.append([i,j,k])
                a = deq.copy()
                p = bfsbfs([i,j,k],a)
                if p > max:
                    max = p
    print(max)
if __name__ == "__main__":
    global e,deq
    N = list(map(int,sys.stdin.readline().split()))
    deq = collections.deque([])
    space = []
    e = 0
    for i in range(N[0]):
        a = list(map(int,sys.stdin.readline().split()))
        for j in range(len(a)):
            if a[j] == 2:
                deq.append([i,j])
            elif a[j] == 0:
                e += 1
        space.append(a)
    b13460()