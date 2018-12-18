package icu.cyclone.alex.Group;

import icu.cyclone.alex.utils.UText;
import icu.cyclone.alex.utils.UCli;

import java.util.Scanner;

public class Cli {
    Group group;

    public Cli(Group group) {
        this.group = group;
        runCli();
    }

    private void runCli() {
        do {
            printMain();
        }
        while (caseMain());
    }

    private void printMain() {
        StringBuilder sb = new StringBuilder("Make your choice:");
        sb.append(UText.SLS)
                .append("1: Print group").append(UText.SLS)
                .append("2: Set group parameters").append(UText.SLS)
                .append("3: Add student").append(UText.SLS)
                .append("4: Remove student by Record Book number").append(UText.SLS)
                .append("5: Order by field").append(UText.SLS)
                .append("6: Show recruits").append(UText.SLS)
                .append("q: Quit").append(UText.SLS);
        System.out.println(sb.toString());
    }

    private boolean caseMain() {
        Scanner sc = new Scanner(System.in);
        String request = sc.nextLine();
        if (request.equalsIgnoreCase("q")) {
            return false;
        }
        switch (request) {
            case "1":
                printGroup();
                break;
            case "2":
                setParameters();
                break;
            case "3":
                addStudent();
                break;
            case "4":
                removeStudent();
                break;
            case "5":
                orderBy();
                break;
            case "6":
                printRecruits(group);
                break;
            default:
                UCli.printAndWait("Incorrect input. Please try again.");
        }
        return true;
    }

    private void printGroup() {
        UCli.printAndWait(group.toString());
    }

    private void setParameters() {
        group.setNumber(UCli.intRequest("Input group number:", 1, Integer.MAX_VALUE));
        group.setCourse(UCli.intRequest("Input course number:", 1, group.maxCourse));
        group.setFaculty(UCli.enumRequest("Select faculty:", Faculty.class));
        UCli.printAndWait("Done");
    }

    private void addStudent() {
        try {
            if (group.addStudent(studentRequest()) > 0) {
                UCli.printAndWait("Done");
            }
        } catch (GroupLimitException | GroupDuplicateException e) {

            UCli.printAndWait(e.getMessage());
        }
    }

    private Student studentRequest() {
        Student student = new Student();
        student.setSurname(UCli.notEmptyString("Input surname:"));
        student.setName(UCli.notEmptyString("Input name:"));
        student.setPatronymic(UCli.trimmedString("Input patronymic:"));
        student.setSex(UCli.boolRequest("Input sex (m - male, f - female):", "m", "f"));
        student.setBirthDay(UCli.calendarRequest("Input birthday (dd.MM.yyyy)", "dd.MM.yyyy"));
        student.setRecordBook(UCli.intRequest("Input record book number:", 1, Integer.MAX_VALUE));
        return student;
    }

    private void removeStudent() {
        try {
            if (group.rmStudent(group.findByRecordBook(UCli.intRequest("Input record book number:"))) > 0) {
                UCli.printAndWait("Done");
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            UCli.printAndWait("Record not found");
        }
    }

    private void orderBy() {
        group.orderByField(UCli.enumRequest("Select Field", StudentField.class));
    }

    private void printRecruits(Recruits recruits) {
        Student[] students = recruits.getRecruits();
        System.out.println("Recruits list:");
        UCli.printAndWait(UText.arrayToStr(students, System.lineSeparator()));
    }
}
