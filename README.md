# Student Database System 

This is a java program to manage student records and perform various functions like searching, adding new students, generating reports etc.

## Features

- Add new students with details like name, class, roll no, marks etc.
- Search for existing students 
- Generate report card for a student
- Display entire student database
- Get academic statistics like highest marks subject-wise
- View seating arrangement of students
- Data is persisted to file

## Usage

- Run `StudentDatabase.java` 
- Choose options from menu:
  - Add new student
  - Search student database
    - Get report card
    - View full database 
    - See academic statistics
    - See seating arrangement
  - Exit
  
- Enter student details when adding
- Search by name when looking up a student

## Implementation

- `StudentDatabase` class contains all methods 
- Students stored in arrays (name, class, roll, marks etc)
- File IO used to persist data in `Project.txt`
- Various functions to print reports, statistics etc.
