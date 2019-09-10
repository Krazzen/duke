import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    @Test
    public void Todo_Test(){
        assertEquals( "[T][\u2718] Test Todo", (new Todo("Test Todo").toString())
    }
}