package Tema_Java;

public class Student implements Human {

    private String nume;
    private String prenume;
    private String acronim;
    protected Integer varsta;
    private int an_studiu;

    public Student(String nume, String prenume, String acronim, int varsta, int an_studiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.an_studiu = an_studiu;
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

    public int getAn_studiu() {
        return an_studiu;
    }

    @Override
    public void greeting() {

    }

    @Override
    public void dowork() {

    }

    @Override
    public String toString() {
        return '['+"Sd. " +
                 nume +  " "+
                 prenume  +" "+
                ", Anul " + an_studiu +" "+
                 acronim + " " +
                ", Varsta " + varsta +
                ']';
    }


    @Override
    public int compareTo(Human o) {
        return this.getVarsta().compareTo(o.getVarsta());
    }
}
