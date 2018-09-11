class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int sumOfLen = 0;
		int start = 0;
		int end = 0;
		while(end < words.length){
			while(sumOfLen - 1 <= maxWidth && end < words.length){
				sumOfLen += words[end].length() + 1;
				end++;
			}
			if(end == words.length && sumOfLen - 1 <= maxWidth){
				String line = "";
				for(int i = start; i < end - 1; i++){
					line += words[i] + " ";
				}
				line += words[end - 1];
				result.add(addTail(line, maxWidth - line.length()));
			}else{
				int sumOfSpace = maxWidth - (sumOfLen - words[--end].length() - 2) + (end - start - 1);
				if(end - start - 1 != 0){
					int spaceAvg = sumOfSpace / (end - start - 1);
					int spacePlus = sumOfSpace % (end - start - 1);
					String line = helper(words, start, end - 1, spaceAvg, spacePlus);
					result.add(line);
					start = end;
					sumOfLen = 0;
				}else{
					result.add(addTail(words[start], maxWidth - words[start].length()));
					start = end;
					sumOfLen = 0;
				}
			}
		}
		return result;
	}
	private String helper(String[] words, int start, int end, int spaceAvg, int spacePlus){
		StringBuilder result = new StringBuilder();
		for(int i = start; i < end; i++){
			result.append(words[i]);
			for(int j = 0; j < spaceAvg; j++){
				result.append(" ");
			}
			if(spacePlus > 0){
				result.append(" ");
				spacePlus--;
			}
		}
		result.append(words[end]);
		return result.toString();
	}
	private String addTail(String str, int numOfSpace){
		for(int i = 0; i < numOfSpace; i++){
			str = str + " ";
		}
		return str;
	}
}