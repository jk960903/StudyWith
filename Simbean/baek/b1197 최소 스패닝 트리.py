#https://www.acmicpc.net/problem/1197
#https://www.acmicpc.net/problem/1197
import sys
def b1197(E):
    E.sort(key= lambda x : x[2])
    sum = 0
    V=[1000001 for i in range(N[0])]
    dic = {}
    M = 0
    for vector in E:
        i = vector[0]-1
        j = vector[1]-1
        if i == j:
            continue
        if V[i] == 1000001 and V[j] == 1000001:
            V[i] = M
            V[j] = M
            dic[M] = [i]
            dic[M].append(j)
            M += 1
            sum += vector[2]
        elif V[i] != 1000001 and V[j] !=1000001:
            if V[i] != V[j]:
                clone = V[j]
                for k in dic[V[j]]:
                    V[k] = V[i]
                    dic[V[i]].append(k)
                del dic[clone]
                sum += vector[2]
            else:
                pass
        else:
            if V[i] == 1000001:
                V[i] = V[j]
                dic[V[j]].append(i)
                sum += vector[2]
            elif V[j] == 1000001:
                V[j] = V[i]
                dic[V[i]].append(j)
                sum += vector[2]
    print(sum)
if __name__ == "__main__":
    N = list(map(int, sys.stdin.readline().split()))
    E = []
    for i in range(N[1]):
        M = list(map(int, sys.stdin.readline().split()))
        E.append(M)
    b1197(E)