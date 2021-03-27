package solution;

public class Test {
	
	public class MapNode{
		MapNode parent;
		MapNode lChild;
		MapNode rChild;
		int nodeInfo;

		public MapNode(MapNode parent, MapNode lChild, MapNode rChild, int nodeInfo) {
			super();
			this.parent = parent;
			this.lChild = lChild;
			this.rChild = rChild;
			this.nodeInfo = nodeInfo;
		}
		
		
		
	}
	
	public class Map{
		MapNode root;
		int nodeNums;

		public Map(MapNode root, int nodeNums) {
			super();
			this.root = root;
			this.nodeNums = nodeNums;
		}

		public int djastra(MapNode node1,MapNode node2) {
			int count;
			if(node1.nodeInfo < node2.nodeInfo) {
				
			}
			return -1;
		}
	}
	
	public int searchTimes(int[][] input) {
		int nodeNums = input[0][0];
		
		
		
		return -1;
	}
	
	public static void main(String[] Args) {
		
	}
}
