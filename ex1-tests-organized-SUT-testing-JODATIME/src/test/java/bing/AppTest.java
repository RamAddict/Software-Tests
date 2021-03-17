package bing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.joda.time.*;
import org.junit.jupiter.api.Test;

public class AppTest {
    // Feature 1: Criação de data
    @Test
    public void shouldCorrectlyCreateAValidDate() {
        // Fixture Setup
        // Exercise SUT
        var date = new LocalDate(2000, 7, 24);
        // Result Verification
        assertEquals(date.getDayOfMonth(), 24);
        assertEquals(date.getMonthOfYear(), 7);
        assertEquals(date.getYear(), 2000);
        // Fixture Teardown
    }
    @Test
    public void shouldThrowWhenCreatingAnInvalidDate() {
        // Fixture Setup
        // Exercise SUT
        assertThrows(org.joda.time.IllegalFieldValueException.class, () -> {
            var date = new LocalDate(2000, 13, 24);
        });
        // Result Verification
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyCreateAValidDateOnTheLastDayOfAMonth() {
        // Fixture Setup
        // Exercise SUT
        var date = new LocalDate(2022, 1, 31);
        // Result Verification
        assertNotEquals(date.getDayOfMonth(), 22);
        assertNotEquals(date.getMonthOfYear(), 7);
        assertNotEquals(date.getYear(), 2000);
        assertEquals(date.getDayOfMonth(), 31);
        assertEquals(date.getMonthOfYear(), 1);
        assertEquals(date.getYear(), 2022);
        // Fixture Teardown
    }
    // Feature 2: Soma de datas 
    @Test
    public void shouldSumDaysCorrectly() {
        // Fixture Setup
        var date1 = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date1 = date1.plusDays(1);
        // Result Verification
        assertEquals(date1.getMonthOfYear(), 2);
        assertEquals(date1.getDayOfMonth(), 1);
        assertEquals(date1.getYear(), 2022);
        // Fixture Teardown
    }

    @Test
    public void shouldSumMonthsCorrectly() {
        // Fixture Setup
        var date = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date = date.plusMonths(10);
        // Result Verification
        assertEquals(date.getMonthOfYear(), 11);
        assertEquals(date.getDayOfMonth(), 30); // -1 because november doesn't have 31st
        assertEquals(date.getYear(), 2022);
        // Fixture Teardown
    }

    @Test
    public void shouldSumYearsCorrectly() {
        // Fixture Setup
        var date = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date = date.plusYears(2);
        // Result Verification
        assertEquals(date.getMonthOfYear(), 1);
        assertEquals(date.getDayOfMonth(), 31);
        assertEquals(date.getYear(), 2024);
        // Fixture Teardown
    }

    @Test
    public void shouldSumWeeksCorrectly() {
        // Fixture Setup
        var date = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date = date.plusWeeks(2);
        // Result Verification
        assertEquals(date.getMonthOfYear(), 2);
        assertEquals(date.getDayOfMonth(), 14);
        assertEquals(date.getYear(), 2022);
        // Fixture Teardown
    }

    @Test
    public void shouldSumRawPeriodCorrectly() {
        // Fixture Setup
        var date = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date = date.plus(Period.days(20));
        // Result Verification
        assertEquals(date.getMonthOfYear(), 2);
        assertEquals(date.getDayOfMonth(), 20);
        assertEquals(date.getYear(), 2022);
        // Fixture Teardown
    }

    //  Feature 3: Subtração de datas

        @Test
    public void shouldSubtractDaysCorrectly() {
        // Fixture Setup
        var date1 = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date1 = date1.minusDays(1);
        // Result Verification
        assertEquals(date1.getMonthOfYear(), 1);
        assertEquals(date1.getDayOfMonth(), 30);
        assertEquals(date1.getYear(), 2022);
        // Fixture Teardown
    }

    @Test
    public void shouldSubtractMonthsCorrectly() {
        // Fixture Setup
        var date = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date = date.minusMonths(10);
        // Result Verification
        assertEquals(date.getMonthOfYear(), 3);
        assertEquals(date.getDayOfMonth(), 31);
        assertEquals(date.getYear(), 2021);
        // Fixture Teardown
    }

    @Test
    public void shouldSubtractYearsCorrectly() {
        // Fixture Setup
        var date = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date = date.minusYears(2);
        // Result Verification
        assertEquals(date.getMonthOfYear(), 1);
        assertEquals(date.getDayOfMonth(), 31);
        assertEquals(date.getYear(), 2020);
        // Fixture Teardown
    }

    @Test
    public void shouldSubtractWeeksCorrectly() {
        // Fixture Setup
        var date = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date = date.minusWeeks(2);
        // Result Verification
        assertEquals(date.getMonthOfYear(), 1);
        assertEquals(date.getDayOfMonth(), 17);
        assertEquals(date.getYear(), 2022);
        // Fixture Teardown
    }

    @Test
    public void shouldSubtractRawPeriodsCorrectly() {
        // Fixture Setup
        var date = new LocalDate(2022, 1, 31);
        // Exercise SUT
        date = date.minus(Period.days(20));
        // Result Verification
        assertEquals(date.getMonthOfYear(), 1);
        assertEquals(date.getDayOfMonth(), 11);
        assertEquals(date.getYear(), 2022);
        // Fixture Teardown
    }

    // Feature 4: Criação de horas

    @Test
    public void shouldCorrectlyCreateAValideTime() {
        // Fixture Setup
        // Exercise SUT
        var time = new LocalTime(17, 0, 0, 0);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 22);
        assertEquals(time.getHourOfDay(), 17);
        assertEquals(time.getMinuteOfHour(), 0);
        assertEquals(time.getSecondOfMinute(), 0);
        assertEquals(time.getMillisOfSecond(), 0);

        // Fixture Teardown
    }

