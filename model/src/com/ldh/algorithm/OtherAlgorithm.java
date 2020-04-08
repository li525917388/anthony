package com.ldh.algorithm;

/**
 * 其他算法类
 * @author Li Dehuan
 * @date 2019年6月28日
 *
 */
public class OtherAlgorithm {

	
	public static void main(String[] args) {
		
		// 1. 输入字符串，打印全部排列
		//charArrangement("abcd");
		
		// 2. 测试2，显示数组中的重复值
		/*int[] problem_array = {2, 3, 1, 0, 2, 5};
		problem1(problem_array);*/
		
		// 3.
		System.out.println(problem3(new StringBuffer("aa bb cc")));
	}
	
	
	/**
	 * 1. 输入字符串，打印全部排列
	 * @param str
	 */
	public static void charArrangement(String str){
		
		char[] chs = str.toCharArray();
		
		arrange(chs , 0, chs.length);
	}

	public static void arrange(char[] chs, int start, int len){
		if(start == len-1){
			for(int i=0; i<chs.length; ++i)
				System.out.print(chs[i]);
			System.out.println();
			return;
		}
		for(int i=start; i<len; i++){
			char temp = chs[start];
			chs[start] = chs[i];
			chs[i] = temp;
			arrange(chs, start+1, len);	//递归
			temp = chs[start];
			chs[start] = chs[i];
			chs[i] = temp;
		}
	}
	
	
	
	/**
	 * 2. 测试2，显示数组中的重复值
	 * 
	 * ※在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
	 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
	 * 请找出数组中任意一个重复的数字。
	 * 
	 * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
	 * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
	 * 本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
	 * @param array
	 */
	public static void problem1(int[] array){

		System.out.println(duplicate(array, array.length, array));
	}

	
	
	public static int duplicate(int[] nums, int length, int[] duplication) {
		
		if (nums == null || length <= 0)
	        return -1;
		
	    for (int i = 0; i < length; i++) {
	        while (nums[i] != i) {
	            if (nums[i] == nums[nums[i]]) {
	                duplication[0] = nums[i];
	                return nums[i];
	            }
	            swap(nums, i, nums[i]);
	        }
	    }
	    
	    return -1;
	}
	
	/**
	 * 交换位置
	 * @param nums
	 * @param i
	 * @param j
	 */
	private static void swap(int[] nums, int i, int j) {
		
		int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
	
	
	
	
	/**
	 * 3. 将一个字符串中的空格替换成 "%20"。
	 * 
	 * 解题思路
	 * ① 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。
	 *   因为一个空格要替换成三个字符（%20），所以当遍历到一个空格时，需要在尾部填充两个任意字符。
	 * ② 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。
	 *   P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
	 *   从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
	 * ③ 当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出。
	 * @param str
	 * @return
	 */
	public static String problem3(StringBuffer str) {
	    int P1 = str.length() - 1;
	    for (int i = 0; i <= P1; i++)
	        if (str.charAt(i) == ' ')
	            str.append("  ");

	    int P2 = str.length() - 1;
	    while (P1 >= 0 && P2 > P1) {
	        char c = str.charAt(P1--);
	        if (c == ' ') {
	            str.setCharAt(P2--, '0');
	            str.setCharAt(P2--, '2');
	            str.setCharAt(P2--, '%');
	        } else {
	            str.setCharAt(P2--, c);
	        }
	    }
	    return str.toString();
	}
}
