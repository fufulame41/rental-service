JAVAC = javac
JAVA = java
FLAGS = -d .

CLASSES = Person.java Admin.java Customer.java Car.java CarRentalSystem.java Main.java

all: compile run

compile:
	$(JAVAC) $(FLAGS) $(CLASSES)

run:
	$(JAVA) Main

clean:
	rm -rf *.class
