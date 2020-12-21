# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
#https://programmers.co.kr/learn/courses/30/lessons/42576?language=python3
#https://programmers.co.kr/learn/courses/30/lessons/42576?language=python3
#https://programmers.co.kr/learn/courses/30/lessons/42576?language=python3
#https://programmers.co.kr/learn/courses/30/lessons/42576?language=python3
#https://programmers.co.kr/learn/courses/30/lessons/42576?language=python3

def makelist(name):
    # Use a breakpoint in the code line below to debug your script.
    name = name[1:-1]
    new = name.split(', ')
    return new
def pushDic(name):
    global dic
    dic = {}
    for i in name:
        try:
            dic[i] += 1
        except KeyError:
            dic[i] = 1
    return dic
def pipDic(name):
    for i in name:
        if (dic[i] == 1):
            del dic[i]
        else:
            dic[i] -= 1
    return dic
# Press the green button in the gutter to run the script.

if __name__ == '__main__':
    S1 = input()
    S2 = input()
    P = makelist(S1)
    M = makelist(S2)
    pushDic(P)
    pipDic(M)
    for k in dic.keys():
        print(k)
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
