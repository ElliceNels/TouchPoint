
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

        /*@Override
        public void remove(int index) {
            if (index != this.size) {
                shiftDownToIndex(index);
            }
            this.internalArray[this.size] = null;
            size--;
        }

         */

        @Override
        public int indexOf(Object value) {
            if (value == null) {
                for (int i = 0; i < size(); i++) {
                    if (get(i) == null) {
                        return i;
                    }
                }
            } else {
                for (int i = 0; i < size(); i++) {
                    if (value.equals(get(i))) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public void remove(T value) {
            int index = indexOf(value);
            if (index >= 0 && index < this.size) {
                shiftDownToIndex(index);
                this.internalArray[this.size - 1] = null;
                size--;
            }
        }



        private void shiftDownToIndex(int index) {
            if (index >= 0 && index < this.size - 1) {
                for (int i = index; i < this.size - 1; i++) {
                    internalArray[i] = internalArray[i + 1];
                }
            }
        }

        @Override
        public void set(int index, T value) {
            this.internalArray[index] = value;
        }

        public boolean contains(T value) {
            for (int i = 0; i < this.size; i++) {
                T currentValue = (T) internalArray[i];
                if (currentValue != null && currentValue.equals(value)) {
                    return true;
                }
            }
            return false;
        }


    }
