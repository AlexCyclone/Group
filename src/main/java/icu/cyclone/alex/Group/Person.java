package icu.cyclone.alex.Group;

import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private Boolean sex;
    private Calendar birthDay;

    public String getFullName() {
        return surname + ' ' + name + ' ' + patronymic;
    }

    public String getSexText() {
        return sex ? "male" : "female";
    }

    @Override
    public String toString() {
        return surname + ' ' +
                name + ' ' +
                (patronymic == null || patronymic.equals("") ? "" : patronymic + ' ') +
                getSexText() + ' ' +
                String.format("%1$td.%1$tm.%1$tY", birthDay);
    }
}
