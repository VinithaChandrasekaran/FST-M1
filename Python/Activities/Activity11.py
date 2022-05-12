"""Create a Python dictionary that contains a bunch of fruits and their prices.
Write a program that checks if a certain fruit is available or not."""

fruit_dict =	{
  "apple": 100,
  "berry": 20,
  "pineApple": 40
}

fruitname = input("Which fruit do you want").lower()

if fruitname in fruit_dict:
    print(fruitname +" is avaliable")
else:
    print(fruitname+" is not avaliable")