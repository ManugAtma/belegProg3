package automat;

import verwaltung.Hersteller;

import java.util.Objects;

public class HerstellerImpl implements Hersteller {
    private final String name;

    public HerstellerImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HerstellerImpl that = (HerstellerImpl) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
