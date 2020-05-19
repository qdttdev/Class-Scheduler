/**
 * @author Caroline Ta
 * @since 05.19.2020
 */

// -----------------------------------------------------------------------------
// Ctrl + Shift + Alt + G = Generate all Javadoc documents
// Ctrl + Shift + Alt + Z = Remove all Javadoc documents

// Ctrl + Shift + A: "Press Alt+Enter to assign a shortcut"

// Collapse javadoc comments: Alt + "-"
// Expand javadoc comments: Alt + "="

// Tools > Generate Javadoc

// Tools > Generate UML Diagram
// -----------------------------------------------------------------------------

package com.company;

import com.company.data.course.*;
import com.company.data.person.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

/**
 * The type Course scheduler main.
 */
public class CourseSchedulerMain {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        //----------------------------------------------------------------------
        // CONSTANTS & VARIABLES
        //----------------------------------------------------------------------

        final String WELCOME =
                "\n-------------------------------" +
                        "\nWELCOME TO THE COURSE SCHEDULER" +
                        "\n-------------------------------" +
                        "\n[0] Exit the program" +
                        "\n[1] Log in as an Admin" +
                        "\n[2] Log in as a  Faculty" +
                        "\n[3] Log in as a  Student";

        final String ADMIN =
                "\n--------------------------" +
                        "\nYOU ARE LOGGED IN AS ADMIN" +
                        "\n--------------------------" +
                        "\n[0] Exit - to COURSE SCHEDULER" +
                        "\n[1] View Course Schedule" +
                        "\n[2] View Faculty List" +
                        "\n[3] View Student List" +
                        "\n[4] Output file ScheduledCourseSessions.txt" +
                        "\n[5] Output file UnscheduledCourseSessions.txt" +
                        "\n[6] Output file Faculty.txt" +
                        "\n[7] Output file ScheduledStudents.txt" +
                        "\n[8] Output file UnscheduledStudents.txt";

        final String FACULTY =
                "\n----------------------------" +
                        "\nYOU ARE LOGGED IN AS FACULTY" +
                        "\n----------------------------" +
                        "\n[0] Exit - to COURSE SCHEDULER" +
                        "\n[1] View Course Schedule" +
                        "\n[2] View My Course List" +
                        "\n[3] View My Information" +
                        "\n[4] Assign myself to a Course" +
                        "\n[5] Remove myself from a Course";

        final String STUDENT =
                "\n----------------------------" +
                        "\nYOU ARE LOGGED IN AS STUDENT" +
                        "\n----------------------------" +
                        "\n[0] Exit - to COURSE SCHEDULER" +
                        "\n[1] View Course Schedule" +
                        "\n[2] View My Course List" +
                        "\n[3] View My Information" +
                        "\n[4] Enroll myself to a Course" +
                        "\n[5] Unenroll myself from a Course";

        // INPUT FILE NAMES

        final String FACULTY_INPUT_FILE = "src\\com\\company\\inputFiles\\info_faculty_input.txt";
        final String STUDENT_INPUT_FILE = "src\\com\\company\\inputFiles\\info_student_input.txt";
        final String COURSE_INPUT_FILE = "src\\com\\company\\inputFiles\\info_course_input.txt";

        final String SESSION_1A_INPUT_FILE = "src\\com\\company\\inputFiles\\1A_session_id_input.txt";
        final String SESSION_1B_INPUT_FILE = "src\\com\\company\\inputFiles\\1B_session_id_input.txt";
        final String SESSION_1C_INPUT_FILE = "src\\com\\company\\inputFiles\\1C_session_id_input.txt";
        final String SESSION_1D_INPUT_FILE = "src\\com\\company\\inputFiles\\1D_session_id_input.txt";
        final String SESSION_4A_INPUT_FILE = "src\\com\\company\\inputFiles\\4A_session_id_input.txt";

        // OUTPUT FILE PATHS

