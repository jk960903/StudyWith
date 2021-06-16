import sys
#https://www.acmicpc.net/problem/1004
def make_circle(inform, prince, flower):
    x0, y0 = prince
    x1, y1 = flower
    ans = 0
    for xi, yi, r in inform:
        f1 = f2 = False
        if (x1 - xi) ** 2 + (y1 - yi) ** 2 <= r ** 2:
            f1 = True
        if (x0 - xi) ** 2 + (y0 - yi) ** 2 <= r ** 2:
            f2 = True
        ans += f1 ^ f2
    sys.stdout.write(str(ans) + '\n')
    return 1
if __name__ == "__main__":
    TC = int(sys.stdin.readline())
    for i in range(TC):
        x0, y0, x1, y1 = list(map(int,sys.stdin.readline().split()))
        planet = int(sys.stdin.readline())
        inform = []
        for i in range(planet):
            inform.append(list(map(int,sys.stdin.readline().split())))
        make_circle(inform, (x0, y0), (x1, y1))