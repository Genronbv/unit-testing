package data;

import exceptions.NoSignatureException;

final public class DigitalSignature {
    private final byte[] signature;
    public DigitalSignature(byte[] signature) throws NoSignatureException
    {
        if(signature == null){
            throw new NoSignatureException("Please, introduce a valid signature");
        }
        this.signature = signature;
    }
    public byte[] getMail(){ return this.signature;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature signature1 = (DigitalSignature) o;
        return signature.equals(signature1.signature);
    }
    @Override
    public int hashCode() { return signature.hashCode(); }
    @Override
    public String toString() {
        return "Digital{" + "Signature='" + signature + '\'' + '}';
    }


}