public class Element {
    double[] cechy;
    String typ;
    Element nastepny;

    public Element(double[] cechy, String typ, Element nastepny) {
        this.cechy = cechy;
        this.typ = typ;
        this.nastepny = nastepny;
    }

    public Element(double[] cechy, String typ) {
        this.cechy = cechy;
        this.typ = typ;
    }

}
