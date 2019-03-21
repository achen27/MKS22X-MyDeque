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

  public void addFirst(E element){
    if (start == 0){
      start = data.length-1;
    }
    data[start] = element;
    size++;
  }

  public void addLast(E element){
    if (end == data.length-1){
      end = 0;
    }
    data[end] = element;
    size++;
  }

  public E removeFirst(){
    E output = data[start];
    data[start] = null;
    if (start == data.length-1){
      start = 0;
    }else{
      start--;
    }
    size--;
    return output;
  }

  public E removeLast(){
    E output = data[end];
    data[end] = null;
    if (end == 0){
      end = data.length-1;
    }else{
      start--;
    }
    size--;
    return output;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

}
