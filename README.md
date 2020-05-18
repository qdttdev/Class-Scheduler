# CS4A Final Project: Course Scheduler Application

This application simulates a Course Scheduler in which students can enroll/unenroll courses and teachers can add/remove courses that they want to teach.

```
Where files are located in this Repository

1. Javadoc documentation can be found inside FINAL_doc
2. UML Class Diagram can be found inside FINAL_UML
3. Source code can be found in FINAL_SourceCode/CourseScheduler/src/com/company	
	* Input files to generate information can be found at /inputFiles
	* Comparators within the same Class can be found at /comparators
	* Plantuml files can be found at /plantuml
	* Course-related (course and session) implementations can be found at /data/course
	* Person-related (student, faculty) implementations can be found at /data/person
```

## General Requirements for "Person" Information

Everyone (both students and faculties) who attends the university has these following information:
* Name: fist name, middle name, last name
* Email address
* Telephone number
* Address information: street address, city, state, zip code.
* Id number

### Specific Requirements for Student

Students also have to have these following information:
* Date of birth
* Current GPA
* Date the student started attending the university

### Specific Requirements for Faculty

Faculty members also have to have these following information:
* Hire date
* Whether the faculty member is tenured.

## Requirements for "Course" Information

Courses have the following information:
* Department (e.g. CS or BIO)
* Code (e.g. 1A, 4A, or 4B)
* Course description
* Course ID
* Minimum and Maximum number of students per session.

Important aspects to be noticed of:
* If there are not enough students to fill a session, that session is cancelled.
* If no session for a course are scheduled, the entire course is cancelled.
* If a course does not meet the minimum of students, it will be cancelled.
* Each course can have multiple session.
* Each session required a unique id that is system generated and must be unique across all sessions.

### Running the tests

The program is generated with pre-created input files to have students, faculties, courses, sessions in the system.

Sample test run will include these following activities:
1. Log in as a Faculty to add a course to teach.
2. Log in as a Student to enroll in to a course with a specific session.
3. Log in as an Admin to output files of related information for the test.


