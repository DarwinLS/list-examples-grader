import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
    public void testFilter(){
        StringChecker sc = new StringChecker(){
            public boolean checkString(String s){
                return s.startsWith("w");
            }
        };
        List<String> input1 = new ArrayList<>();
        input1.add("what");
        input1.add("what");
        input1.add("wow");
        input1.add("bruh");
        List<String> expected1 = new ArrayList<>();
        expected1.add("what");
        expected1.add("what");
        expected1.add("wow");
        assertEquals(expected1, ListExamples.filter(input1,sc));
    }

    @Test
    public void testMerge(){
        List<String> input1 = new ArrayList<>();
        input1.add("a");
        input1.add("b");
        input1.add("c");
        List<String> input2 = new ArrayList<>();
        input2.add("c");
        input2.add("d");
        input2.add("e");
        List<String> expected1 = new ArrayList<>();
        expected1.add("a");
        expected1.add("b");
        expected1.add("c");
        expected1.add("c");
        expected1.add("d");
        expected1.add("e");
        assertEquals(expected1,ListExamples.merge(input1,input2));
    }
}
