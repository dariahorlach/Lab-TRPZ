import chain.*;
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

        String html = """
            <html>
                <script>alert('hack')</script>
                <div class="ads">BUY NOW</div>
                <p>This page contains crawler keyword</p>
            </html>
            """;

        PageContext context = new PageContext(html, "crawler");

        PageHandler chain =
                new ScriptCleanerHandler()
                        .setNext(new AdsCleanerHandler())
                        .setNext(new KeywordSearchHandler());

        chain.handle(context);

        System.out.println("Фінальний HTML:");
        System.out.println(context.getHtmlContent());
    }
}
