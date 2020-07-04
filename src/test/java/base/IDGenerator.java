package base;

public class IDGenerator {

    public static String idFor(String id) {
        if (AppiumConfigurations.platform.equalsIgnoreCase(AppiumConfigurations.ANDROID)) {
            return "com.android.calculator2:id/" + id;
        } else {
            return "com.ios.mycalc:id/" + id;
        }
    }

}
