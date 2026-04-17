import random

secret = random.randint(1, 100)
attempts = 0

print("Guess the number between 1 and 100!")

while True:
    try:
        guess = int(input("Your guess: "))
    except ValueError:
        print("Please enter a valid integer.")
        attempts += 1
    else:
        attempts += 1

        if guess < secret:
            print("Too low!")
        elif guess > secret:
            print("Too high!")
        else:
            print(f"Correct! You won in {attempts} attempts.")
            choice = input("Do you want to play again? (yes/no): ").strip().lower() # Added strip() to remove any leading/trailing whitespace and lower() to make the input case-insensitive
            if 'yes' in choice:
                continue
            else:
             print("Thanks for playing! Goodbye!")
             break   
            