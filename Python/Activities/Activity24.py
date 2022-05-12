""" Parameterization
Using pytest:

Create a new test file and do the following:

Create a fixture named wallet() that initializes the variable 'amount' with 0
Create a test with the following parameters:
earned	spent	expected
30	10	20
20	2	18

Write a test that performs the following scenario with the parameters
    My wallet initially has 0,
    I add {earned} units of cash to the wallet,
    I spend {spent} units of cash, and
    I should have {expected} units of cash remaining after the two transactions.
"""
# pytest Activity24.py use to run
import pytest

# Define a fixture for the wallet amount
@pytest.fixture
def wallet_amount():
   amount = 0
   return amount

# Set up the paremeterized test method
@pytest.mark.parametrize("earned, spent, expected", [ (30, 10, 20), (20, 2, 18), ])
def test_transactions(wallet_amount, earned, spent, expected):
	
    # Add money to your wallet
    wallet_amount += earned

    # Subtract amount from wallet
    wallet_amount -= spent

    # Assertion
    assert wallet_amount == expected