        final String SCHEDULED_COURSE_SESSIONS_OUTPUT = "out\\outputFiles\\ScheduledCourseSessions.txt";
        final String UNSCHEDULED_COURSE_SESSIONS_OUTPUT = "out\\outputFiles\\UnscheduledCourseSessions.txt";
        final String FACULTY_OUTPUT = "out\\outputFiles\\Faculty.txt";
        final String SCHEDULED_STUDENTS_OUTPUT = "out\\outputFiles\\ScheduledStudents.txt";
        final String UNSCHEDULED_STUDENTS_OUTPUT = "out\\outputFiles\\UnscheduledStudents.txt";

        // FOR PERSON - 10 categories

        String firstName;
        String middleName;
        String lastName;
        String email;
        String tel;
        String street;
        String city;
        String state;
        String zip;
        String id;

        // FOR FACULTIES - 2 categories

        String hireDate;
        String tenured;

        // FOR STUDENTS - 3 categories

        String dob;
        String gpa;
        String dateStart;

        // FOR COURSE
        String department;
        String code;
        String description;
        String min;
        String max;

        String line;

        int loginOption = 0;
        String loginNameTel;

        String fileData;
        FileOutputStream fos;

        //----------------------------------------------------------------------
        // START GENERATE INFORMATION FROM INPUT FILES
        //----------------------------------------------------------------------

        PersonDirectory personDirectory = new PersonDirectory();
        CourseDirectory courseDirectory = new CourseDirectory();

        Scanner input;

