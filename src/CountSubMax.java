//class Solution {
//    public:
//    long long countSubarrays(vector<int>& nums, int k) {
//        int max = 0;
//        for (int n: nums) max = std::max(max, n);
//        std::vector<int> prefix(nums.size()+1);
//        prefix[0] = 0;
//        for (int i=1; i<=nums.size(); i++){
//            prefix[i] = prefix[i-1];
//            if (nums[i-1] == max) prefix[i]++;
//        }
//        long long count = 0;
//        std::unordered_map<int, int> map;
//        for (int i=0; i<prefix.size(); i++){
//            if (!map.contains(prefix[i]) && i!=0) map[prefix[i]] = map[prefix[i]-1];
//            map[prefix[i]]++;
//            count += map[prefix[i]-k];
//        }
//        return count;
//    }
//};