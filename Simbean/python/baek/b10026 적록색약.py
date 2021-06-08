import sys
#https://www.acmicpc.net/problem/10026
xi = [1, 0, -1, 0]
xj = [0, 1, 0, -1]
def transform_color_blind(space, visit):
    for i in range(len(space)):
        for j in range(len(space)):
            if space[i][j] == 'G':
                space[i][j] = 'R'
            visit[i][j] = 0
    return space, visit
def search_part(space, visit):
    q = []
    whole = []
    index = 0
    for idx1, _ in enumerate(space):
        for idx2, __ in enumerate(space):
            if visit[idx1][idx2] == 0:
                part = [[idx1, idx2]]
                visit[idx1][idx2] = len(whole) + 1
                q.append([idx1, idx2])
                while len(q) > index:
                    i, j = q[index]
                    for n in range(4):
                        ci = i + xi[n]
                        cj = j + xj[n]
                        if 0 <= ci < len(space) and 0 <= cj < len(space):
                            if visit[ci][cj] == 0:
                                if space[ci][cj] == space[i][j]:
                                    q.append([ci, cj])
                                    visit[ci][cj] = len(whole) + 1
                                    part.append([ci, cj])
                    index += 1
                whole.append(part)
    return len(whole)
if __name__ == '__main__':
    N = int(sys.stdin.readline())
    space = []
    visit = []
    for i in range(N):
        space.append(list(sys.stdin.readline().rstrip()))
        visit.append([0 for _ in range(N)])
    ans = search_part(space, visit)
    print(ans, end= ' ')
    space, visit = transform_color_blind(space, visit)
    ans = search_part(space, visit)
    print(ans)