        // GENERATE LIST OF FACULTY OBJECTS WITH INFO FROM INPUT FILE
        try {
            File facultyFile = new File(FACULTY_INPUT_FILE);
            input = new Scanner(facultyFile);

            while (input.hasNext()) {

                line = input.nextLine();

                String[] lineAr = line.split("_");

                firstName = lineAr[0];
                middleName = lineAr[1];
                lastName = lineAr[2];
                email = lineAr[3];
                tel = lineAr[4];
                street = lineAr[5];
                city = lineAr[6];
                state = lineAr[7];
                zip = lineAr[8];
                id = lineAr[9];
                hireDate = lineAr[10];
                tenured = lineAr[11];

                Person person = new Faculty(new PersonName(firstName, middleName, lastName), email, tel,
                        new PersonAddress(street, city, state, zip), id, hireDate, parseBoolean(tenured));

                personDirectory.addPerson(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // GENERATE LIST OF STUDENT OBJECTS WITH INFO FROM INPUT FILE
        try {
            File studentFile = new File(STUDENT_INPUT_FILE);
            input = new Scanner(studentFile);

            while (input.hasNext()) {

                line = input.nextLine();

                String[] lineAr = line.split("_");

                firstName = lineAr[0];
                middleName = lineAr[1];
                lastName = lineAr[2];
                email = lineAr[3];
                tel = lineAr[4];
                street = lineAr[5];
                city = lineAr[6];
                state = lineAr[7];
                zip = lineAr[8];
                id = lineAr[9];
                dob = lineAr[10];
                gpa = lineAr[11];
                dateStart = lineAr[12];

                Person person = new Student(new PersonName(firstName, middleName, lastName), email, tel,
                        new PersonAddress(street, city, state, zip), id, dob, gpa, dateStart);

                personDirectory.addPerson(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // GENERATE LIST OF COURSE OBJECTS WITH INFO FROM INPUT FILE
        try {
            File courseFile = new File(COURSE_INPUT_FILE);
            input = new Scanner(courseFile);
            Course course;

            while (input.hasNext()) {

                line = input.nextLine();

                String[] lineAr = line.split("_");

                department = lineAr[0];
                code = lineAr[1];
                description = lineAr[2];
                id = lineAr[3];
                min = lineAr[4];
                max = lineAr[5];

                course = new Course(department, code, description, id, parseInt(min), parseInt(max));

                courseDirectory.addCourse(course);
            }

            // GENERATE LIST OF SESSIONS FOR EACH COURSE
            courseDirectory.generateSession(courseDirectory.getCourseList().get(0).getCourseId(), SESSION_1A_INPUT_FILE);
            courseDirectory.generateSession(courseDirectory.getCourseList().get(1).getCourseId(), SESSION_1B_INPUT_FILE);
            courseDirectory.generateSession(courseDirectory.getCourseList().get(2).getCourseId(), SESSION_1C_INPUT_FILE);
            courseDirectory.generateSession(courseDirectory.getCourseList().get(3).getCourseId(), SESSION_1D_INPUT_FILE);
            courseDirectory.generateSession(courseDirectory.getCourseList().get(4).getCourseId(), SESSION_4A_INPUT_FILE);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //----------------------------------------------------------------------
        // START COURSE SCHEDULER PROGRAM
        //----------------------------------------------------------------------

        input = new Scanner(System.in);
        System.out.println(WELCOME);
        System.out.print("Option: ");
        loginOption = input.nextInt();

        while (loginOption != 0) {
            switch (loginOption) {
                //--------------------------------------------------------------
                // ADMIN LOGIN
                //--------------------------------------------------------------
                case 1 -> {
                    System.out.println(ADMIN);
                    System.out.print("Option: ");
                    loginOption = input.nextInt();
                    while (loginOption != 0) {
                        switch (loginOption) {
                            case 1: // View Course Session
                                System.out.println(courseDirectory.printCourseWSession());
                                break;

                            case 2: // View Faculty List
                                System.out.println(personDirectory.getFacultyAsString());
                                break;

                            case 3: // View Student List
                                System.out.println(personDirectory.getStudentAsString());
                                break;

                            case 4: // ScheduledCourseSessions.txt
                                try {
                                    fileData = courseDirectory.getScheduledCourseSessionsOutputData();

                                    fos = new FileOutputStream(SCHEDULED_COURSE_SESSIONS_OUTPUT);
                                    fos.write(fileData.getBytes());
                                    fos.flush();
                                    fos.close();

                                    System.out.println("\nOutputting file ScheduledCourseSessions.txt...");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case 5: // UnscheduledCourseSessions.txt
                                try {
                                    fileData = courseDirectory.getUnscheduledCourseSessionsOutputData();

                                    fos = new FileOutputStream(UNSCHEDULED_COURSE_SESSIONS_OUTPUT);
                                    fos.write(fileData.getBytes());
                                    fos.flush();
                                    fos.close();

                                    System.out.println("\nOutputting file UnscheduledCourseSessions.txt...");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case 6: // Faculty.txt
                                try {
                                    fileData = personDirectory.getFacultyOutputData();

                                    fos = new FileOutputStream(FACULTY_OUTPUT);
                                    fos.write(fileData.getBytes());
                                    fos.flush();
                                    fos.close();

                                    System.out.println("\nOutputting file Faculty.txt...");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case 7: // ScheduledStudents.txt
                                try {
                                    fileData = personDirectory.getScheduledStudentsOutputData();

                                    fos = new FileOutputStream(SCHEDULED_STUDENTS_OUTPUT);
                                    fos.write(fileData.getBytes());
                                    fos.flush();
                                    fos.close();

                                    System.out.println("\nOutputting file ScheduledStudents.txt...");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case 8: // UnscheduledStudents.txt
                                try {
                                    fileData = personDirectory.getUnscheduledStudentsOutputData();

                                    fos = new FileOutputStream(UNSCHEDULED_STUDENTS_OUTPUT);
                                    fos.write(fileData.getBytes());
                                    fos.flush();
                                    fos.close();

                                    System.out.println("\nOutputting file UnscheduledStudents.txt...");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                        System.out.println(ADMIN);
                        System.out.print("Option: ");
                        loginOption = input.nextInt();
                    }
                }

                //--------------------------------------------------------------
                // FACULTY LOGIN
                //--------------------------------------------------------------
                // TEST INPUT: Zeph Prissy Spalding 480586
                // Zeph_Prissy_Spalding_zps@gmail.com_480586_KLM_Mission Viejo_CA_92692_F001_01/01/2010_true
                case 2 -> {
                    System.out.println();
                    System.out.println("Enter your full name and phone number as the following format");
                    System.out.print("(FirstName MiddleName LastName 123456): ");
                    firstName = input.next();
                    middleName = input.next();
                    lastName = input.next();
                    tel = input.next();
                    System.out.println(FACULTY);
                    System.out.print("Option: ");
                    loginOption = input.nextInt();
                    while (loginOption != 0) {
                        switch (loginOption) {
                            case 1: // View Course Schedule
                                System.out.println(courseDirectory.printCourseWSession());
                                break;

                            case 2: // View My Course List
                                System.out.println(((Faculty) personDirectory.findPerson(tel)).getFacultyCourseList());
                                break;

                            case 3: // View My Information
                                System.out.println(personDirectory.findPerson(tel).toString());
                                break;

                            case 4: // Assign myself to a Course
                                System.out.print("\nEnter the Id of the Course you would like to teach: ");
                                String courseIdAdd = input.next().toUpperCase();
                                Course courseToAdd = courseDirectory.findCourse(courseIdAdd);

                                ((Faculty) personDirectory.findPerson(tel)).addCourse(courseToAdd);

                                System.out.println();
                                System.out.println("----------------------------------");
                                System.out.println("SESSIONS AVAILABLE FOR THIS COURSE");
                                System.out.println("----------------------------------");
                                for (int i = 0; i < courseToAdd.sessionList.size(); i++) {
                                    System.out.print(courseToAdd.sessionList.get(i).toString());
                                }

                                System.out.print("\nEnter the Id of the Session you would like to teach: ");
                                String sessionIdAdd = input.next().toUpperCase();
                                Session sessionToAdd = courseDirectory.findCourse(courseIdAdd).findSession(sessionIdAdd);

                                sessionToAdd.setTeacher((Faculty) personDirectory.findPerson(tel));

                                System.out.println();
                                System.out.println("-----------------------------------");
                                System.out.println("SESSIONS FOR THIS COURSE IS UPDATED");
                                System.out.println("-----------------------------------");
                                for (int i = 0; i < courseToAdd.sessionList.size(); i++) {
                                    System.out.print(courseToAdd.sessionList.get(i).toString());
                                }
                                break;

                            case 5: // Remove myself from a Course
                                System.out.print("\nEnter the Id of the Course you would like to quit: ");
                                String courseIdRemove = input.next().toUpperCase();
                                Course courseToRemove = courseDirectory.findCourse(courseIdRemove);

                                ((Faculty) personDirectory.findPerson(tel)).removeCourse(courseToRemove);

                                System.out.println();
                                System.out.println("----------------------------------");
                                System.out.println("SESSIONS AVAILABLE FOR THIS COURSE");
                                System.out.println("----------------------------------");
                                for (int i = 0; i < courseToRemove.sessionList.size(); i++) {
                                    System.out.print(courseToRemove.sessionList.get(i).toString());
                                }

                                System.out.print("\nEnter the Id of the Session you would like to quit: ");
                                String sessionIdRemove = input.next().toUpperCase();
                                Session sessionToRemove = courseDirectory.findCourse(courseIdRemove).findSession(sessionIdRemove);

                                sessionToRemove.unsetTeacher();

                                System.out.println();
                                System.out.println("-----------------------------------");
                                System.out.println("SESSIONS FOR THIS COURSE IS UPDATED");
                                System.out.println("-----------------------------------");
                                for (int i = 0; i < courseToRemove.sessionList.size(); i++) {
                                    System.out.print(courseToRemove.sessionList.get(i).toString());
                                }
                                break;
                            default:
                        }
                        System.out.println(FACULTY);
                        System.out.print("Option: ");
                        loginOption = input.nextInt();
                    }
                }
                //--------------------------------------------------------------
                // STUDENT LOGIN
                //--------------------------------------------------------------
                // TEST INPUT: Ruthie Bernadine Hanley 182575
                // TEST INPUT: Camille Alfred Emmett 681690
                // Ruthie_Bernadine_Hanley_rbh@gmail.com_182575_JKL_Mission Viejo_CA_92692_S010_10/01/1998_4.0_10/20/2016
                // Camille_Alfred_Emmett_cae@gmail.com_681690_IJK_Mission Viejo_CA_92692_S009_09/01/1998_3.9_09/20/2016
                case 3 -> {
                    System.out.println();
                    System.out.println("Enter your full name and phone number as the following format");
                    System.out.print("(FirstName MiddleName LastName 123456): ");
                    firstName = input.next();
                    middleName = input.next();
                    lastName = input.next();
                    tel = input.next();
                    System.out.println(STUDENT);
                    System.out.print("Option: ");
                    loginOption = input.nextInt();
                    while (loginOption != 0) {
                        switch (loginOption) {
                            case 1: // View Course Schedule
                                System.out.println(courseDirectory.printCourseWSession());
                                break;

                            case 2: // View My Course List
                                System.out.println(((Student) personDirectory.findPerson(tel)).getCourseScheduledList());
                                break;

                            case 3: // View My Information
                                System.out.println(personDirectory.findPerson(tel).toString());
                                break;

                            case 4: // Enroll myself to a Course
                                System.out.print("\nEnter the Id of the Course you would like to enroll: ");
                                String courseIdAdd = input.next().toUpperCase();
                                Course courseToAdd = courseDirectory.findCourse(courseIdAdd);

                                // ADDING COURSE HERE
                                ((Student) personDirectory.findPerson(tel)).addCourse(courseToAdd);

                                System.out.println();
                                System.out.println("----------------------------------");
                                System.out.println("SESSIONS AVAILABLE FOR THIS COURSE");
                                System.out.println("----------------------------------");
                                for (int i = 0; i < courseToAdd.sessionList.size(); i++) {
                                    System.out.print(courseToAdd.sessionList.get(i).toString());
                                }

                                System.out.print("\nEnter the Id of the Session you would like to enroll: ");
                                String sessionIdAdd = input.next().toUpperCase();
                                Session sessionToAdd = courseDirectory.findCourse(courseIdAdd).findSession(sessionIdAdd);

                                // ADDING SESSION HERE
                                sessionToAdd.addStudent((Student) personDirectory.findPerson(tel));

                                // UPDATE COURSE WITH SESSION + STUDENT
                                courseDirectory.findCourse(courseIdAdd).enrollStudent(((Student) personDirectory.findPerson(tel)), sessionToAdd);

                                System.out.println();
                                System.out.println("-----------------------------------");
                                System.out.println("SESSIONS FOR THIS COURSE IS UPDATED");
                                System.out.println("-----------------------------------");
                                for (int i = 0; i < courseToAdd.sessionList.size(); i++) {
                                    System.out.print(courseToAdd.sessionList.get(i).toString());
                                }
                                break;

                            case 5: // Unenroll myself from a Course
                                System.out.print("\nEnter the Id of the Course you would like to enroll: ");
                                String courseIdRemove = input.next().toUpperCase();
                                Course courseToRemove = courseDirectory.findCourse(courseIdRemove);

                                // REMOVE COURSE HERE
                                ((Student) personDirectory.findPerson(tel)).removeCourse(courseToRemove);

                                System.out.println();
                                System.out.println("----------------------------------");
                                System.out.println("SESSIONS AVAILABLE FOR THIS COURSE");
                                System.out.println("----------------------------------");
                                for (int i = 0; i < courseToRemove.sessionList.size(); i++) {
                                    System.out.print(courseToRemove.sessionList.get(i).toString());
                                }

                                System.out.print("\nEnter the Id of the Session you would like to enroll: ");
                                String sessionIdRemove = input.next().toUpperCase();
                                Session sessionToRemove = courseDirectory.findCourse(courseIdRemove).findSession(sessionIdRemove);

                                // REMOVE SESSION HERE
                                sessionToRemove.removeStudent((Student) personDirectory.findPerson(tel));

                                System.out.println();
                                System.out.println("-----------------------------------");
                                System.out.println("SESSIONS FOR THIS COURSE IS UPDATED");
                                System.out.println("-----------------------------------");
                                for (int i = 0; i < courseToRemove.sessionList.size(); i++) {
                                    System.out.print(courseToRemove.sessionList.get(i).toString());
                                }
                                break;
                        }

                        System.out.println(STUDENT);
                        System.out.print("Option: ");
                        loginOption = input.nextInt();
                    }
                }
            }

            System.out.println(WELCOME);
            System.out.print("Option: ");
            loginOption = input.nextInt();
        } // Program running Switch statements
    }
}
