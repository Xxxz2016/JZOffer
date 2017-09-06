
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
	
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val){
		data = val;
	}
	
	public void display(){
		System.out.print(data);
	}
}

class Tree{
	
	public TreeNode root;
	
	public Tree(){
		root = null;
	}
	
	// --------------------------------------------------
	// 都是插到最底层哦
	// 二叉搜索树
	public void insert(int val){
		
		TreeNode newTreeNode = new TreeNode(val);
		
		if(root==null){
			root = newTreeNode;
		}else{

			TreeNode current = root;
			TreeNode parent;
			while(true){
				parent = current;		// 要走到current==null，所以用parent保存父节点
				if(val<current.data){	
					current = current.left;     // 小于则向左走
					if(current==null){
						parent.left = newTreeNode;
						return;
					}
				}else{					
					current = current.right;	// 大于则向右走
					if(current==null){
						parent.right = newTreeNode;
						return;
					}
				}
			}
		}
	}
	
	//--------------------------------------------------
	// 删除结点
	public boolean delete(int key){
		TreeNode current = root;
		TreeNode parent = root;
		boolean isLeftChild = true;	//标识待删除结点是父节点的左/右
		
		// 向左向右直到找到key
		// 保存了parent和isleft
		while(current.data!=key){
			parent = current;
			if(key<current.data){
				current = current.left;
				isLeftChild = true;
			}else{
				current = current.right;
				isLeftChild = false;
			}
			if(current==null){
				return false;  
			}
		}
		
		// 如果没有子节点，直接删掉，父节点的左/右指向null
		if(current.left==null&&current.right==null){
			if(current==root){
				root = null;
			}else if(isLeftChild){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		
		// 如果仅左/右子节点，子树直接上移
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}
		
		// 如果左右子结点都有，需要和中序后继替换
		// （即相当于先去删掉（无左子结点的）中序后继）
		else{
			TreeNode successor = getSuccessor(current);
			// 连接上半部分
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}
			// 连接下半部分
			successor.left = current.left;
			if(successor!=current.right){
				successor.right = current.right;
			}
		}
		
		return true;
	}
	
	// 取出中序后继（先向右，再一直向左找！！！）
	private TreeNode getSuccessor(TreeNode delTreeNode){
		TreeNode parent = delTreeNode;
		TreeNode current = delTreeNode.right;
		while(current!=null){
			parent = current;
			current = current.left;
		}	
		// 如果后继与待删除结点相邻（即右子节点），直接替换就行，后续部分相当于自动上移了
		// 否则要将后继的右子树上移（类似于删掉后继，而后继只有右子树）!!!!
		if(current != delTreeNode.right){
			parent.left = current.right;
		}
		return current;
	}
	
	//--------------------------------------------------
	// 遍历
	public void traverse(String traverseType){
		switch(traverseType){
			case "pre":
				System.out.print("\nPreOrder: ");
				preOrder(root);
				break;
			case "in":
				System.out.print("\nInOrder: ");
				inOrder(root);
				break;
			case "post":
				System.out.print("\nPostOrder: ");
				postOrder(root);
				break;	
		}
		System.out.print("\n");
	}
	
	// 递归实现
	private void preOrder(TreeNode root){
		if(root!=null){
			System.out.print(root.data+"-->");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	private void inOrder(TreeNode root){
		if(root!=null){
			inOrder(root.left);
			System.out.print(root.data+"-->");
			inOrder(root.right);
		}
	}
	private void postOrder(TreeNode root){
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+"-->");
		}
	}
	
	//--------------------------------------------------
	// 层次遍历
	// 队列实现！按前序遍历依次入队列!!
	private void levelOrder(TreeNode root){

		if(root!=null){
						
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();	// 队列
			TreeNode current = null;
			
			queue.offer(root);		//根节点入队列
			
			while(!queue.isEmpty()){
				
				current = queue.poll();
				System.out.print(current.data + "-->");
				
				if(current.left!=null){
					queue.offer(current.left);
				}
				if(current.right!=null){
					queue.offer(current.right);
				}
			}
		}
	}
	
	//--------------------------------------------------
	// 命令行中打印Tree
	
	public void display(){
		
		ArrayList<ArrayList<Integer>> levelList = getLevelList(root);
		int nBlanks = 1 << (levelList.size()+1);
		
		for(int i=0; i<levelList.size(); i++){
			for(int j=0; j<levelList.get(i).size(); j++){
				
				// 打印空格，尽量对齐
				for(int k=0; k<nBlanks-1; k++){
					System.out.print(" ");
				}
				
				if(levelList.get(i).get(j)!=null){
					System.out.print(levelList.get(i).get(j));
				}else{
					System.out.print("--");
				}
				
				for(int k=0; k<nBlanks-1; k++){
					System.out.print(" ");
				}
			}
			System.out.println("");
			nBlanks/=2;
		}
		
	}
	
	// 利用层次遍历得到每一层结点
	// 1
	// 2 3
	// null 2 null 9
	public ArrayList<ArrayList<Integer>> getLevelList(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arrayListlayer = new ArrayList<Integer>();
		
		if (root == null) {
			return arrayList;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();		// 队列
		
		int start = 0;
		int end = 1;		// 每一层结点数
		
		queue.add(root);
		int nElems = 1;	    // 队列中非空结点个数
			
		while (true) {
			
			TreeNode cur = queue.remove();	// 出队列
			// 保存到ArrayList
			if(cur!=null){					
				arrayListlayer.add(cur.data);
				nElems--;
			}else{
				arrayListlayer.add(null);
			}
					
			start++;
			
			// 出队列的结点的子节点入队列
			if(cur!=null){
				if (cur.left!= null) {
					queue.add(cur.left);
					nElems++;
				}else{
					queue.add(null);
				}
				
				if (cur.right!= null) {
					queue.add(cur.right);
					nElems++;
				}else{
					queue.add(null);
				}	
			}else{
				queue.add(null);
				queue.add(null);
			}

			// 存完一层
			if (start == end) {
				start = 0;
				end = queue.size();	//下一层的结点数
				arrayList.add(arrayListlayer);
				if(nElems<=0){
					break;	// 所有非空结点已存入ArrayList
				}
				arrayListlayer = new ArrayList<>(); // 刷新存一层
			}
		}
		return arrayList;	
	}
	
}

class TreeApp{
	
	public static void main(String[] args){
		
		Tree mTree = new Tree();
		
		// 插的顺序不同，树也不同
		mTree.insert(11);
		mTree.insert(12);
		mTree.insert(13);
		mTree.insert(14);
		/*
		mTree.insert(50);
		mTree.insert(25);
		mTree.insert(75);
		mTree.insert(37);
		mTree.insert(34);
		mTree.insert(89);
		mTree.insert(14);
		mTree.insert(67);
		mTree.insert(94);
		mTree.insert(24);
		mTree.insert(12);
		mTree.insert(13);
		mTree.insert(45);
		*/
		mTree.display();	
	}
}
