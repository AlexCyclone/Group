package icu.cyclone.alex.Group;

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Group implements Recruits {
    @Getter
    private ArrayList<Student> students = new ArrayList<>();
    protected final int maxGroupSize = 10;
    protected final int maxCourse = 5;
    @Getter
    @Setter
    @NonNull
    private Integer number;
    @Getter
    @Setter
    @NonNull
    private Faculty faculty;
    @Getter
    @Setter
    @NonNull
    private Integer course;

    public int getSize() {
        return students.size();
    }

    public int addStudent(@NonNull Student student) throws GroupLimitException, GroupDuplicateException {
        int size = getSize();
        if (getSize() == maxGroupSize) {
            throw new GroupLimitException();
        }
        if (findByPerson(student) != null || findByRecordBook(student.getRecordBook()) != null) {
            throw new GroupDuplicateException();
        }
        students.add(student);
        return getSize() - size;
    }

    public int rmStudent(@NonNull Student student) {
        int size = getSize();
        students.remove(student);
        return size - getSize();
    }

    public Student findByPerson(@NonNull Person person) {
        for (Student student : students) {
            if (student.superEquals(person)) {
                return student;
            }
        }
        return null;
    }

    public Student findByRecordBook(int recordBook) {
        for (Student student : students) {
            if (student.getRecordBook().equals(recordBook)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student[] getRecruits() {
        ArrayList<Student> recruits = students.stream()
                .filter(student -> student.getSex() && student.getAge() >= 18)
                .collect(Collectors.toCollection(ArrayList::new));
        Student[] res = new Student[recruits.size()];
        return recruits.toArray(res);
    }

    public void orderByField(StudentField field) {
        switch (field) {
            case RECORDBOOK:
                students.sort(Comparator.comparing(o -> (o.getRecordBook())));
                break;
            case FULLNAME:
                students.sort(Comparator.comparing(o -> (o.getFullName())));
                break;
            case SURNAME:
                students.sort(Comparator.comparing(o -> (o.getSurname())));
                break;
            case NAME:
                students.sort(Comparator.comparing(o -> (o.getName())));
                break;
            case PATRONYMIC:
                students.sort(Comparator.comparing(o -> (o.getPatronymic())));
                break;
            case BIRTHDAY:
                students.sort(Comparator.comparing(o -> (o.getBirthDay())));
        }
    }

    public void runCli() {
        new Cli(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group number ").append(number)
                .append(", course ").append(course)
                .append(", faculty ").append(faculty)
                .append(System.lineSeparator());
        for (Student s : students) {
            sb.append(s.toString()).append(System.lineSeparator());
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