```
-------------------------------
WELCOME TO THE COURSE SCHEDULER
-------------------------------
[0] Exit the program
[1] Log in as an Admin
[2] Log in as a  Faculty
[3] Log in as a  Student
Option: 2

Enter your full name and phone number as the following format
(FirstName MiddleName LastName 123456): Zeph Prissy Spalding 480586

----------------------------
YOU ARE LOGGED IN AS FACULTY
----------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View My Course List
[3] View My Information
[4] Assign myself to a Course
[5] Remove myself from a Course
Option: 4

Enter the Id of the Course you would like to teach: cs1a

----------------------------------
SESSIONS AVAILABLE FOR THIS COURSE
----------------------------------
Session Id: 1A123	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A234	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A345	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A456	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A567	Available seats: 7/7
	Instructor:     N/A

Enter the Id of the Session you would like to teach: 1a123

-----------------------------------
SESSIONS FOR THIS COURSE IS UPDATED
-----------------------------------
Session Id: 1A123	Available seats: 7/7
	Instructor:     Zeph Prissy Spalding
Session Id: 1A234	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A345	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A456	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A567	Available seats: 7/7
	Instructor:     N/A

----------------------------
YOU ARE LOGGED IN AS FACULTY
----------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View My Course List
[3] View My Information
[4] Assign myself to a Course
[5] Remove myself from a Course
Option: 0

-------------------------------
WELCOME TO THE COURSE SCHEDULER
-------------------------------
[0] Exit the program
[1] Log in as an Admin
[2] Log in as a  Faculty
[3] Log in as a  Student
Option: 3

Enter your full name and phone number as the following format
(FirstName MiddleName LastName 123456): Ruthie Bernadine Hanley 182575

----------------------------
YOU ARE LOGGED IN AS STUDENT
----------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View My Course List
[3] View My Information
[4] Enroll myself to a Course
[5] Unenroll myself from a Course
Option: 4

Enter the Id of the Course you would like to enroll: cs1a

----------------------------------
SESSIONS AVAILABLE FOR THIS COURSE
----------------------------------
Session Id: 1A123	Available seats: 7/7
	Instructor:     Zeph Prissy Spalding
Session Id: 1A234	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A345	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A456	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A567	Available seats: 7/7
	Instructor:     N/A

Enter the Id of the Session you would like to enroll: 1a123

-----------------------------------
SESSIONS FOR THIS COURSE IS UPDATED
-----------------------------------
Session Id: 1A123	Available seats: 6/7
	Instructor:     Zeph Prissy Spalding
Session Id: 1A234	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A345	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A456	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A567	Available seats: 7/7
	Instructor:     N/A

----------------------------
YOU ARE LOGGED IN AS STUDENT
----------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View My Course List
[3] View My Information
[4] Enroll myself to a Course
[5] Unenroll myself from a Course
Option: 0

-------------------------------
WELCOME TO THE COURSE SCHEDULER
-------------------------------
[0] Exit the program
[1] Log in as an Admin
[2] Log in as a  Faculty
[3] Log in as a  Student
Option: 3

Enter your full name and phone number as the following format
(FirstName MiddleName LastName 123456): Camille Alfred Emmett 681690

----------------------------
YOU ARE LOGGED IN AS STUDENT
----------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View My Course List
[3] View My Information
[4] Enroll myself to a Course
[5] Unenroll myself from a Course
Option: 4

Enter the Id of the Course you would like to enroll: cs1a

----------------------------------
SESSIONS AVAILABLE FOR THIS COURSE
----------------------------------
Session Id: 1A123	Available seats: 6/7
	Instructor:     Zeph Prissy Spalding
Session Id: 1A234	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A345	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A456	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A567	Available seats: 7/7
	Instructor:     N/A

Enter the Id of the Session you would like to enroll: 1a123

-----------------------------------
SESSIONS FOR THIS COURSE IS UPDATED
-----------------------------------
Session Id: 1A123	Available seats: 5/7
	Instructor:     Zeph Prissy Spalding
Session Id: 1A234	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A345	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A456	Available seats: 7/7
	Instructor:     N/A
Session Id: 1A567	Available seats: 7/7
	Instructor:     N/A

----------------------------
YOU ARE LOGGED IN AS STUDENT
----------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View My Course List
[3] View My Information
[4] Enroll myself to a Course
[5] Unenroll myself from a Course
Option: 0

-------------------------------
WELCOME TO THE COURSE SCHEDULER
-------------------------------
[0] Exit the program
[1] Log in as an Admin
[2] Log in as a  Faculty
[3] Log in as a  Student
Option: 1

--------------------------
YOU ARE LOGGED IN AS ADMIN
--------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View Faculty List
[3] View Student List
[4] Output file ScheduledCourseSessions.txt
[5] Output file UnscheduledCourseSessions.txt
[6] Output file Faculty.txt
[7] Output file ScheduledStudents.txt
[8] Output file UnscheduledStudents.txt
Option: 4

Outputting file ScheduledCourseSessions.txt...

--------------------------
YOU ARE LOGGED IN AS ADMIN
--------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View Faculty List
[3] View Student List
[4] Output file ScheduledCourseSessions.txt
[5] Output file UnscheduledCourseSessions.txt
[6] Output file Faculty.txt
[7] Output file ScheduledStudents.txt
[8] Output file UnscheduledStudents.txt
Option: 5

Outputting file UnscheduledCourseSessions.txt...

--------------------------
YOU ARE LOGGED IN AS ADMIN
--------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View Faculty List
[3] View Student List
[4] Output file ScheduledCourseSessions.txt
[5] Output file UnscheduledCourseSessions.txt
[6] Output file Faculty.txt
[7] Output file ScheduledStudents.txt
[8] Output file UnscheduledStudents.txt
Option: 6

Outputting file Faculty.txt...

--------------------------
YOU ARE LOGGED IN AS ADMIN
--------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View Faculty List
[3] View Student List
[4] Output file ScheduledCourseSessions.txt
[5] Output file UnscheduledCourseSessions.txt
[6] Output file Faculty.txt
[7] Output file ScheduledStudents.txt
[8] Output file UnscheduledStudents.txt
Option: 7

Outputting file ScheduledStudents.txt...

--------------------------
YOU ARE LOGGED IN AS ADMIN
--------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View Faculty List
[3] View Student List
[4] Output file ScheduledCourseSessions.txt
[5] Output file UnscheduledCourseSessions.txt
[6] Output file Faculty.txt
[7] Output file ScheduledStudents.txt
[8] Output file UnscheduledStudents.txt
Option: 8

Outputting file UnscheduledStudents.txt...

--------------------------
YOU ARE LOGGED IN AS ADMIN
--------------------------
[0] Exit - to COURSE SCHEDULER
[1] View Course Schedule
[2] View Faculty List
[3] View Student List
[4] Output file ScheduledCourseSessions.txt
[5] Output file UnscheduledCourseSessions.txt
[6] Output file Faculty.txt
[7] Output file ScheduledStudents.txt
[8] Output file UnscheduledStudents.txt
Option: 0

-------------------------------
WELCOME TO THE COURSE SCHEDULER
-------------------------------
[0] Exit the program
[1] Log in as an Admin
[2] Log in as a  Faculty
[3] Log in as a  Student
Option: 0

Process finished with exit code 0
```

### Output files

#### ScheduledCourseSessions.txt: 
* Each course that was scheduled (full details)  
* Each session for that course (i.e. session id) 
* The full name and id number of the instructor for the session 
* The number of students in the session 
* For each student in the session, the full name and id number.  
 
#### UnscheduledCourseSessions.txt: 
* Each course that was not scheduled (i.e. not even one session scheduled) along with the minimum number of students that needed to be in the course.  
 
#### Faculty.txt: 
* Print all details for each faculty member and list the full course details of each course and session he/she has scheduled along with the session id and number of students in that session 
 
#### ScheduledStudents.txt: 
* For each student show all details and list the session id, course id, and course description for the classes taken.  
 
#### UnscheduledStudents.txt: 
* List full details for each student that has no classes to take. 

## Author

* **Caroline Ta**

## Acknowledgments

* [Javadoc Generator](https://github.com/setial/intellij-javadocs/wiki) of Intellij IDEA
* PlantUML files generated by [Sketch It!](https://plugins.jetbrains.com/plugin/10387-sketch-it-) and visualized by [PlantUML Integration](https://plugins.jetbrains.com/plugin/7017-plantuml-integration) plugins
* Random name genrator by [Behind The Name](https://www.behindthename.com/)
* Class Diagram using [draw.io](https://app.diagrams.net/)

