from typing import List

def read_integers() -> List[int]:
    my_list = input().split(",")

    return list(map(lambda x: int(x), my_list))

# do not modify the code below
print(read_integers())
print(read_integers())
print(read_integers())
