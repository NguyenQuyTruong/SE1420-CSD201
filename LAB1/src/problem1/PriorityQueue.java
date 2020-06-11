package problem1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import problem1.DoubleLinkedList.node;

public class PriorityQueue implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	DoubleLinkedList list = new DoubleLinkedList();
	
	/**
	 * Insert into priority queue, look simple but it doesn't!!!
	 * @param email
	 * @param point
	 */
	public void insert(String email, long point) {
		node newNode = list.makeNode(email, point);
		
		if (list.isEmpty()) { 
			//if head link to tail ==> queue empty ==> insert center between HEAD and TAIL
			list.headNode.right = newNode;
			newNode.left = list.headNode;
			newNode.right = list.tailNode;
			list.tailNode.left = newNode;
		}else{
			
			if (newNode.getPoint() < list.tailNode.left.getPoint()) { 
				//if the tail node value bigger than newNode, break the link and set new tail
				list.tailNode.left.right = newNode;
				newNode.left = list.tailNode.left;
				newNode.right = list.tailNode;
				list.tailNode.left = newNode;
			}
			else if (newNode.getPoint() > list.headNode.right.getPoint()) {
				//if the head node value smaller than newNode, break the link and set new head
				list.headNode.right.left = newNode;
				newNode.right = list.headNode.right;
				newNode.left = list.headNode;
				list.headNode.right = newNode;
			}
			else {
				//normal case, looping though
				node currentNode = list.headNode.right;
				while(currentNode.getPoint() >= newNode.getPoint()) {
					currentNode = currentNode.right;
				}
				newNode.right = currentNode;
				newNode.left = currentNode.left;
				currentNode.left.right = newNode;
				currentNode.left = newNode;
			}
			
		}
		
		//System.out.println("Inserted new data!");
		
	}
	
	private node SearchByEmail(String email) {
		node currentNode = list.headNode.right;
		while(!(currentNode.getEmail().contentEquals(email)) && (currentNode != list.tailNode)) {
			currentNode = currentNode.right;
		}
		
		return currentNode;
	}
	
	/**
	 * Delete a node using email
	 * @param email
	 */
	public void Delete(String email) {
		node currentNode = SearchByEmail(email);
		
		if (currentNode == list.tailNode) {
			System.out.println("Warning: not found to delete.. no problem!");
		}else {
			currentNode.left.right = currentNode.right;
			currentNode.right.left = currentNode.left;
			currentNode = null; //free mem
			
			System.out.println("Deleted " + email + " from queue");
		}
		
	}
	
	/**
	 * find and update point of email
	 * @param email
	 * @param newPoint
	 */
	public void Update(String email, long newPoint) {
		node currentNode = SearchByEmail(email);
		
		if (currentNode == list.tailNode) {
			System.out.println("Warning: not found to update.. no problem!");
		}else {
			currentNode.setPoint(newPoint);
			System.out.println("Updated " + email + " new point: " + newPoint);
		}
	}
	
	public void printAll() {
		node currentNode = list.headNode;
		while(currentNode.right != null) {
			if (currentNode != list.headNode) {
				System.out.println(currentNode.getEmail() + " " + currentNode.getPoint());	
			}
			currentNode = currentNode.right;
		}
	}

	/**
	 * Get point of user
	 * @param email
	 * @return null if cant find user else, a value
	 */
	public Long GetPoint(String email) {
		node currentNode = SearchByEmail(email);
		
		if (currentNode != list.tailNode) {
			return currentNode.getPoint();
		}
		
		return null;
	}

	
	/**
	 * Get top user
	 */
	public void getTop() {
		if (list.isEmpty()) {
			System.out.println("data is empty!");
		}else {
			System.out.println(list.headNode.right.getPoint());
		}
	}
	
	/**
	 * Delete top user
	 */
	public void DeleteTop() {
		if (list.isEmpty()) {
			System.out.println("Data is empty, cancel deletion!");
		}else {
			node currentNode = list.headNode.right;
			currentNode.left.right = currentNode.right;
			currentNode.right.left = currentNode.left;
			currentNode = null; //free mem
			
			System.out.println("Deleted top user!");
		}
	}

	/**
	 * write current queue to CSV
	 * @param path
	 * @throws IOException
	 */
	public void exportCSV(String path) throws IOException {
		FileWriter writer = new FileWriter(path);
		writer.append("Email,Point\n");
		
		node currentNode = list.headNode.right;
		
		while(currentNode != list.tailNode) {
			String rawData = String.format("%s,%d\n", currentNode.getEmail(), currentNode.getPoint());
			writer.append(rawData);
			
			currentNode = currentNode.right;
		}
		
		writer.flush();
		writer.close();
		
		System.out.println("Saved data to CSV file!");
	}
	
	
	
	
}
