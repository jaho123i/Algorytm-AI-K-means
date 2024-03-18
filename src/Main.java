import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Stos stosGlowny = new Stos();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("IRIS.csv"));

        String linia;
        double[] cechy;
        String typ;

        String atrybuty = bufferedReader.readLine();

        while ((linia = bufferedReader.readLine()) != null) {
            cechy = new double[4];
            for (int j = 0; j < cechy.length; j++) {
                cechy[j] = Double.parseDouble(linia.split(",")[j]);
            }
            typ = linia.split(",")[4];

            stosGlowny.dodaj(cechy,typ);
        }

        System.out.println("Typy obiektów po treningu: ");
        stosGlowny.pokaz();


        String najblizszyTyp;
        bufferedReader = new BufferedReader(new FileReader("TEST.csv"));
        String atrybuty2 = bufferedReader.readLine();

        int sukcesy = 0;
        int porażki = 0;
        while ((linia = bufferedReader.readLine()) != null) {
            cechy = new double[4];
            for (int j = 0; j < cechy.length; j++) {
                cechy[j] = Double.parseDouble(linia.split(",")[j]);
            }
            typ = linia.split(",")[4];
            najblizszyTyp = stosGlowny.najblizszyElement(new Element(cechy,"-")).typ;
            System.out.println("\nNajbliżej do: " + najblizszyTyp +"\nPrawidłowy to: "+typ);
            if (typ.equals(najblizszyTyp)) {
                System.out.println("Sukces");
                sukcesy++;
            } else {
                System.out.println("Nie odgadnięto");
                porażki++;
            }
            stosGlowny.dodaj(cechy,typ);
        }

        System.out.println("Procent sukcesów: "+sukcesy/(porażki+sukcesy)*100);

        System.out.println("Podaj nazwę pliku, aby poznać typy obiektów: \n");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String podanaNazwa = reader.readLine();
        System.out.println("Czytam: "+podanaNazwa);
        bufferedReader = new BufferedReader(new FileReader(podanaNazwa));

        while ((linia = bufferedReader.readLine()) != null) {
            cechy = new double[4];
            for (int j = 0; j < cechy.length; j++) {
                cechy[j] = Double.parseDouble(linia.split(",")[j]);
            }
            najblizszyTyp = stosGlowny.najblizszyElement(new Element(cechy,"-")).typ;
            System.out.println("\nNajbliżej do: " + najblizszyTyp);
        }
    }
}