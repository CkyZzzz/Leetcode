class Solution {
	//高盛OA 跪的题
	public List<String> removeComments(String[] source) {
		List<String> result = new ArrayList<>();
		boolean isComment = false;
		StringBuilder sb = new StringBuilder();
		for(String line: source){
			//加"#"是为了让一行中的最后一个字符也可以遍历到
			line = line + "#";
			for(int i = 0; i < line.length() - 1; i++){                 
				char curr = line.charAt(i);
				char next = line.charAt(i + 1);
				//必须加!isComment 以免出现/*e/*/这种第二个/*会被标记
				if(curr == '/' && next == '*' && !isComment){
					isComment = true;
					i++;
				}else if(curr == '*' && next == '/' && isComment){
					isComment = false;
					i++;
				}else if(curr == '/' && next == '/'){
					if(!isComment) break;
				}else{
					if(!isComment) sb.append(curr);
				}
			}
			//!isComment一定要加，针对corner case ["a/*comment", "line", "more_comment*/b"]， 输出是 "ab" 而不是 "a", "b"
			if(sb.length() != 0 && !isComment){
				result.add(sb.toString());
				sb.setLength(0);
			}
		}
		return result;
	}
}