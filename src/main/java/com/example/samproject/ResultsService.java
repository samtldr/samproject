package com.example.samproject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultsService {

	final int maxScore = 3;
	List<String> getResults(List<Ballot> ballots) {
		
		HashMap<String, int[]> canditateScore = new HashMap<>();
		
		for(Ballot ballot: ballots ) {
			
			String [] votes = ballot.getVotes();
			
			for(int i = 0; i < votes.length; i++) {
				
				int score = maxScore - i;
				
				if(score > 0) {
					
					var newVal = canditateScore.getOrDefault(votes[i], new int[] {0,0});
					
					newVal[0] = newVal[0] + score;
					newVal[1] = newVal[1] + (score == maxScore ? 1 : 0);
					
					canditateScore.put(votes[i], newVal);
				}
			}
			
		}
		
        List<String> sortedKeys = canditateScore.entrySet()
        		.stream()
        		.sorted(Comparator.<Map.Entry<String, int[]>>comparingInt(entry -> entry.getValue()[0])
        				.thenComparing(entry -> entry.getValue()[1])
        				.reversed())
        		.map(Map.Entry::getKey)
        		.collect(Collectors.toList());
		
		return sortedKeys;
	}
	
	List<String> getResults2(List<Ballot> ballots) {
		
		HashMap<String, ScoreProfile> canditateScore = new HashMap<>();
		
		for(Ballot ballot: ballots ) {
			
			String [] votes = ballot.getVotes();
			
			for(int i = 0; i < votes.length; i++) {
				
				int score = maxScore - i;
				
				if(score > 0) {
					
					var newVal = canditateScore.getOrDefault(votes[i], new ScoreProfile());
					newVal.addScore(score);
					if(score == maxScore) newVal.addFirstPlaceCount();
					if(score == 2) newVal.addSecondPlaceCount();
					if(score == 1) newVal.addSecondPlaceCount();
					
					canditateScore.put(votes[i], newVal);
				}
			}
			
		}
		
        List<String> sortedKeys = canditateScore.entrySet()
        		.stream()
        		.sorted(Comparator.<Map.Entry<String, ScoreProfile>>comparingInt(entry -> entry.getValue().getScore())
        				.thenComparing(entry -> entry.getValue().getFirstPlaceCount())
        				.thenComparing(entry -> entry.getValue().getSecondPlaceCount())
        				.thenComparing(entry -> entry.getValue().getThirdPlaceCount())
        				.reversed())
        		.map(Map.Entry::getKey)
        		.collect(Collectors.toList());
		
		return sortedKeys;
	}
	
	
}
