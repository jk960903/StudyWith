import sys
import copy
#https://www.acmicpc.net/problem/17135
ry = [0,1,0]
rx = [-1,0,1]
def makerange(y,x,d):
    ans = []
    for i in range(x):
        q = [[0, i]]
        s = [[0 for j in range(x)] for k in range(y)]
        index = 0
        while len(q) != index:
            s[0][i] = 1
            for j in range(3):
                if abs(0-q[index][0]) + abs(i-q[index][1]) < d:
                    if 0 <= rx[j]+q[index][1] < x and 0 <= q[index][0]+ry[j] < y:
                        if s[q[index][0] + ry[j]][q[index][1]+rx[j]] == 0:
                            q.append([q[index][0] + ry[j],q[index][1]+rx[j]])
                            s[q[index][0] + ry[j]][q[index][1] + rx[j]] = 1
            index += 1
        ans.append(q)
    return ans
if __name__ == "__main__":
    ans = 0
    n = list(map(int,sys.stdin.readline().split()))
    M = []
    d = n[2] - 1
    R = makerange(n[0],n[1],d)
    for i in range(n[0]):
        M.append(list(map(int,sys.stdin.readline().split())))
    for i in range(n[1]-2):
        for j in range(i+1,n[1]):
            for k in range(j+1,n[1]):
                cnt = 0
                space = copy.deepcopy(M)
                for y in range(n[0]-1,-1,-1): #돌때마다 적 전진
                    clear = []
                    index = 0
                    for i2 in R[i]:
                        if 0 <= y-i2[0]:
                            if space[y-i2[0]][i2[1]] != 0:
                                clear.append([y - i2[0], i2[1]])
                                break
                    for j2 in R[j]:
                        if 0 <= y - j2[0]:
                            if space[y-j2[0]][j2[1]] != 0:
                                clear.append([y - j2[0], j2[1]])
                                break
                    for k2 in R[k]:
                        if 0 <= y - k2[0]:
                            if space[y-k2[0]][k2[1]] != 0:
                                clear.append([y - k2[0], k2[1]])
                                break
                    for p in clear:
                        if space[p[0]][p[1]] == 1:
                            cnt += 1
                            space[p[0]][p[1]] = 0
                    if cnt > ans:
                        ans = cnt
    print(ans)


