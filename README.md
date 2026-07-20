# Klasyfikator Zbioru Iris (Algorytm 1-NN)

Kompaktowa aplikacja w języku Java implementująca algorytm klasyfikacji najbliższego sąsiada (1-NN) dla popularnego zbioru danych Iris. Projekt opiera się na autorskiej implementacji struktury stosu (`Stos`) do przechowywania wektorów cech oraz obliczania dystansu między nimi.

## Funkcjonalności

* **Trening bazowy:** Wczytywanie danych początkowych z pliku `IRIS.csv` (4 cechy numeryczne + etykieta) i inicjalizacja stosu.
* **Ewaluacja i uczenie przyrostowe (incremental learning):** Sprawdzanie dokładności modelu na zbiorze `TEST.csv`. Program po sklasyfikowaniu obiektu testowego od razu dodaje go do bazy wiedzy, zwiększając pulę próbek dla kolejnych iteracji.
* **Interaktywna klasyfikacja:** Po zakończeniu testów program prosi użytkownika o podanie ścieżki do własnego pliku CSV, z którego czyta wektory cech i przypisuje im najbliższe etykiety.

## Wymagania i uruchomienie

Do uruchomienia wymagane jest środowisko Java (JDK). Upewnij się, że w głównym katalogu znajdują się pliki danych CSV oraz odpowiednie klasy powiązane (`Main.java`, `Stos.java`, `Element.java`).

```bash
# Kompilacja
javac Main.java

# Uruchomienie
java Main
