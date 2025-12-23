//class Solution {
//    public:
//    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
//        std::vector<int> leftSatisfied(nums.size());
//        std::vector<int> rightBroken(nums.size());
//        int n = nums.size()-1;
//        if (nums[n] < left) leftSatisfied[n] = 1;
//        if (nums[n] <= right) rightBroken[n] = 1;
//        int count = 0;
//        if (nums[n] >= left && nums[n] <= right) count++;
//        for (int i=n-1; i>=0; i--){
//            if (nums[i]<left) leftSatisfied[i] = 1+leftSatisfied[i+1];
//            if (nums[i]<=right) rightBroken[i] = 1+rightBroken[i+1];
//            count += rightBroken[i]-leftSatisfied[i];
//        }
//        return count;
//    }
//};