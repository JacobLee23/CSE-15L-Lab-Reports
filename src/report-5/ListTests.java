import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.*;

public class ListTests {

    String[] input0 = {};
    String[] input1 = { "", "\t", "\n", " " };
    String[] input2 = { "a", "b", "c", "d", "e" };
    String[] input3 = { "0", "1", "2", "3", "4", "5" };
    String[] input4 = { "AA", "Aa", "aA", "aa" };
    String[] input5 = { "1", "12", "123", "a", "ab", "abc" };

    @Test
    public void testFilter() {
        this.helpFilter(this.input0, new String[] {}, String::isEmpty);
        this.helpFilter(this.input0, new String[] {}, String::isBlank);

        this.helpFilter(this.input1, new String[] { "" }, String::isEmpty);
        this.helpFilter(
            this.input1, new String[] { "", "\t", "\n", " " }, String::isBlank
        );

        this.helpFilter(
            this.input2, new String[] { "b", "d" },
            (String s) -> s.charAt(0) % 2 == 0
        );
        this.helpFilter(
            this.input2, new String[] { "a", "c", "e" },
            (String s) -> s.charAt(0) % 2 == 1
        );

        this.helpFilter(
            this.input3, new String[] { "0", "2", "4" },
            (String s) -> Integer.parseInt(s) % 2 == 0
        );
        this.helpFilter(
            this.input3, new String[] { "1", "3", "5" },
            (String s) -> Integer.parseInt(s) % 2 == 1
        );

        this.helpFilter(
            this.input4, new String[] { "AA", "Aa" },
            (String s) -> (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')
        );
        this.helpFilter(
            this.input4, new String[] { "AA", "aA" },
            (String s) -> (s.charAt(1) >= 'A' && s.charAt(1) <= 'Z')
        );
        this.helpFilter(
            this.input4, new String[] { "aA", "aa" },
            (String s) -> (s.charAt(0) >= 'a' && s.charAt(0) <= 'z')
        );
        this.helpFilter(
            this.input4, new String[] { "Aa", "aa" },
            (String s) -> (s.charAt(1) >= 'a' && s.charAt(1) <= 'z')
        );

        this.helpFilter(
            this.input5, new String[] { "1", "a" }, (String s) -> (s.length() == 1)
        );
        this.helpFilter(
            this.input5, new String[] { "12", "123", "ab", "abc" },
            (String s) -> (s.length() > 1)
        );
    }

    public void helpFilter(
        String[] arrInput, String[] arrOutput, StringChecker sc
    ) {
        List<String> input = new ArrayList<>();
        for (String s: arrInput) {
            input.add(s);
        }

        List<String> output = new ArrayList<>();
        for (String s: arrOutput) {
            output.add(s);
        }

        assertEquals(output, ListExamples.filter(input, sc));
    }

    @Test
    public void testMerge() {
        this.helpMerge(this.input0, this.input0, this.input0);
        this.helpMerge(this.input0, this.input1, this.input1);
        this.helpMerge(this.input0, this.input2, this.input2);
        this.helpMerge(this.input0, this.input3, this.input3);
        this.helpMerge(this.input0, this.input4, this.input4);
        this.helpMerge(this.input0, this.input5, this.input5);

        this.helpMerge(
            this.input1, this.input1, new String[] {
                "", "", "\t", "\t", "\n", "\n", " ", " "
            }
        );
        this.helpMerge(
            this.input1, this.input2, new String[] {
                "", "\t", "\n", " ", "a", "b", "c", "d", "e"
            }
        );
        this.helpMerge(
            this.input1, this.input3, new String[] {
                "", "\t", "\n", " ", "0", "1", "2", "3", "4", "5"
            }
        );
        this.helpMerge(
            this.input1, this.input4, new String[] {
                "", "\t", "\n", " ", "AA", "Aa", "aA", "aa"
            }
        );
        this.helpMerge(
            this.input1, this.input5, new String[] {
                "", "\t", "\n", " ", "1", "12", "123", "a", "ab", "abc"
            }
        );

        this.helpMerge(
            this.input2, this.input2, new String[] {
                "a", "a", "b", "b", "c", "c", "d", "d", "e", "e"
            }
        );
        this.helpMerge(
            this.input2, this.input3, new String[] {
                "0", "1", "2", "3", "4", "5", "a", "b", "c", "d", "e"
            }
        );
        this.helpMerge(
            this.input2, this.input4, new String[] {
                "AA", "Aa", "a", "aA", "aa", "b", "c", "d", "e"
            }
        );
        this.helpMerge(
            this.input2, this.input5, new String[] {
                "1", "12", "123", "a", "a", "ab", "abc", "b", "c", "d", "e"
            }
        );

        this.helpMerge(
            this.input3, this.input3, new String[] {
                "0", "0", "1", "1", "2", "2", "3", "3", "4", "4", "5", "5"
            }
        );
        this.helpMerge(
            this.input3, this.input4, new String[] {
                "0", "1", "2", "3", "4", "5", "AA", "Aa", "aA", "aa"
            }
        );
        this.helpMerge(
            this.input3, this.input5, new String[] {
                "0", "1", "1", "12", "123", "2", "3", "4", "5", "a", "ab",
                "abc"
            }
        );

        this.helpMerge(
            this.input4, this.input4, new String[] {
                "AA", "AA", "Aa", "Aa", "aA", "aA", "aa", "aa"
            }
        );
        this.helpMerge(
            this.input4, this.input5, new String[] {
                "1", "12", "123", "AA", "Aa", "a", "aA", "aa", "ab", "abc"
            }
        );

        this.helpMerge(
            this.input5, this.input5, new String[] {
                "1", "1", "12", "12", "123", "123", "a", "a", "ab", "ab",
                "abc", "abc"
            }
        );
    }

    public void helpMerge(
        String[] arrInput1, String[] arrInput2, String[] arrOutput
    ) {
        List<String> input1 = new ArrayList<>();
        for (String s: arrInput1) {
            input1.add(s);
        }

        List<String> input2 = new ArrayList<>();
        for (String s: arrInput2) {
            input2.add(s);
        }

        List<String> output = new ArrayList<>();
        for (String s: arrOutput) {
            output.add(s);
        }

        assertEquals(output, ListExamples.merge(input1, input2));
    }

}