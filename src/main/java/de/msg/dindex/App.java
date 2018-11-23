package de.msg.dindex;

import java.util.HashMap;

import de.msg.dindex.crawler.Controller;

public class App {
	
	private HashMap staedteUrl = new HashMap<String, String>();
	
	

	public HashMap getStaedteUrl() {
		return staedteUrl;
	}
	public void setStaedteUrl(HashMap staedteUrl) {
		this.staedteUrl = staedteUrl;
	}
	
	public HashMap intialisierteHashMap () {
		
		staedteUrl.put("Köln", "https://www.stadt-koeln.de/");
		staedteUrl.put("Essen", "https://www.essen.de/aktuell/portalaktuell.de.html");
		staedteUrl.put ("München", "https://www.muenchen.de/");
		staedteUrl.put ("Düsseldorf", "https://www.duesseldorf.de/");
		
		return staedteUrl; 
		
	}
	public String liefereUrl(String stadt) {
		
		return (String) staedteUrl.get(stadt);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Controller controller = new Controller();
		controller.run();
		
		

		
	
	}

}
