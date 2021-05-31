import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SILab2Test {

    private Time getTime(int h, int m, int s) {
        return new Time(h, m, s);
    }

    @SafeVarargs
    private <E> List<E> createList(E... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    @Test
    public void multipleConditionTests() {
        SILab2 siLab2 = new SILab2();
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(-1, 0, 0))));
        assertEquals("The hours are smaller than the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(25, 0, 0))));
        assertEquals("The hours are grater than the maximum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(0, -1, 0))));
        assertEquals("The minutes are not valid!", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(0, 60, 0))));
        assertEquals("The minutes are not valid!", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(0, 0, -1))));
        assertEquals("The seconds are not valid", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(0, 0, 60))));
        assertEquals("The seconds are not valid", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(24, 1, 0))));
        assertEquals("The time is greater than the maximum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(24, 0, 1))));
        assertEquals("The time is greater than the maximum", ex.getMessage());
        assertEquals(createList((19 * 60 + 6) * 60 + 37, 24 * 60 * 60), siLab2.function(createList(getTime(19, 06, 37), getTime(24, 0, 0))));
    }

    @Test
    public void everyBranchTests() {
        SILab2 siLab2 = new SILab2();
        RuntimeException ex;
        assertEquals(createList((19 * 60 + 6) * 60 + 37, 24 * 60 * 60), siLab2.function(createList(getTime(19, 06, 37), getTime(24, 0, 0))));
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(-1, 0, 0))));
        assertEquals("The hours are smaller than the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(25, 0, 0))));
        assertEquals("The hours are grater than the maximum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(0, -1, 0))));
        assertEquals("The minutes are not valid!", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(0, 0, -1))));
        assertEquals("The seconds are not valid", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(getTime(24, 0, -1))));
        assertEquals("The seconds are not valid", ex.getMessage()); //todo fix the code so that it detects the right exception
    }
}
