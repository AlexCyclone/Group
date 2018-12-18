package icu.cyclone.alex.Group;

public enum Faculty {
    JAVA("Java"),
    ANDROID("Android"),
    CSHARP("C#"),
    FRONTEND("Front-End"),
    WEBDESIGN("Web-Design"),
    QA("QA");

    private String name;

    Faculty(String faculty) {
        this.name = faculty;
    }

    @Override
    public String toString() {
        return name;
    }
}
