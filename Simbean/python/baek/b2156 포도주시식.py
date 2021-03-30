#https://www.acmicpc.net/problem/2156
import sys
if __name__ == "__main__":
    a = int(sys.stdin.readline())
    space = []
    for i in range(a):
        space.append(int(sys.stdin.readline()))
    ans = [0 for i in range(a)]
    ans[0] = space[0]
    if a > 1:
        ans[1] = space[0] + space[1]
    if a> 2:
        ans[2] = max(space[1]+ space[2], space[2]+ space[0],ans[1])
    if a> 3:
        for i in range(3, a):
            ans[i] = max(ans[i-1], ans[i - 2] + space[i], ans[i - 3] + space[i - 1] + space[i])
    print(ans[-1])