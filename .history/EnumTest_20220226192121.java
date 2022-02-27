import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        
        
    }

    enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        private Size(String abbreviation) {
            this.abbreviation = abbreviation;}

        public String getAbbreviation() {
            return abbreviation;
        }
        private String abbreviation;
    }
}
