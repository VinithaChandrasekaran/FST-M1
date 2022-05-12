"""Calculator Test

Activity 21

Using pytest:

Create a new test file and write test to validate the following cases:

Sum of two numbers
Difference of two numbers
Product of two numbers
Quotient of two numbers"""
#  pytest Activity21.py  use this to run
import pytest

def test_Sum():
    n1=13
    n2=15
    sum = n1+n2
    assert sum == 28

def test_Difference():
    n1 =50
    n2 = 40
    diff = n1-n2
    assert diff == 10

# Multiplication test
def test_multiplication():
  
	# Initialize two numbers
	num1 = 5
	num2 = 20
    
	# Multiply them
	prod = num1 * num2
 
	# Assertion
	assert prod == 100

# Division test
def test_division():
  
	# Initialize two numbers
	num1 = 100
	num2 = 5
    
	# Divide them
	quot = num1 / num2
 
	# Assertion
	assert quot == 20

