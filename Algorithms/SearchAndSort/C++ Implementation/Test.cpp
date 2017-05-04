/* 
 * File:   Test.cpp
 * Author: Kayhan Dehghani
 *
 * Created on May 3, 2017, 3:35 PM
 */

#include <cstdlib>
#include <cstdio>
#include <iostream>
#include "SearchAndSortAlgorithms.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {

    // Test binary search
    int testArray[5] = {-44, -4, 0, 123, 899};
    int * emptyArray;
   
    if(!SearchAndSortAlgorithms::BinarySearch(testArray, 5,44)
            && !SearchAndSortAlgorithms::BinarySearch(testArray, 5,144)
            && SearchAndSortAlgorithms::BinarySearch(testArray, 5,-44)
            && SearchAndSortAlgorithms::BinarySearch(testArray, 5,123)
            && SearchAndSortAlgorithms::BinarySearch(testArray, 5,899)
            && !SearchAndSortAlgorithms::BinarySearch(emptyArray, 0,899)) {
        cout << "Success: binary search is working successfully." << endl;
    }
    else 
        cout << "Failure: binary search is not working properly!" << endl;

    return 0;
}
