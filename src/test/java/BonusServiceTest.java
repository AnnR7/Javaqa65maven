
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndNearUnderLimit() {
        BonusService service = new BonusService();

        long amount = 16_666;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndNearOverLimit() {
        BonusService service = new BonusService();

        long amount = 16_667;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1_000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndEqualsLimit() {
        BonusService service = new BonusService();

        long amount = 50_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndNearUnderLimit() {
        BonusService service = new BonusService();

        long amount = 49_999;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndNearOverLimit() {
        BonusService service = new BonusService();

        long amount = 50_001;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}
