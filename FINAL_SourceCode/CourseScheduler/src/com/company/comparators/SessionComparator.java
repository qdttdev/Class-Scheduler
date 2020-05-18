/**
 * @author Caroline Ta
 * @since 05.19.2020
 */

package com.company.comparators;

import com.company.data.course.Session;

import java.util.Comparator;

/**
 * The type Session comparator.
 */
public class SessionComparator implements Comparator<Session> {
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
    public int compare(Session o1, Session o2) {

        return o1.getSessionId().compareTo(o2.getSessionId());
    }
}
