package proxy;

import chain.PageContext;
import chain.PageHandler;

import java.util.*;

public class PageFetcherProxy implements PageFetcher {

    private final PageFetcher realFetcher;

    private PageHandler htmlProcessor;

    private final Queue<String> fetchQueue = new LinkedList<>();
    private final Map<String, String> localCache = new HashMap<>();

    public PageFetcherProxy(PageFetcher realFetcher) {
        this.realFetcher = realFetcher;
    }

    public void setHtmlProcessor(PageHandler processor) {
        this.htmlProcessor = processor;
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
                String html = realFetcher.getPageContent(url);

                if (htmlProcessor != null) {
                    PageContext context = new PageContext(html, "example");
                    htmlProcessor.handle(context);
                    html = context.getHtmlContent();
                }

                localCache.put(url, html);
            }
        }
    }
}
