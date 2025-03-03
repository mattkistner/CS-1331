/**
 * A subclass of the Course Class that creates a LabScience course.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class LabScience extends Course {
    private boolean labCoatRequired;

    /**
     * Constructor that instantiates a LabScience course.
     * @param cN String representing the course name.
     * @param id int representing the course in 5 digits.
     * @param pN String representing the professor's name.
     * @param lCR boolean indicating if a lab coat is required.
     */
    public LabScience(String cN, int id, String pN, boolean lCR) {
        super(cN, id, pN);
        this.labCoatRequired = lCR;
    }

    @Override
    public String toString() {
        return "LabScience," + super.toString() + "," + this.labCoatRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof LabScience) {
            LabScience ls = (LabScience) o;
            return super.equals(ls) && this.labCoatRequired == ls.labCoatRequired;
        }
        return false;
    }

    /**
     * A getter for the boolean labCoatRequired.
     * @return boolean labCoatRequired.
     */
    public boolean getLabCoatRequired() {
        return this.labCoatRequired;
    }
}