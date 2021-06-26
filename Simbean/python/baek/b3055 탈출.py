import sys
#https://www.acmicpc.net/problem/3055
ix = [0, 1, 0, -1]
jx = [1, 0, -1, 0]
def bfs(inform, space, visit):
    index = 0
    D, W, S = inform
    visit[S[0]][S[1]] = 1
    for i in W:
        visit[i[0]][i[1]] = 1
    q = [[S,W, 0]]
    while len(q) > 0:
        ij, water, count = q.pop(0)
        i, j = ij
        if i == D[0] and j == D[1]:
            return count
        Tempwater = []
        if water == []:
            pass
        else:
            for wi, wj in water:
                for i2, j2 in zip(ix, jx):
                    if 0 <= wi + i2 < R and 0 <= wj + j2 < C and visit[wi + i2][wj + j2] == 0:
                        if space[wi + i2][wj + j2] != 'X' and space[wi + i2][wj + j2] != 'D':
                            visit[wi + i2][wj + j2] = 1
                            Tempwater.append((wi + i2, wj + j2))
        if len(Tempwater) > 0:
            q.append([S, water + Tempwater, count])
        for i2, j2 in zip(ix, jx):
            if 0 <= i + i2 < R and 0 <= j + j2 < C and visit[i + i2][j + j2] == 0:
                if space[i + i2][j + j2] != 'X':
                    visit[i + i2][j + j2] = 1
                    q.append([(i + i2, j + j2), water,  count + 1])
    return -1
if __name__ == "__main__":
    R, C = list(map(int, sys.stdin.readline().split()))
    space = []
    ij_D = ij_S = (-1,-1)
    ij_W = []
    for i in range(R):
        N = list(sys.stdin.readline().rstrip())
        for idx, value in enumerate(N):
            if value == 'D':
                ij_D = (i, idx)
            elif value == '*':
                ij_W.append((i, idx))
            elif value == 'S':
                ij_S = (i, idx)
        space.append(N)
    answer = bfs([ij_D, ij_W, ij_S], space, [[0 for i in range(C)] for i in range(R)])
    if answer == -1:
        print('KAKTUS')
    else:
        print(answer)
