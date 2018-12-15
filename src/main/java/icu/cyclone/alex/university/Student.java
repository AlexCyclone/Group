package icu.cyclone.alex.university;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Student extends Person {
    Integer recordBook;

    public Student(String name, String patronymic, String surname, Calendar birthDay, Integer recordBook) {
        super(name, patronymic, surname, birthDay);
        this.recordBook = recordBook;
    }

    @Override
    public String toString() {
        return "Record Book: " + recordBook + ' ' + super.toString();
    }
}
