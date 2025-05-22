class Codec:
    def encode(self, strs: List[str]) -> str:
        return " & ".join([s.replace("&", "&&") for s in strs])
        
    def decode(self, s: str) -> List[str]:
        return [s.replace("&&", "&") for s in s.split(" & ")]


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))