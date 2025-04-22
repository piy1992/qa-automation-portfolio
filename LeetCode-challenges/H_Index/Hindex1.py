class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        h_index=0
        for citations in reversed(citations):
            if(citations>h_index):
                h_index+=1
            else:
                break
        return h_index