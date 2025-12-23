import java.util.Arrays;

class FriendAge {
    public static void main(String[] args){
        System.out.println(numFriendRequests(new int[]{73,106,39,6,26,15,30,100,71,35,46,112,6,60,110}));
    }

    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0;

        int[] equals = new int[ages.length];
        equals[ages.length - 1] = 0;

        for (int i = ages.length - 2; i >= 0; i--) {
            if (ages[i] == ages[i + 1]) {
                equals[i] = equals[i + 1] + 1;
            } else {
                equals[i] = 0;
            }
            count += equals[i];
        }

        for (int i = 0; i < ages.length; i++) {
            float min = ages[i] / 2.0f + 7;

            int l = 0;
            int r = i - 1;
            int index = i;

            while (l < r) {
                int m = (l + r) / 2;
                if (ages[m] <= min) {
                    l = m + 1;
                } else {
                    index = m;
                    r = m;
                }
            }

            if (ages[l] > min) {
                index = l;
            }

            count += i - index;
        }

        return count;
    }
}
