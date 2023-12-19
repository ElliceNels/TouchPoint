public class ArrayList<T> implements List {
        private static final int capacity = 100;
        private Object
        private int size;

        private class ListNode{
            public Location data;
            public ListNode next;


            public ListNode(Location data) {
                this.data = data;
                next = null;
            }
        }

        public LinkedList()
        {
            head=null;
            size =0;
        }

        @Override
        public boolean isEmpty() {
            if(head == null)
                return true;
            return false;
        }

        @Override
        public int length() {
            return size;
        }

        @Override
        public Location retrieve(int positionNum) {
            if (isEmpty())
            {
                System.out.println("list is empty, null will be returned");
                return null;
            }
            if ((positionNum +1)> size) {
                System.out.println("location exceeds list length, null will be returned");
                return null;
            }
            else {
                ListNode tmp = head;
                int j=0;
                while (j< positionNum)
                {
                    tmp = tmp.next;
                    j++;
                }

                return tmp.data;
            }

        }

        @Override
        public void update(Location newPosition, int positionNum) {
            if (isEmpty())
            {
                System.out.println("list is empty");
            }
            if ((positionNum +1)> size) {
                System.out.println("location exceeds list length");
            }
            else {
                ListNode tmp = head;
                int j=0;
                while (j< positionNum)
                {
                    tmp = tmp.next;
                    j++;
                }

                tmp.data=newPosition;
            }
        }

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


    }
