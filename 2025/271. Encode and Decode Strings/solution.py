class Codec:

    def encode(self, strs: List[str]) -> str:
        encoded_strs = []
        for s in strs:
            encoded_strs.append(s.replace("/", "//"))
        return "/&".join(encoded_strs)
        
        

    def decode(self, s: str) -> List[str]:
        decoded_strs = []
        decoded = ""
        i = 0
        while i < len(s):
            if (s[i:i+2]) == "/&":
                decoded_strs.append(decoded)
                decoded = ""
                i += 2
            elif(s[i:i+2] == "//"):
                decoded += "/"
                i += 2
            else:
                decoded += s[i]
                i += 1
        decoded_strs.append(decoded)
        return decoded_strs


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))