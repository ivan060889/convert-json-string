package in.reqres.api.convert.json.string.util;

public class UserUtil {

    public static String convertFieldsToString(String field, String value) {
        StringBuilder result = new StringBuilder(Constants.SYMBOL_SMALL_THAN);
        result.append(field).append(Constants.SYMBOL_GREATER_THAN).append(value);
        return result.toString();
    }
}
