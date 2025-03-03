/**
 * A subclass of the Course class that creates a Computer Science course.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class ComputerScience extends Course {
    private String language;

    /**
     * A constructor that creates a Computer Science class.
     * @param cN String representing the course name.
     * @param id int representing the course in 5 digits.
     * @param pN String representing the professor's name.
     * @param language String showing which language the CS course is taught in.
     * @throws IllegalArgumentException if certain conditions are not met.
     */
    public ComputerScience(String cN, int id, String pN, String language) throws IllegalArgumentException {
        super(cN, id, pN);
        if (language == null || language.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.language = language;
        }
    }

    @Override
    public String toString() {
        return "ComputerScience," + super.toString() + "," + this.language;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof ComputerScience) {
            ComputerScience cs = (ComputerScience) o;
            return super.equals(cs) && this.language.equals(cs.language);
        }
        return false;
    }

    /**
     * A getter for the String language.
     * @return String language.
     */
    public String getLanguage() {
        return this.language;
    }
}