# Compiler and Flags
JAVAC = javac
JAVA = java
FLAGS = -d .

# Classes
CLASSES = Person.java Admin.java Customer.java Car.java CarRentalSystem.java Main.java

# Default Target
all: compile run

compile:
	$(JAVAC) $(FLAGS) $(CLASSES)

run:
	$(JAVA) Main

clean:
	rm -rf *.class
