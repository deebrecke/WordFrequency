
public class LinkedMap<KeyType, ValueType> {

    private class Node{
        KeyType key;
        ValueType value;
        Node next;
    }

    private Node head;

    public void put(KeyType theKey, ValueType theValue) {
        //is theKey in the map already
        Node current = head;
        while (current != null) {
            if (theKey.equals(current.key)) {
                //I found it
                current.value = theValue;
                return;
            }
            current = current.next;
        }//while

        Node theNewNode = new Node();
        theNewNode.key = theKey;
        theNewNode.value = theValue;
        theNewNode.next = head;
        head= theNewNode;
    }//put

    public  ValueType get(KeyType theKey){
        Node current = head;
        while (current != null){
            if(theKey.equals(current.key)){
                return current.value;
            }
        }
        return null;
    }//get




}//class
