package icu.cyclone.alex;

import icu.cyclone.alex.university.Faculty;
import icu.cyclone.alex.university.Group;
import icu.cyclone.alex.university.GroupLimitException;
import icu.cyclone.alex.university.Student;
import icu.cyclone.alex.utils.Utils;

public class Test {
    public static void run() {
        Group group = new Group(2, Faculty.JAVA, 3);
        fillGroup(group);
        System.out.println(group);
        Student rem = group.getStudents().get(0);
        group.rmStudent(rem);
        System.out.println(group);
    }

    private static void fillGroup(Group group) {
        Student[] students = {
                new Student("John", null, "Dou",
                        Utils.toCalendar("28.10.1979", "dd.MM.yyyy"), 2455432),
                new Student("Edgar", "Alan", "Po",
                        Utils.toCalendar("15.02.1864", "dd.MM.yyyy"), 7465623),
                new Student("Bill", null, "Fur",
                        Utils.toCalendar("01.09.1973", "dd.MM.yyyy"), 8453456),
                new Student("John5", null, "Dou",
                        Utils.toCalendar("28.10.1984", "dd.MM.yyyy"), 3572865),
                new Student("John7", null, "Dou",
                        Utils.toCalendar("28.10.1984", "dd.MM.yyyy"), 4567343),
                new Student("John8", null, "Dou",
                        Utils.toCalendar("28.10.1984", "dd.MM.yyyy"), 8635654),
                new Student("John", null, "Dou5",
                        Utils.toCalendar("28.10.1984", "dd.MM.yyyy"), 3475435),
                new Student("John", null, "Dou4",
                        Utils.toCalendar("28.10.1984", "dd.MM.yyyy"), 3456745),
                new Student("John", null, "Dou9",
                        Utils.toCalendar("28.10.1984", "dd.MM.yyyy"), 7245755),
                new Student("John", null, "Dou2",
                        Utils.toCalendar("28.10.1984", "dd.MM.yyyy"), 3333376),
                new Student("John", null, "Dou2",
                        Utils.toCalendar("28.10.1984", "dd.MM.yyyy"), 3333376),
        };
        for (Student student : students) {
            try {
                group.addStudent(student);
            } catch (GroupLimitException e) {
                e.printStackTrace();
            }
        }
    }
}
