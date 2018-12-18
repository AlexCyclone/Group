package icu.cyclone.alex.utils;

public class UText {
    final public static String SLS = System.lineSeparator();

    public static String arrayToStr(Object[] array, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i].toString()).append(separator);
        }
        sb.append(array[array.length - 1]);
        return sb.toString();
    }

    public static <T extends Enum<T>> String enumToStr(Class<T> aEnum, String textBefore,
                                                     String textAfter, String separator, boolean numbered)
    {
        T[] array = aEnum.getEnumConstants();
        if (array.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            if (numbered) {
                sb.append(i);
            }
            sb.append(textBefore).append(array[i]).append(textAfter).append(separator);
        }
        if (numbered) {
            sb.append(array.length - 1);
        }
        sb.append(textBefore).append(array[array.length - 1].toString()).append(textAfter);
        return sb.toString();
    }
}
