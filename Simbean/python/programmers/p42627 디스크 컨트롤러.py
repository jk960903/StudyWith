#https://programmers.co.kr/learn/courses/30/lessons/42627
def heapappend(arr, n, idx = None):
    VALUE = 0
    if idx == None:
        arr.append(n)
        idx = len(arr) - 1
    if idx == 0:
        return arr
    next_idx = (idx- 1)//2
    if arr[next_idx][VALUE] > arr[idx][VALUE]:
        arr[next_idx], arr[idx] = arr[idx], arr[next_idx]
        arr = heapappend(arr, n, next_idx)
    return arr

def heappop(arr, idx= None, throwNum = None):
    VALUE = 0
    if idx == None:
        point = arr[0]
        arr[0], arr[-1] = arr[-1], arr[0]
        arr.pop()
        if len(arr) <= 1:
            return point, arr
        idx = 0
    else:
        point = throwNum
    L_idx = (lambda x: (idx+1) * 2 - 1 if (idx+1) * 2 - 1 < len(arr) else idx)(idx)
    R_idx = (lambda x: (idx+1) * 2 if (idx+1) * 2 < len(arr) else idx)(idx)
    _, Temp_idx = min((arr[L_idx][VALUE], L_idx), (arr[R_idx][VALUE], R_idx),  key= lambda x : x[0])
    if arr[Temp_idx][VALUE] < arr[idx][VALUE]:
        arr[Temp_idx], arr[idx] = arr[idx], arr[Temp_idx]
        point, arr = heappop(arr, Temp_idx, point)
    return point, arr

def solution(jobs):
    answer = 0
    L = sorted(jobs, key = lambda x : x[0])
    index = 0
    q = []
    current_t = 0
    while True:
        while index < len(L):
            t, value = L[index]
            if t > current_t:
                if len(q) == 0 and index < len(L):
                    current_t = t
                else:
                    break
            q = heapappend(q, (value, t))
            index += 1
        x_value, x_t = q[0]
        if x_t <= current_t:
            (y_value, y_t), q = heappop(q)
            current_t += y_value
            answer += current_t - y_t
        if index >= len(L) and len(q) == 0:
            break
    return answer//len(L)
print(solution([[0, 3], [1, 9], [2, 6]]	))