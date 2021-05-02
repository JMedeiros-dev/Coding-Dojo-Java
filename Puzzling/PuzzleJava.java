import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> printSumGreaterTen() {
        ArrayList<Integer> greaterThanTen = new ArrayList<Integer>();
        int[] arr = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 10) {
                greaterThanTen.add(arr[i]);
            }
            sum += arr[i];
        }
        System.out.println(sum);
        System.out.println(greaterThanTen);
        return greaterThanTen;
    }

    public ArrayList<String> namesArr() {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> greaterThanFive = new ArrayList<String>();
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");

        Collections.shuffle(names);
        System.out.println(names);

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).length() > 5) {
                greaterThanFive.add(names.get(i));
            }
        }
        System.out.println(greaterThanFive);
        return greaterThanFive;
    }

    public ArrayList<String> alphabet() {
        ArrayList<String> alphabet = new ArrayList<String>(25);
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("o");
        alphabet.add("p");
        alphabet.add("q");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("w");
        alphabet.add("x");
        alphabet.add("y");
        alphabet.add("z");
        ArrayList<String> vowels = new ArrayList<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        Collections.shuffle(alphabet);
        System.out.println(alphabet.get(25));
        System.out.println(alphabet.get(0));
        for (int i = 0; i < vowels.size(); i++) {
            if (alphabet.get(0) == vowels.get(i)) {
                System.out.println("The first letter is a vowel!");
            }
        }
        return alphabet;
    }

    public ArrayList<Integer> randoArr() {
        ArrayList<Integer> randomTen = new ArrayList<Integer>();
        Random r = new Random();
        int low = 55;
        int high = 100;
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        System.out.println(randomTen);
        return randomTen;
    }

    public ArrayList<Integer> randoArrSorted() {
        ArrayList<Integer> randomTen = new ArrayList<Integer>();
        Random r = new Random();
        int low = 55;
        int high = 100;
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        randomTen.add(r.nextInt(high - low) + low);
        Collections.sort(randomTen);
        System.out.println(randomTen);
        System.out.println(randomTen.get(0));
        System.out.println(randomTen.get(9));
        return randomTen;
    }

    public void randomString() {
        String alphabet = "abcdefghijklmnopqrstuvwxy";
        Random rando = new Random();
        StringBuilder str = new StringBuilder();
        int strLength = 5;
        for (int i = 0; i < strLength; i++) {
            int index = rando.nextInt(alphabet.length());
            char c = alphabet.charAt(index);
            str.append(c);
        }
        System.out.println(str);
    }

    public String randomStringArr() {
        String alphabet = "abcdefghijklmnopqrstuvwxy";
        Random rando = new Random();
        StringBuilder str = new StringBuilder();
        int strLength = 50;
        for (int i = 0; i < strLength; i++) {
            int index = rando.nextInt(alphabet.length());
            char c = alphabet.charAt(index);
            str.append(c);
        }
        String newString = str.toString();
        System.out.println(Arrays.toString(newString.split("(?<=\\G.....)")));
        return newString;
    }
}