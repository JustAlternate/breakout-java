JAVAC = javac

SRCDIR = src
BINDIR = bin

SOURCES = $(shell find $(SRCDIR) -name '*.java')

CLASSES = $(patsubst $(SRCDIR)/%.java, $(BINDIR)/%.class, $(SOURCES))

all: build run

####################################
# /!\ known bug: always recompile everything when 'make build'. 
build: $(CLASSES)

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR) $<
####################################

# Run the project.
run:
	java -cp bin src.main.Game

# Clean classes files.
clean:
	find $(BINDIR) -name \*.class -type f -delete

clear: clean
