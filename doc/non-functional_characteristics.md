# Nem funkcionális jellemzők vizsgálata
A nem funkcionális jellemzők vizsgálatához először felvettem az eredeti projekt leírásában található Person példaosztályt. Ezután, hogy legyen mit futtatni a projektben, létrehoztam egy Main osztályt, ezen belül a main függvényt. Ezen belül létrehoztam két ciklust, mindkettő elindít 20000 szálat, majd azokban létrehoz egy RDF objektumot egy Person objektumból, vagy visszafejt egy Person objektumot egy RDF objektumból.

![](pictures/perf/method_1.png)

 A függvény kiírja, hogy összesen mennyi időre volt szükség a műveletek elvégzéséhez, valamint, hogy átlagosan hány miliszekundum alatt hajtódott végre egy művelet.

 ![](pictures/perf/method_output.png)

Ezen kívül a windiws beépített teljesítmény figyelőjében megnéztem, mi történik a processzorral a projekt futtatásakor.

![](pictures/perf/CPU.png)
