package com.endava.homework.collections;

import com.endava.homework.model.Student;

import java.io.Serializable;
import java.util.*;




public class StudentTreeSet implements Set<Student>, Cloneable, Serializable,  NavigableSet<Student> {


    private transient NavigableMap<Student,Object> m;

    private static final Student PRESENT = new Student();

    StudentTreeSet(NavigableMap<Student,Object> m) {
        this.m = m;
    }

    public StudentTreeSet() {
        this(new TreeMap<Student,Object>());
    }

    public StudentTreeSet(Comparator<? super Student> comparator) {
        this(new TreeMap<>(comparator));
    }

    public StudentTreeSet(Collection<? extends Student> c) {
        this();
        addAll(c);
    }

    public StudentTreeSet(SortedSet<Student> s) {
        this(s.comparator());
        addAll(s);
    }


    @Override
    public int size() {
        return m.size();
    }

    @Override
    public boolean isEmpty() {
        return m.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return m.containsKey(o);
    }

    @Override
    public Student lower(Student student) {
        return m.lowerKey(student);
    }

    @Override
    public Student floor(Student student) {
        return m.floorKey(student);
    }

    @Override
    public Student ceiling(Student student) {
        return m.ceilingKey(student);
    }

    @Override
    public Student higher(Student student) {
        return m.higherKey(student);
    }

    @Override
    public Student pollFirst() {
        Map.Entry<Student,?> e = m.pollFirstEntry();
        return (e == null) ? null : e.getKey();
    }

    @Override
    public Student pollLast() {
        Map.Entry<Student,?> e = m.pollLastEntry();
        return (e == null) ? null : e.getKey();
    }

    @Override
    public Iterator<Student> iterator() {
        return m.navigableKeySet().iterator();
    }

    @Override
    public NavigableSet<Student> descendingSet() {
        return new StudentTreeSet(m.descendingMap());
    }

    @Override
    public Iterator<Student> descendingIterator() {
        return m.descendingKeySet().iterator();
    }

    @Override
    public NavigableSet<Student> subSet(Student fromElement, boolean fromInclusive, Student toElement, boolean toInclusive) {
        return new StudentTreeSet(m.subMap(fromElement, fromInclusive,
                toElement,   toInclusive));
    }

    @Override
    public NavigableSet<Student> headSet(Student toElement, boolean inclusive) {
        return new StudentTreeSet(m.headMap(toElement, inclusive));
    }

    @Override
    public NavigableSet<Student> tailSet(Student fromElement, boolean inclusive) {
        return new StudentTreeSet(m.tailMap(fromElement, inclusive));
    }

    @Override
    public Comparator<? super Student> comparator() {
        return m.comparator();
    }

    @Override
    public SortedSet<Student> subSet(Student fromElement, Student toElement) {
        return new StudentTreeSet(m.subMap(fromElement, true,
                toElement,   true  ));
    }

    @Override
    public SortedSet<Student> headSet(Student toElement) {
        return headSet(toElement, false);
    }

    @Override
    public SortedSet<Student> tailSet(Student fromElement) {
        return new StudentTreeSet(m.tailMap(fromElement, true));
    }

    @Override
    public Student first() {
        return m.firstKey();
    }

    @Override
    public Student last() {
        return m.lastKey();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean add(Student student) {
        return m.put(student, PRESENT)==null;
    }

    @Override
    public boolean remove(Object o) {
        return m.remove(o)==PRESENT;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Student> c) {
//        // Use linear-time version if applicable
//        if (m.size()==0 && c.size() > 0 &&
//                c instanceof SortedSet &&
//                m instanceof TreeMap) {
//            SortedSet<? extends Student> set = (SortedSet<? extends Student>) c;
//            TreeMap<Student,Object> map = (TreeMap<Student, Object>) m;
//            Comparator<?> cc = set.comparator();
//            Comparator<? super Student> mc = map.comparator();
//            if (Objects.equals(cc, mc)) {
//                map.addAllForTreeSet(set, PRESENT);
//                return true;
//            }
//        }
//        return super.addAll(c);
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;

        if (size() > c.size()) {
            for (Iterator<?> i = c.iterator(); i.hasNext(); )
                modified |= remove(i.next());
        } else {
            for (Iterator<?> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        m.clear();
    }
}
