answer = input("Hello, How are you?\n")

answer = input("Do you want to talk? Yes or No.\n")

if answer == "Yes":
    name = input("Ok, what is your name?\n")
    print(name, "..., ummmmm beautiful name.")
    print("How old are you", name,"?")
elif answer == "No":
    print("Good bye then.")

years_old = int(input())
if years_old <= 17:
    print("Ups, you are younger than I thought.")
elif years_old >= 18:
    print("Finally, someone who\'s an adult.")

study_1 = input("Do you study?, Yes or No.\n")

if study_1 == "Yes":
    study_2 = input("Great. What do you study?\n")
    print("Wow, nice election.")
    about_study = input("Tell me about it, because I don\'t really know to much.\n")
    print("Good....")
elif study_1 == "No":
    study_3 = input("No way. Why?\n")
    print("Well I\"m sorry for that, I really wanted to think you were studying something.")

work = input("Do you work? Yes or No.\n")

if work == "Yes":
    job = input("Amazing, tell me about it.\n")
    like_job = input("Amazing, and; Do you really like your job? Yes or No.\n")
    print("I\"m glad you are happy with it.")
elif work == "No":
    print("Well, then quit it, don\'t be in a job you ain\'t like.")
    