import proxy.*;

public class WebCrawlerApp {
    public static void main(String[] args) {
        PageFetcher realFetcher = new HttpPageFetcher();
        PageFetcherProxy proxy = new PageFetcherProxy(realFetcher);

        proxy.fetchPage("https://example.com");
        proxy.fetchPage("https://example.org");

        System.out.println(proxy.isPageFetched("https://example.com"));

        proxy.processBatch();

        System.out.println(proxy.isPageFetched("https://example.com"));
        System.out.println(proxy.getPageContent("https://example.com"));
    }
}
