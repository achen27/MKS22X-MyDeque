import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){ //constructor
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }

  public MyDeque(int initialCapacity){ //constructor with starting capacity
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }

  public int size(){ //returns size of deque
    return size;
  }

  private void resize(){ //doubles capcity of array
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
    if (end > start){ //one loop if end is after start
      for (int i = start; i <= end; i++){
        //System.out.println("data[i]1 "+ data[i]);
        newData[idx] = data[i];
        idx++;
      }
    } else if (end < start){ //two loops is end is before start
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
    start = 0; //change instance variables
    end = size - 1;
    data = newData;
  }

  public String toString(){
    String output = "{";
    //System.out.println("start: "+start+" end: "+end);
    if (size != 0){ //one loop if end is after start
      if (end > start || size == 1){
        for (int i = start; i <= end; i++){
          //System.out.println("data[i]1 "+ data[i]);
          output += data[i] + " ";
        }
      }
      if (end < start){ //two loops is end is before start
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

  private String toStringDebug(){ //prints entire array with nulls
    String output = "{";
    for (int i = 0; i < data.length; i++){
      output += data[i] + " ";
    }
    output += "}";
    return output;
  }

  public void addFirst(E element){ //adds element to front
    if (element == null){
      throw new NullPointerException("Element is Null");
    }
    if (size == 0){
      data[start] = element;
      end  = start;
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

  public void addLast(E element){ //adds element to end
    if (element == null){
      throw new NullPointerException("Element is Null");
    }
    //System.out.println("Size:"+size);
    if (size == 0){
      data[end] = element;
      start = end;
      //System.out.println(data[end]);
    } else {
      if (size == data.length){
        resize();
      }
      if (end == data.length-1){
        //System.out.println("!!");
        end = 0;
      } else {
        //System.out.println("end++");
        end++;
      }
      data[end] = element;
    }
    size++;
  }

  public E removeFirst(){ //removes element from front
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

  public E removeLast(){ //removes element from end
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

  public E getFirst(){ //returns first element without removing
    if (size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    return data[start];
  }

  public E getLast(){ //returns last element without removing
    if (size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    return data[end];
  }

  public static void main(String[] args){
    MyDeque<Integer> d = new MyDeque<Integer>();
    //System.out.println(d.toString());
    /*for(int i =0; i < 21; i++){
      d.addFirst(i);
      System.out.println("S: "+d.start);
      System.out.println("E: "+d.end);
      System.out.println("Debug: " +d.toStringDebug());
      System.out.println(d.toString());
    }*/
    d.addLast(1);
    d.addLast(1);
    d.addLast(1);
    d.addLast(1);
    d.addLast(1);
    d.addLast(1);
    d.addLast(1);
    d.addLast(1);
    d.addLast(1);
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    d.removeFirst();
    System.out.println("Size: "+d.size);
    System.out.println(d.toStringDebug());
    System.out.println("S: "+d.start);
    System.out.println("E: "+d.end);
    System.out.println("addLast");
    d.addLast(1);
    System.out.println("S: "+d.start);
    System.out.println("E: "+d.end);
    //d.addFirst(0);
    System.out.println(d.toString());
    System.out.println(d.toStringDebug());

    //System.out.println(d.toString());
    //d.addFirst("hello");
    //System.out.println(d.toStringDebug());
  }

}
