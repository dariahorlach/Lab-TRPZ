package composite;

import java.util.List;

public interface HtmlComponent {
    void add(HtmlComponent component);
    void remove(HtmlComponent component);
    List<HtmlComponent> getChildren();
    String render();
}
