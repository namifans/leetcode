class Solution:
    def maxDiff(self, num: int) -> int:
        sa = sb = str(num)
        i = j = 0
        while i < len(sa) and sa[i] == '9':
            i += 1
        if i < len(sa):
            sa = sa.replace(sa[i], '9')
        if sb[0] == '1':
            while j < len(sb) and (sb[j] == '1' or sb[j] == '0'):
                j += 1
            if j < len(sb):
                sb = sb.replace(sb[j], '0')
        else:
            sb = sb.replace(sb[0], '1')
        return int(sa) - int(sb)