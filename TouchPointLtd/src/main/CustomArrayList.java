
    public class CustomArrayList<T> implements List<T> {

        private static final int DEFAULT_CAPACITY = 5;

        private int size;
        private int capacity;
        private Object[] internalArray;

        public CustomArrayList(int capacity) {
            this.capacity = capacity;
            internalArray = new Object[this.capacity];
        }

        public CustomArrayList() {
            this.capacity = DEFAULT_CAPACITY;
            internalArray = new Object[this.capacity];
        }

        @Override
        public T get(int index) {
            return (T) this.internalArray[index];
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        private void resize() {
            int newCapacity = this.capacity * 2;
            Object[] resizedData = new Object[newCapacity];
            for (int i = 0; i < this.size; i++) {
                resizedData[i] = this.internalArray[i];
            }
            this.internalArray = resizedData;
            this.capacity = newCapacity;
        }

        @Override
        public void add(T value) {
            if (capacity == size) {
                resize();
            }
            internalArray[size] = value;
            size++;
        }

        @Override
        public void remove(int index) {
            if (index != this.size) {
                shiftDownToIndex(index);
            }
            this.internalArray[this.size] = null;
            size--;
        }

        /*public void remove(int index) {
            if (index != this.size) {
                shiftDownToIndex(index);
            }
            this.internalArray[this.size] = null;
            size--;
        }

         */

        private void shiftDownToIndex(int index) {
            for (int i = index; i < this.size; i++) {
                internalArray[i] = internalArray[i + 1];
            }

        }

        @Override
        public void set(int index, T value) {
            this.internalArray[index] = value;
        }

        /*public boolean contains(T value) {
            for (int i = 0; i <= this.size; i++) {
                T currentValue = (T) internalArray[i];
                if (currentValue != null && currentValue.equals(value)) {
                    return true;
                }
            }
            return false;
        }

         */
    }
