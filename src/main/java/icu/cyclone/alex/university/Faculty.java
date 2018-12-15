package icu.cyclone.alex.university;

import lombok.Getter;

@Getter
public enum Faculty {
    JAVA("Java"),
    ANDROID("Android"),
    CSHARP("C#"),
    FRONTEND("Front-End"),
    WEBDESIGN("Web-Design"),
    QA("QA");

    private String faculty;

    Faculty(String faculty) {
        this.faculty = faculty;
    }
}
