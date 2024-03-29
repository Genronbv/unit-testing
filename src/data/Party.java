package data;

import exceptions.NoNameException;

/**
 * The name of a party that participates in an election.
 */
final public class Party {
    private final String name;
    public Party(String name) throws NoNameException {
        if(name == null) throw new NoNameException("Introduce a valid Party");
        this.name = name;
    }
    public String getName() { return name; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party1 = (Party) o;
        return name.equals(party1.name);
    }
    @Override
    public int hashCode() { return name.hashCode(); }
    @Override
    public String toString() {
        return "Party{" + "name='" + name + '\'' + '}';
    }
}