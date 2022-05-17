# Kód manuális átvizsgálása
A kód átvizsgálásakor igyekeztem a korábban tanult objektum orientált elvek megvalósulását ellenőrizni, code smelleket keresni és megérteni az osztályok, függvények működését. Mivel a projekt viszonylag nagy kódbázissal rendelkezik, a fontosabbnak tűnő osztályokat vizsgáltam meg részletesen.

## RDFMapper.java
Az osztály aránytalanul nagy a többi fájlhoz képest, 1259 sort tartalmaz, emiatt felmerül, hogy Isten-osztályról van szó, vagy hogy az SRP-t megsérti. 
A fájlon belül több osztály található, ami nehezítheti a munkát a fejlesztés során.
A kód viszonylag jól kommentezett, ezáltal a függvények funkciója érthető. Sok generikus függvényt definiálnak az osztályban, ami átgondolt tervezésre enged következtetni.
  A kód érthetőbb és átláthatóbb lenne, ha a függvények rövidebbek lennének, ezáltal az osztály tagoltabb lenne. A clean code egyik szabálya, hogy egy függvény ne legyen 1-2 bekezdésnél hosszabb, viszont ebben az osztályban előfordulnak 60, 70, 90, de még 130 soros függvények is. A leghosszabb függvény a readValue, amely több hosszú ciklusból és if-else ágból áll, amelyek mentén könnyen tagolható lenne a kód.
Az osztály sorozatosan megsérti a TDA elvet típusellenőrzésre szolgáló függvények bevezetésével.

## UnidentifiableObjectException.java, RDFMappingException.java
Az ősosztály függvényeit átnevező függvényeket tartalmaznak, de funkcionalitásában nem különböznek az ősökétől.

## UUIDCodec.java
Az RDFCodec interfészt implementálja, UUID objektum értékének írására és olvasására szolgáló függvényeket tartalmaz.

## Annotations mappa
Annotációkat tartalmaz az adatok RDF modellbe való integrálhatóságának megoldásához.

## Beans.java
Segédosztály a Java Beans kezeléséhez. Jól kommentezett, érthető, főleg típusellenőrzéseket tartalmaz

## Reflects mappa
Segédosztályok a Java reflects használatához. Egyszerű osztályok, jól kommentezettek, érthető a működés.
