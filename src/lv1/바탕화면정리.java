package lv1;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int h = wallpaper.length;
        int w = wallpaper[0].length();
        int [][] wp = new int[h][w];
        for(int i = 0; i<h;i++){
            for(int j=0;j<w;j++){
                if(wallpaper[i].charAt(j)=='#')
                    wp[i][j]=1;
            }
        }
        int lux =50, luy=50, rux=0,ruy=0;
        for(int i = 0; i<h;i++){
            for(int j=0;j<w;j++){
                if(wp[i][j]==1){
                    lux = Math.min(lux,i);
                    luy = Math.min(luy,j);
                    rux = Math.max(rux,i);
                    ruy = Math.max(ruy,j);
                }

            }
        }

        return new int[] {lux,luy,rux+1,ruy+1};
    }
}
