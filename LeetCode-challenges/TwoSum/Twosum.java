class Twosum {
    public int[] twoSum(int[] nums, int target) {
        int[] myarray = { 0, 0 };
        Map<Integer, Integer> mapweneed = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (mapweneed.containsKey(complement) && mapweneed.get(complement) != i) {
                return new int[] { mapweneed.get(complement), i };
            }
             mapweneed.put(nums[i], i);
        }
             return new int[] {};
    }
}