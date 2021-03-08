import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final Main mainClass = new Main();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testSystemOut() {
        System.out.println("Hello World!");
        Assertions.assertEquals("Hello World!", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void testPrintNumbers() {
        int start = 1;
        int end = 10;
        mainClass.printNumbers(start, end);
        Assertions.assertEquals("12345678910", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void testTriangleArea1() {
        int[] a = {15, 15};
        int[] b = {23, 30};
        int[] c = {50, 25};
        //area = 15(30-25) + 23(25-15) + 50(15-30) / 2 = 222.50
        double area = 222.50;
        Assertions.assertEquals(area, mainClass.calcTriangleArea(a,b,c));

    }

    @Test
    void testInvalidInputTriangleArea() {
        int[] a = {};
        int[] b = {23, 30};
        int[] c = {50, 25};
        Assertions.assertThrows(IllegalArgumentException.class, () -> mainClass.calcTriangleArea(a,b,c));
    }

}
