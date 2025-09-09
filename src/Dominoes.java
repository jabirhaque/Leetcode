class Dominoes {
    public static void main(String[] args){
        System.out.println(pushDominoes("R.R.L"));
    }
    public static String pushDominoes(String dominoes) {
        char[] dominoesArray = dominoes.toCharArray();
        int lastL = -1;
        int lastR = -1;
        int i=0;
        while (i<dominoes.length()){
            if (dominoes.charAt(i) == 'L'){
                if (lastL>lastR){
                    for (int j=lastL; j<i; j++){
                        dominoesArray[j] = 'L';
                    }
                }else if (lastR>lastL){
                    int x = lastR;
                    int y = i;
                    while (x<y){
                        dominoesArray[x] = 'R';
                        dominoesArray[y] = 'L';
                        x++;
                        y--;
                    }
                }else{
                    for (int j=0; j<i; j++){
                        dominoesArray[j] = 'L';
                    }
                }
                lastL = i;
            }if (dominoes.charAt(i) == 'R'){
                if (lastR>lastL){
                    for (int j=lastR; j<i; j++){
                        dominoesArray[j] = 'R';
                    }
                }
                lastR = i;
            }if (i==dominoes.length()-1 && dominoes.charAt(i)=='.' && lastR>lastL){
                for (int j=Math.max(lastR, 0); j<dominoes.length(); j++){
                    dominoesArray[j] = 'R';
                }
            }
            i++;
        }
        String result = "";
        for (char c: dominoesArray){
            result+=c;
        }
        return result;
    }
}