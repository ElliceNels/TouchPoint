public interface List<T> {

        boolean isEmpty(); //checks if list is empty

        int size();

        T get(int index); //get data from particular location

        void add(T value);

        void remove(int index);

        void set(int index, T value);

        boolean contains(T value);

    }


