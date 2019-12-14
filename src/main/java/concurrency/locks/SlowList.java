package concurrency.locks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.UnaryOperator;

public class SlowList implements List<String> {

  private final List<String> values = new ArrayList<>();
  private Lock lock = new ReentrantLock(true);

  public List<String> getValues() {
    return values;
  }

  public boolean add(String value) {
    try {
      lock.lock();
      values.add(value);
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return false;
    } finally {
      lock.unlock();
    }
    return true;
  }

  @Override
  public String toString() {
    return values.toString();
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public void replaceAll(UnaryOperator<String> operator) {

  }

  @Override
  public void sort(Comparator<? super String> c) {

  }

  @Override
  public boolean addAll(Collection c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection c) {
    return false;
  }

  @Override
  public void clear() {

  }

  @Override
  public String get(int index) {
    return null;
  }

  @Override
  public String set(int index, String element) {
    return null;
  }

  @Override
  public void add(int index, String element) {

  }

  @Override
  public String remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator listIterator() {
    return null;
  }

  @Override
  public ListIterator listIterator(int index) {
    return null;
  }

  @Override
  public List subList(int fromIndex, int toIndex) {
    return null;
  }

  @Override
  public Spliterator<String> spliterator() {
    return null;
  }

  @Override
  public boolean retainAll(Collection c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection c) {
    return false;
  }

  @Override
  public boolean containsAll(Collection c) {
    return false;
  }

  @Override
  public Object[] toArray(Object[] a) {
    return new Object[0];
  }
}
