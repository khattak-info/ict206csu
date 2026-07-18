# Topic 01: Getting Started with Java

## Why this topic matters
This topic sets up the technical foundation for the semester. Students install the Java Development Kit (JDK), configure Java in their terminal, and prepare Visual Studio Code for writing and running Java programs.

## Learning outcomes
By the end of this topic, students should be able to:
- explain the basics of computing, role of programming and Java in the software development lifecycle;
- explain the difference between JDK, JRE, and JVM;
- install a supported JDK version;
- verify Java with `java -version` and `javac -version`;
- create, compile, and run a simple Java class in VS Code and terminal.

## Setup guide
### Windows
1. Install a current LTS JDK (for example Temurin/OpenJDK).
```
winget install -e --id Oracle.JDK.17
```
2. Confirm `JAVA_HOME` and update `Path` with `<JDK>/bin`.
3. Run `java -version` and `javac -version` in a new terminal.

### macOS
1. Install JDK using an installer or Homebrew.
```
brew install openjdk
```
2. Verify installation with `java -version`.
3. Optionally set `JAVA_HOME` in shell profile.

### Linux
1. Install OpenJDK using your package manager.
```
sudo apt update
sudo apt install openjdk-17-jdk
```
2. Verify compiler and runtime versions.
3. Confirm environment variables if multiple JDK versions are installed.

### Visual Studio Code
Install vscode from [https://code.visualstudio.com/](https://code.visualstudio.com/download) and add the following extensions:
- Extension Pack for Java https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack
- Debugger for Java https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug
- Test Runner for Java https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-test

## In-class flow we will follow each week
- environment check and troubleshooting (if required);
- Java file (`Welcome.java` for week 1 and so on);
- compile (`javac Welcome.java`) and run (`java Welcome`);
- explain source file, class name, and `main` method structure.

## Practice tasks
- print your name and student ID;
- print a multi-line class welcome message;
- create a method which computes something
- intentionally break syntax and identify compiler messages.

## Common troubleshooting
- command not found: fix PATH;
- class not found: run from correct folder;
- filename/class mismatch: ensure public class name matches file name exactly.s

## Folder usage
Use the `src` directory in this topic folder for live in-class coding examples.

## Tips
- Use `javac -d bin src/Welcome.java` to compile into a separate `bin` folder.
- ensure your `main` method is declared as `public static void main(String[] args)` to avoid runtime errors.
- ensure your class name matches the filename exactly, including case sensitivity.
- take care of spelling and punctuation in your code, as Java is case-sensitive and syntax-sensitive.
- use comments wisely as well as choose meaningful variable and method names to improve code readability.
- practice writing code in a text editor and compiling/running from the terminal to understand the underlying process, even if you use an generative AI supported IDE for convenience.