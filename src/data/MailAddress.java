package data;

import exceptions.NoMailException;

final public class MailAddress {
    private final String mail;
    public MailAddress(String mail) throws NoMailException {
        if(mail == null || mail.equals("")) throw new NoMailException("Introduce a valid address");
        this.mail = mail;
    }
    public String getMail(){ return this.mail;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress mail1 = (MailAddress) o;
        return mail.equals(mail1.mail);
    }
    @Override
    public int hashCode() { return mail.hashCode(); }
    @Override
    public String toString() {
        return "Mail{" + "mail='" + mail + '\'' + '}';
    }


}