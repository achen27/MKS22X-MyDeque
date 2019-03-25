import java.util.*;

public class MyDeque<E>{
  private E[] data;
  public int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] newData = (E[])new Object[size*2];
    int idx = 0;
    //System.out.println("S "+start);
    //System.out.println("E "+end);
    /*for (int i = start; i != end; i++){
      System.out.println(i != end);
      System.out.println("I "+i);
      System.out.println("E "+end);
      System.out.println("data: "+ Arrays.toString(newData));
      if (i == data.length){
        i = 0;
      }
      //System.out.println("I "+i);
      newData[idx] = data[i];
      idx++;
    }
    //newData[idx] = data[end];*/
    if (end > start){
      for (int i = start; i <= end; i++){
        //System.out.println("data[i]1 "+ data[i]);
        newData[idx] = data[i];
        idx++;
      }
    }else if (end < start){
      for (int i = start; i < data.length; i++){
        //System.out.println("data[i]2 "+ data[i]);
        newData[idx] = data[i];
        idx++;
      }
      for (int i = 0; i <= end; i++){
        //System.out.println("data[i]3 "+ data[i]);
        newData[idx] = data[i];
        idx++;
      }
    }
    start = 0;
    end = size - 1;
    data = newData;
  }

  public String toString(){
    String output = "{";
    //System.out.println("start: "+start+" end: "+end);
    if (size != 0){
      if (end > start || size == 1){
        for (int i = start; i <= end; i++){
          //System.out.println("data[i]1 "+ data[i]);
          output += data[i] + " ";
        }
      }
      if (end < start){
        for (int i = start; i < data.length; i++){
          //System.out.println("data[i]2 "+ data[i]);
          output += data[i] + " ";
        }
        for (int i = 0; i <= end; i++){
          //System.out.println("data[i]3 "+ data[i]);
          output += data[i] + " ";
        }
      }
    }
    output += "}";
    //System.out.println(toStringDebug());
    return output;
  }

  public String toStringDebug(){
    String output = "{";
    for (int i = 0; i < data.length; i++){
      output += data[i] + " ";
    }
    output += "}";
    return output;
  }

  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException("Element is Null");
    }
    if (size == 0){
      data[start] = element;
      //System.out.println(data[end]);
    } else {
      if (size == data.length){
        resize();
      }
      if (start == 0){
        start = data.length-1;
      } else {
        start--;
      }
      data[start] = element;
    }
    size++;
  }

  public void addLast(E element){
    if (element == null){
      throw new NullPointerException("Element is Null");
    }
    if (size == 0){
      data[end] = element;
      //System.out.println(data[end]);
    } else {
      if (size == data.length){
        resize();
      }
      if (end == data.length-1){
        end = 0;
      } else {
        end++;
      }
      data[end] = element;
    }
    size++;
  }

  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    E output = data[start];
    data[start] = null;
    if (start == data.length-1){
      //System.out.println(toString());
      //System.out.println("last");
      start = 0;
    }else{
      start++;
    }
    size--;
    return output;
  }

  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    E output = data[end];
    data[end] = null;
    if (end == 0){
      end = data.length-1;
    }else{
      end--;
    }
    size--;
    return output;
  }

  public E getFirst(){
    if (size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    return data[start];
  }

  public E getLast(){
    if (size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    return data[end];
  }

  public static void main(String[] args){
    MyDeque<Integer> d = new MyDeque<Integer>();
    //System.out.println(d.toString());
    for(int i =0; i < 21; i++){
      d.addFirst(i);
      System.out.println("S: "+d.start);
      System.out.println("E: "+d.end);
      System.out.println("Debug: " +d.toStringDebug());
      System.out.println(d.toString());
    }
    //d.addFirst(0);
    //System.out.println(d.toString());
    System.out.println(d.toStringDebug());

    //System.out.println(d.toString());
    //d.addFirst("hello");
    //System.out.println(d.toStringDebug());
  }

}
