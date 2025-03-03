import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * A class to write and read csv files as well as test Course objects.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Classes {
    /**
     * Method that reads through a csv and creates Course objects from each line.
     * @param file String defining the csv to be read through.
     * @return ArrayList of Course objects read from the csv.
     * @throws FileNotFoundException if no file found.
     */
    public static ArrayList<Course> outputCourses(String file) throws FileNotFoundException {
        ArrayList<Course> courses = new ArrayList<>();
        Scanner scan = new Scanner(new File(file));
        while (scan.hasNextLine()) {
            String info = scan.nextLine();
            String[] l = new String[5];
            l = info.split(",");
            if (l[0].equals("ComputerScience")) {
                courses.add(new ComputerScience(l[1], Integer.parseInt(l[2]), l[3], l[4]));
            } else if (l[0].equals("LabScience")) {
                courses.add(new LabScience(l[1], Integer.parseInt(l[2]), l[3], Boolean.parseBoolean(l[4])));
            } else {
                scan.close();
                throw new InvalidCourseException();
            }
        }
        scan.close();
        return courses;
    }

    /**
     * Method that writes Course objects to a csv file.
     * @param file String representing the file to be written on.
     * @param c ArrayList of Course objects to be written to the file.
     * @return boolean indicating if the Course objects were written in.
     * @throws FileNotFoundException if no file found.
     */
    public static boolean writeCourses(String file, ArrayList<Course> c) throws FileNotFoundException {
        try {
            PrintWriter print = new PrintWriter(file);
            for (Course co : c) {
                String s = co.toString();
                print.println(s);
            }
            print.close();
            return true;
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            return false;
        }
    }

    /**
     * A method that reads Course objects from a file and identifies the index where a Course is found.
     * @param file String representing the file to be read.
     * @param c Course object to be found in the file.
     * @return ArrayList of Integer representing the index(s) where the course is found.
     * @throws FileNotFoundException if no file found.
     */
    public static ArrayList<Integer> readCourses(String file, Course c) throws FileNotFoundException {
        ArrayList<Course> courses = outputCourses(file);
        ArrayList<Integer> i = new ArrayList<>();
        for (int a = 0; a < courses.size(); a++) {
            if (c.equals(courses.get(a))) {
                i.add((Integer) a + 1);
            }
        }
        if (i.size() == 0) {
            throw new InvalidCourseException();
        }
        return i;
    }

    /**
     * A main method to test the code.
     * @param args standard parameter.
     */
    public static void main(String[] args) {
        ComputerScience cs1 = new ComputerScience("CS 3451", 627891, "Vuduc", "C++");
        ComputerScience cs2 = new ComputerScience("CS 4140", 58931, "Mac", "Python");
        ComputerScience cs3 = new ComputerScience("CS 1331", 42865, "Landry", "");
        LabScience ls1 = new LabScience("CHEM 1211", 46821, "Evans", true);
        LabScience ls2 = new LabScience("", 89765, "Fenton", false);
        LabScience ls3 = new LabScience("EAS 1600", 97645, "", true);
        try {
            ArrayList<Course> c1 = new ArrayList<>(java.util.Arrays.asList(cs1, cs2, cs3, ls1, ls2, ls3));
            writeCourses("TestCourses.csv", c1);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCourseException e) {
            System.out.println(e.getMessage());
        }
        ComputerScience cs4 = new ComputerScience("CS 1100", 86753, "Mark", "None");
        ArrayList<Course> c2 = new ArrayList<>(java.util.Arrays.asList(cs4));
        try {
            writeCourses("TestCourses.csv", c2);
            ArrayList<Course> o1 = outputCourses("TestCourses.csv");
            for (Course c : o1) {
                System.out.println(c.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCourseException e) {
            System.out.println(e.getMessage());
        }
    }
}