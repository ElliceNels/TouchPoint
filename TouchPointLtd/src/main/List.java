public interface List {

        public boolean isEmpty(); //checks if list is empty

        public int length();

        public Location retrieve(int positionNum); //get data from particularl location

        public void update(Location newPosition, int positionNum); //update element at particular location

        public void insert(Location newPosition, int positionNum); //insert element at location positionNum, if positionNum exceeds list length, it will be at last location, if list is empty, this will be added as first element

        public void remove(int positionNum); //remove the element at location positionNum

    }


