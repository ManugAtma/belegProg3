package event.dto;

import kuchen.Kuchen;

import java.util.Date;

public class KuchenDTO {
    private Kuchen kuchen;
    private Date inspektionsdatum;
    private int fachnummer;

    public KuchenDTO(Kuchen kuchen, Date inspektionsdatum, int fachnummer) {
        if (kuchen == null) throw new NullPointerException("kuchen is null");
        this.kuchen = kuchen;
        this.inspektionsdatum = inspektionsdatum;
        this.fachnummer = fachnummer;
    }

    public Kuchen getKuchen() {
        return kuchen;
    }

    public Date getInspektionsdatum() {
        return inspektionsdatum;
    }

    public int getFachnummer() {
        return fachnummer;
    }
}