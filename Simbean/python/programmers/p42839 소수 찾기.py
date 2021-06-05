#https://programmers.co.kr/learn/courses/30/lessons/42839
def sosu(n):
    Table = [0 for i in range(n)]
    Table[0] = Table[1] = 1
    for i in range(2,int(n**0.5)):
        if Table[i] == 0:
            for j in range(i*2,n,i):
                Table[j] = 1
    return Table

def dfs(n,r,numbers,index = None, word = None, num = None):
    if index == None:
        index = [0 for i in range(len(numbers))]
    if word == None:
        word = ''
    if num == None:
        num = []
    if r == 0:
        if word != '':
            num.append(int(word))
        return num
    for i in range(len(numbers)):
        if index[i] == 0:
            word += numbers[i]
            index[i] = 1
            num = dfs(n,r-1,numbers,index,word,num)
            word = word[:-1]
            index[i] = 0
    return num

def solution(numbers):
    answer = 0
    Table = sosu(10000001)
    ans = []
    for i in range(1,len(numbers)+1):
        num = dfs(len(numbers),i,numbers)
        ans += num
    ans = list(set(ans))
    for i in range(len(ans)):
        try:
            if Table[ans[i]] == 0:
                answer += 1
        except IndexError:
            pass
    return answer
if __name__ == '__main__':
    print(solution('1234'))
    print(solution('5555'))