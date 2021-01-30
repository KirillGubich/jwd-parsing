package com.epam.jwd.parser.model;

import com.epam.jwd.parser.composite.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements TextComponent {

    private final List<TextComponent> components;

    public Text() {
        this.components = new ArrayList<>();
    }

    public List<TextComponent> getComponents() {
        return components;
    }

    public void addComponent(TextComponent component) {
        components.add(component);
    }

    public void removeComponent(TextComponent component) {
        components.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(components, text.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return buildText();
    }

    @Override
    public String buildText() {
        StringBuilder text = new StringBuilder();
        components.forEach(child -> text.append(child.buildText()));
        return text.toString();
    }
}
