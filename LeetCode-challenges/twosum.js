/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = {};
    let list1 = []
    for(let i = 0;i<nums.length;i++){
        let complement = target-nums[i]
        if(complement in map){
            list1.push(i)
            list1.push(map[complement])
            return list1
        }
        map[nums[i]] = i;
    }
};