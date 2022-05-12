""""
Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5
Bonus points if you can make the user enter their own tuple."""

T1 = tuple(input("Enter numbers by separating with comma").split(","))
print("Numbers that are divisible by 5 are:")
for value in T1:
    if(int(value)%5) == 0:
        print(int(value))