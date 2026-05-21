 class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        // Build Trie
        for (String word : words) {
            insert(word);
        }
        List<String> ans = new ArrayList<>();
        // Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }

    // Insert word into Trie
    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }
            node = node.child[idx];
        }
        node.word = word;
    }

    void dfs(char[][] board,int r,int c,TrieNode node,List<String> ans) {
        // Boundary check
        if ( r < 0 || c < 0 ||r >= board.length ||c >= board[0].length) {
            return;
        }

        char ch = board[r][c];
        // Already visited
        if (ch == '#') {
            return;
        }

        // Move inside Trie
        node = node.child[ch - 'a'];

        // No matching prefix
        if (node == null) {
            return;
        }

        // Complete word found
        if (node.word != null) {
            ans.add(node.word);
            // Prevent duplicates
            node.word = null;
        }

        // Mark visited
        board[r][c] = '#';

        // Explore 4 directions
        dfs(board, r + 1, c, node, ans);
        dfs(board, r - 1, c, node, ans);
        dfs(board, r, c + 1, node, ans);
        dfs(board, r, c - 1, node, ans);

        // Backtrack
        board[r][c] = ch;
    }
}