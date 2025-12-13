import chain.*;
import proxy.*;

public class WebCrawlerApp {
    public static void main(String[] args) {
        PageFetcher realFetcher = new HttpPageFetcher();
        PageFetcherProxy proxy = new PageFetcherProxy(realFetcher);

        PageHandler chain =
                new ScriptCleanerHandler()
                        .setNext(new AdsCleanerHandler())
                        .setNext(new KeywordSearchHandler());


        proxy.setHtmlProcessor(chain);

        proxy.fetchPage("https://example.com");
        proxy.fetchPage("https://example.org");

        proxy.processBatch();

        System.out.println(proxy.getPageContent("https://example.com"));
    }
}
