public class AuctionSystemProblem {
    public static void main(String[] args){
        AuctionSystem auctionSystem = new AuctionSystem();
        auctionSystem.addBid(10, 1, 1000);
        auctionSystem.addBid(20, 1, 1000);
        System.out.println(auctionSystem.getHighestBidder(1));

        System.out.println("=========");
        for (Pair<Integer, Integer> entries: auctionSystem.treemaps.get(1).keySet()){
            System.out.println(entries.getKey() + ", " + entries.getValue());
        }
        System.out.println(auctionSystem.treemaps.get(1).containsKey(new Pair(10, 1000)));
        System.out.println(auctionSystem.treemaps.get(1).containsKey(new Pair(12330, 1000)));
    }
}
