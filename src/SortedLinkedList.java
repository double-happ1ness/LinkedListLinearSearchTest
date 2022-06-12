// this is a cut down version of the class specifically for the Linear Search test
// the complete version is in the Library folder on Moodle

public class SortedLinkedList implements SortedADT {

    private class ListNode {

        private Comparable object;
        private ListNode next;
    }

    private ListNode head;

    public String toString() {
        /* algorithm
            set up a string to contain the list details
            if list not empty then
                set current node to head of list
                while nodes remain loop
                    add the node object to the string
                    move to next node
                end loop
            else
                add empty list message to the string
         end if
         */
        String listDetails = new String();
        if (this.head != null) {
            ListNode current = this.head;
            while (current != null) {
                listDetails += current.object + "\n";
                current = current.next;
            }
        } else {
            listDetails += "list is empty";
        }
        return listDetails;
    }

    public void insert(Comparable object) {
        // cut down version, for this test objects are added in order
        ListNode newNode = new ListNode();
        newNode.object = object;
        if (this.head == null) {
            this.head = newNode;
        } else {
            ListNode current = this.head;
            Boolean insertionPositionFound = false;
            while (!insertionPositionFound) {
                if (current.next == null) {
                    insertionPositionFound = true;
                    current.next = newNode;
                } else {
                    current = current.next;
                }
            }
        }
    }

    public Comparable find(Comparable object) throws NotFoundException {
        /* algorithm
            if list empty then
                throw not found exception
            end if
            set current node to head of list
            while object not found loop
                if object matches current node object then
                    object found
                else
                    if object is less than current object then
                        // object is not in the list
                        throw not found exception
                    else
                        if no more objects to compare with then
                            // object is not in the list
                            throw not found exception
                        else
                            // move to the next node
                            set the current node to the next node
                        end if
                    end if
                end if
            end loop
         */
        if (this.head == null) {
            throw new NotFoundException();
        }
        Comparable foundObject = null;
        ListNode current = this.head;
        if (this.head == null) {
            throw new NotFoundException();
        }
        current = this.head;
        // require to explicitly set to null to avoid compilation error
        ListNode previous = null;
        Boolean objectFound = false;
        while (!objectFound) {
            if (object.compareTo(current.object) == 0) {
                objectFound = true;
            } else if (object.compareTo(current.object) < 0) {
                throw new NotFoundException();
            } else {
                if (current.next == null) {
                    throw new NotFoundException();
                } else {
                    current = current.next;
                }
            }
        }
        return foundObject;
    }
}
