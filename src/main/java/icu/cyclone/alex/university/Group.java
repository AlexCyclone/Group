package icu.cyclone.alex.university;

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;

@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"students", "maxGroupSize"})
public class Group {
    @Getter
    private ArrayList<Student> students = new ArrayList<>();
    private final int maxGroupSize = 10;
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

    public int addStudent(Student student) throws GroupLimitException {
        int size = getSize();
        if (size == maxGroupSize) {
            throw new GroupLimitException();
        }
        if (!students.contains(student)) {
            students.add(student);
        }
        return getSize() - size;
    }

    public int rmStudent(Student student) {
        int size = getSize();
        students.remove(student);
        return size - getSize();
    }

    private void orderByName() {
        students.sort(Comparator.comparing(o -> (o.getSurname() + ' ' + o.getName() + ' ' + o.getPatronymic())));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group number ").append(number)
                .append(", course ").append(course)
                .append(", faculty ").append(faculty)
                .append(System.lineSeparator());
        orderByName();
        for (Student s : students) {
            sb.append(s.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
