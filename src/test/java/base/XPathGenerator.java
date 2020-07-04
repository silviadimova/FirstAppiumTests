package base;



public class XPathGenerator {

    public static String toXPathWithText(String text) {
        String variable;
        if (AppiumConfigurations.platform.equals(AppiumConfigurations.IOS)) {
            variable = "name";
        }
        else {
            variable = "text";
        }
        return "//*[contains(@" + variable + ", '" + text + "')]";
    }

    public static String toXPathWithValue(String text){
        return "//*[contains(@value,'"+text+"')]";
    }

    public static String toXPathWithContentDesc(String description){
        return "//*[contains(@content-desc, '"+ description +"')]";
    }
}
