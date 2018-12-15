package icu.cyclone.alex.university;

import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {
    private String name;
    private String patronymic;
    private String surname;
    private Calendar birthDay;

    @Override
    public String toString() {
        return surname + ' ' +
                name + ' ' +
                (patronymic == null || patronymic.equals("") ? "" : patronymic + ' ') +
                String.format("%1$td.%1$tm.%1$tY", birthDay);
    }
}
