public class Stack extends DynamicArray implements Comparable<Stack>, Xifo<String>, Lifo<String> {

    public int compareTo(Stack other) {
        return this.occupancy - other.occupancy; // sees the difference between the two arrays
    } // method compareTo

   public String peek() {
        String result = null;
        if (this.occupancy > 0){
            result = this.underlying[0];
        }
        return result;
        /*
         * sets result to null so that something can be added
         * uses an if statement to see if there is something in the array
         * if there is then it sets what is in the top position to result
         * then returns result
         */
    } // method peek

    public String pop() {
        return this.remove(0); // removes the eleement in the top index
    } // method pop

   public String toString() {
        StringBuilder sb = new StringBuilder("("); // uses string builder to create the start add continue to add to it
        for (int i = 0; i < this.occupancy; i++) { // iterates through the occupancy
            sb.append(":").append(this.underlying[i]); // adds : to differentiate between the occupancy and index and
                                                           //adds the index #
            if (i < this.occupancy -1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    } // method toString

    public void push(String e) {
        if (getOccupancy() == this.underlying.length){
            this.resize(); // if the array is full then resize it
        }
        for (int i = getOccupancy(); i > 0; i--) {
            this.underlying[i] = this.underlying[i-1]; // moves the elements one index to the right,
                                                       // creating an open space in the beginning.

        }
        this.underlying[0] = e; // puts the new element in the beginning
        this.occupancy++; // increases the occupancy count
        // 
    } // method push

} // class Stack