#https://www.acmicpc.net/problem/1932
import sys
if __name__ == "__main__":
    a = int(sys.stdin.readline())
    space = []
    for i in range(a):
        space.append(list(map(int,sys.stdin.readline().split())))
    if a== 1:
        answer = space[0][0]
    else:
        c = [space[0][0]]
        for i in range(1,len(space)):
            ans = []
            for j in range(len(space[i])):
                if i == 1:
                    ans.append(space[i][j]+c[0])
                else:
                    if j == 0:
                        ans.append(c[0]+space[i][j])
                    elif j == len(space[i])-1:
                        ans.append(c[j-1]+space[i][j])
                    else:
                        ans.append(max(c[j]+space[i][j],c[j-1]+space[i][j]))
            c = ans[:]
        answer = max(ans)
    print(answer)