    @Test
    public void shouldNOTCorrectlyCreateATime() {
        // Fixture Setup
        // Exercise SUT
        assertThrows(org.joda.time.IllegalFieldValueException.class, () -> 
        {
            var time = new LocalTime(-17, 0, 0, 0);
        });
        // Result Verification
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyCreateAValideTimeFromASingleNumber() {
        // Fixture Setup
        // Exercise SUT
        var time = new LocalTime(12000000);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 14);
        assertEquals(time.getHourOfDay(), 0);
        assertEquals(time.getMinuteOfHour(), 20);
        assertEquals(time.getSecondOfMinute(), 0);
        assertEquals(time.getMillisOfSecond(), 0);

        // Fixture Teardown
    }

    // Feature 5: Soma de horas 

    
    @Test
    public void shouldCorrectlyAddNothingToTimeAndNotChange() {
        // Fixture Setup
        var time = new LocalTime(12000000);
        // Exercise SUT
        time = time.plus(null);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 14);
        assertEquals(time.getHourOfDay(), 0);
        assertEquals(time.getMinuteOfHour(), 20);
        assertEquals(time.getSecondOfMinute(), 0);
        assertEquals(time.getMillisOfSecond(), 0);

        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyAddHours() {
        // Fixture Setup
        var time = new LocalTime(12000000);
        // Exercise SUT
        time = time.plusHours(21);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 0);
        assertEquals(time.getHourOfDay(), 21);
        assertEquals(time.getMinuteOfHour(), 20);
        assertEquals(time.getSecondOfMinute(), 0);
        assertEquals(time.getMillisOfSecond(), 0);

