/**
 * @author Caroline Ta
 * @since 05.19.2020
 */
package com.company.data.course;

import com.company.data.person.Faculty;
import com.company.data.person.Student;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * The type Session.
 */
public class Session implements Comparable<Session>{

    /**
     * The Min student for session.
     */
    final int minStudentForSession = 2;
    /**
     * The Max student for session.
     */
    final int maxStudentForSession = 7;
    /**
     * The course id of the session.
     */
    private String courseIdOfSession;
    /**
     * The session id.
     */
    private String sessionId;
    /**
     * The teacher for session.
     */
    private Faculty teacher;
    /**
     * The student list in the session.
     */
    private ArrayList<Student> studentList;
    /**
     * The number of students in session.
     */
    private int studentsInSession = 0;
    /**
     * The session's filled status.
     */
    private boolean isFilled;
    /**
     * The session's cancelled status.
     */
    private boolean isCancelled;

    // -------------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------------

    /**
     * Instantiates a new Session.
     */
    public Session()
    {

    }

    /**
     * Instantiates a new Session.
     *
     * @param courseIdOfSession the course id of session
     * @param sessionId         the session id
     * @throws Exception the exception
     */
    public Session(String courseIdOfSession, String sessionId) throws Exception
    {
        setCourseIdOfSession(courseIdOfSession);
        setSessionId(sessionId);
        studentList = new ArrayList<>();
    }

    /**
     * Instantiates a new Session.
     *
     * @param student   the student
     * @param sessionId the session id
     * @param teacher   the teacher
     * @throws Exception the exception
     */
    public Session(Student student, String sessionId, Faculty teacher) throws Exception
    {
        studentList = new ArrayList<>();
        studentList.add(student);
        setSessionId(sessionId);
        setTeacher(teacher);
    }

    // -------------------------------------------------------------------------
    // ACCESSORS - GETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Gets min student for session.
     *
     * @return the min student for session
     */
    public int getMinStudentForSession() {
        return minStudentForSession;
    }

    /**
     * Gets max student for session.
     *
     * @return the max student for session
     */
    public int getMaxStudentForSession() {
        return maxStudentForSession;
    }

    /**
     * Gets teacher.
     *
     * @return the teacher
     */
    public String getTeacher() {
        return teacher.toString();
    }

    public String getCourseIdOfSession() {
        return courseIdOfSession;
    }

    /**
     * Gets session id.
     *
     * @return the session id
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Gets student list.
     *
     * @return the student list
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    /**
     * Gets students in session.
     *
     * @return the students in session
     */
    public int getStudentsInSession() {
        return studentsInSession;
    }

    /**
     * Gets session filled status.
     *
     * @return true if session is filled.
     */
    public boolean getFilledStatus() {
        updateFilledStatus();
        return isFilled;
    }

    /**
     * Gets session cancelled status.
     *
     * @return true if session is cancelled.
     */
    public boolean getCancelledStatus() {
        updateCancelledStatus();
        return isCancelled;
    }

    // -------------------------------------------------------------------------
    // MUTATORS - SETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Sets course id of session.
     *
     * @param courseIdOfSession the course id of session
     * @throws Exception the exception
     */
    public void setCourseIdOfSession(String courseIdOfSession) throws Exception {
        checkStringValue(courseIdOfSession, "CourseIdOfSession");
        this.courseIdOfSession = courseIdOfSession;
    }

    /**
     * Sets session id.
     *
     * @param sessionId the session id
     * @throws Exception the exception
     */
    public void setSessionId(String sessionId) throws Exception {
        checkStringValue(sessionId, "SessionId");
        this.sessionId = sessionId;
    }

    /**
     * Sets teacher.
     *
     * @param teacher the teacher
     */
    public void setTeacher(Faculty teacher) {
        this.teacher = teacher;
    }

    public void unsetTeacher()
    {
        this.teacher = null;
    }

    /**
     * Sets cancelled status.
     *
     * @param status cancelled
     */
    public void setCancelledStatus(boolean status) {
        isCancelled = status;
    }

    // -------------------------------------------------------------------------
    // FUNCTIONALITY METHODS
    // -------------------------------------------------------------------------

    /**
     * Add course.
     *
     * @param studentToAdd the student to add
     */
    public void addStudent(Student studentToAdd) {

        if (!studentList.contains(studentToAdd)) {
            studentList.add(studentToAdd);
        }

        updateFilledStatus();
        updateCancelledStatus();
        updateStudentsInSession();
    }

    /**
     * Remove course boolean.
     *
     * @param studentToRemove the student to remove
     * @return the boolean
     */
    public boolean removeStudent(Student studentToRemove) {

        studentList.remove(studentToRemove);
        updateFilledStatus();
        updateCancelledStatus();
        updateStudentsInSession();

        return studentList.remove(studentToRemove);
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

    public void setStudentsInSession(int studentsInSession) {
        this.studentsInSession = studentList.size();
    }

    /**
     * Update filled status.
     */
    public void updateFilledStatus()
    {
        isFilled = studentList.size() == maxStudentForSession;
    }

    /**
     * Update cancelled status.
     */
    public void updateCancelledStatus()
    {
        isCancelled = studentList.size() < minStudentForSession;
    }

    public void updateStudentsInSession()
    {
        studentsInSession = studentList.size();
    }

    public String printSessionIdOnly()
    {
        StringBuilder build = new StringBuilder();
        build.append("Session Id: ");
        build.append(sessionId);
        build.append("\tAvailable seats: ");
        build.append(maxStudentForSession - studentsInSession);
        build.append("/");
        build.append(maxStudentForSession);

        return build.toString();
    }

    public String printStudentList()
    {
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < studentList.size(); i++)
        {
            build.append("\n\tStudent #");
            build.append(i+1);
            build.append(": ");
            build.append(studentList.get(i).getName());
            build.append("\t");
            build.append(studentList.get(i).getId());
        }

        build.append("\n");

        return build.toString();
    }

    // -------------------------------------------------------------------------
    // OVERRIDDEN METHODS
    // -------------------------------------------------------------------------

    /**
     * Override toString method.
     *
     * @return a string description of the Session class.
     */
    @Override
    public String toString()
    {
        StringBuilder build = new StringBuilder();
        build.append("Session Id: ");
        build.append(sessionId);
        build.append("\tAvailable seats: ");
        build.append(maxStudentForSession - studentsInSession);
        build.append("/");
        build.append(maxStudentForSession);
        build.append("\n\tInstructor:     ");

        if(teacher == null)
        {
            build.append("N/A");
        }
        else
        {
            build.append(teacher.getName());
        }

        build.append("\n");

        return build.toString();
    }

    /**
     * Override compareTo method.
     *
     * @param otherSession other session
     * @return comparision result (i.e. -1, 0, -1) between Sessions.
     */
    @Override
    public int compareTo(@NotNull Session otherSession) {
        return this.sessionId.compareTo(otherSession.sessionId);
    }

    /**
     * Override equals method.
     *
     * @param obj object
     * @return the result of thisSession equals otherSession as a boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Session)) {
            return false;
        }

        return compareTo((Session) obj) == 0;
    }
}
