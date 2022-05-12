"""Given a list of numbers, return True if first and last number of a list is same."""

numbers = list(input("Enter a sequence of comma separated values: ").split(","))
sum = 0

First = numbers[0]
Last = numbers[-1]

if(First == Last):
    print(True)
else:
    print(False)
