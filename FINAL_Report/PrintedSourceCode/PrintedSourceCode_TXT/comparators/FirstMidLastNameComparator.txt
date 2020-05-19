/**
 * @author Caroline Ta
 * @since 05.19.2020
 */

package com.company.comparators;

import com.company.data.person.Person;

import java.util.Comparator;

/**
 * The type First mid last name comparator.
 */
public class FirstMidLastNameComparator implements Comparator<Person> {

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
    public int compare(Person o1, Person o2) {

        String o1FullName = o1.getName();
        String o2FullName = o2.getName();

        return o1FullName.compareTo(o2FullName);
    }
}
