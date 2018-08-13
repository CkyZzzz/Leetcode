class Solution {
	//用字典书优化，这样在dfs时，只会往字典书里有值的方向遍历，而且有些word之间是重叠的，这样做可以减去重复的遍历
	private static final int[] directionX = new int[]{0, 1, 0, -1};
	private static final int[] directionY = new int[]{1, 0, -1, 0};
	private class Trie{
		String word;
		Trie[] children;
		public Trie(){
			word = "";
			children = new Trie[26];
		}
	}
	private void buildTrie(Trie root, String[] words){
		for(String word: words){
			Trie temp = root;
			for(int i = 0; i < word.length(); i++){
				char curr = word.charAt(i);
				if(temp.children[curr - 'a'] == null) temp.children[curr - 'a'] = new Trie();
				temp = temp.children[curr - 'a'];
			}
			temp.word = word;
		}
	}
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> set = new HashSet<>();
		if(board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
		Trie root = new Trie();
		buildTrie(root, words);
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(root.children[board[i][j] - 'a'] != null){
					//一定要建立这个used二位数组，来避免重复使用同一个位置的字母
					boolean[][] used = new boolean[board.length][board[0].length];
					used[i][j] = true;
					//helper函数里的三个参数分别赋值root.children[board[i][j] - 'a'] 和 i, j, 这也就意味着二者是同步关系
					helper(board, root.children[board[i][j] - 'a'], i, j, used, set);
					used[i][j] = false;
				}
			}
		}
		return new ArrayList<>(set);
	}
	private void helper(char[][] board, Trie root, int x, int y, boolean[][] used, Set<String> set){
		if(root == null) return;
		if(!root.word.equals("")) set.add(root.word);
		for(int i = 0; i < 4; i++){
			int next_x = x + directionX[i];
			int next_y = y + directionY[i];
			if(inBound(board, next_x, next_y) && !used[next_x][next_y]){
				used[next_x][next_y] = true;
				helper(board, root.children[board[next_x][next_y] - 'a'], next_x, next_y, used, set);
				used[next_x][next_y] = false;
			}
		}
	}
	private boolean inBound(char[][] board, int x, int y){
		return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
	}
}