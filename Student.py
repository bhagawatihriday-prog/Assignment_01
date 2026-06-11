class Address:
    def __init__(self, street, city, zip_code):
        self.street = street
        self.city = city
        self.zip_code = zip_code

    def __str__(self):
        return f"{self.street}, {self.city} - {self.zip_code}"


class Student:
    def __init__(self, name, age, address):
        self.name = name
        self._age = None
        self.age = age
        self.address = address
        self.courses = []

    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, value):
        if not isinstance(value, int):
            raise TypeError("Age must be integer")
        if value <= 0 or value > 120:
            raise ValueError("Age must be between 1 and 120")
        self._age = value

    def add_course(self, course):
        if not course.strip():
            print("Invalid course name")
            return
        if course in self.courses:
            print("Course already added")
            return
        self.courses.append(course)

    def display(self):
        print("\n--- Student ---")
        print("Name:", self.name)
        print("Age:", self.age)
        print("Address:", self.address)
        print("Courses:", ", ".join(self.courses) if self.courses else "None")


class ScholarshipStudent(Student):
    def __init__(self, name, age, address, scholarship_amount):
        super().__init__(name, age, address)
        self.scholarship_amount = scholarship_amount

    def display(self):
        super().display()
        print("Scholarship:", self.scholarship_amount)


# -------- INPUT HELPERS --------
def input_age():
    while True:
        try:
            age = int(input("Enter age: "))
            if 1 <= age <= 120:
                return age
            else:
                print("Age must be 1–120")
        except:
            print("Invalid input")


def input_scholarship():
    while True:
        try:
            amount = float(input("Enter scholarship amount: "))
            if amount < 0:
                print("Cannot be negative")
            else:
                return amount
        except:
            print("Invalid input")


def create_address():
    street = input("Street: ")
    city = input("City: ")
    zip_code = input("Zip: ")
    return Address(street, city, zip_code)


def create_student():
    name = input("Enter name: ").strip()
    age = input_age()
    address = create_address()

    choice = input("Scholarship student? (y/n): ").lower()

    if choice == "y":
        scholarship = input_scholarship()
        student = ScholarshipStudent(name, age, address, scholarship)
    else:
        student = Student(name, age, address)

    while True:
        course = input("Add course (or 'done'): ")
        if course.lower() == "done":
            break
        student.add_course(course)

    return student


# -------- MAIN SYSTEM --------
students = []

def menu():
    while True:
        print("\n===== MENU =====")
        print("1. Add Student")
        print("2. Display All")
        print("3. Exit")

        choice = input("Enter choice: ")

        if choice == "1":
            student = create_student()
            students.append(student)
            print("Student added successfully")

        elif choice == "2":
            if not students:
                print("No students found")
            for s in students:
                s.display()

        elif choice == "3":
            print("Exiting...")
            break

        else:
            print("Invalid choice")


# -------- RUN --------
if __name__ == "__main__":
    menu()