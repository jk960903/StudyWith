import sys
#https://www.acmicpc.net/problem/9095
if __name__ == "__main__":
    space = [0 for i in range(11)]
    space[0] = 1
    space[1] = 2
    space[2] = 4
    for i in range(3,11):
        space[i] = space[i-1] + space[i-2] + space[i-3]
    N = int(sys.stdin.readline())
    for i in range(N):
        print(space[int(sys.stdin.readline())-1])
