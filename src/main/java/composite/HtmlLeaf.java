package composite;

import java.util.List;

public class HtmlLeaf implements HtmlComponent {
    private final String content;

    public HtmlLeaf(String content) {
        this.content = content;
    }

    @Override
    public void add(HtmlComponent component) {
        throw new UnsupportedOperationException("Cannot add child to leaf");
    }

    @Override
    public void remove(HtmlComponent component) {
        throw new UnsupportedOperationException("Cannot remove child from leaf");
    }

    @Override
    public List<HtmlComponent> getChildren() {
        return List.of();
    }

    @Override
    public String render() {
        return content;
    }
}