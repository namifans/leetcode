class Solution:
    def checkValidString(self, s: str) -> bool:
        stack, star_stack = [], []
        for i, ch in enumerate(s):
            if ch == "(":
                stack.append((i, ch))
            elif ch == ")":
                if stack and stack[-1][1] == "(":
                    stack.pop()
                else:
                    if not star_stack:
                        return False
                    star_stack.pop()
            else:
                star_stack.append((i, ch))
        
        if len(star_stack) < len(stack):
            return False

        pair_count = 0
        for i, p in reversed(stack):
            if not star_stack:
                return False
            while star_stack:
                j, star = star_stack.pop()
                if p == "(" and j > i:
                    pair_count += 1
                    break

        return pair_count == len(stack)