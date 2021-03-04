#https://www.acmicpc.net/problem/2206
import sys
import collections
def search(xin,yin,z):
    global q
    w1 = [-1, 0, 0, 1]
    w2 = [0, -1 , 1 ,0]
    if [xin, yin] == [N[0] - 1, N[1] - 1]:
        print(load[N[0]-1][N[1]-1][z])
        exit(0)
    for i in range(4):
        x = xin+w1[i]
        y = yin+w2[i]
        if 0 > x or x >= N[0] or y < 0 or y >= N[1]:
            continue
        #print("x,y = " + str(x) + ", " + str(y))
        if load[x][y][z]:
            continue
        if L[x][y] == '0':
            load[x][y][z] = load[xin][yin][z] + 1
            q.append([x,y,z])
        elif L[x][y] == '1' and z == 0:
            load[x][y][1] = load[xin][yin][z] + 1
            q.append([x, y, 1])
if __name__ == "__main__":
    global N,L,visit,q
    L = []
    clone = []
    q = collections.deque([[0,0,0]])
    N = list(map(int,sys.stdin.readline().split()))
    for i in range(N[0]):
        L.append(sys.stdin.readline().rstrip())
    load = [[[0,0] for _ in range(N[1])] for i in range(N[0])]
    load[0][0][0] = 1
    if L == ['0']:
        print(1)
    else:
        while len(q) > 0:
            [a,b,c] = q.popleft()
            search(a,b,c)
        print(-1)