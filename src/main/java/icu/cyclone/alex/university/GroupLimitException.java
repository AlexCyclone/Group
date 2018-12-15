package icu.cyclone.alex.university;

public class GroupLimitException extends RuntimeException {
    public String getMessage(){
        return "The maximum count of students in the group has been reached";
    }
}
