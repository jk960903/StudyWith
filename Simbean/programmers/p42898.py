def GCD(a,b):
    if a%b == 0:
        return b
    else:
        return -(a%b)
def solution(arr):
    answer = 1
    min = 1
    arr.sort()
    c1 = arr[0]
    temp = 0
    for i in range(0,len(arr)-1):
        c2 = arr[i+1]
        while c1 >= 0:
            if c1 > c2:
                Temp = GCD(c1,c2)
                c1 = c2
                c2 = Temp
            else:
                Temp = GCD(c2,c1)
                c1 = c2
                c2 = Temp
    return answer
if __name__ == "__main__":
