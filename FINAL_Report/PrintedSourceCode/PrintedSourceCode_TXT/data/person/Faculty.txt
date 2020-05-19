/**
 * @author Caroline Ta
 * @since 05.19.2020
 */
package com.company.data.person;

import com.company.data.course.Course;
import com.company.data.course.Session;

import java.util.ArrayList;

/**
 * The type Faculty.
 */
public class Faculty extends Person {

    /**
     * The Faculty count.
     */
    private int facultyCount = 0;
    /**
     * The Faculty hire date.
     */
    private String hireDate;
    /**
     * The Faculty tenured status.
     */
    private boolean tenured;
    /**
     * The Faculty id.
     */
    private String id;
    /**
     * The Faculty course list.
     */
    private ArrayList<Course> facultyCourseList;
    /**
     * The Faculty session list.
     */
    private ArrayList<Session> facultySessionList;

    // -------------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------------

    /**
     * Instantiates a new Faculty.
     */
    public Faculty() {
        facultyCount++;
    }

    /**
     * Instantiates a new Faculty.
     *
     * @param nameO    the name o
     * @param email    the email
     * @param tel      the tel
     * @param addressO the address o
     * @param id       the id
     * @param hideDate the hide date
     * @param tenured  the tenured
     * @throws Exception the exception
     */
    public Faculty(PersonName nameO,
                   String email,
                   String tel,
                   PersonAddress addressO,
                   String id,
                   String hideDate,
                   boolean tenured
                   ) throws Exception {
        super(nameO, email, tel, addressO);
        setHireDate(hideDate);
        setTenured(tenured);
        setId(id);

        facultyCourseList = new ArrayList<>();
        facultyCount++;
    }

    // -------------------------------------------------------------------------
    // ACCESSORS - GETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Gets hire date.
     *
     * @return the hire date
     */
    public String getHireDate() {
        return hireDate;
    }

    /**
     * Gets tenured.
     *
     * @return the tenured
     */
    public boolean getTenured() {
        return tenured;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    public ArrayList<Course> getFacultyCourseList() {
        return facultyCourseList;
    }

    // -------------------------------------------------------------------------
    // MUTATORS - SETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Sets hire date.
     *
     * @param hireDate the hire date
     * @throws Exception the exception
     */
    public void setHireDate(String hireDate) throws Exception {
        checkStringValue(hireDate, "Hiredate");
        this.hireDate = hireDate;
    }

    /**
     * Sets tenured.
     *
     * @param tenured the tenured
     */
    public void setTenured(boolean tenured) {
        this.tenured = tenured;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @throws Exception the exception
     */
    public void setId(String id) throws Exception {
        checkStringValue(id, "Id");
        this.id = id;
    }

    // -------------------------------------------------------------------------
    // FUNCTIONALITY METHODS
    // -------------------------------------------------------------------------

    /**
     * Generate id.
     */
    public void generateId() {
        if (facultyCount < 10) {
            this.id = "F00" + facultyCount;
        } else if (facultyCount < 100) {
            this.id = "F0" + facultyCount;
        } else {
            this.id = "F" + facultyCount;
        }
    }

    /**
     * Add course.
     *
     * @param courseToAdd the course to add
     */
    public void addCourse(Course courseToAdd) {

        if (!facultyCourseList.contains(courseToAdd)) {
            facultyCourseList.add(courseToAdd);
        }
    }


    /**
     * Remove course boolean.
     *
     * @param courseToRemove the course to remove
     * @return the boolean
     */
    public boolean removeCourse(Course courseToRemove) {
        return facultyCourseList.remove(courseToRemove);
    }

    /**
     * Add session.
     *
     * @param sessionToAdd the session to add
     * @param teacher      the teacher
     */
    public void addSession(Session sessionToAdd, Faculty teacher) {
        if (!facultySessionList.contains(sessionToAdd)) {
            facultySessionList.add(sessionToAdd);
        }

        sessionToAdd.setTeacher(teacher);
    }

    /**
     * Remove session boolean.
     *
     * @param sessionToRemove the session to remove
     * @return the boolean
     */
    public boolean removeSession(Session sessionToRemove) {
        return facultySessionList.remove(sessionToRemove);
    }

    /**
     * Output faculty.
     */
    public void outputFaculty() {
        int j = 0;
        String sessionId;

        StringBuilder build = new StringBuilder();

        build.append(this.toString());

        for (int i = 0; i < facultyCourseList.size(); i++) {
            build.append("\nCourse Id: ");
            build.append(facultyCourseList.get(i).getCourseId());

            j = facultyCourseList.get(i).studentList.indexOf(this);
            sessionId = facultyCourseList.get(i).sessionList.get(j).getSessionId();
            build.append("\n\tSession Id: ");
            build.append(sessionId);
        }

        System.out.println(build.toString());
    }

    // -------------------------------------------------------------------------
    // OVERRIDDEN METHODS
    // -------------------------------------------------------------------------

    /**
     * Override toString method.
     *
     * @return a string description for the Faculty class
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());

        builder.append("\nHire date:      ");
        builder.append(hireDate);

        builder.append("\nTenured status: ");
        builder.append(tenured);

        builder.append("\nID:             ");
        builder.append(id);

        return builder.toString();
    }
}
