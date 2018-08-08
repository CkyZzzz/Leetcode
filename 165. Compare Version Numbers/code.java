//java split 以dot作为分隔符时, 要写成\\. 然后要考虑一些corner case e.g. version1 = "1.0", version2 = "1" return 0
class Solution {
	public int compareVersion(String version1, String version2) {
		String[] strs1 = version1.split("\\.");
		String[] strs2 = version2.split("\\.");
		for(int i = 0; i < Math.min(strs1.length, strs2.length); i++){
			int n1 = Integer.valueOf(strs1[i]);
			int n2 = Integer.valueOf(strs2[i]);
			if(n1 > n2) return 1;
			else if(n2 > n1) return -1;
		}
		if(strs1.length > strs2.length){
			for(int i = strs2.length; i < strs1.length; i++){
				if(Integer.valueOf(strs1[i]) > 0) return 1;
			}
		}else if(strs1.length < strs2.length){
			for(int i = strs1.length; i < strs2.length; i++){
				if(Integer.valueOf(strs2[i]) > 0) return -1;
			}
		}
		return 0;
	}
}