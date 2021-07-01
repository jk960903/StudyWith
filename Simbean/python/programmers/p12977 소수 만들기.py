#https://programmers.co.kr/learn/courses/30/lessons/12977
numarray = []
def sosu(n):
    for i in range(2, int(len(n) ** 0.5) + 1):
        if n[i] == 1:
            for j in range(i * 2, len(n), i):
                n[j] = 0
    return n

def com_dfs(n, arr, r = None, store = None, index = None): #conbination
    if r == None:
        r = 0
    if index == None:
        index = 0
    if store == None:
        store = 0
    if r == n:
        numarray.append(store)
        return store
    for i in range(index, len(arr)):
        store += arr[i]
        store = com_dfs(n, arr, r + 1, store, i+1)
        store -= arr[i]
    return store

def solution(nums):
    answer = 0
    n = [1 for i in range(100000)]
    t = len(nums)
    com_dfs(3, nums)
    n = sosu(n)
    for i in numarray:
        answer += n[i]
    return answer