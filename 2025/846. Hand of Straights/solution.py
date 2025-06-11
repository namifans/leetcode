class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        n = len(hand)
        if n % groupSize != 0:
            return False
        hand = sorted(hand)
        counter = Counter(sorted(hand))
        for card in hand:
            if not counter[card]:
                continue
            counter[card] -= 1
            for i in range(1, groupSize):
                next_card = card + i
                if counter[next_card] <= 0:
                    return False
                counter[next_card] -= 1
        return True