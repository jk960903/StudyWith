#https://www.acmicpc.net/problem/2579
import sys
if __name__ == "__main__":
    a = int(sys.stdin.readline())
    space = []
    for i in range(a):
        space.append(int(sys.stdin.readline()))
    ans = [0 for i in range(a)]
    ans[0] = space[0]
    if a > 1:
        ans[1] = max(space[1]+ans[0],space[1])
    if a> 2:
        ans[2] = max(space[0]+space[2], space[1]+space[2])
    for i in range(3,a):
        ans[i] = max(ans[i-2]+space[i], ans[i-3]+space[i-1]+space[i])
    print(ans[a-1])