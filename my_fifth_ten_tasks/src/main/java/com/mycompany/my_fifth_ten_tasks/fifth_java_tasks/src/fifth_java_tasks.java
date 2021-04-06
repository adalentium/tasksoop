import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class fifth_java_tasks {
    public static void main (String[] args){
        //encrypt + decrypt!
        System.out.println("encrypt(\"Hello\") -> " +  encrypt("Hello"));
        int[] test_a = {72, 33, -73, 84, -12, -3, 13, -13, -68};
        System.out.println("decrypt([ 72, 33, -73, 84, -12, -3, 13, -13, -68 ]) -> " + decrypt(test_a));
        System.out.println("encrypt(\"Sunshine\") -> " +  encrypt("Sunshine"));
        System.out.println();

        //canMove
        System.out.println("canMove(\"Rook\", \"A8\", \"H8\") -> " + canMove("Rook", "A8", "H8"));
        System.out.println("canMove(\"Bishop\", \"A7\", \"G1\") -> " + canMove("Bishop", "A7", "G1"));
        System.out.println("canMove(\"Queen\", \"C4\", \"D6\") -> " + canMove("Queen", "C4", "D6"));
        System.out.println();

        //canComplete
        System.out.println("canComplete(\"butl\", \"beautiful\") -> " +
                canComplete("butl", "beautiful"));
        System.out.println("canComplete(\"butlz\", \"beautiful\") -> " +
                canComplete("butlz", "beautiful"));
        System.out.println("canComplete(\"tulb\", \"beautiful\") -> " +
                canComplete("tulb", "beautiful"));
        System.out.println();

        //sumDigProd
        System.out.println("sumDigProd(16,28) -> " +  sumDigProd(16, 28));
        System.out.println("sumDigProd(0) -> " +  sumDigProd(0));
        System.out.println("sumDigProd(1, 2, 3, 4, 5, 6) -> " +  sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println();

        //sameVowelGroup!
        String[] test_b = {"toe", "ocelot", "maniac"};
        String[] test_c = {"many", "carriage", "emit", "apricot", "animal"};
        String[] test_d = {"hoops", "chuff", "bot", "bottom"};
        System.out.println("sameVowelGroup([\"toe\", \"ocelot\", \"maniac\"]) -> " +
                sameVowelGroup(test_b));
        System.out.println("sameVowelGroup([\"many\", \"carriage\", \"emit\", \"apricot\", \"animal\"]) -> " +
                sameVowelGroup(test_c));
        System.out.println("sameVowelGroup([\"hoops\", \"chuff\", \"bot\", \"bottom\"]) -> " +
                sameVowelGroup(test_d));
        System.out.println();

        //validateCard!
        System.out.println("validateCard(1234567890123456) -> ");

        System.out.println();

        //numToEng
        System.out.println("numToEng(0) -> " +  numToEng(0));
        System.out.println("numToEng(18) -> " +  numToEng(18));
        System.out.println("numToEng(126) -> " +  numToEng(126));
        System.out.println("numToEng(909) -> " +  numToEng(909));
        System.out.println();

        //getSha256Hash
        System.out.println("getSha256Hash(\"password123\") -> " + getSha256Hash("password123"));
        System.out.println("getSha256Hash(\"Fluffy@home\") -> " + getSha256Hash("Fluffy@home"));
        System.out.println("getSha256Hash(\"Hey dude!\") -> " + getSha256Hash("Hey dude!"));
        System.out.println();

        //correctTitle
        System.out.println("correctTitle(\"jOn SnoW, kINg IN thE noRth.\") -> " +
                correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println("correctTitle(\"sansa stark, lady of winterfell.\") -> " +
                correctTitle("sansa stark, lady of winterfell."));
        System.out.println("correctTitle(\"TYRION LANNISTER, HAND OF THE QUEEN.\") -> " +
                correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println();

        //hexLattice
        System.out.println("hexLattice(1) -> ");
        System.out.print(hexLattice(1));
        System.out.println("hexLattice(7) -> ");
        System.out.print(hexLattice(7));
        System.out.println("hexLattice(19) -> ");
        System.out.print(hexLattice(19));
        System.out.println("hexLattice(21) -> " + hexLattice(21));
        System.out.println();
    }

    //Создайте две функции, которые принимают строку и массив и возвращают закодированное
    // или декодированное сообщение.
    //
    //Первая буква строки или первый элемент массива представляет собой символьный код этой буквы.
    // Следующие элементы-это различия между символами
    public static String encrypt(String a) {
        char[] str = a.toCharArray();
        String str2 = "[";
        for (int i = 0; i < str.length; i++) {
            if (i == 0)
                str2 += (int) str[i];
            else {
                str2 += (int) ((int) str[i] - (int) str[i - 1]);
            }
            if (i < a.length() - 1) {
                str2 += ",";
            }
        }
        str2 += "]";
        return str2;
    }

    public static String decrypt(int[] crypt){

        if(!(crypt.length >0)){return null;}

        String result = "";
        int num = 0;//пред символ

        for(int i = 0; i < crypt.length; i++){
            result += "" + (char)(crypt[i]+num);
            num = crypt[i]+num;
        }
        return result;
    }

    //Создайте функцию, которая принимает имя шахматной фигуры, ее положение и целевую позицию.
    // Функция должна возвращать true, если фигура может двигаться к цели,
    // и false, если она не может этого сделать.
    public static boolean canMove(String figure, String first_pos, String second_pos) {
        boolean Possibility = false;
        figure = figure.toLowerCase();
        first_pos = first_pos.toLowerCase();
        second_pos = second_pos.toLowerCase();
        char[] f = first_pos.toCharArray();
        char[] s = second_pos.toCharArray();
        int zf = 0;
        int zs = 0;
        switch (figure) {
            case "pawn":
                if (f[0] == s[0] & (s[1] - f[1] == 2 || s[1] - f[1] == -2)) {
                    Possibility = true;
                }
                break;
            case "knight":
                zf = Integer.valueOf(f[0]);
                zs = Integer.valueOf(s[0]);
                if (zs > zf & zs < zf + 2 & (s[1] - f[1] == 2 || s[1] - f[1] == -2) || zs < zf & zs > zf - 2 &
                        (s[1] - f[1] == 2 || s[1] - f[1] == -2)) {
                    Possibility = true;
                }
                if ((zs - zf == 2 || zs - zf == -2) & (s[1] - f[1] == 1 || s[1] - f[1] == -1)) {
                    Possibility = true;
                }
                break;
            case "queen":
                zf = Integer.valueOf(f[0]);
                zs = Integer.valueOf(s[0]);
                if (s[1] == f[1] & zf != zs || s[1] != f[1] & zf == zs) {
                    Possibility = true;
                }
                if (f[1] - s[1] == zf - zs || s[1] - f[1] == zs - zf || f[1] - s[1] == zs - zf || s[1] - f[1]
                        == zf - zs) {
                    Possibility = true;
                }
                break;
            case "bishop":
                zf = Integer.valueOf(f[0]);
                zs = Integer.valueOf(s[0]);
                if (f[1] - s[1] == zf - zs || s[1] - f[1] == zs - zf || f[1] - s[1] == zs - zf || s[1] - f[1]
                        == zf - zs) {
                    Possibility = true;
                }
                break;
            case "rook":
                zf = Integer.valueOf(f[0]);
                zs = Integer.valueOf(s[0]);
                if (s[1] == f[1] & zf != zs || s[1] != f[1] & zf == zs) {
                    Possibility = true;
                }
                break;
            case "king":
                zf = Integer.valueOf(f[0]);
                zs = Integer.valueOf(s[0]);
                if (s[1] == f[1] & (zs == zf - 1 || zs == zf + 1) || (s[1] == f[1] - 1 || s[1] == f[1] + 1) & zf
                        == zs) {
                    Possibility = true;
                }
                if (f[1] - s[1] == zf - zs & (f[1] - s[1] == 1 || s[1] - f[1] == 1)
                        || s[1] - f[1] == zs - zf & (f[1] - s[1] == 1 || s[1] - f[1] == 1)
                        || f[1] - s[1] == zs - zf & (f[1] - s[1] == 1 || s[1] - f[1] == 1)
                        || s[1] - f[1] == zf - zs & (f[1] - s[1] == 1 || s[1] - f[1] == 1)) {
                    Possibility = true;
                }
                break;
        }
        return Possibility;
    }

    //Входная строка может быть завершена, если можно добавить дополнительные буквы,
    // и никакие буквы не должны быть удалены, чтобы соответствовать слову.
    // Кроме того, порядок букв во входной строке должен быть таким же, как и порядок букв в последнем слове.
    //
    //Создайте функцию, которая, учитывая входную строку, определяет, может ли слово быть завершено.
    public static boolean canComplete(String toComleate, String isComleate) {
        char[] first = toComleate.toCharArray();
        char[] second = isComleate.toCharArray();
        for (int i = 0; i < first.length; i++) {
            int position = -1;
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j] && position < j) {
                    second[j] = '*';
                    position = j;
                    first[i] = '*';
                    break;
                }
            }
        }
        for (int i = 0; i < first.length; i++) {
            if (first[i] != '*')
                return false;
        }
        return true;
    }

    //Создайте функцию, которая принимает числа в качестве аргументов,
    // складывает их вместе и возвращает произведение цифр до тех пор,
    // пока ответ не станет длиной всего в 1 цифру.
    public static int sumDigProd(int... a) {
        int sum = 0;
        for (int j : a) {
            sum += j;
        }

        while (sum > 10) {
            int sum2 = sum;
            int multiplication = 1;
            while (sum2 > 0) {
                multiplication *= sum2 % 10;
                sum2 /= 10;
            }
            sum = multiplication;
        }
        return sum;
    }

    //Напишите функцию, которая выбирает все слова, имеющие все те же гласные (в любом порядке и / или количестве),
    // что и первое слово, включая первое слово.

    public static String sameVowelGroup(String... words){
        if(words.length < 1){return " ";}
        String glas = "aeoqiujy";
        String resultS = "";
        HashSet<String> sim = new HashSet<String>();
        for(int i=0; i<words[0].length();i++){
            if(  glas.indexOf(words[0].charAt(i)) != -1  ){
                sim.add(""+words[0].charAt(i));
            }
        }
        List<String> list = new ArrayList<String>(sim);
        Collections.sort(list);



        for(String word:words){
            HashSet<String> sim2 = new HashSet<String>();
            for(int i =0; i<word.length();i++){
                if( glas.indexOf(word.charAt(i)) != -1  ){
                    sim2.add(""+word.charAt(i));
                }
            }
            List<String> list2 = new ArrayList<String>(sim2);
            Collections.sort(list2);

            if(list.equals(list2)){
                resultS+=word+" ";
            }

        }


        return resultS;
    }

    //Создайте функцию, которая принимает число в качестве аргумента и возвращает true,
    // если это число является действительным номером кредитной карты, а в противном случае-false.
    public static boolean validateCard(String strIN) {
        //"1234567890123452"
        char[] str = strIN.toCharArray();
        char[] strRev = (strIN).toCharArray();
        int num = str[str.length - 1] - 48;
        for (int i = 0; i < str.length; i++) {
            strRev[strRev.length - i - 1] = str[i];
        }
        int sum = 0;
        for (int i = 1; i < strRev.length; i++) {
            if (i % 2 == 0) {
                int a = ((int) strRev[i] - 48) * 2;
                if (a > 10) {
                    a = a / 10 + a % 10;
                }
                sum += a;
            } else {
                sum += (int) strRev[i] - 48;
            }
        }
        return (10 - sum % 10) == num;
    }

    //Напишите функцию, которая принимает положительное целое число от 0 до 999
    // включительно и возвращает строковое представление этого целого числа, написанное на английском языке.
    public static String numToEng(int rawr) {
        String g = "";
        int d = 0;
        int h = 0;
        char[] s = {};
        g += rawr;
        s = g.toCharArray();
        String[] dig = {"zero", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten"};
        String[] dig1 = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"};
        String[] dig2 = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
                "ninety", "hundred"};
        if (rawr <= 10) {
            g = dig[rawr];
            return g;
        }
        if (rawr == 10 || rawr == 20 || rawr == 30 || rawr == 40 || rawr == 50 || rawr == 60 || rawr == 70 || rawr == 80
                || rawr == 90) {
            g = dig2[rawr / 10 - 1];
            return g;
        }
        if (rawr >= 11 & rawr < 20) {
            g = dig1[rawr % 10 - 1];
            return g;
        }
        if (rawr > 20 & rawr < 100 & rawr != 10 & rawr != 20 & rawr != 30 & rawr != 40 & rawr != 50
                & rawr != 60 & rawr != 70 & rawr != 80 & rawr != 90) {
            g = dig2[rawr / 10 % 10 - 1] + " " + dig[rawr % 10];
            return g;
        }
        if (rawr == 100 || rawr == 200 || rawr == 300 || rawr == 400 || rawr == 500 || rawr == 600
                || rawr == 700 || rawr == 800 || rawr == 900) {
            g = dig[rawr / 10 / 10] + " " + dig2[9];
            return g;
        }
        if (rawr / 10 % 10 == 0) {
            g = dig[rawr / 10 / 10] + " " + dig2[9] + " " + dig[rawr % 10];
            return g;
        }

        if (s.length == 3 & rawr % 10 == 0) {
            g = dig[rawr / 10 / 10] + " " + dig2[9] + " " + dig2[rawr / 10 % 10 - 1];
            return g;
        }

        if (s.length == 3 & rawr % 100 > 10 & rawr % 100 < 20) {
            g = dig[rawr / 10 / 10] + " " + dig2[9] + " " + dig1[rawr % 10 - 1];
            return g;
        }
        if (rawr > 109 & rawr < 1000 & rawr != 100 & rawr != 200 & rawr != 300 & rawr != 400 & rawr != 500
                & rawr != 600 & rawr != 700 & rawr != 800 & rawr != 900) {
            g = dig[rawr / 10 / 10] + " " + dig2[9] + " " + dig2[rawr / 10 % 10 - 1] + " " + dig[rawr % 10];
        }
        return g;
    }

    //
    public static String getSha256Hash(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static String correctTitle(String s) {
        String[] f = {};
        String g = "";
        String o = "";
        String v = "";
        char[] q = {};
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            f = s.split(" ");
        }
        for (int h = 0; h < f.length; h++) {
            q = f[h].toCharArray();
            if (!f[h].equals("in") && !f[h].equals("the") && !f[h].equals("on") && !f[h].equals("and")) {
                o += q[0];
                q[0] = Character.toUpperCase(q[0]);
            }
            g += String.valueOf(q) + " ";
        }
        return g;
    }
    public static String hexLattice(int n) {
        double t = 0;
        int k = 0;
        while (n > t) {
            k++;
            t = 1 + 6 * (0.5 * k * (k - 1));

        }
        if (n != t) {
            return "Invalid";
        }
        int how;
        int prob;
        String hex = "";
        for (int i = 0; i < 2 * k - 1; i++) {
            if (i < k) {
                how = k + i;
                prob = k - i;
            } else {
                how = k + 2 * k - 2 - i;
                prob = i - k + 2;
            }
            for (int ll = 0; ll < prob; ll++) {
                hex += " ";
            }
            for (int ll = 0; ll < 2 * how - 1; ll++) {
                if (ll % 2 == 0) {
                    hex += "o";
                } else {
                    hex += " ";
                }
            }
            for (int ll = 0; ll < prob; ll++) {
                hex += " ";
            }
            hex += "\n";
        }
        return hex;
    }

}

