/* The knows API is defined in the parent class Relation.
	  boolean knows(int a, int b); */

public class Solution extends Relation {
	public int findCelebrity(int n) {
		int celebrity = 0;
		for(int i = 1; i < n; i++){
			//know函数有两个作用，如果knows(celebrity, i) = true,说明当前的celebrity不是celebrity
			//knows(celebrity, i) = false, 说明i一定不是celebrity，所以这次循环基本可以确立一个celebrity
			if(knows(celebrity, i)) celebrity = i;
		}
		//但是我们需要second check，因为很可能出现0 does not know 1; 1 does not know 0.这类情况
		for(int i = 0; i < n; i++){
			if(celebrity != i && (knows(celebrity, i) || !knows(i, celebrity))) return -1;
		}
		return celebrity;
	}
}