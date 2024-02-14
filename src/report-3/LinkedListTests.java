/**
 * 
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.junit.*;

/**
 * 
 */
public class LinkedListTests {

    int[] array0 = {};
    int[] array1 = { 0 };
    int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] array3 = { 1, 1, 2, 3, 5, 8 };
    int[] array4 = { -8, 8, -4, 4, -2, 2, -1, 1, 0 };
    int[][] arrays = { array0, array1, array2, array3, array4 };

    /* */
    ArrayList<Integer>[] alists;

    /* */
    LinkedList[] llists;

    @Before
    public void setUp() {
        this.alists = (ArrayList<Integer>[]) new ArrayList[this.arrays.length];
        this.llists = new LinkedList[this.arrays.length];

        for (int i = 0; i < this.arrays.length; ++i) {
            this.alists[i] = this.constructArrayList(this.arrays[i]);
            this.llists[i] = this.constructLinkedList(this.arrays[i]);
        }
    }

    /**
     * 
     * @param array
     * @return
     */
    public ArrayList<Integer> constructArrayList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int x: array) {
            list.add(x);
        }

        return list;
    }

    /**
     * 
     * @param array
     * @return
     */
    public LinkedList constructLinkedList(int[] array) {
        Node node = null;

        for (int i = array.length - 1; i >= 0; --i) {
            node = new Node(array[i], node);
        }

        LinkedList list = new LinkedList();
        list.root = node;
        
        return list;
    }

    /**
     * 
     */
    @Test
    public void testPrepend() {
        for (int i = 0; i < this.arrays.length; ++i) {
            this.helpPrepend(this.llists[i], this.alists[i]);
        }
    }

    /**
     * 
     * 
     * @param llist
     * @param alist
     */
    public void helpPrepend(LinkedList llist, ArrayList<Integer> alist) {
        llist.prepend(0);

        assertEquals(alist.size() + 1, llist.length());
        assertEquals(0, llist.first());

        Node node = llist.root;
        for (int i = 0; i < alist.size(); ++i) {
            node = node.next;
            assertEquals(Integer.toString(i), alist.get(i), (Integer) node.value);
        }
    }

    /**
     * 
     */
    @Test
    public void testAppend() {
        for (int i = 0; i < this.arrays.length; ++i) {
            this.helpAppend(this.llists[i], this.alists[i]);
        }
    }

    /**
     * 
     * 
     * @param llist
     * @param alist
     */
    public void helpAppend(LinkedList llist, ArrayList<Integer> alist) {
        llist.append(0);
        
        assertEquals(alist.size() + 1, llist.length());
        assertEquals(0, llist.last());
        
        Node node = llist.root;
        for (int i = 0; i < alist.size(); ++i) {
            assertEquals(Integer.toString(i), alist.get(i), (Integer) node.value);
            node = node.next;
        }
    }

    /**
     * 
     */
    @Test
    public void testFirst() {
        for (int i = 0; i < this.arrays.length; ++i) {
            if (this.alists[i].size() == 0) {
                assertThrows(
                    NoSuchElementException.class, this.llists[i]::first
                );
            } else {
                assertEquals(
                    this.alists[i].get(0), (Integer) this.llists[i].first()
                );
            }
        }
    }

    @Test
    public void testLast() {
        for (int i = 0; i < this.arrays.length; ++i) {
            if (this.alists[i].size() == 0) {
                assertThrows(NoSuchElementException.class, this.llists[i]::last);
            } else {
                assertEquals(
                    this.alists[i].get(this.alists[i].size() - 1),
                    (Integer) this.llists[i].last()
                );
            }
        }
    }

    @Test
    public void testToString() {
        assertEquals("", this.llists[0].toString());
        assertEquals("0", this.llists[1].toString());
        assertEquals("1 2 3 4 5 6 7 8 9", this.llists[2].toString());
        assertEquals("1 1 2 3 5 8", this.llists[3].toString());
        assertEquals("-8 8 -4 4 -2 2 -1 1 0", this.llists[4].toString());
    }

    /**
     * 
     */
    @Test
    public void testLength() {
        for (int i = 0; i < this.arrays.length; ++i) {
            assertEquals(this.alists[i].size(), this.llists[i].length());
        }
    }
}
