package automat;

import verwaltung.Hersteller;

import java.util.Objects;



public class HerstellerImpl implements Hersteller {
    private final String name;

    public HerstellerImpl(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("hersteller darf nicht null oder empty sein");
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // Quelle: Ich habe Methode automatisch von IntelliJ generieren lassen. Allgemeine Infos über die Methode von: siehe Quellen.md
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HerstellerImpl that = (HerstellerImpl) o;
        return Objects.equals(name, that.name);
    }

    // Quelle: Ich habe Methode automatisch von IntelliJ generieren lassen. Allgemeine Infos über die Methode von: siehe Quellen.md
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
