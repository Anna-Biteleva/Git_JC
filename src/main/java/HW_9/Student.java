package HW_9;

import java.util.List;

public class Student {

    private String surname;
    private List<Course> courseList;

    @Override
    public String toString() {
        return ( surname + " ( всего " + courseList.size() + " курсов) ");
    }

    public Student (String  surname, List<Course> courseList){
        this.surname= surname;
        this.courseList = courseList;
    }


    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }



}
