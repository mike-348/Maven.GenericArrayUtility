package com.zipcodewilmington.arrayutility;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    protected List<T> inputArray;
    public ArrayUtility(T[] inputArray) {
        this.inputArray = new CopyOnWriteArrayList<>(Arrays.asList(inputArray));
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (T element : inputArray) {
            if (element == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        inputArray.addAll(Arrays.asList(arrayToMerge));
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        inputArray.addAll(Arrays.asList(arrayToMerge));
        List<Integer> freq = new ArrayList<>();
        for (T element : inputArray) {
            freq.add(getNumberOfOccurrences(element));
        }
        int indexOfMostCommon = freq.indexOf(Collections.max(freq));
        return inputArray.get(indexOfMostCommon);
    }

    public T[] removeValue(T valueToRemove) {
        for (T element : inputArray) {
            if (element == valueToRemove) {
                inputArray.remove(element);
            }
        }
        if (valueToRemove instanceof Integer) {
            return (T[]) inputArray.toArray(new Integer[0]);
        } else if (valueToRemove instanceof String) {
            return (T[]) inputArray.toArray(new String[0]);
        } else {
            return (T[]) inputArray.toArray(new Long[0]);
        }
    }

}
