/**
 * @author Caroline Ta
 * @since 05.19.2020
 */
package com.company.data.course;

import com.company.data.person.Faculty;
import com.company.data.person.Student;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The type Course.
 */
public class Course implements Comparable<Course> {

    /**
     * The Course department.
     */
    private String department;
    /**
     * The Course code.
     */
    private String code;
    /**
     * The Course description.
     */
    private String description;
    /**
     * The Course id.
     */
    private String courseId;
    /**
     * The Course minimum number of student.
     */
    private int minStudentForCourse;
    /**
     * The Course maximum number of student.
     */
    private int maxStudentForCourse;
    /**
     * The status if the Course is cancelled.
     */
    private boolean cancelledStatus;
    /**
     * The Student list.
     */
    public ArrayList<Student> studentList;
    /**
     * The Session list.
     */
    public ArrayList<Session> sessionList;

    // -------------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------------

    /**
     * Instantiates a new Course.
     */
    public Course() {

    }

    /**
     * Instantiates a new Course.
     *
     * @param department          the department
     * @param code                the code
     * @param description         the description
     * @param courseId            the course id
     * @param minStudentForCourse the min student for course
     * @param maxStudentForCourse the max student for course
     * @throws Exception the exception
     */
    public Course(String department,
                  String code,
                  String description,
                  String courseId,
                  int minStudentForCourse,
                  int maxStudentForCourse) throws Exception {
        setDepartment(department);
        setCode(code);
        setDescription(description);
        setCourseId(courseId);
        setMinStudentForCourse(minStudentForCourse);
        setMaxStudentForCourse(maxStudentForCourse);

        studentList = new ArrayList<>();
        sessionList = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // ACCESSORS - GETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets course id.
     *
     * @return the course id
     */
    public String getCourseId() {
        generateId();
        return courseId;
    }

    /**
     * Gets min student for course.
     *
     * @return the min student for course
     */
    public int getMinStudentForCourse() {
        return minStudentForCourse;
    }

    /**
     * Gets max student for course.
     *
     * @return the max student for course
     */
    public int getMaxStudentForCourse() {
        return maxStudentForCourse;
    }

    /**
     * Gets cancelled status.
     *
     * @return the cancelled status
     */
    public boolean getCancelledStatus() {
        updateCancelledStatus();
        return cancelledStatus;
    }

    // -------------------------------------------------------------------------
    // MUTATORS - SETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Sets department.
     *
     * @param department the department
     * @throws Exception the exception
     */
    public void setDepartment(String department) throws Exception {
        checkStringValue(department, "Department");
        this.department = department;
    }

    /**
     * Sets code.
     *
     * @param code the code
     * @throws Exception the exception
     */
    public void setCode(String code) throws Exception {
        checkStringValue(code, "Code");
        this.code = code;
    }

    /**
     * Sets description.
     *
     * @param description the description
     * @throws Exception the exception
     */
    public void setDescription(String description) throws Exception {
        checkStringValue(description, "Description");
        this.description = description;
    }

    /**
     * Sets course id.
     *
     * @param courseId the course id
     * @throws Exception the exception
     */
    public void setCourseId(String courseId) throws Exception {
        checkStringValue(courseId, "CourseId");
        this.courseId = courseId;
    }

    /**
     * Sets min student for course.
     *
     * @param minStudentForCourse the min student for course
     */
    public void setMinStudentForCourse(int minStudentForCourse) {
        this.minStudentForCourse = minStudentForCourse;
    }

    /**
     * Sets max student for course.
     *
     * @param maxStudentForCourse the max student for course
     */
    public void setMaxStudentForCourse(int maxStudentForCourse) {
        this.maxStudentForCourse = maxStudentForCourse;
    }

    /**
     * Sets cancelled status.
     *
     * @param cancelledStatus the cancelled status
     */
    public void setCancelledStatus(boolean cancelledStatus) {
        this.cancelledStatus = cancelledStatus;
    }

    // -------------------------------------------------------------------------
    // SESSION-RELATED METHODS
    // -------------------------------------------------------------------------

    /**
     * Find session session.
     *
     * @param sessionId the session id
     * @return the session
     */
    public Session findSession(String sessionId) {
        for (Session s : sessionList) {
            if (s.getSessionId().equals(sessionId)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Add session.
     *
     * @param session the session
     * @throws Exception the exception
     */
    public void addSession(Session session) throws Exception {
        Session sInDirectory = findSession(session.getSessionId());

        if (sInDirectory != null) {
            throw new Exception("Session with id "
                    + sInDirectory.getSessionId() + " is already in the list.\n");
        }
        sessionList.add(session);
    }

    /**
     * Remove session.
     *
     * @param session the session
     */
    public void removeSession(Session session) {
        sessionList.remove(session);
    }

    /**
     * Sort.
     *
     * @param comparator the comparator
     */
    public void sort(Comparator<Session> comparator) {
        sessionList.sort(comparator);
    }

    /**
     * Generate session list.
     *
     * @param pathName the path name
     */
    public void generateSessionList(String pathName) {
        String line;
        Session sessionToAdd;

        try {
            File sessionFile = new File(pathName);
            Scanner input = new Scanner(sessionFile);

            while (input.hasNext()) {
                line = input.nextLine();
                String[] lineAr = line.split("_");

                sessionList.add(new Session(courseId, lineAr[0]));
                sessionList.add(new Session(courseId, lineAr[1]));
                sessionList.add(new Session(courseId, lineAr[2]));
                sessionList.add(new Session(courseId, lineAr[3]));
                sessionList.add(new Session(courseId, lineAr[4]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------------------------------------------------------------------------
    // FUNCTIONALITY METHODS
    // -------------------------------------------------------------------------

    /**
     * Generate id.
     */
    public void generateId() {
        this.courseId = this.department + this.code;
    }

    /**
     * Check string value.
     *
     * @param valueString   the value string
     * @param attributeName the attribute name
     * @throws Exception the exception
     */
    protected void checkStringValue(String valueString, String attributeName) throws Exception {
        if (valueString == null || valueString.trim().equals("")) {
            throw new Exception(attributeName + " must be non-null and non-empty");
        }
    }

    /**
     * Update cancelled status.
     */
    public void updateCancelledStatus() {
        if (sessionList.size() == 0 || studentList.size() < minStudentForCourse) {
            cancelledStatus = true;
        } else {
            cancelledStatus = false;
        }
    }

    /**
     * Enroll student.
     *
     * @param student the student
     * @param session the session
     */
    public void enrollStudent(Student student, Session session) {
        if (studentList.size() < maxStudentForCourse
                && session.getStudentList().size() < session.maxStudentForSession) {
            studentList.add(student);
//            sessionList.add(session);
        }

        updateCancelledStatus();
    }

    /**
     * Unenroll student.
     *
     * @param student the student
     * @param session the session
     * @return true if student is unenrolled successfully.
     */
    public boolean unenrollStudent(Student student, Session session) {
        boolean unenrolled = false;

        if (studentList.remove(student) && sessionList.remove(session)) {
            studentList.remove(student);
//            sessionList.remove(session);
            unenrolled = true;
            updateCancelledStatus();
        }

        return unenrolled;
    }

    // -------------------------------------------------------------------------
    // OVERRIDDEN METHODS
    // -------------------------------------------------------------------------

    /**
     * Override toString method.
     *
     * @return a string description for the Course class
     */
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        updateCancelledStatus();

        build.append("\nCourse:               ");
        build.append(courseId);

        build.append("\nDescription:          ");
        build.append(description);

        build.append("\nClass size (min-max): ");
        build.append(minStudentForCourse);
        build.append("-");
        build.append(maxStudentForCourse);

        build.append("\nOpen seats:           ");
        build.append(maxStudentForCourse - studentList.size());
        build.append("/");
        build.append(maxStudentForCourse);

        build.append("\nStudents enrolled:    ");
        build.append(studentList.size());

        build.append("\nCancelled status:     ");
        build.append(getCancelledStatus());

        build.append("\n\n");

        build.append(sessionList.toString());

        return build.toString();
    }

    /**
     * Override compareTo method.
     *
     * @param otherCourse the other course
     * @return comparision result (i.e. -1, 0, 1) between Courses
     */
    @Override
    public int compareTo(Course otherCourse) {
        return this.courseId.compareTo(otherCourse.courseId);
    }

    /**
     * Override equals method.
     *
     * @param obj the object
     * @return the result of thisCourse equals otherCourse as a boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Course)) {
            return false;
        }

        return compareTo((Course) obj) == 0;
    }
}
