#Write a recursive function to calculate the sum of numbers from 0 to 10


#recursive function to calculate the sum of numbers from 0 to 10
def SumofNumbers(number):
    if number:
        # Recursive function call
        return number + SumofNumbers(number-1)
    else:
        return 0

Result = SumofNumbers(10)
print(Result)