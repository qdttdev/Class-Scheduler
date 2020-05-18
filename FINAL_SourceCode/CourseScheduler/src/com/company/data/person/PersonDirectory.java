/**
 * @author Caroline Ta
 * @since 05.19.2020
 */

package com.company.data.person;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The type Person directory.
 */
public class PersonDirectory {

    /**
     * The list of Person.
     */
    private ArrayList<Person> personList;
    /**
     * The list of Faculty.
     */
    private ArrayList<Faculty> facultyList;
    /**
     * The list of Student.
     */
    private ArrayList<Student> studentList;

    // -------------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------------

    /**
     * Instantiates a new Person directory.
     */
    public PersonDirectory() {
        personList = new ArrayList<>();
        facultyList = new ArrayList<>();
        studentList = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // FUNCTIONALITY METHODS
    // -------------------------------------------------------------------------

    /**
     * Sort.
     *
     * @param comparator the comparator
     */
    public void sort(Comparator<Person> comparator)
    {
        personList.sort(comparator);
        facultyList.sort(comparator);
        studentList.sort(comparator);
    }

    /**
     * Find person person.
     *
     * @param personTel the person tel
     * @return the person
     */
    public Person findPerson(String personTel) {
        for (Person p : personList) {
            if (p.getTel().equals(personTel))
            {
                return p;
            }
        }

        return null;
    }

    /**
     * Add person.
     *
     * @param person the person
     * @throws Exception the exception
     */
    public void addPerson(@NotNull Person person) throws Exception {
        Person pInDirectory = findPerson(person.getTel());

        if (pInDirectory != null) {
            throw new Exception("Person with phone number "
                    + pInDirectory.getTel() + " is already in the list.\n");
        }

        personList.add(person);

        if (person instanceof Faculty) {
            facultyList.add((Faculty) person);
        } else if (person instanceof Student) {
            studentList.add((Student) person);
        }

    }

    /**
     * Remove person.
     *
     * @param person the person
     */
    public void removePerson(Person person) {

        personList.remove(person);

        if (person instanceof Faculty) {
            facultyList.remove((Faculty) person);
        } else if (person instanceof Student) {
            studentList.remove((Student) person);
        }
    }

    /**
     * Gets faculty as string.
     *
     * @return the faculty as string
     */
    public String getFacultyAsString() {
        StringBuilder build = new StringBuilder();

        build.append("\n***********************************************************");
        build.append("\n                     FACULTY DIRECTORY");
        build.append("\n-----------------------------------------------------------\n");
        for (Faculty f : facultyList) {
            build.append(f);
            build.append("\n");
        }
        build.append("\n***********************************************************\n\n");

        return build.toString();
    }

    /**
     * Gets student as string.
     *
     * @return the student as string
     */
    public String getStudentAsString() {
        StringBuilder build = new StringBuilder();
        build.append("\n***********************************************************");
        build.append("\n                     STUDENT DIRECTORY");
        build.append("\n-----------------------------------------------------------\n");
        for (Person s : studentList) {
            build.append(s);
            build.append("\n");
        }
        build.append("\n***********************************************************\n\n");

        return build.toString();
    }

    /**
     * Add person clone.
     *
     * @param person       the person
     * @param newPersonTel the new person tel
     * @throws Exception the exception
     */
    public void addPersonClone(@NotNull Person person, String newPersonTel) throws Exception
    {
        Person newPerson = (Person)person.clone();
        newPerson.setTel(newPersonTel);
        addPerson(newPerson);
    }

    /**
     * Gets faculty output data.
     *
     * @return the faculty output data
     */
    public String getFacultyOutputData()
    {
        StringBuilder build = new StringBuilder();
        build.append("\n***********************************************************");
        build.append("\n                     FACULTY OUTPUT");

        for(int i = 0; i < facultyList.size(); i++)
        {
            build.append("\n-----------------------------------------------------------\n");
            build.append(facultyList.get(i).toString());
            build.append("\n");
            build.append(facultyList.get(i).getFacultyCourseList().toString());
            build.append("\n");
        }

        build.append("\n\n***********************************************************\n\n");
        return build.toString();
    }

    /**
     * Gets scheduled students output data.
     *
     * @return the scheduled students output data
     */
    public String getScheduledStudentsOutputData()
    {
        StringBuilder build = new StringBuilder();
        build.append("\n***********************************************************");
        build.append("\n                 SCHEDULED STUDENTS OUTPUT");

        for(int i = 0; i < studentList.size(); i++)
        {
            if(studentList.get(i).getScheduledStatus())
            {
                build.append("\n-----------------------------------------------------------\n");
                build.append(studentList.get(i).toString());
                build.append("\n");
                build.append(studentList.get(i).getCourseScheduledList().toString());
                build.append("\n");
            }
        }

        build.append("\n\n***********************************************************\n\n");
        return build.toString();
    }

    /**
     * Gets unscheduled students output data.
     *
     * @return the unscheduled students output data
     */
    public String getUnscheduledStudentsOutputData()
    {
        StringBuilder build = new StringBuilder();
        build.append("\n***********************************************************");
        build.append("\n                UNSCHEDULED STUDENTS OUTPUT");

        for(int i = 0; i < studentList.size(); i++)
        {
            if(!studentList.get(i).getScheduledStatus())
            {
                build.append("\n-----------------------------------------------------------\n");
                build.append(studentList.get(i).toString());
                build.append("\n");
            }
        }

        build.append("\n\n***********************************************************\n\n");
        return build.toString();
    }

    // -------------------------------------------------------------------------
    // OVERRIDDEN METHODS
    // -------------------------------------------------------------------------

    @Override
    public String toString() {

        StringBuilder build = new StringBuilder();

        build.append("\n***********************************************************");
        build.append("\n                     PERSON DIRECTORY");
        build.append("\n-----------------------------------------------------------\n");
        for (Person p : personList) {
            build.append("\n");
            build.append(p);
        }
        build.append("\n\n***********************************************************\n\n");

        return build.toString();
    }
}
