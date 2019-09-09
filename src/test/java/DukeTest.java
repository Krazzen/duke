import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    @Test
    public void Todo_Test(){
        String in = "Todo 123";
        String out = "Got it. I've added this task:\n" +
                "[T][✘] 123\n" +
                "Now you have 4 tasks in the lists.";
        assertEquals(in, out);
    }
}