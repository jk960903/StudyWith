#https://programmers.co.kr/learn/courses/30/lessons/60059
def coopy(a):
    t = [[0 for i in range(len(a))] for i in range(len(a))]
    for i in range(len(a)):
        for j in range(len(a)):
            t[i][j] = a[i][j]
    return t
def insp(a):
    for i in range(len(a)):
        for j in range(len(a)):
            if a[i][j] != 1:
                return 0
    return 1
def solution(key, lock):
    answer = False
    clone2 = lock.copy()
    clone = key[:][:]
    for i in range(4):
        arr = [[0 for i in range(len(key[0]))] for i in range(len(key[0]))]
        for j in range(len(key[0])):
            for k in range(len(key[0])):
                arr[j][len(key)-k-1] = clone[k][j]
        clone = arr[:][:]
        for j2 in range(-(len(lock)- 1), len(lock)+2):
            for k2 in range(-(len(lock)- 1), len(lock)+2):
                lc = coopy(clone2)
                for j in range(len(key)):
                    for k in range(len(key)):
                        if 0 <= j+j2 < len(lc) and 0 <= k + k2 < len(lc):
                            lc[j+j2][k+k2] += arr[j][k]
                c = insp(lc)
                if c == 1:
                    return True
    return answer
if __name__ == "__main__":
    print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]],	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]))