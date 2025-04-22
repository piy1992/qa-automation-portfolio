class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dicth = {}
        list1 = []
        for i, num in enumerate(nums):
            complement = target-num
            if complement in dicth:
                list1.append(i)
                list1.append(dicth[complement])
                return list1
            dicth[num] = i