# Minimum Toplam Süre Hesaplama Üretim Planlama Projesi

Bu proje, belirli işlerin farklı makinelerde işlenme sürelerini ve makineler arasındaki geçiş maliyetlerini dikkate alarak, tüm işlerin tamamlanması için gereken minimum toplam süreyi hesaplayan bir Java uygulaması içerir.

## Proje Açıklaması

Proje, dinamik programlama yaklaşımını kullanarak, işlerin sırasını sabitleyerek (burada işlerin sırası sabittir ve her iş bir sonraki işi takip eder) makineler arasında geçiş yapmanın en düşük maliyetli yolunu bulmayı hedefler. Amaç, tüm işlerin en kısa sürede tamamlanmasını sağlayacak makine atamalarını belirlemektir.

## Nasıl Çalışır?

`toplamEnDusukSureHesapla` metodu, iki girdi alır:

* `isSureleri`: Her bir işin farklı makinelerde tamamlanma sürelerini içeren iki boyutlu bir tamsayı dizisi. `isSureleri[i][j]`, `i`. işin `j`. makinede tamamlanma süresini temsil eder.
* `gecisMaliyeti`: Makineler arasındaki geçiş maliyetlerini içeren iki boyutlu bir tamsayı dizisi. `gecisMaliyeti[i][j]`, `i`. makineden `j`. makineye geçiş yapmanın maliyetini (bu durumda süre olarak düşünülmektedir) temsil eder.

Metot, aşağıdaki adımları izleyerek minimum toplam süreyi hesaplar:

1.  İlk işin her bir makinede tamamlanma süresini, o makinedeki en düşük maliyet olarak başlangıç kabul eder.
2.  Sonraki her iş için, her bir makinede tamamlanma süresini hesaplarken, önceki işin tüm makinelerinde tamamlanma süreleri ve bu makineden mevcut makineye geçiş maliyeti toplanır. Bu toplamlar arasından en düşüğü seçilerek, mevcut işin ilgili makinedeki en düşük maliyeti bulunur.
3.  Tüm işler için bu işlem tekrarlandıktan sonra, son işin farklı makinelerde tamamlanma süreleri arasındaki en düşük değer, tüm işlerin tamamlanması için gereken minimum toplam süre olarak belirlenir.


