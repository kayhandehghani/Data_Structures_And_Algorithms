/* 
 * File:   SearchAndSortAlgorithms.cpp
 * Author: Kayhan Dehghani
 * 
 * Created on May 3, 2017, 3:12 PM
 */

#include <cstddef>
#include <iostream>
#include "SearchAndSortAlgorithms.h"

SearchAndSortAlgorithms::SearchAndSortAlgorithms() {
}

SearchAndSortAlgorithms::SearchAndSortAlgorithms(const SearchAndSortAlgorithms& orig) {
}

SearchAndSortAlgorithms::~SearchAndSortAlgorithms() {
}

using namespace std;

/*
* ============================================================ 
* Iterative binary search algorithm for an array of integers 
* Pre: <array> is sorted in ascending order 
* Post: returns true only if <array> contains <value>
* ============================================================
 */
bool SearchAndSortAlgorithms::BinarySearch(int * array, int length, int value) {
    if( length > 0 ) {
        int left = 0; // initialize left index
        int right = length - 1; //initialize right index
        int middle; // middle index
        
        while(right >= left) {
            middle = (left + right) / 2;

            if(value > *(array + middle) )
                left = middle + 1; // search the upper sub array
            else if (value < *(array + middle))
                right = middle - 1; // search the lower sub array
            else 
                return true; // array[midIndx] is equal to value 
        }
    }
    else 
        return false;
}

