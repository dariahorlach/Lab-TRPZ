package proxy;

import java.util.HashMap;
import java.util.Map;

public class HttpPageFetcher implements PageFetcher {

    private final Map<String, String> downloadedPages = new HashMap<>();

    @Override
    public void fetchPage(String url) {
        System.out.println("Завантаження сторінки " + url);
        downloadedPages.put(url, "<html>Content of " + url + "</html>");
    }

    @Override
    public boolean isPageFetched(String url) {
        System.out.println("Перевірка статусу сторінки " + url);
        return downloadedPages.containsKey(url);
    }

    @Override
    public String getPageContent(String url) {
        return downloadedPages.get(url);
    }
}
