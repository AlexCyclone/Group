package icu.cyclone.alex.Group;

public enum StudentField {
    RECORDBOOK("Record Book"),
    FULLNAME("Full Name"),
    SURNAME("Surname"),
    NAME("Name"),
    PATRONYMIC("Patronymic"),
    BIRTHDAY("Birth Day");

    private String name;

    StudentField(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
