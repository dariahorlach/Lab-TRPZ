package proxy;

import java.util.*;

public class PageFetcherProxy implements PageFetcher {

    private final PageFetcher realFetcher;

    private final Queue<String> fetchQueue = new LinkedList<>();
    private final Map<String, String> localCache = new HashMap<>();

    public PageFetcherProxy(PageFetcher realFetcher) {
        this.realFetcher = realFetcher;
    }

    @Override
    public void fetchPage(String url) {
        System.out.println("Додаємо URL у чергу " + url);
        fetchQueue.add(url);
    }

    @Override
    public boolean isPageFetched(String url) {
        System.out.println("Перевірка з локального кешу");
        return localCache.containsKey(url);
    }

    @Override
    public String getPageContent(String url) {
        return localCache.get(url);
    }

    public void processBatch() {
        System.out.println("Пакетне завантаження сторінок");

        while (!fetchQueue.isEmpty()) {
            String url = fetchQueue.poll();
            realFetcher.fetchPage(url);

            if (realFetcher.isPageFetched(url)) {
                localCache.put(url, realFetcher.getPageContent(url));
            }
        }
    }
}
