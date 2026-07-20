def concatenate(s1: str, s2: str) -> str:
    concat = s1 + s2
    return concat if len(concat) <= 10 else "Too long!"



# do not modify below this line
print(concatenate("He", "llo"))
print(concatenate("Hello ", "world!"))
print(concatenate("Length", "of10"))
