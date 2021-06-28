#https://programmers.co.kr/learn/courses/30/lessons/64064
def search_banned(user_id, banned_id):
    hash_table = [[] for i in range(len(banned_id))]
    for idx, i in enumerate(banned_id):
        for idx2, j in enumerate(user_id):
            flag = 0
            if len(i) != len(j):
                continue
            for c_i, c_j in zip(i, j):
                if c_i != '*':
                    if c_i != c_j:
                        flag = 1
            if flag == 0:
                hash_table[idx].append(idx2)
    return hash_table
def dfs(arr, b = None, idx = None,
        cnt = None, q = None, qq = None):
    if q == None:
        q = []
    if cnt == None:
        cnt = 0
    if b == None:
        b = 0
    if idx == None:
        idx = 0
    if qq == None:
        qq = []
    if idx == len(arr):
        Temp = q[:]
        Temp.sort()
        qq.append(tuple(Temp))
        return qq
    for i in arr[idx]:
        if b & (1 << i) == 0:
            q.append(i)
            b = b | (1 << i)
            cnt = dfs(arr, b, idx + 1, cnt, q, qq)
            t = q.pop()
            b = b & ~(1 << t)
    return qq
def solution(user_id, banned_id):
    answer = 0
    n = search_banned(user_id, banned_id)
    qq = dfs(n)
    answer = len(set(qq))
    return answer