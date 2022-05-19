public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /**
     * case insensitive
     * @param word
     * @return true or false
     */
    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> d = wordToDeque(word);
        while (d.size() > 1){
            if (d.removeFirst() != d.removeLast()){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> d = wordToDeque(word);
        while (d.size() > 1){
            if (!cc.equalChars(d.removeFirst(), d.removeLast())){
                return false;
            }
        }
        return true;
    }
}
