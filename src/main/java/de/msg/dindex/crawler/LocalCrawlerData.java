package de.msg.dindex.crawler;

public class LocalCrawlerData {

	private int matchCounter=0;
	
	public void resetMatchCounter() {
		matchCounter=0;
	}
	
	public int getMatchCounter() {
		return matchCounter;
	}
	
	public void countMatch () {
		matchCounter++;
	}
}
