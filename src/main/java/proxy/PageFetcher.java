package proxy;

public interface PageFetcher {

    void fetchPage(String url);

    boolean isPageFetched(String url);

    String getPageContent(String url);
}

