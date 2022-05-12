"""Write a Python program to calculate the sum of all the elements in a list.

Bonus points if you can make the user enter their own list."""

# creating an empty list
lst = []

# number of elements as input
n = int(input("Enter number of elements : "))
print("Enter the numbers")
# iterating till the range
for i in range(0, n):
	ele = int(input())
	lst.append(ele) # adding the element
    
#printing the list
print(lst)
sum = 0
for i in range(0,n):
    sum += lst[i]
txt = "Sum of the numbers is: {}"
print(txt.format(sum))