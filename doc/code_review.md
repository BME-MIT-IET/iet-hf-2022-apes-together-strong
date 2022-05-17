# Kód manuális átvizsgálása
A kód átvizsgálásakor igyekeztem a korábban tanult objektum orientált elvek megvalósulását ellenőrizni, code smelleket keresni és megérteni az osztályok, függvények működését. Mivel a projekt viszonylag nagy kódbázissal rendelkezik, a fontosabbnak tűnő osztályokat vizsgáltam meg.

## RDFMapper.java
Az osztály aránytalanul nagy a többi fájlhoz képest, 1259 sort tartalmaz, emiatt felmerül, hogy Isten-osztályról van szó, vagy hogy az SRP megsérti. 
A fájlon belül több osztály található, ami nehezítheti a munkát a fejlesztés során.
A kód viszonylag jól kommentezett, ezáltal a függvények megértése könnyebb. A megértést segíetné elő továbbá az is, ha a függvények rövidebbek lennének, ezáltal az osztály tagoltabb lenne. A clean code egyik szabálya, hogy egy függvény ne álljon 1-2 bekezdésnél több kódból, viszont ebben az osztályban előfordulnak 60, 70, 90, de még 130 soros függvények is. A leghosszabb függvény a readValue, amely több hosszú ciklusból és if6else ágból áll, amelyek mentén könyen tagolható lenne a kód.
Az osztály sorozatosan megsérti a TDA elvet típusellenőrzésre szolgáló függvények bevezetésével.