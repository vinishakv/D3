# SOEN 6011 Delivery 3 - Sinh(x) Calculator GUI

This project implements a simple Java Swing GUI application that calculates the hyperbolic sine (sinh) of a given input using a Taylor series approximation with 10 terms. Users can enter a real number, and the program displays the calculated sinh value formatted to five decimal places. The GUI also handles invalid or empty inputs by showing appropriate error messages.

The project includes comprehensive JUnit 5 test cases that verify the accuracy of the sinh calculation method as well as the GUI’s input validation and output display logic. Tests invoke private event-handling methods via reflection to ensure correctness.

Code quality is maintained using the Maven PMD plugin, which enforces standard Java coding rules and fails the build if violations occur. The project is built using Maven, with Java 17 as the target version.

To run the project, use Maven commands to compile, test, and perform static code analysis. The GUI can be launched either from the command line or within an IDE by running the main class.

This delivery demonstrates clean coding practices, unit testing of both core logic and GUI, and integration of static analysis tools to improve software quality.
