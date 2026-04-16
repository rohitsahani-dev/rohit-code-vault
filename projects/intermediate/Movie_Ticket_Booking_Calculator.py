import random

class MovieTicketSystem:
    def __init__(self):
        self.movies = [
            {"id": 1, "title": "The Godfather", "price": 10.00},
            {"id": 2, "title": "The Super Mario Galaxy Movie", "price": 22.00},
            {"id": 3, "title": "Project Hail Mary", "price": 16.08},
            {"id": 4, "title": "Scream 7", "price": 15.00},
            {"id": 5, "title": "The Marvels", "price": 17.00},
            {"id": 6, "title": "The Hunger Games: ", "price": 18.00},
            {"id": 7, "title": "The Flash", "price": 19.00},
            {"id": 8, "title": "Avengers: Doomsday", "price": 25.00},
            {"id": 9, "title": "Spider-Man: Brand New Day", "price": 24.00},
            {"id": 10, "title": "Moana (2026) – Live-Action", "price": 23.00},
            {"id": 11, "title": "Toy Story 5", "price": 21.00},
            {"id": 12, "title": "Minions 3", "price": 20.00},
            {"id": 13, "title": "The Odyssey", "price": 24.00},
            {"id": 14, "title": "Michael", "price": 22.00},
            {"id": 15, "title": "Star Wars: The Mandalorian and Grogu", "price": 25.00},
            {"id": 16, "title": "Dune: Part Three", "price": 24.00}
        ]
        self.total_revenue = 0.0

    def display_movies(self):
        print("\n🎬 Please select a movie:")
        for movie in self.movies:
            print(f"{movie['id']}. {movie['title']} - ${movie['price']:.2f}")
        print("17. 🎰 Random Movie Selection")
        print("18. ❌ Exit")

    def get_movie_by_id(self, movie_id):
        return next((m for m in self.movies if m["id"] == movie_id), None)

    def select_movie(self):
        while True:
            try:
                choice = int(input("\nEnter movie number: "))
                if choice == 18:
                    print("👋 Thank you for using the Movie Ticket Booking System. Goodbye!")
                    return None, None
                elif choice == 17:
                    movie = random.choice(self.movies)
                    print(f"🎲 Randomly selected: {movie['title']} - ${movie['price']:.2f}")
                    if input("Book this movie? (yes/no): ").lower() == 'yes':
                        return movie["title"], movie["price"]
                else:
                    movie = self.get_movie_by_id(choice)
                    if movie:
                        return movie["title"], movie["price"]
                    else:
                        print("❌ Invalid choice. Please try again.")
            except ValueError:
                print("⚠️  Please enter a valid number.")

    def get_ticket_count(self):
        while True:
            try:
                count = int(input("🎟️  Number of tickets: "))
                if 1 <= count <= 100:
                    return count
                elif count <= 0:
                    print("❌ At least 1 ticket required.")
                else:
                    print("❌ Max 100 tickets per booking.")
            except ValueError:
                print("⚠️  Please enter a number.")

    def calculate_price(self, num_tickets, ticket_price):
        base_price = num_tickets * ticket_price
        discount_rate = 0.2 if base_price > 200 else 0.1 if base_price > 100 else 0.05 if base_price > 50 else 0
        final_price = base_price * (1 - discount_rate)
        discount_msg = f"{int(discount_rate*100)}% discount applied!" if discount_rate > 0 else "No discount applied."
        return round(final_price, 2), discount_msg

    def book_tickets(self):
        print("\n" + "="*50)
        print("🎥 WELCOME TO MOVIE TICKET BOOKING SYSTEM")
        print("="*50)

        while True:
            self.display_movies()
            movie_name, ticket_price = self.select_movie()
            if not movie_name:
                break

            num_tickets = self.get_ticket_count()
            total_price, discount_msg = self.calculate_price(num_tickets, ticket_price)

            print("\n" + "-"*40)
            print("🧾 BOOKING SUMMARY")
            print("-"*40)
            print(f"🎬 Movie: {movie_name}")
            print(f"🎟️  Tickets: {num_tickets}")
            print(f"💸 {discount_msg}")
            print(f"💰 Total: ${total_price:.2f}")
            print("-"*40)

            self.total_revenue += total_price

            if input("\n🔁 Book another ticket? (yes/no): ").lower() != 'yes':
                break

        print(f"\n📊 Total revenue generated: ${self.total_revenue:.2f}")
        print("👋 Thank you for using our system. Enjoy the movie!")

# Run the system
if __name__ == "__main__":
    system = MovieTicketSystem()
    system.book_tickets()   