import java.util.HashMap;
import java.util.Map;

class ForceWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        String bitmap = "";
        for (int i=0; i<maxChoosableInteger; i++) bitmap += '1';
        if ((maxChoosableInteger*(maxChoosableInteger+1))/2<desiredTotal) return false;
        return forceWin(bitmap, desiredTotal, new HashMap<>());
    }

    private boolean forceWin(String bitmap, int desiredTotal, Map<String, Boolean> map){
        String key = bitmap+','+desiredTotal;
        if (map.containsKey(key)) return map.get(key);
        for (int i=0; i<bitmap.length(); i++){
            if (bitmap.charAt(i) == '1' && i+1>=desiredTotal){
                map.put(key, true);
                return true;
            }
        }
        for (int i=0; i<bitmap.length(); i++){
            if (bitmap.charAt(i) == '1'){
                String newMap = bitmap.substring(0, i) + '0' + bitmap.substring(i+1);
                if (!forceWin(newMap, desiredTotal-i-1, map)){
                    map.put(key, true);
                    return true;
                }
            }
        }
        map.put(key, false);
        return false;
    }
}