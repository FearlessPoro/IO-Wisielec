# IO-Wisielec

## Uruchomienie aplikacji
Najbezpieczniejszą opcją jest postąpienie zgodnie z radami zawartymi w części "Kompilacja" poniżej i skompilowanie i uruchomienie projektu za pomocą komendy "gradle run". W wypadku jeśli nie jest to możliwe, można uruchomić program za pomocą pliku SRC\build\install\IO-wisielec\bin\IO-wisielec.bat . Uruchomienie za pomocą tej metody może skutkować nieprzewidzianym zachowaniem, gdyż ta wersja aplikacji nie była testowana.

## Kompilacja
Należy najpierw upewnić się, że mamy zainstalowane Java Software Development Kit oraz Gradle w systemie.
Sprawdzamy też czy mamy ustawione zmienne środowiskowe dla Gradle (GRADLE_HOME i PATH).
Możemy sprawdzić czy wszystko jest zainstalowane i dobrze skonfugurowane komendami:

```java - version```

```gradle –v```

Jeżeli powyższe działa, to przechodzimy to katalogu SRC i wykonujemy komendę:

```gradle run``` - aby skompilować i uruchomić aplikację

#### Uwaga: W przypadku Windowsa komenda ```gradle``` może nie działać, w takim wypadku należy użyć ```gradlew```. A jeżeli mamy możliwość skorzystać z IDE wspierającego gradle np. IntelliJ IDEA to powinniśmy wybrać tę opcję.

## Używanie aplikacji
Obsługa aplikacji jest bardzo intuicyjna dla użytkownika. Na ekranie głównym, użytkownik ma możliwość rozpocząć nową grę, przełączyć aplikację w tryb nocny, przywrócić zapisaną grę, zobaczyć ranking, dodać nowe słowo, bądź też zamknąć aplikacje. Po wciśnięciu klawisza nowa gra, należy wybrać tryb gry, kategorię słowa, oraz jego poziom trudności. Wtedy pojawi się widok gry, w którym poprzez kliknięcie odpowiednich przycisków z literami należy dążyć do odgadnięcia hasła.

Na ekranie gry użytkownik widzi też liczbę żyć oraz obrazek wisielca, zamalowany zgodnie z liczbą pozostałych żyć, ma też możliwość poddania się lub zapisania gry, jeśli nie jest w trybie gry na czas. W trybie gry na czas, widoczny jest też zegar, pokazujący pozostałą liczbę sekund. W przypadku wygranej bądź przegranej, wyświetlany jest komunikat, którego zamknięcie przenosi użytkownika do menu głównego. 

Naciśnięcie przycisku ranking w menu głównym wyświetli ekran z pięcioma najlepszymi wynikami, z którego użytkownik ma tylko możliwość powrotu do menu głównego.

Dodawanie słowa przenosi użytkownika do widoku odpowiadającego za tą funkcjonalność. Użytkownik ma możliwość dodać słowo zgodne z widocznymi na stronie instrukcjami, lub wrócić do menu głównego.

Naciśnięcie przycisku tryb nocny zmiania kolorystykę aplikacji, na każdym ekranie.
