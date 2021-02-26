package com.epam.training.tasks.fifth.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component{

    private List<Component> data = new ArrayList<>();

    public void add(Component component) {
        data.add(component);
    }

    public List<Component> get() {
        return data;
    }

    @Override
    public String toString() {
        return "Composite{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Composite composite = (Composite) object;
        return Objects.equals(data, composite.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
