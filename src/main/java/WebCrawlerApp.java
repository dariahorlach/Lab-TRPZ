import chain.*;
import proxy.*;
import memento.*;

public class WebCrawlerApp {
    public static void main(String[] args) {
        PageFetcher realFetcher = new HttpPageFetcher();
        PageFetcherProxy proxy = new PageFetcherProxy(realFetcher);

        PageHistory history = new PageHistory();

        PageHandler chain =
                new ScriptCleanerHandler(history)
                        .setNext(new AdsCleanerHandler())
                        .setNext(new KeywordSearchHandler());


        proxy.setHtmlProcessor(chain);

        proxy.fetchPage("https://example.com");
        proxy.processBatch();

        System.out.println(proxy.getPageContent("https://example.com"));
    }
}