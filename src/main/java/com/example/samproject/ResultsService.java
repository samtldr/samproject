package com.example.samproject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultsService {

	final int maxScore = 3;

	List<String> getResults2(List<Ballot> ballots) {
		
		HashMap<String, int[]> canditateScore = new HashMap<>();
		
		for(Ballot ballot: ballots ) {
			
			String [] votes = ballot.getVotes();
			
			for(int i = 0; i < votes.length; i++) {
				
				int score = maxScore - i;
			
				var newVal = canditateScore.getOrDefault(votes[i], new int[3]);
				newVal[i]++;
				canditateScore.put(votes[i], newVal);
			}
			
		}
		
			Comparator<Map.Entry<String, int[]>> comparitor = (val1, val2) -> {
				
				int sum1 = (val1.getValue()[0] * 3) + (val1.getValue()[1] * 2) + (val1.getValue()[2] * 1);
				int sum2 = (val2.getValue()[0] * 3) + (val2.getValue()[1] * 2) + (val2.getValue()[2] * 1);
				
				return Integer.compare(sum1, sum2);
			};
	
			List<String> sortedKeys = canditateScore.entrySet().stream()
								.sorted(
										comparitor
										.thenComparing(entry -> entry.getValue()[0])
										.thenComparing(entry -> entry.getValue()[1])
										.thenComparing(entry -> entry.getValue()[2]).reversed()
										)
								.map(Map.Entry::getKey)
								.collect(Collectors.toList());
					
					
			return sortedKeys;

	}

}
