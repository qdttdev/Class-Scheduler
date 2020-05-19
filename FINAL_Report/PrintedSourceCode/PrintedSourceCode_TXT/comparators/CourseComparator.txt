/**
 * @author Caroline Ta
 * @since 05.19.2020
 */

package com.company.comparators;

import com.company.data.course.Course;

import java.util.Comparator;

/**
 * The type Course comparator.
 */
public class CourseComparator implements Comparator<Course> {
    // -------------------------------------------------------------------------
    // OVERRIDDEN METHODS
    // -------------------------------------------------------------------------

    /**
     * Override compare method.
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return comparision between object 1 and object 2
     */
    @Override
    public int compare(Course o1, Course o2) {

        return o1.getCourseId().compareTo(o2.getCourseId());
    }
}
