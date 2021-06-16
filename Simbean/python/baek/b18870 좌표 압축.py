import sys
#https://www.acmicpc.net/problem/18870
if __name__ == "__main__":
    N = int(sys.stdin.readline())
    M = sys.stdin.readline().split()
    dic_M = list(set(map(int,M)))
    list_M = list(map(int,M))
    dic_M.sort()
    dic_index_M = {}
    for index, value in enumerate(dic_M):
        dic_index_M[value] = index
    for i in list_M:
        sys.stdout.write(str(dic_index_M[i]) + ' ')