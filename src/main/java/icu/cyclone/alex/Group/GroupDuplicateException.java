package icu.cyclone.alex.Group;

public class GroupDuplicateException extends RuntimeException {
    public String getMessage() {
        return "Duplicate person or record book";
    }
}
