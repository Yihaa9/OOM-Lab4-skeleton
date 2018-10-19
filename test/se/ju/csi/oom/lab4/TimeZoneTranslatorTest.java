package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime dateTime = new DateTime(2018, 12, 31, 23, 0, 0);
		String stringDate = "2019-01-01 01:00:00";
		
		dateTime = TimeZoneTranslator.shiftTimeZone(dateTime, 0, 2);
		assertEquals(stringDate ,dateTime.toString());
		//fail("Not yet implemented");
	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime startTime = new DateTime(2018, 10, 15, 9, 15, 0);
		DateTime endTime = new DateTime(2018, 10, 15, 11, 15, 0);
		
		DateTime startTime2 = new DateTime(2018, 10, 15, 10, 15, 0);
		DateTime endTime2 = new DateTime(2018, 10, 15, 12, 15, 0);
		
		Person bullen = new Person("bullen");
		Person jakob = new Person("Jakey");
		Place hemma = new Place("hemma", 0.0, 0.0, 0.0);
		
		Event event = new Event("yihaa", startTime, endTime, new HashSet<>(Arrays.asList(bullen, jakob)), hemma);
		Event event2 = new Event("yihaa", startTime2, endTime2, new HashSet<>(Arrays.asList(bullen, jakob)), hemma);
		
		event = TimeZoneTranslator.shiftEventTimeZone(event, TimeZone.GREENWICH_UTC, TimeZone.CENTRAL_EUROPEAN_TIME);
		assertEquals(event.toString(), event2.toString());
				
				
				
				
		//fail("Not yet implemented");
	}

}
