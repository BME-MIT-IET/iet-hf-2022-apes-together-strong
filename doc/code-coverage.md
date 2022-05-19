# Kódlefedettség vizsgálata és egységtesztek készítése
A választott projektünk (Pinto) alapból is tartalmazott Unit teszteket, arról viszont semmi információnk nem volt, hogy ezek a tesztek a kódállomány mekkora részét fedik le. Erre a problémára nyújt megoldást a JaCoCo Plugin.
## Beüzemelés
A projekt a Gradle-t használja projektépítő eszközként, ezért elég volt a build.gradle fájlba beírni a JaCoCo plugint, valamint beállítani annak egy-két paraméterét, például a verziószámot és a kimenet formátumát. A projekt már használta a JUnit plugint, így ennek a telepítésével nem kellett foglalkozni.
## Használat
A beüzemelés után a JaCoCo minden Gradle build utasítás után legenerálja a kódlefedettséget mutató fájlokat, így könnyen ellenőrizni tudjuk, hogy a tesztekkel elértük-e a kívánt eredményt.
## Elvégzett feladatok
A feladatok elvégzését a kódbázis vizsgálatával kezdtem. Ezután igyekeztem csomagonként haladva új tesztekkel kiegészíteni a már meglévő tesztállományt. Az új tesztek megírása után ellenőriztem a JaCoCo-val, hogy tényleg sikeres volt-e a kódlefedettség bővítése.
## Összefoglalás
A JaCoCo egy rendkívül hasznos eszköz, mert segítségével effektívebbé tehetjük a tesztjeinket, ezáltal lehet, hogy eddig rejtett hibákat fedezünk fel a kódunkban.