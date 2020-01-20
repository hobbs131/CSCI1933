public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// TODO: Implement me for milestone 1
	public void addElement(int index, double value){
		if (index <= length - 1){
			Node curr = head;
			if (curr == null){
				curr = new Node(index,value);
				this.head = curr;
			}
			else{
				while (curr.getNext() != null){
					curr = curr.getNext();
				}
				curr.setNext(new Node(index,value));
			}
		}
	}

	// TODO: Implement me for milestone 2
	public static double dot( SparseVector x, SparseVector y ){
		double result = 0;

		if (x.length == y.length){
			Node currentXHead = x.head;
			Node currentYHead = y.head;
			while(currentXHead != null && currentYHead != null){
				if (currentXHead.getIndex() == currentYHead.getIndex()){
					result += currentXHead.getValue() * currentYHead.getValue();

					currentXHead = currentXHead.getNext();
					currentYHead = currentYHead.getNext();
				}
				else{
					if (currentXHead.getIndex() < currentYHead.getIndex()){
						currentXHead = currentXHead.getNext();
					}
					else {
						currentYHead = currentYHead.getNext();
					}
				}
			}
			return result;
		}
		else{
			return -1;
		}
	}

	public void removeElement(int index){

	}

	// TODO: Test out your code here!
	public static void main(String[] args) {
		SparseVector vec = new SparseVector(1000000000);
		vec.addElement(0, 1.0);
		vec.addElement(100000000, 3.0);
		vec.addElement(100000001, -2.0);
		SparseVector vec1 = new SparseVector(1000000000);
		vec1.addElement(0, 2.0);
		vec1.addElement(100000001, -4.0);
		double result = dot(vec,vec1);
		System.out.println(result);
	}
}
