/**
 * @author Caroline Ta
 * @since 05.19.2020
 */

package com.company.data.course;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The type Course directory.
 */
public class CourseDirectory {

    /**
     * The courseList list.
     */
    private ArrayList<Course> courseList;

    // -------------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------------

    /**
     * Instantiates a new Course directory.
     */
    public CourseDirectory()
    {
        courseList = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // ACCESSOR - GETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Gets course list.
     *
     * @return the course list
     */
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    // -------------------------------------------------------------------------
    // FUNCTIONALITY METHODS
    // -------------------------------------------------------------------------

    /**
     * Sort.
     *
     * @param comparator the comparator
     */
    public void sortCourse(Comparator<Course> comparator)
    {
        courseList.sort(comparator);
    }

    /**
     * Find course course.
     *
     * @param courseId the course id
     * @return the course
     */
    public Course findCourse(String courseId) {
        for (Course c : courseList) {
            if (c.getCourseId().equals(courseId))
            {
                return c;
            }
        }

        return null;
    }

    /**
     * Add course.
     *
     * @param course the course
     * @throws Exception the exception
     */
    public void addCourse(Course course) throws Exception {
        Course cInDirectory = findCourse(course.getCourseId());

        if (cInDirectory != null) {
            throw new Exception("Course "
                    + cInDirectory.getCourseId() + " is already in the list.\n");
        }

        courseList.add(course);
    }

    /**
     * Remove course.
     *
     * @param course the course
     */
    public void removeCourse(Course course) {
        courseList.remove(course);
    }

    /**
     * Generate session.
     *
     * @param courseId the course id
     * @param path     the path
     */
    public void generateSession(String courseId, String path)
    {
        findCourse(courseId).generateSessionList(path);
    }

    // -------------------------------------------------------------------------
    // OUTPUT METHODS
    // -------------------------------------------------------------------------

    /**
     * Print course w session string.
     *
     * @return the string
     */
    public String printCourseWSession()
    {
        StringBuilder build = new StringBuilder();

        build.append("\n***********************************************************");
        build.append("\n               COURSE SCHEDULE WITH SESSIONS");
        for (Course p : courseList) {
            build.append("\n-----------------------------------------------------------");
            build.append("\n");
            build.append(p);
            build.append("\n\n");
//            for(int i = 0; i < p.sessionList.size(); i++)
//            {
//                build.append("\t#");
//                build.append(i+1);
//                build.append(" ");
//                build.append(p.sessionList.get(i).toString());
//            }
        }
        build.append("\n***********************************************************\n\n");

        return build.toString();
    }

    /**
     * Gets scheduled course sessions output data.
     *
     * @return the scheduled course sessions output data
     */
    public String getScheduledCourseSessionsOutputData()
    {
        StringBuilder build = new StringBuilder();
        build.append("\n***********************************************************");
        build.append("\n              SCHEDULED COURSE SESSIONS OUTPUT");

        for(int i = 0; i < courseList.size(); i++)
        {
            if(!courseList.get(i).getCancelledStatus())
            {
                build.append("\n-----------------------------------------------------------\n");
                build.append(courseList.get(i).toString());
                build.append("\n");
            }
        }

        build.append("\n\n***********************************************************\n\n");
        return build.toString();
    }

    /**
     * Gets unscheduled course sessions output data.
     *
     * @return the unscheduled course sessions output data
     */
    public String getUnscheduledCourseSessionsOutputData()
    {
        StringBuilder build = new StringBuilder();
        build.append("\n***********************************************************");
        build.append("\n            UNSCHEDULED COURSE SESSIONS OUTPUT");

        for(int i = 0; i < courseList.size(); i++)
        {
            if(courseList.get(i).getCancelledStatus())
            {
                build.append("\n-----------------------------------------------------------\n");
                build.append(courseList.get(i).toString());
                build.append("\n");
                build.append(courseList.get(i).studentList.toString());
                build.append("\n");
            }
        }

        build.append("\n\n***********************************************************\n\n");
        return build.toString();
    }

    // -------------------------------------------------------------------------
    // OVERRIDDEN METHODS
    // -------------------------------------------------------------------------

    /**
     * Override toString method.
     *
     *  @return a string description of the CourseDirectory class.
     */
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("\n***********************************************************");
        build.append("\n                     COURSE DIRECTORY");
        build.append("\n-----------------------------------------------------------");
        for (Course p : courseList) {
            build.append("\n");
            build.append(p);
        }
        build.append("\n\n***********************************************************\n\n");

        return build.toString();
    }
}
