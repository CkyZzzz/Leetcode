class Solution {
	public String validIPAddress(String IP) {
		if(IP.indexOf(".") != -1){
			//split("\\.")  重点!!!, 以'.'拆分时一定要加//
			String[] strs = IP.split("\\.");
			//必须是4段，且因为split方法本身的缺陷我们需要额外判断第一个字符和最后一个字符是不是'.'
			if(strs.length != 4 || IP.charAt(IP.length() - 1) == '.' || IP.charAt(0) == '.') return "Neither";
			for(String str: strs){
				//IPv4地址不允许有leading zeros
				if(str.length() == 0 || (str.length() > 1 && str.charAt(0) == '0') || str.length() > 3) return "Neither";
				for(int i = 0; i < str.length(); i++) if(!Character.isDigit(str.charAt(i))) return "Neither";
				int temp = Integer.valueOf(str);
				if(temp > 255) return "Neither";
			}
			return "IPv4";
		}else{
			String[] strs = IP.split(":");
			if(strs.length != 8 || IP.charAt(IP.length() - 1) == ':' || IP.charAt(0) == ':') return "Neither";
			for(String str: strs){
				str = str.toUpperCase();
				if(str.length() == 0 || str.length() > 4) return "Neither";
				for(int i = 0; i < str.length(); i++){
					char curr = str.charAt(i);
					//IPv6合法的字符只有数字和'A','B','C','D','E','F','a','b','c','d','e','f'
					if(!Character.isDigit(curr) && curr != 'A' && curr != 'B' && curr != 'C' && curr != 'D' && curr != 'E' &&
					  curr != 'F') return "Neither";
				}
			}
			return "IPv6";
		}
	}
}