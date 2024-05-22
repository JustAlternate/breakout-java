# Define the compiler
JAVAC = javac

# Define the flags
JFLAGS = -g

# Define the source directories
SRCDIR = src
BINDIR = bin

# Define the source files
SOURCES = $(shell find $(SRCDIR) -name '*.java')

# Define the class files
CLASSES = $(patsubst $(SRCDIR)/%.java, $(BINDIR)/%.class, $(SOURCES))

# Define the main class
MAIN = Game

# Compile Java source files
all: $(CLASSES)

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) $(JFLAGS) -d $(BINDIR) $<

# Run the Java program
run: classes
	cd $(BINDIR)
	java $(BINDIR) $(MAIN)
	cd ../

# Clean up generated files
clean:
	rm -rf $(BINDIR)
