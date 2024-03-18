import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Stos {
    Element wierzch;

    public void dodaj(double[] cechy, String typ) {
        Element element;
        if (wierzch == null) {
            element = new Element(cechy, typ);
        } else {
            element = new Element(cechy, typ, wierzch);
        }
        wierzch = element;
    }

    public void pokaz() {
        if (wierzch != null) {
            if (wierzch.nastepny != null) {
                System.out.print(wierzch.typ + " ");
                pokaz(wierzch.nastepny);
            }
        } else {
            System.out.println("Pusty stos!");
        }
        System.out.println();
    }

    public void pokaz(Element element) {
        if (element.nastepny != null) {
            System.out.print(element.typ + " ");
            pokaz(element.nastepny);
        }
    }

    public Element najblizszyElement(Element bazowy) {
        return najblizszyElement(bazowy,wierzch,wierzch);
    }

    private double wyliczOdleglosc(Element pierwszy, Element drugi) {
        double sum = 0;
        for (int i = 0; i < pierwszy.cechy.length; i++) {
            sum += pow(pierwszy.cechy[i] - drugi.cechy[i],2);
        }
        return sqrt(sum);
    }

    private Element najblizszyElement(Element bazowy, Element badany, Element najblizszy) {
        if (wyliczOdleglosc(bazowy,badany) < wyliczOdleglosc(bazowy,najblizszy)) {
            najblizszy = badany;
        }
        if (badany.nastepny != null) {
            return najblizszyElement(bazowy,badany.nastepny,najblizszy);
        } else {
            return najblizszy;
        }
    }
}
