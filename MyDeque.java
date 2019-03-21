public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String output = "{";
    for (int i = start; i != end; i++){
      if (i == data.length){
        i = 0;
      }
      output += data[i]+" ";
    }
    output += "}";
    return output;
  }

  public void addFirst(E element){ }

  public void addLast(E element){ }

  public E removeFirst(){ }

  public E removeLast(){ }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

}
