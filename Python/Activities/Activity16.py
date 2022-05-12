"""Create a car class with the following details:

Properties: manufacturer, model, make, transmission, color

Methods: accelerate(), stop()

accelerate() should print "{Manufacturer} {Model} is moving"

stop() should print "{Manufacturer} {Model} has stopped"

 

Using this car class, create 3 different car objects."""


class Car:

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer =manufacturer
        self.model =model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer+" "+ self.model+" is moving")

    def stop(self):
        print(self.manufacturer+" "+ self.model+" has stopped")
    
c1 = Car("Toyota", "Corolla", "2015", "Manual", "White")
c2 = Car("Maruti", "800", "2013", "Manual", "Red")
c3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")

c1.accelerate()
c1.stop()

        