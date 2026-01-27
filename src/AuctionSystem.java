import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class AuctionSystem {

    Map<Integer, TreeMap<Pair<Integer, Integer>, Integer>> treemaps;
    Map<Integer, Map<Integer, Integer>> maps;

    public AuctionSystem() {
        treemaps = new HashMap<>();
        maps = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        if (maps.containsKey(itemId) && maps.get(itemId).containsKey(userId)){
            updateBid(userId, itemId, bidAmount);
            return;
        }
        if (!maps.containsKey(itemId)){
            maps.put(itemId, new HashMap<>());
            treemaps.put(itemId, new TreeMap<>((a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : b.getValue() - a.getValue()));
        }
        maps.get(itemId).put(userId, bidAmount);
        Pair<Integer, Integer> pair = new Pair(userId, bidAmount);
        treemaps.get(itemId).put(pair, bidAmount);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        Pair<Integer, Integer> pair = new Pair(userId, maps.get(itemId).get(userId));
        maps.get(itemId).put(userId, newAmount);
        treemaps.get(itemId).remove(pair);
        treemaps.get(itemId).put(new Pair(userId, newAmount), newAmount);
    }

    public void removeBid(int userId, int itemId) {
        Pair<Integer, Integer> pair = new Pair(userId, maps.get(itemId).get(userId));
        maps.get(itemId).remove(userId);
        treemaps.get(itemId).remove(pair);
    }

    public int getHighestBidder(int itemId) {
        if (!maps.containsKey(itemId) || maps.get(itemId).isEmpty()) return -1;
        Pair<Integer, Integer> pair = treemaps.get(itemId).firstKey();
        return pair.getKey();
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */