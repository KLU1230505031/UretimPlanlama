public class Main {

    public static int toplamEnDusukSureHesapla(int[][] isSureleri, int[][] gecisMaliyeti) {
        int isSayisi = isSureleri.length;
        int makineSayisi = isSureleri[0].length;

        int[][] enDusukMaliyetler = new int[isSayisi][makineSayisi];

        for (int j = 0; j < makineSayisi; j++) {
            enDusukMaliyetler[0][j] = isSureleri[0][j];
        }


        for (int i = 1; i < isSayisi; i++) {
            for (int j = 0; j < makineSayisi; j++) {
                int oncekiEnDusukMaliyet = Integer.MAX_VALUE;
                // Önceki işin tüm makinelerini kontrol et
                for (int k = 0; k < makineSayisi; k++) {
                    int maliyet = enDusukMaliyetler[i - 1][k] + gecisMaliyeti[k][j];
                    oncekiEnDusukMaliyet = Math.min(oncekiEnDusukMaliyet, maliyet);
                }
                enDusukMaliyetler[i][j] = oncekiEnDusukMaliyet + isSureleri[i][j];
            }
        }

        int enDusukToplam = Integer.MAX_VALUE;
        for (int j = 0; j < makineSayisi; j++) {
            enDusukToplam = Math.min(enDusukToplam, enDusukMaliyetler[isSayisi - 1][j]);
        }

        return enDusukToplam;
    }

    public static void main(String[] args) {

        int[][] isSureleri = {
                {2, 3, 4},
                {5, 1, 2}
        };

        int[][] gecisMaliyeti = {
                {0, 1, 2},
                {1, 0, 1},
                {2, 1, 0}
        };

        System.out.println("Minimum Toplam Süre: " + toplamEnDusukSureHesapla(isSureleri, gecisMaliyeti));
    }
}