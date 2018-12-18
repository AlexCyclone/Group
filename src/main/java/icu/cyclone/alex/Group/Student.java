package icu.cyclone.alex.Group;

import lombok.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends Person {
    @NonNull
    Integer recordBook;

    public int getAge() {
        Calendar now = new GregorianCalendar();
        int age = now.get(Calendar.YEAR) - this.getBirthDay().get(Calendar.YEAR);
        return age;
    }

    public boolean superEquals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "" + recordBook + ' ' + super.toString();
    }
}
