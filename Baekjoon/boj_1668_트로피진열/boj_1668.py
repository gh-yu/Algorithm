n = int(input())

trophys = [int(input()) for _ in range(n)]

def count_visible_trophy(trophys):
    visible_count = 0
    max = 0
    for i in range(len(trophys)):
        if max < trophys[i]:
            max = trophys[i]
            visible_count += 1

    return visible_count

print(count_visible_trophy(trophys))
trophys.reverse()
print(count_visible_trophy(trophys))                

