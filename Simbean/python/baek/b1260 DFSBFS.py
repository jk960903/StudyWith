import sys
#https://www.acmicpc.net/problem/1260
def dfs(point,visit):
    for i in v[point-1]:
        if i in visit:
            pass
        else:
            visit.append(i)
            dfs(i,visit)
    return visit
def bfs(s,e,visit):
    #print(v)
    while True:
        #print(visit)
        for i in range(s,e):
            for j in v[visit[i]-1]:
                if j in visit:
                    pass
                else:
                    visit.append(j)
        if e == len(visit):
            break
        else:
            s = e
            e = len(visit)
    return visit
def init():
    global v,o
    v = []
    o = 0
    visit = [N[2]]
    for i in range(1000):
        v.append([])
    for i in range(N[1]):
        M = list(map(int, sys.stdin.readline().split()))
        v[M[0]-1].append(M[1])
        v[M[1]-1].append(M[0])
    for i in v:
        i.sort()
    visit = dfs(N[2],visit)
    for i in visit:
        print(i, end=' ')
    visit = [N[2]]
    visit= bfs(0,len(visit),visit)
    print()
    for i in visit:
        print(i, end=' ')
if __name__ == "__main__":
    d = []
    b = []
    N = list(map(int,sys.stdin.readline().split()))
    init()
