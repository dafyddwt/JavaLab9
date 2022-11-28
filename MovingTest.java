import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class MovingTest {
    
    Moving moving;

    // @BeforeEach
    // public void setUp() {
    //     moving = new Moving(0, 0, 0, 0, 0, 0, 0, false, false);
    // }


    @DisplayName("Test Constructor")
    @Test
    public void testConstructor() {
       Moving moving = new Moving(12, 13, 14, 15, 16, 17, 18, false, true);
        assertEquals(12, moving.getDistance());
        assertEquals(13, moving.getWeight());
        assertEquals(14, moving.getFlights());
        assertEquals(15, moving.getApplicances());
        assertEquals(16, moving.getPianos());
        assertEquals(17, moving.getOther());
        assertEquals(18, moving.getMovers());
        assertFalse(moving.isElevator());
        assertTrue(moving.isSurchargeApplicable());
    }



    @DisplayName("Test calcMileageCost")
    @Test
    void testCalcMileageCost() {
    Moving moving = new Moving(100, 0, 0, 0, 0, 0, 0, false, false);
    double expected = 150;
    double actual = moving.calcMileageCost();
    assertEquals(expected, actual);

    
       
    }

    @DisplayName("Test calcLabourCost")
    @Test
    void testCalcLabourCost() {
    Moving moving = new Moving(0, 50, 0, 0, 0, 0,3, false, false);
    double expected = 18.75;
    double actual = moving.calcLabourCost();
    assertEquals(expected, actual);
    }

    @DisplayName("Test calcLabourCostmore then 4 people")
    @Test
    void testCalcLabourCostmorethen4() {
    Moving moving = new Moving(0, 50, 0, 0, 0, 0,4, false, false);
    double expected = 18.75;
    double actual = moving.calcLabourCost();
    assertEquals(expected, actual);
    }

    @DisplayName("Test Flight Cost")
    @Test
    void testFlightCost() {
    Moving moving = new Moving(0, 0, 2, 0, 0, 0,0, false, false);
    double expected = 1000;
    double actual = moving.calcFlightCost();
    assertEquals(expected, actual);
    }

    @DisplayName("Test Appliance Cost")
    @Test
    void testApplianceCost() {
    Moving moving = new Moving(0, 0, 0, 2, 0, 0,0, false, false);
    double expected = 100;
    double actual = moving.calcApplianceCost();
    assertEquals(expected, actual);
    }

    @DisplayName("Test Piano Cost")
    @Test
    void testPianoCost() {
    Moving moving = new Moving(0, 0, 0, 0, 2, 0,0, false, false);
    double expected = 400;
    double actual = moving.calcPianoCost();
    assertEquals(expected, actual);
    }

    @DisplayName("Test Other Cost")
    @Test
    void testOtherCost() {
    Moving moving = new Moving(0, 0, 0, 0, 0, 2,0, true, true);
    double expected = 502;
    double actual = moving.calcMiscCost();
    assertEquals(expected, actual);
    }

    @DisplayName("Test Other Cost 2 ")
    @Test
    void testOtherCost2() {
    Moving moving = new Moving(0, 0, 0, 0, 0, 2,0, false, true);
    double expected = 1002;
    double actual = moving.calcMiscCost();
    assertEquals(expected, actual);
    }

    @DisplayName("Test Other Cost 3 ")
    @Test
    void testOtherCost3() {
    Moving moving = new Moving(0, 0, 0, 0, 0, 2,0, false, false);
    double expected = 2;
    double actual = moving.calcMiscCost();
    assertEquals(expected, actual);
    }

    @DisplayName("CalcSubTotal")
    @Test
    void testCalcSubTotal() {
    Moving moving = new Moving(100, 1000, 2, 2, 2, 2,3, false, false);
    double expected = 2027.0;
    double actual = moving.calcSubtotal();
    assertEquals(expected, actual);
    }

    @DisplayName("CalcTax")
    @Test
    void testCalcTax() {
    Moving moving = new Moving(100, 1000, 2, 2, 2, 2,3, false, false);
    double expected = 202.70;
    double actual = moving.calcTax();
    assertEquals(expected, actual);
    }

    @DisplayName("CalcTotal")
    @Test
    void testCalcTotal() {
    Moving moving = new Moving(100, 50, 2, 2, 2, 2,3, false, false);
    double expected = 758.45;
    double actual = moving.calcTotal();
    assertEquals(expected, actual);
    }



    @DisplayName("Test Final chart")
    @Test
    void testFinalChart() {
    moving = new Moving(10, 100, 1, 2, 0, 100,4, true, false);
    double expected = 869;
    double actual = moving.calcTotal();
    assertEquals(expected, actual);
    }









    



}
