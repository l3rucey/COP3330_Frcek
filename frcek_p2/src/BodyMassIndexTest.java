import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    // to-do ... return all categories
    @Test
    void bmiCalc() {
        BodyMassIndex bmi = new BodyMassIndex(66, 343);
        double actual = bmi.bmiCalc();
        assertEquals(55.36, actual);
    }

    @Test
    void bmiCat() {
        BodyMassIndex bmi = new BodyMassIndex(66, 343);
        String expected = "Obese";
        String actual = bmi.bmiCat(bmi.bmiCalc());
        assertEquals(expected, actual);
    }

}