        // Fixture Teardown
    }
    
    @Test
    public void shouldCorrectlyAddMinutes() {
        // Fixture Setup
        var time = new LocalTime(12000000);
        // Exercise SUT
        time = time.plusMinutes(61);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 11);
        assertEquals(time.getHourOfDay(), 1);
        assertEquals(time.getMinuteOfHour(), 21);
        assertEquals(time.getSecondOfMinute(), 0);
        assertEquals(time.getMillisOfSecond(), 0);

        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyAddMiliseconds() {
        // Fixture Setup
        var time = new LocalTime(12000000);
        // Exercise SUT
        time = time.plusMillis(61);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 11);
        assertEquals(time.getHourOfDay(), 0);
        assertEquals(time.getMinuteOfHour(), 20);
        assertEquals(time.getSecondOfMinute(), 0);
        assertEquals(time.getMillisOfSecond(), 61);

        // Fixture Teardown
    }

    // Feature 6: Subtração de horas

    @Test
    public void shouldCorrectlySubtractHours() {
        // Fixture Setup
        var time = new LocalTime(12000000);
        // Exercise SUT
        time = time.minusHours(21);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 0);
        assertEquals(time.getHourOfDay(), 3);
        assertEquals(time.getMinuteOfHour(), 20);
        assertEquals(time.getSecondOfMinute(), 0);
        assertEquals(time.getMillisOfSecond(), 0);

        // Fixture Teardown
    }
    
    @Test
    public void shouldCorrectlySubtractMinutes() {
        // Fixture Setup
        var time = new LocalTime(12000000);
        // Exercise SUT
        time = time.minusMinutes(61);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 1);
        assertEquals(time.getHourOfDay(), 23);
        assertEquals(time.getMinuteOfHour(), 19);
        assertEquals(time.getSecondOfMinute(), 0);
        assertEquals(time.getMillisOfSecond(), 0);

        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlySubtractMiliseconds() {
        // Fixture Setup
        var time = new LocalTime(12000000);
        // Exercise SUT
        time = time.minusMillis(61);
        // Result Verification
        assertNotEquals(time.getHourOfDay(), 11);
        assertEquals(time.getHourOfDay(), 0);
        assertEquals(time.getMinuteOfHour(), 19);
        assertEquals(time.getSecondOfMinute(), 59);
        assertEquals(time.getMillisOfSecond(), 939);

        // Fixture Teardown
    }
    // Feature 7: Before e After de data/hora 
    @Test
    public void shouldCorrectlyTellWhatsAfter() {
        // Fixture Setup
        var time1 = new LocalTime(12000000);
        var time2 = new LocalTime(14000000);
        // Exercise SUT
        var isTime1AfterTime2 = time2.isAfter(time1);
        // Result Verification
        assertEquals(isTime1AfterTime2, true);

        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyTellWhatsBefore() {
        // Fixture Setup
        var time1 = new LocalTime(12000000);
        var time2 = new LocalTime(14000000);
        // Exercise SUT
        var isTime1AfterTime2 = time2.isBefore(time1);
        // Result Verification
        assertEquals(isTime1AfterTime2, false);

        // Fixture Teardown
    }

    
    @Test
    public void shouldNotBeBeforeItself() {
        // Fixture Setup
        var time1 = new LocalTime(12000000);
        // Exercise SUT
        var isTime1AfterTime1 = time1.isBefore(time1);
        // Result Verification
        assertEquals(isTime1AfterTime1, false);
        // Fixture Teardown
    }

    // Feature 8: Criação de data/hora 

    @Test
    public void shouldCorrectlyCreateAValideDateAndTime() {
        // Fixture Setup
        // Exercise SUT
        var time = new LocalDateTime(2017, 7, 7, 4, 20);
        // Result Verification
        assertEquals(time.getYear(), 2017);
        assertEquals(time.getMonthOfYear(), 7);
        assertEquals(time.getDayOfMonth(), 7);
        assertEquals(time.getHourOfDay(), 4);
        assertEquals(time.getMinuteOfHour(), 20);

        // Fixture Teardown
    }

    @Test
    public void shouldNOTCorrectlyCreateAValideDateAndTime() {
        // Fixture Setup
        // Exercise SUT
        
        assertThrows(org.joda.time.IllegalFieldValueException.class, () -> 
        {
            var time = new LocalDateTime(2017, 0, 7, 4, 20);
        });
        // Result Verification
        // Fixture Teardown
    }

    @Test
    public void shouldCorrectlyCreateAValidDateAndTimeInTheFuture() {
        // Fixture Setup
        // Exercise SUT
        var time = new LocalDateTime(2026, 6, 6, 4, 30);
        // Result Verification
        assertEquals(time.getYear(), 2026);
        assertEquals(time.getMonthOfYear(), 6);
        assertEquals(time.getDayOfMonth(), 6);
        assertEquals(time.getHourOfDay(), 4);
        assertEquals(time.getMinuteOfHour(), 30);

        // Fixture Teardown
    }

    // Feature 9: Intervalo de datas (Interval) 
    @Test
    public void shouldCorrectlyCreateAnInterval() {
        // Fixture Setup
        // Exercise SUT
        var interval = new Interval(0, 20);
        // Result Verification
        assertEquals(interval.getStart(), new DateTime(1969, 12,31,21,0,0,0));
        assertEquals(interval.getEnd(), new DateTime(1969, 12,31,21,0,0,20));
        // Fixture Teardown
    }
    
    @Test
    public void shouldCorrectlyCreateAnIntervalInTheFuture() {
        // Fixture Setup
        // Exercise SUT
        var interval = new Interval(new DateTime(2022, 2, 2, 2, 2), new DateTime(2027, 2, 2, 2, 2));
        // Result Verification
        assertEquals(interval.getStart(), new DateTime(2022, 2, 2, 2, 2));
        assertEquals(interval.getEnd(), new DateTime(2027, 2, 2, 2, 2));
        // Fixture Teardown
    }
    
    @Test
    public void shouldNOTCreateAnInterval() {
        // Fixture Setup
        // Exercise SUT
        assertThrows(java.lang.IllegalArgumentException.class, () -> 
        {var interval = new Interval(new DateTime(2020, 2, 2, 2, 2), new DateTime(2020, 2, 2, 2, 1));
        });
        // Result Verification
        // Fixture Teardown
        
    }
}