#https://www.acmicpc.net/problem/1854
import sys
import heapq
def popleft(L):
    return [L[1:],L[0]]
def d(space,start):
    costmap =[[] for i in range(len(space))]
    N = [0 for i in range(len(space))]
    costmap[start] = [0]
    N[start] = 0
    L = [(0,start)]
    while len(L) != 0:
        p = heapq.heappop(L)
        for i in space[p[1]]:
            node = i[0]
            cost = i[1] + p[0]
            if N[node] > cost or len(costmap[node]) <= B[2]:
                if len(costmap[node]) >= B[2] and N[node] > cost:
                    costmap[node].remove(N[node])
                    costmap[node].append(cost)
                    N[node] = max(costmap[node])
                    heapq.heappush(L, (cost, node))
                elif len(costmap[node]) < B[2]:
                    costmap[node].append(cost)
                    heapq.heappush(L,(cost,node))
                    N[node] = max(N[node],cost)
    for i in range(1,len(costmap)):
        try:
            if len(costmap[i]) < B[2]:
                print(-1)
            else:
                print(N[i])
        except IndexError:
            print(-1)
        except AttributeError:
            print(-1)
    return 1
if __name__ == "__main__":
    B = list(map(int,sys.stdin.readline().split()))
    space = [[] for i in range(B[0]+1)]
    for i in range(B[1]):
        M = list(map(int, sys.stdin.readline().split()))
        space[M[0]].append([M[1],M[2]])
    d(space,1)