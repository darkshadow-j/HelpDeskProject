## Table of contents
* [General info](#general-info)
* [Technologie](#Technologie)
* [Demo](#Demo)

## General info
Projekt wykonany po ukończeniu kursów:
SPRING BOOT 2: Tworzenie efektywnych aplikacji internetowych
SPRING BOOT 2: Skuteczne zabezpieczanie aplikacji
	
## Technologie
W projekcie wykorzystano następujące technologie:
...
* Spring Data
* Spring Security JWT
* Spring AOP
Z Aplikacji backend'owej korzysta aplikacja frontend'owa napisana w Angularze
...

## Prezentacja projektu

## Opis
Aplikacja HelpDesk służąca do zarządzania incydentami w organizacji. Aplikacja ma umożliwiać zgłaszanie pojawiających się problemów w obszarze IT przez pracowników. Informacje te trafiają do pracowników HelpDesk, którzy widząc zgłoszenie o statusie ‘NOWE’ mogą przypisać je do siebie. 

## Formularz nowego zgłoszenia

![form](img/1.PNG)

Powyższy formularz umożliwia rejestracje nowego zgłoszenia w systemie HelpDesk. Składa on się z następujących pól
*	Kategoria – określająca ogólna kategorię do której należy problem
*	Subkategoria  - szczegółowy obszar zgłaszanej usterki
*	Temat – zawierający temat zgłoszenia
*	Opis szczegółowy – pole tekstowe pozwalające opisać szczegółowo napotkany problem
*	Załaczniki – pozwala na dołączanie do zgłoszenia zrzutów ekranu

Po kliknięciu w przycisk ‘Submit’ zgłoszenie zostaje zarejestrowane w systemie:

![skkoook](img/2.png)

System w tym momencie wykorzystując techniki programowania aspektowego wyśle wiadomość Email do pracownika Helpdesk o nowym zgłoszeniu

## Obsługa zgłoszeń przez pracownika HelpDesk

Pracownik HelpDesku ma na sidebarze zakładkę dającą możliwość przeglądania wszystkich zgłoszeń jakie trafiły do systemu. Widok przedstawia poniższy rysunek.

![ss](img/3.PNG)

Pracownik na tym poziomi widzi temat zgłoszenia, osobę która zainicjowała zgłoszenie oraz  kategorię danego zgłoszenia. Pracownik ma możliwość wyświetlenia szczegółowych informacji klikając w przycisk ‘View’. Widok aplikacji prezentującej szczegółowe informacje zawarte w zgłoszeniu przedstawia poniższy rysunek

![ssa](img/4.PNG)

Ma tym etapie operator widzi informacje na temat osoby zgłaszającej oraz jej adres email. Dodatkowo widzi 
jaki priorytet został nadany przez system w tym zgłoszeniu (default’owo jest to MEDIUM), status zgłoszenia,
kto danym zgłoszeniem się zajmuje
Szczegółowy opis zgłoszenia
Załączniki w formie jpeg zawierjące zrzuty ekranu
Dalszą korespondencje z osobą dokonującą zgłoszenia.

Operator w przypadku, gdy zgłoszenia jest w statusie ‘NOWY’ ma możliwość przypisania zgłoszenia do siebie. W tym celu wybiera z górnej belki przycisk Operacje -> Przypis do siebie.

![ssb](img/5.PNG)

Status zostanie automatycznie zmieniony na  ‘Przypisany’, a operator pod przyciskiem Operacje dostanie dwie nowe opcje do wyboru i są to kolejno:

Zamknij sprawę – zamyka sprawę w systemie ustawiając status na ‘ZREALIZOWANY’
Wyślij wiadomość – wysyła wiadomość do osoby, która dokonała zgłoszenia np. o jakieś bardziej szczegółowe informacje. Funkcjonalność ta została zaprezentowana za poniższym 

![ssb](img/6.PNG)
![ssba](img/7.PNG)

Po tej wykonaniu tej opracji odpowiedź można zobaczyć wchodząc w szczegóły danego zgłoszenia i na dole jest pole zawierające wszystkie odpowiedzi. 

## Dashboard

Na stronie głównej aplikacji prezentowane są proste  statystyki dotyczące zarejestrowanych zgłoszeń w systemie. Zaobserwować tutaj można informacje o tym ile zgloszeń jest w statusie ‘NOWE’, ile w ‘PRZYPISANE’, a ile jest spraw zamkniętych. Dodatkowo prezentowane są wykresy zawierające 3 obszary, w których następuje najwięcej zgłoszeń. Dzięki temu administrator ma informację o tym gdzie należy ewentualnie dopracować infrastrukturę, aby zredukować ilość zgłoszeń w przyszłości.

![ssba](img/8.PNG)

## Konfigurowanie Kategorii i Subategorii w systemie HelpDesk

System umożliwia konfigurowania Kategorii i Subategorii przez pracowników HelpDesk. Wówczas pracownicy będą mogli wybierać te kategorie w formularzuy zgłoszeniowym. Funkcjonalność ta dostępna jest z poziomu sidebar’u (Ustawienia systemu – Kategorie i SubKategorie )

![ssba](img/9.PNG)

## Demo

Aplikacja wdrożona została na serwer VPS.
adres: app.plenczewski.pl
login: admin
hasło: 123456789
