package Tema_Java;

public class Profesor implements Human{


    private String nume;
    private String prenume;
    private String acronim;
    private Integer varsta;
    private String materie;

    public Profesor(String nume, String prenume, String acronim, int varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.materie = materie;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getAcronim() {
        return acronim;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public String getMaterie() {
        return materie;
    }

    @Override
    public void greeting() {

    }

    @Override
    public void dowork() {

    }

    @Override
    public String toString() {
        return '['+"Prof. " +
                nume + " " +
                prenume + " " +
                ", Fac."  + acronim + " " +
                ", Varsta " + varsta + " " +
                ", Materie predata " + materie +
                ']';
    }


    @Override
    public int compareTo(Human o) {
        return this.getVarsta().compareTo(o.getVarsta());
    }
}
