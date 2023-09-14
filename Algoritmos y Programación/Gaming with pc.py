def name():
    name = input("What\'s your name?\n")
    return name

def games():
    games = input("Do you like games? Yes or No.\n")
    return games

def main():

    from random import randint
    a = randint(0,10)

    print("Hi", name())

    if games() == "Yes":
        print("Ok, let\'s play a game then.")
        answer = input("If I guess the number between 0 - 10 that your thinking; I win. If not; you win. Do you like it? Yes or No.\n")
        if answer == "Yes":
            print("The number your thinking it\'s", a)
            answer_2 = input("Are you surprise? Yes or No.\n")
            if answer_2 == "Yes":
                print("I\'m glad you are.")
    else:
        print("Ok, bye.")
main()


