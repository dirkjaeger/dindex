package de.msg.dindex.crawler;

import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
	
    public void run() throws Exception {
    	
    	String rootURL = "https://www.msg.group/";
        String crawlStorageFolder = "/home/developer/data/crawl/root";
        int numberOfCrawlers = 1;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        //controller.addSeed("https://www.ics.uci.edu/~lopes/");
        // controller.addSeed("https://www.ics.uci.edu/~welling/");
    	controller.addSeed(rootURL);

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(MyCrawler.class, numberOfCrawlers);
        List<Object> list = controller.getCrawlersLocalData();

        int indexValue = 0;
        for (Object data : list) {
        	
        	indexValue += ((LocalCrawlerData) data).getMatchCounter();
        }
        
        System.out.println("=================================================================================");
        System.out.println("Digitalisierungsindex der Seite " + rootURL + " = " + indexValue);
    }
}	