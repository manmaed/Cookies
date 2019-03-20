package net.manmaed.cookies.lib;

public class EnumUtil {
    public static String getNameOfEnum(Enum<?> enumValue) {
        return enumValue.name().toLowerCase();
    }

    public static String getNameOfEnum(Enum<?>... enumValues) {
        StringBuilder builder = new StringBuilder();
        int length = enumValues.length;
        for (int i = 0; i < length; i++) {
            Enum<?> enumValue = enumValues[i];
            builder.append(getNameOfEnum(enumValue));
            if(i + 1 != length) {
                builder.append("_");
            }
        }
        return builder.toString();
    }

}
