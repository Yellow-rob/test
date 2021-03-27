package solution;

import java.util.Stack;

public class LeetCode {
	// 链表结点
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	//二叉树结点
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// 反转链表进阶版（指定开始结束位置，反转这一部分）
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode preNode = null;
		ListNode nextNode = head;
		ListNode leftPreNode;
		ListNode rightNextNode;
		ListNode leftNode = null;
		int count = 1;

		for (int i = 1; i < left - 1; i++) {
			nextNode = nextNode.next;
			count = i;// 记录到第几个节点了
		}
		leftPreNode = nextNode;// 记录开始反转的前一个结点
		for (int j = count; j < right; j++) {// 对left和right之间的结点进行翻转
			preNode = nextNode;
			nextNode = nextNode.next;
			nextNode.next = preNode;
			if (j == count) {
				leftNode = preNode; // 记录开始翻转的结点，做特殊处理
			}
		}
		rightNextNode = nextNode;
		leftPreNode.next = preNode;
		leftNode.next = rightNextNode;
		if (left == 1) {// 从头结点开始翻转，特殊考虑(反转后right位置的结点变成了头结点)
			return preNode;
		}
		return head;// 其他情况直接返回原头结点作为新链表的头结点
	}

	// 原地移除数组中指定的值
	public int removeElement(int[] nums, int val) {
		int i = 0;// 双指针
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}

	// 简单的括号匹配
	public boolean isValid(String s) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.split("")[i]);
			} else if (s.charAt(i) == ')') {
				if (stack.empty())
					return false;
				if (stack.peek().equals("(")) {
					stack.pop();
				} else {
					return false;
				}
			} else if (s.charAt(i) == ']') {
				if (stack.empty())
					return false;
				if (stack.peek().equals("[")) {
					stack.pop();
				} else {
					return false;
				}
			} else if (s.charAt(i) == '}') {
				if (stack.empty())
					return false;
				if (stack.peek().equals("{")) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}

	// 判断回文数
	public boolean isPalindrome(int x) {
		String intStr = Integer.toString(x);
		int len = intStr.length();
		for (int i = 0; i < len / 2; i++) {
			if (intStr.charAt(i) == intStr.charAt(len - i - 1)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// 判断无符号整型数的二进制表示中一的个数
	public int hammingWeight(int n) {
		int count = 0;
		long l = n & 0xFFFFFFFFL;
		for (int i = 31; i >= 0; i--) {
			long power = (long) this.power(2, i) & 0xFFFFFFFFL;
			if (power <= l && l > 0) {
				l -= power;
				count++;
			}
		}
		return count;
	}
	//num的power次方
	private int power(int num, int power) {
		int total = num;
		if (power == 0) {
			return 1;
		}
		for (int i = 2; i < power; i++) {
			total *= num;
		}
		return total;
	}

	// 删除数组中的重复元素，返回删除后长度
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] == nums[i]) {
				continue;
			}
			nums[count] = nums[i];
			count++;
		}
		nums[count] = nums[nums.length - 1];
		return count + 1;
	}

	// 最大子序和
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		if (len == 1) {
			return nums[0];
		}
		int maxSub = 0;
		int count = 0;
		int maxNum = 0xFFFFFFFF;
		for (int i = 0; i < len; i++) {
			if (nums[i] < 0) {
				count++;// 记录负数的个数
				if (nums[i] > maxNum) {
					maxNum = nums[i];
				}
			}
			int sum = 0;
			for (int j = i; j < len; j++) {
				sum += nums[j];
				if (sum > maxSub) {// 没考虑数组元素全为负数的情况
					maxSub = sum;
				}
			}
		}
		if (count == len) {// 数组元素全负的情况
			return maxNum;
		}
		return maxSub;
	}

	// 在数组表示的整数基础上加1
	public int[] plusOne(int[] digits) {
		// 主要是考虑进位的问题
		int len = digits.length;
		for (int i = len - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;// 是9，考虑进位
			} else {
				digits[i] += 1;// 不是9，加一不用考虑进位问题
				break;
			}
		}
		// 还要考虑全为9的情况
		if (digits[0] == 0) {// 进位完最高位是0说明全是9
			int[] allNine = new int[len + 1];
			allNine[0] = 1;
			for (int i = 1; i < len + 1; i++) {
				allNine[i] = 0;
			}
			return allNine;
		}
		return digits;
	}

	// 爬楼梯（加数只有1和2两种，有多少种方式可以达到和n）
	/**************
	 * 动态规划经典题目************ 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和 1.爬上 n−1
	 * 阶楼梯的方法数量。因为再爬1阶就能到第n阶 2.爬上 n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶 所以我们得到公式 dp[n] = dp[n-1]
	 * + dp[n-2] 同时需要初始化 dp[0]=1 和 dp[1]=1
	 ***************************************/
	class Solution {
		public int climbStairs(int n) {
			int dp[] = new int[n + 1];// 从0到n共n+1种方式
			dp[0] = 1;
			dp[1] = 1;// 给初值
			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			return dp[n];
		}
	}

	//判断两颗二叉树是否相同（传参为两颗树的根节点）
	public boolean isSameTree(TreeNode p, TreeNode q) {
		//先序遍历两棵树，得到的序列相同则为相同
		//要考虑某结点没有左子树的情况
		int[] order1 = new int[100];//结点最多100个
		int[] order2 = new int[100];
		if(!p.equals(q)) {
			return false;//根节点不一样直接返回false
		}
		return preOrder(p, order1, 0).equals(preOrder(q, order2, 0)) ? true : false;
    }
	private int[] preOrder(TreeNode root, int[] order, int i) {
//		if(root == null) {
//			order[i] = 10001;//用结点值赋值范围外的一个值表示空的区别
//		}else {
//			order[i] = root.val;
//		}
		order[i] = root.val;
		preOrder(root.left, order, ++ i);
		preOrder(root.right, order, ++ i);
		return order;
	}
}
