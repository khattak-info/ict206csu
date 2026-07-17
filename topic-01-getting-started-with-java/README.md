# Topic 01: Getting Started with Java

## Why this topic matters
This topic sets up the technical foundation for the semester. Students install the Java Development Kit (JDK), configure Java in their terminal, and prepare Visual Studio Code for writing and running Java programs.

## Learning outcomes
By the end of this topic, students should be able to:
- explain the difference between JDK, JRE, and JVM;
- install a supported JDK version;
- verify Java with `java -version` and `javac -version`;
- create, compile, and run a simple Java class in VS Code and terminal.

## Setup guide
### Windows
1. Install a current LTS JDK (for example Temurin/OpenJDK).
2. Confirm `JAVA_HOME` and update `Path` with `<JDK>/bin`.
3. Run `java -version` and `javac -version` in a new terminal.

### macOS
1. Install JDK using an installer or Homebrew.
2. Verify installation with `java -version`.
3. Optionally set `JAVA_HOME` in shell profile.

### Linux
1. Install OpenJDK using your package manager.
2. Verify compiler and runtime versions.
3. Confirm environment variables if multiple JDK versions are installed.

### Visual Studio Code
Install:
- Extension Pack for Java
- Debugger for Java
- Test Runner for Java

## In-class flow
- environment check and troubleshooting;
- first Java file (`Main.java`);
- compile (`javac Main.java`) and run (`java Main`);
- explain source file, class name, and `main` method structure.

## Practice tasks
- print your name and student ID;
- print a multi-line class welcome message;
- intentionally break syntax and identify compiler messages.

## Common troubleshooting
- command not found: fix PATH;
- class not found: run from correct folder;
- filename/class mismatch: ensure public class name matches file name exactly.

## Folder usage
Use the `src` directory in this topic folder for live in-class coding examples.
