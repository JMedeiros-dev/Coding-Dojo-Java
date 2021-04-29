import java.util.ArrayList;

public class Exceptions {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("Casted element to an Integer: " + castedValue);
            } catch (Exception e) {
                System.out.println("Error occurred at index: " + i);
                System.out.println("The value of the object that triggered the error: " + myList.get(i));

            }
        }
    }
}