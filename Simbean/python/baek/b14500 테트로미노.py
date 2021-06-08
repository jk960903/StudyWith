import sys
#https://www.acmicpc.net/problem/14500
def search_max(arr, shape):
    ans = 0
    for i in range(N):
        for j in range(M):
            cnt = 0
            try:
                for i2 in range(len(shape)):
                    for j2 in range(len(shape[i2])):
                        if shape[i2][j2] == 1:
                            cnt += arr[i + i2][j + j2]
                ans = max(cnt, ans)
            except IndexError:
                pass
    return ans
def tetromino_shape_1(arr):
    tetromino = [[1, 1],
                 [1, 1]]
    return search_max(arr,tetromino)

def tetromino_shape_2(arr):
    tetromino = [[1, 1, 1, 1]]
    ans = 0
    for i in range(2):
        tetromino = inv(tetromino, len(tetromino), len(tetromino[0]))
        ans = max(ans, search_max(arr,tetromino))
    return ans

def tetromino_shape_3(arr):
    tetromino = [[1, 0],
                 [1, 0],
                 [1, 1]]
    ans = 0
    for i in range(4):
        tetromino = inv(tetromino, len(tetromino), len(tetromino[0]))
        ans = max(ans, search_max(arr,tetromino))
    tetromino = mirror(tetromino, len(tetromino), len(tetromino[0]))
    for i in range(4):
        tetromino = inv(tetromino, len(tetromino), len(tetromino[0]))
        ans = max(ans, search_max(arr, tetromino))
    return ans

def tetromino_shape_4(arr):
    tetromino = [[1, 0],
                 [1, 1],
                 [0, 1]]
    ans = 0
    for i in range(4):
        tetromino = inv(tetromino, len(tetromino), len(tetromino[0]))
        ans = max(ans, search_max(arr,tetromino))
    tetromino = mirror(tetromino, len(tetromino), len(tetromino[0]))
    for i in range(4):
        tetromino = inv(tetromino, len(tetromino), len(tetromino[0]))
        ans = max(ans, search_max(arr, tetromino))
    return ans
def tetromino_shape_5(arr):
    tetromino = [[1, 0],
                 [1, 1],
                 [1, 0]]
    ans = 0
    for i in range(4):
        tetromino = inv(tetromino, len(tetromino), len(tetromino[0]))
        ans = max(ans, search_max(arr,tetromino))
    return ans
def inv(tetromino, n, m):
    space = [[0 for i in range(n)] for j in range(m)]
    for i in range(n):
        for j in range(m):
            space[m-1-j][i] = tetromino[i][j]
    return space
def mirror(tetromino, n, m):
    space = [[0 for i in range(m)] for j in range(n)]
    for i in range(n):
        for j in range(m):
            space[i][m-1-j] = tetromino[i][j]
    return space
def tetromino(arr):
    return max(tetromino_shape_1(arr),
               tetromino_shape_2(arr),
               tetromino_shape_3(arr),
               tetromino_shape_4(arr),
               tetromino_shape_5(arr))

if __name__ == '__main__':
    N, M = list(map(int,sys.stdin.readline().split()))
    arr = []
    for i in range(N):
        arr.append(list(map(int,sys.stdin.readline().split())))
    print(tetromino(arr))