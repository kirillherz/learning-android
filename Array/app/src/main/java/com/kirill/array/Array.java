package com.kirill.array;

public class Array<T> {

    private int _memorySize;
    private int _size;
    private Object[] _array;
    private double _expansionFactor;
    private boolean _autoResize;

    public Array() {
        this._size = 0;
        this._memorySize = 10;
        this._expansionFactor = 1.5;
        this._array = new Object[this._memorySize];
    }

    public int getSize() {
        return this._size;
    }

    public int getMemorySize() {
        return this._memorySize;
    }

    public void resizeMemory(int memorySize) {
        if (memorySize < this._size) {
            throw new RuntimeException("Memory Error");
        }
        this._memorySize = memorySize;
        Object[] newArray = new Object[this._memorySize];
        for (int i = 0; i != this._size; i++) {
            newArray[i] = this._array[i];
        }
        this._array = newArray;
    }

    public void add(int index, T value) throws ArrayIndexOutOfBoundsException {
        if (index >= this._memorySize) {
            this.resizeMemory((int) (this._memorySize * this._expansionFactor));
        }
        if (index > this._size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this._array[index] = value;
        if (index >= this._size) {
            this._size += 1;
        }
    }

    public T delete(int index) throws ArrayIndexOutOfBoundsException{
        T item;
        if ((index >= this._size) || (index < 0)) {
            throw new ArrayIndexOutOfBoundsException();
        }else{
            item = (T) this._array[index];
        }
        if ((index == 0) && (this._size == 1)) {
            this._size = 0;
        } else {
            for (int i = index; i != this._size - 1; i++) {
                this._array[i] = this._array[i + 1];
            }
            this._size -= 1;
        }
        return item;
    }

    public T get(int index) {
        T item;
        if ((index >= this._size) || (index < 0)) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            item = (T) this._array[index];
        }
        return item;
    }
}