import chain.*;
import proxy.*;
import memento.*;
import template.*;

public class WebCrawlerApp {
    public static void main(String[] args) {
        PageFetcher realFetcher = new HttpPageFetcher();
        PageFetcherProxy proxy = new PageFetcherProxy(realFetcher);

        PageHistory history = new PageHistory();

        ScriptCleanerHandler scriptHandler = new ScriptCleanerHandler(history);
        AdsCleanerHandler adsHandler = new AdsCleanerHandler(history);
        KeywordSearchHandler keywordHandler = new KeywordSearchHandler(history);

        scriptHandler.setNext(adsHandler);
            adsHandler.setNext(keywordHandler);

        SimpleWebCrawler crawler = new SimpleWebCrawler(proxy, scriptHandler);
        crawler.crawl("https://example.com");

        history.printHistory();
    }
}