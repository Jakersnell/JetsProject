# JetsProject


## Description
	JetsApp is an interactive CLI program that deals with the reading/writing from file and creation of Jet objects, as well as the CLI interaction with their behaviors and state during the operation of the program.  On startup the program reads a default amount of Jet objects from "jets.csv" and parses the data into corresponding child classes of the class Jet, creating instances of these classes.  These objects are then able to be interacted with in various ways within the program. The user can create, delete, fly, or assign a pilot to, each jet. The user has many other options as well as but not limited to saving the current state of their JetApp into a csv file.

## Tech used
	In this project I used Java 8 as the sole programming language for this project.  The project relys on OOP principles such as polymorphism when creating multiple subclasses of the super class Jet, each with its own respective functions. File IO is also essential to this project for reading/writing objects, as well as then parsing them into Jet objects. In this project I tried to focus on minimal boilerplate and maximum reusability, this can be seen in my use of generic types in various methods, I believe this is essential as it allows for the clean refactoring of the code when necessary, which was a lot haha. Another neat feature I enjoyed was using ANSI escape codes to change the color of the text on terminal, which I like a lot, seeing as this is a CLI application.

## Lessons learned
	I learned a lot during this project, but I will keep to the main points. First off I learned a lot about Java generics, Im used to using thes extensively in Rust but Java does these sorts of things different, I learned about the Function and Consumable interface, which if you have used rust may remind you of the Fn and FnOnce traits. Its neat to see these things in other languages, and since I dont have much experience outside of Rust and Python, Ive learned a lot using Java. I also learned a ton about organization of projects and workflow, I feel like I developed better tools for keeping track of a codebase, and grew my ability of foresight. This project was a lot of fun, thank you for taking the time to read this, best of.