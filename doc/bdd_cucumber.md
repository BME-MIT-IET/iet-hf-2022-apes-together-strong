# BDD tesztek készítése
A BDD tesztelés egy nagyszerű formája a teszteléseknek, megegyszerűsíti a tesztek értelmezését a nem programozói gondolkodású személyeknek, hiszen a tesztek menetét nem program nyelven, hanem valamilyen beszélt nyelven írják meg. Ezért egy szoftver fejlesztése során kifejezetten hasznos eszközünk lehet.

## Beüzemelés
A BDD tesztekre a Cucumber nevű eszözt használtuk, aminek a beüzemelése nagyon egyszerű, hiszen a telepítését a készítői igen részletes dokumentációkkal segítik. Jó esetben csak a szükséges függőségeket kell megadni a pom.xml/build.gradle állományunkban. Viszont ha ez még nincs a projektben, akkor még JUnit tesztelő eszközöket is kell mellé telepíteni, amiket szintén részletes dokumentációkkal segítenek.
Miután a megfelelő függőségeket megadtuk, és meggyőződtünk róla, hogy a projektben tudunk használni JUnit eszközt, azután már írhattuk is a teszteket.

## Használat
A tesztek írásához a [features](/test/resources/features) mappába egy .feature kiterjeszésű fájlba kell írni a szcenáriókat, itt meg is tudunk adni példa adatokat, amivel a lépések átírása nélkül is tudjuk változtatni a tesztadatokat.
Az szcenáriókhoz a lépéseket a [cucumber](/test/src/cucumber) mappában valósítottuk meg. A lépéseknél próbáltunk arra figyelni, hogy minél kevesebb adatot égessünk bele a függvényekbe. A lényegesen különböző teszteket pedig próbáltuk elszeparálni egymástól, azaz külön osztályban valósítottuk meg őket.

Innentől bármikor lefuttathatóak a tesztek.

## Eredmény és összefoglalás
A feladat elvégzése során megtanultuk, hogy hogy működnek a BDD tesztek, és azt is hogy kell őket megírni. A BDD tesztekkel elértük, hogy a néhány teszt olvashatóbb legyen főleg azoknak, akik nem programozói háttérrel rendelkeznek.