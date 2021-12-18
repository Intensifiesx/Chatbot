
/*
 * Name: Zain, Pari
 * Date: 10/29/19
 * Program: Chat Bot
 */
import java.util.*;
import java.lang.String;

public class WaifuBot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String statement;
        statement = input.nextLine(); // user input
        String keyWord = " "; // the key word that the computer must find
        String[] farewells = { "bye", "quit", "exit", "done" };
        String[] responses = {
                "Until next time Senpai!",
                "See you l8er! :)",
                "Talk to you later!",
                "Take it easy!",
                "Take care!",
                "Baiii!! :)" };

        int index = (int) (Math.random() * responses.length - 1);

        statement = statement.toLowerCase();

        while (!containsAnyOf(statement, farewells)) {
            System.out.println(getResponse(statement));
            statement = input.nextLine(); // user input
        }

        System.out.println(responses[index]);
    }

    public static String getResponse(String statement) {
        String[] negatives = { "no", "never", "not" };
        String[] family = { "mother", "mom", "father", "dad", "brother", "sister", "uncle", "grandpa", "grandma",
                "aunt" };
        String[] pets = { "cat", "dog", "parrot", "lizard", "rabbit", "gerbil", "fish", "turtle" };
        String[] IWantTo = { "I want to", "I need to" };
        String[] IWant = { "I want", "I need" };
        String[] greetings = { "hey", "hai", "hi", "sup", "hello", "greetings" };
        String[] exiting = { "bye! ", "cya", "goodbye" };
        String[] activities = { "what are you doing?", "what are you doing", "what are you up to",
                "what are you up to?", "what r you up to?", "what r you up to", "what are u up to?", "what r u up to?",
                "what r u up to", "watcha up to?", "watcha up to" };
        String[] feeling = { "how are you", "how are you up to", "how are you up to?", "how are you?", "how r u",
                "how r u?", "how's it going", "how's it going?", "what's up", "what's up?", "what have you been up to",
                "what have you been up to?" };
        String[] likes = { "what do you like", "what do you like?", "what do u like?", "what do u like" };

        statement = statement.toLowerCase();
        statement.trim();

        if (statement.trim().length() == 0) {
            return "Please say something Senpai!";
        } else if (containsAnyOf(statement, greetings) == true) {
            String[] responses = { "Ohayo!", "Konichiwa.", "Yahho~", "Moshi Moshi.", "Ossu.", "Oi!" };

            int index = (int) (Math.random() * responses.length - 1);

            return responses[index];
        } else if (containsAnyOf(statement, negatives) == true) {
            String[] responses = {
                    "Why are you so negative, senpai? >_<",
                    "Why is that?",
                    "Do you really think so?",
                    "You don't say.",
                    "I see.",
                    "Sorry to hear that." };
            int index = (int) (Math.random() * responses.length - 1);

            return responses[index];
        } else if (containsAnyOf(statement, likes) == true) {
            String[] responses = {
                    "I like going shopping!",
                    "I like traveling.",
                    "I like talking to you! :3",
                    "I like hanging out with you.",
                    "I like watching anime.",
                    "I like reading mangas." };
            int index = (int) (Math.random() * responses.length - 1);

            return responses[index];
        } else if (containsAnyOf(statement, family) == true) {
            String[] responses = {
                    "Tell me more about your family!",
                    "How is your family?",
                    "How is the family?",
                    "Your family seems interesting.",
                    "Are you close to your father?",
                    "Are you close to your mother?" };
            int index = (int) (Math.random() * responses.length - 1);

            return responses[index];
        } else if (containsAnyOf(statement, feeling) == true) {
            String[] responses = {
                    "Doin' fine, and you?",
                    "Good, how about you?",
                    "Nothin' much, and you?",
                    "Okey, how about you?",
                    "Average. Not terrific, not terrible, just average. How about you?",
                    "Better now that I'm talking to you! :3",
                    "Tired. What about you?"
            };
            int index = (int) (Math.random() * responses.length - 1);

            return responses[index];
        } else if (containsAnyOf(statement, activities) == true) {
            String[] responses = {
                    "Playing games. How about you?",
                    "Reading a book. How about you?",
                    "Watching tv. How about you?",
                    "Shopping. How about you?",
                    "Not much. How about you?",
                    "Layin' on the couch. How about you?" };
            int index = (int) (Math.random() * responses.length - 1);

            return responses[index];
        } else if (containsAnyOf(statement, pets) == true) {
            String[] responses = {
                    "How many pets do you have?",
                    "What type of pets do you have?",
                    "What are their favourite toys and games?",
                    "Is there anything the pet is scared of?",
                    "How old is your pet?",
                    "What is your pet’s name?" };
            int index = (int) (Math.random() * responses.length - 1);

            return responses[index];
        } else if (containsAnyOf(statement, IWantTo)) {
            return transformIWantToStatement(statement);
        } else if (containsAnyOf(statement, IWant)) {
            return transformIWantStatement(statement);
        } else {
            String[] responses = {
                    "I see",
                    "Okey",
                    "Mmmm",
                    "lol",
                    "I gotcha",
                    "Yuh"
            };
            int index = (int) (Math.random() * responses.length - 1);

            return responses[index];
        }
    }

    public static boolean containsAnyOf(String statement, String[] sArr) {
        boolean b = false;

        for (String e : sArr) {
            if (indexOfKeyWord(e, statement) >= 0) {
                b = true;
                return b;
            } else {
                b = false;
            }
        }
        return b;
    }

    public static String switchWords(String s, String inWord, String outWord) {
        String result = "";

        int index = indexOfKeyWord(inWord, s);
        while (index >= 0) {
            result += s.substring(0, index) + outWord;
            s = s.substring(index + inWord.length());
            index = indexOfKeyWord(s, inWord);
        }
        return result + s;
    }

    public static String stripFinalPunctuation(String s) {
        s = s.trim();
        String lastChar = s.substring(s.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    public static String transformIWantToStatement(String s) {
        String[] wantTo = { "I want to" };
        String[] needTo = { "I need to" };

        String afterTo = " ";
        if (containsAnyOf(s, wantTo)) {
            afterTo = s.substring(indexOfKeyWord("I want to", s) + 7);
        } else if (containsAnyOf(s, needTo)) {
            afterTo = s.substring(indexOfKeyWord("I need to", s) + 7);
        } else {
            return "I do not understand.";
        }
        return "What would it mean to you to " + afterTo + "?";
    }

    public static String transformIWantStatement(String s) {
        String[] want = { "I want" };
        String[] need = { "I need" };

        String after = " ";
        if (containsAnyOf(s, want)) {
            after = s.substring(indexOfKeyWord("I want to", s) + 7);
        } else if (containsAnyOf(s, need)) {
            after = s.substring(indexOfKeyWord("I need to", s) + 7);
        } else {
            return "I do not understand.";
        }
        return "What would it mean to you if you had" + after + "?";
    }

    public static String switchPronouns(String s) {
        s = switchWords(s, "I'm", "you're");
        s = switchWords(s, "I am", "you are");
        s = switchWords(s, "I", "you");
        s = switchWords(s, "me", "you");
        s = switchWords(s, "my", "your");
        return s;
    }

    public static int indexOfKeyWord(String s, String statement) {
        s = s.toLowerCase();
        statement = statement.toLowerCase();

        int startIdx = statement.indexOf(s);

        while (startIdx >= 0) {
            String before = " ", after = " ";

            if (startIdx > 0) {
                before = statement.substring(startIdx - 1, startIdx);
            }

            int endIdx = startIdx + s.length();

            if (endIdx < statement.length()) {
                after = statement.substring(endIdx, endIdx + 1);
            }

            if ((before.compareTo("a") >= 0 && before.compareTo("z") <= 0) ||
                    (after.compareTo("a") >= 0 && after.compareTo("z") <= 0)) {
                return -1;
            } else {
                return startIdx;
            }
        }
        return -1;
    }
}
