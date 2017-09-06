
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
	// ���ǲ嵽��ײ�Ŷ
	// ����������
	public void insert(int val){
		
		TreeNode newTreeNode = new TreeNode(val);
		
		if(root==null){
			root = newTreeNode;
		}else{

			TreeNode current = root;
			TreeNode parent;
			while(true){
				parent = current;		// Ҫ�ߵ�current==null��������parent���游�ڵ�
				if(val<current.data){	
					current = current.left;     // С����������
					if(current==null){
						parent.left = newTreeNode;
						return;
					}
				}else{					
					current = current.right;	// ������������
					if(current==null){
						parent.right = newTreeNode;
						return;
					}
				}
			}
		}
	}
	
	//--------------------------------------------------
	// ɾ�����
	public boolean delete(int key){
		TreeNode current = root;
		TreeNode parent = root;
		boolean isLeftChild = true;	//��ʶ��ɾ������Ǹ��ڵ����/��
		
		// ��������ֱ���ҵ�key
		// ������parent��isleft
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
		
		// ���û���ӽڵ㣬ֱ��ɾ�������ڵ����/��ָ��null
		if(current.left==null&&current.right==null){
			if(current==root){
				root = null;
			}else if(isLeftChild){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		
		// �������/���ӽڵ㣬����ֱ������
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
		
		// ��������ӽ�㶼�У���Ҫ���������滻
		// �����൱����ȥɾ���������ӽ��ģ������̣�
		else{
			TreeNode successor = getSuccessor(current);
			// �����ϰ벿��
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}
			// �����°벿��
			successor.left = current.left;
			if(successor!=current.right){
				successor.right = current.right;
			}
		}
		
		return true;
	}
	
	// ȡ�������̣������ң���һֱ�����ң�������
	private TreeNode getSuccessor(TreeNode delTreeNode){
		TreeNode parent = delTreeNode;
		TreeNode current = delTreeNode.right;
		while(current!=null){
			parent = current;
			current = current.left;
		}	
		// ���������ɾ��������ڣ������ӽڵ㣩��ֱ���滻���У����������൱���Զ�������
		// ����Ҫ����̵����������ƣ�������ɾ����̣������ֻ����������!!!!
		if(current != delTreeNode.right){
			parent.left = current.right;
		}
		return current;
	}
	
	//--------------------------------------------------
	// ����
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
	
	// �ݹ�ʵ��
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
	// ��α���
	// ����ʵ�֣���ǰ��������������!!
	private void levelOrder(TreeNode root){

		if(root!=null){
						
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();	// ����
			TreeNode current = null;
			
			queue.offer(root);		//���ڵ������
			
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
	// �������д�ӡTree
	
	public void display(){
		
		ArrayList<ArrayList<Integer>> levelList = getLevelList(root);
		int nBlanks = 1 << (levelList.size()+1);
		
		for(int i=0; i<levelList.size(); i++){
			for(int j=0; j<levelList.get(i).size(); j++){
				
				// ��ӡ�ո񣬾�������
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
	
	// ���ò�α����õ�ÿһ����
	// 1
	// 2 3
	// null 2 null 9
	public ArrayList<ArrayList<Integer>> getLevelList(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arrayListlayer = new ArrayList<Integer>();
		
		if (root == null) {
			return arrayList;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();		// ����
		
		int start = 0;
		int end = 1;		// ÿһ������
		
		queue.add(root);
		int nElems = 1;	    // �����зǿս�����
			
		while (true) {
			
			TreeNode cur = queue.remove();	// ������
			// ���浽ArrayList
			if(cur!=null){					
				arrayListlayer.add(cur.data);
				nElems--;
			}else{
				arrayListlayer.add(null);
			}
					
			start++;
			
			// �����еĽ����ӽڵ������
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

			// ����һ��
			if (start == end) {
				start = 0;
				end = queue.size();	//��һ��Ľ����
				arrayList.add(arrayListlayer);
				if(nElems<=0){
					break;	// ���зǿս���Ѵ���ArrayList
				}
				arrayListlayer = new ArrayList<>(); // ˢ�´�һ��
			}
		}
		return arrayList;	
	}
	
}

class TreeApp{
	
	public static void main(String[] args){
		
		Tree mTree = new Tree();
		
		// ���˳��ͬ����Ҳ��ͬ
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
