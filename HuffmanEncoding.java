import java.util.*;

public class HuffmanEncoding {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        int[] array = new int[256]; //an array to store all the frequencies

        for (int i = 0; i < sentence.length(); i++) { //go through the sentence
            array[(int) sentence.charAt(i)]++; //increment the appropriate frequencies
        }

        PriorityQueue < Tree > PQ = new PriorityQueue < Tree > (); //make a priority queue to hold the forest of trees

        for (int i = 0; i < array.length; i++) { //go through frequency array
            if (array[i] > 0) { //print out non-zero frequencies - cast to a char





                //FILL THIS IN:
				Node N1 = new Node();
				N1.letter=N1.smallestLetter=(char)i;
                //MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ
				//create a new Tree
				Tree tree1= new Tree();
				//insert the letter as the root node
				tree1.root=N1;
				//set the cumulative frequency of that Tree
				tree1.frequency=array[i];

                //add the Tree into the PQ
                PQ.add(tree1);




            }
        }

        while (PQ.size() > 1) { //while there are two or more Trees left in the forest



			Tree tree_a = PQ.poll();
			Tree tree_b = PQ.poll();
			//make new tree
			Node newNode=new Node();
			newNode.leftChild = tree_a.root;
			newNode.rightChild= tree_b.root;
			newNode.smallestLetter = (char)Math.min(tree_a.root.smallestLetter, tree_b.root.smallestLetter );

			Tree newTree= new Tree();
			newTree.root=newNode;
			newTree.frequency=tree_a.frequency+tree_b.frequency;




			PQ.add(newTree);




        }

        Tree HuffmanTree = PQ.poll(); //now there's only one tree left - get its codes




        //FILL THIS IN:
		String enc="";
		for (char c: sentence.toCharArray())
		{
			enc += HuffmanTree.getCode(c);
		}
	System.out.println(enc);
        //get all the codes for the letters and print them out
        //call the getCode() method on the HuffmanTree Tree object for each letter in the sentence





    }
}

class Node {


    public char letter = '@'; //stores letter
    public char smallestLetter = '@';  //a nice idea it to track the smallest letter in the tree in a special variable like this

    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child


} // end class Node





class Tree implements Comparable < Tree > {
    public Node root; // first node of tree
    public int frequency = 0;

    public Tree() // constructor
    {
        root = null;
    } // no nodes in tree yet



    public int compareTo(Tree object) {
        if (frequency - object.frequency > 0) { //compare the cumulative frequencies of the tree
            return 1;
        } else if (frequency - object.frequency < 0) {
            return -1; //return 1 or -1 depending on whether these frequencies are bigger or smaller
        } else {
            // Sort based on letters
            char a = this.root.smallestLetter;
            char b = object.root.smallestLetter;

            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            return 0;
        }
    }

    String path = "error"; //this variable will track the path to the letter we're looking for

    public String getCode(char letter) { //we want the code for this letter

        return this._getCode(letter, this.root, ""); //return the path that results
    }

    private String _getCode(char letter, Node current, String path) {
        if (current == null) {
            return null;
        }
        if (current.letter == letter) {
            return path;
        }

        String leftPath = this._getCode(letter, current.leftChild, path + "0");
        if (leftPath != null) {
            return leftPath;
        }

        String rightPath = this._getCode(letter, current.rightChild, path + "1");
        return rightPath;
    }

} // end class Tree