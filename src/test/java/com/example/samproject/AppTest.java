package com.example.samproject;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @InjectMocks
    private ResultsService resultsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void emptyList() {

    	var results = resultsService.getResults2(new LinkedList<Ballot>());
    	
    	Assertions.assertTrue(results.isEmpty());
    }
    
    
    @Test
    public void testOrder() {
    	
    	var results = resultsService.getResults2(List.of(
					new Ballot(new String [] {"Matt","Sam","Tupac"})
    			));
    	
    	Assertions.assertIterableEquals(List.of("Matt","Sam","Tupac"), results);
    	
    }
    
    @Test
    public void twoFirstPlaces() {
    	var results = resultsService.getResults2(List.of(
    			new Ballot(new String[] {"Tupac","Smalls","Biggie"}),
    			new Ballot(new String[] {"Biggie","Tupac","Smalls"}),
    			new Ballot(new String[] {"Biggie","Tupac","Smalls"}),
    			new Ballot(new String[] {"Smalls","Tupac","Biggie"}),
    			new Ballot(new String[] {"Tupac","Smalls","Biggie"})
    			));
    	
    	Assertions.assertIterableEquals(List.of("Tupac","Biggie","Smalls"), results);
    }

    @Test
    public void twoFirstAndSecondPlaces() {
    	var results = resultsService.getResults2(List.of(
    			new Ballot(new String[] {"Matt","Sam","Andy"}),
    			new Ballot(new String[] {"Karel","Josh","Andy"}),
    			new Ballot(new String[] {"Karel","Jack","Josh"}),
    			new Ballot(new String[] {"Sam","Jack","Andy"}),
    			new Ballot(new String[] {"Andy","Sam","Andy"}),
    			new Ballot(new String[] {"Karel","Sam","Josh"})
    			));
    	
    	Assertions.assertIterableEquals(List.of("Karel","Sam","Andy","Jack","Josh","Matt"), results);
    }


    
}


