class LargestNumber {
    public static void main(String[] args){
        System.out.println(largestNumber(new int[] {700000000,500000000}));
        System.out.println(Long.MAX_VALUE);
    }

    public static String largestNumber(int[] nums) {
        String[] list = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            list[i] = String.valueOf(nums[i]);
        }
        String result = "";
        for (int i=0; i<list.length; i++){
            for (int j=0; j<list.length-1; j++){
                if (compare(list[j], list[j+1])){
                    String temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        for (String str: list){
            result = str+result;
        }
        int i=0;
        while (i<result.length()-1 && result.charAt(i) == '0'){
            i++;
        }
        return result.substring(i);
    }

    private static boolean compare(String bigger, String smaller){
        return Long.valueOf(bigger+smaller)>Long.valueOf(smaller+bigger);
    }
}