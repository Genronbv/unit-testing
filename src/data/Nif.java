package data;

import exceptions.NoNifException;

final public class Nif {

    private final String nif;
    public Nif(String nif) throws NoNifException {

        if(nif == null || nif.equals("")) throw new NoNifException("Introduce a valid Nif");
        this.nif = nif;
    }
    public String getNif(){ return this.nif;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif nif1 = (Nif) o;
        return nif.equals(nif1.nif);
    }
    @Override
    public int hashCode() { return nif.hashCode(); }
    @Override
    public String toString() {
        return "Nif{" + "nif='" + nif + '\'' + '}';
    }


}