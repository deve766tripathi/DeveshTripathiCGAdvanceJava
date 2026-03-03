package in.cg.beans;

import java.util.Arrays;

public class Subject {

    private String[] subjects;

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return Arrays.toString(subjects);
    }
}