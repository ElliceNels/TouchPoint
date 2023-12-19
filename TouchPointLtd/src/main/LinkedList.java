import java.util.Objects;

public class ArrayList<T> implements List {
        private static final int capacity = 100;
        private Object[]elements;
        private int current;
        private int size;

        public ArrayList() {
            this.elements = new Object[capacity];
            this.size = 0;
            current =-1;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int length() {
            return size;
        }

        @Override
        public T get(int index) {
            Objects.checkIndex(index, size);
            return elementData(index);

        @Override
        public void insert(Location newPosition, int positionNum) {
            if (isEmpty())
            {
                System.out.println("list is empty, however the element will be inserted at location 0");
                head=new ListNode(newPosition);
                size++;

            }
            else if ((positionNum +1)> size) {
                System.out.println("location exceeds list length, element will be inserted to the end of the list");
                ListNode tmp = head;
                while (tmp.next!=null)
                {
                    tmp = tmp.next;
                }
                tmp.next=new ListNode(newPosition);
                size++;
            }
            else if (positionNum ==0)
            {
                ListNode tmp=new ListNode(newPosition);
                tmp.next=head;
                head=tmp;
                size++;
            }
            else {
                ListNode tmp = head;
                int j=0;
                while (j< positionNum -1)
                {
                    tmp = tmp.next;
                    j++;
                }

                ListNode newElem=new ListNode(newPosition);
                newElem.next=tmp.next;
                tmp.next=newElem;
                size++;
            }
        }

        @Override
        public void remove(int positionNum) {

            if (isEmpty())
            {
                System.out.println("list is empty");
            }
            else if ((positionNum +1)> size) {
                System.out.println("location exceeds list length");

            }
            else if (positionNum ==0)
            {
                head=head.next;
                size--;
            }
            else {
                ListNode tmp = head;
                int j=0;
                while (j< positionNum -1)
                {
                    tmp = tmp.next;
                }

                tmp.next=tmp.next.next;
                size--;
            }
        }

        public void add(T e, Object[] elements, int s) {
            if (s == elements.length)
                elements = grow();
            elementData[s] = e;
            size = s + 1;


    }
