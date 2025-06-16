class Solution:
    def generateTag(self, caption: str) -> str:
        caption_list = list(filter(None, caption.split(" ")))
        s = '#'
        for i in range(len(caption_list)):
            c = caption_list[i]
            if i == 0:
                s += c[0].lower() + c[1:].lower()
            else:
                s += c[0].upper() + c[1:].lower()
        return s if len(s) < 100 else s[:100]