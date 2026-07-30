class SuperHero:
    def __init__(self, name: str, health: int, power_level: int):
        self.name = name
        self.__health = health
        self.__power_level = power_level

    @property
    def health(self): 
        return self.__health

    @property
    def power_level(self): 
        return self.__power_level

    @health.setter
    def health(self, new_health):
        if 0 <= new_health <= 100:
            self.__health = new_health
        else:
            print("You can't set the health to more than 100" if new_health > 100 else "You can't set the health to less than 0")
    
    @power_level.setter
    def power_level(self, new_power_level):
        if 1 <= new_power_level <= 10:
            self.__power_level = new_power_level
        else:
            print("You can't set the power level to more than 10" if new_power_level > 10 else "You can't set the power level to less than 1")
    # TODO: Add the getter and setter methods



super_hero = SuperHero("Batman", 80, 9)

print(super_hero.health) # this should print 80
super_hero.health = 110
super_hero.health = -10
super_hero.health = 70

print(super_hero.power_level) # this should print 9
super_hero.power_level = 11
super_hero.power_level = 0
super_hero.power_level = 7

print(f"{super_hero.name} has {super_hero.health} health and {super_hero.power_level} power level")


# TODO: print the hero's attributes
