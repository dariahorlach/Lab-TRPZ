package proxy;

import chain.PageHandler;

import java.util.*;

public class PageFetcherProxy implements PageFetcher {

    private final PageFetcher realFetcher;

    private final Queue<String> fetchQueue = new LinkedList<>();
    private final Map<String, String> localCache = new HashMap<>();

    public PageFetcherProxy(PageFetcher realFetcher) {
        this.realFetcher = realFetcher;
    }

    public void setHtmlProcessor(PageHandler processor) {
    }

    @Override
    public void fetchPage(String url) {
        System.out.println("Додаємо URL у чергу " + url);
        fetchQueue.add(url);
    }

    @Override
    public boolean isPageFetched(String url) {
        return localCache.containsKey(url);
    }

    @Override
    public String getPageContent(String url) {
        if (!localCache.containsKey(url)) {
            realFetcher.fetchPage(url);
            localCache.put(url, realFetcher.getPageContent(url));
        }
        return localCache.get(url);
    }

    public void processBatch() {
        while (!fetchQueue.isEmpty()) {
            String url = fetchQueue.poll();
            realFetcher.fetchPage(url);
            if (realFetcher.isPageFetched(url)) {
                localCache.put(url, realFetcher.getPageContent(url));
            }
        }
    }
}
