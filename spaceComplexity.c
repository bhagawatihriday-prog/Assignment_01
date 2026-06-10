#include <stdio.h>
#include <stdlib.h>

void constantSpace() {
    printf("\nO(1) Space Complexity");
    printf("\nOperation: Using a single variable");

    int x = 10;
    printf("\nOperations = 1");
    printf("\nMemory Used = %lu bytes\n", sizeof(x));
}

void linearSpace(int n) {
    printf("\nO(n) Space Complexity");
    printf("\nOperation: Creating 1D array");

    int *arr = (int*)malloc(n * sizeof(int));

    printf("\nOperations = %d", n);
    printf("\nMemory Used = %lu bytes\n", n * sizeof(int));

    free(arr);
}

void quadraticSpace(int n) {
    printf("\nO(n^2) Space Complexity");
    printf("\nOperation: Creating 2D array");

    int **arr = (int**)malloc(n * sizeof(int*));
    for(int i = 0; i < n; i++)
        arr[i] = (int*)malloc(n * sizeof(int));

    printf("\nOperations = %d", n*n);
    printf("\nMemory Used = %lu bytes\n", (unsigned long)n*n*sizeof(int));

    for(int i = 0; i < n; i++)
        free(arr[i]);
    free(arr);
}

int main() {
    int n;
    printf("Enter input size n: ");
    scanf("%d", &n);

    constantSpace();
    linearSpace(n);
    quadraticSpace(n);

    return 0;
}