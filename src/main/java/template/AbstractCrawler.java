package template;

import java.util.List;

public abstract class AbstractCrawler {
    public final void crawl(String url) {
        System.out.println("\nCrawl: " + url);
        String html = fetchPage(url);
        html = processHtml(html);
        saveHtml(url, html);
        collectStats(url);
        for (String link : extractLinks(html)) {
            crawl(link);
        }
    }

    protected abstract String fetchPage(String url);
    protected abstract String processHtml(String html);
    protected abstract void saveHtml(String url, String html);
    protected abstract void collectStats(String url);
    protected abstract List<String> extractLinks(String html);
}
