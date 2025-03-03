/**
 * An abstract class meant to be the parent class for creating a college course.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public abstract class Course {
    protected String courseName;
    protected int id;
    protected String professorName;

    /**
     * A constructor to create an instance of a course.
     * @param courseName String representing the course title.
     * @param id int identifying the course in 5 digits.
     * @param professorName String representing the Lecturer.
     * @throws IllegalArgumentException if certain conditions are not met.
     */
    public Course(String courseName, int id, String professorName) throws IllegalArgumentException {
        if (courseName == null || courseName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.courseName = courseName;
        }
        if (id > 99999 || id < 10000) {
            throw new IllegalArgumentException();
        } else {
            this.id = id;
        }
        if (professorName == null || professorName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.professorName = professorName;
        }
    }

    @Override
    public String toString() {
        String s1 = String.format("%s,%d,%s", this.courseName, this.id, this.professorName);
        return s1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof Course) {
            Course c = (Course) o;
            return c.courseName.equals(this.courseName) && c.id == this.id
                && c.professorName.equals(this.professorName);
        }
        return false;
    }
}