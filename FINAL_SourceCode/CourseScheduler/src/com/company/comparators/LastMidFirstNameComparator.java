package com.company.comparators;
/**
 * @author Caroline Ta
 * @since 05.19.2020
 */

import com.company.data.person.Person;

import java.util.Comparator;

/**
 * The type Last mid first name comparator.
 */
public class LastMidFirstNameComparator implements Comparator<Person> {

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

        String[] o1NameAr = o1FullName.split(" ", 2);
        String[] o2NameAr = o2FullName.split(" ", 2);

        String o1LastName = o1NameAr[3];
        String o2LastName = o2NameAr[3];

        return o1LastName.compareTo(o2LastName);
    }
}
