from typing import List
from collections import Counter

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        result = []

        if not words:
            return result

        word_len = len(words[0])
        word_count = len(words)
        total_len = word_len * word_count

        if len(s) < total_len:
            return result

        target = Counter(words)

        for offset in range(word_len):
            left = offset
            right = offset
            current = Counter()
            count = 0

            while right + word_len <= len(s):
                word = s[right:right + word_len]
                right += word_len

                if word in target:
                    current[word] += 1
                    count += 1

                    while current[word] > target[word]:
                        left_word = s[left:left + word_len]
                        current[left_word] -= 1
                        left += word_len
                        count -= 1

                    if count == word_count:
                        result.append(left)

                        left_word = s[left:left + word_len]
                        current[left_word] -= 1
                        left += word_len
                        count -= 1

                else:
                    current.clear()
                    count = 0
                    left = right

        return result