import java.util.Random;

public class Quick {
    private int[] sortedArray;

    Quick(int[] array){
        this.sortedArray = array;
    }

    void quickSort(int first, int n) {
        //quickSort: partition함수를 통해 pivot을 기준으로 pivot보다 작은 수들의 배열, 큰 수들의 배열로 분할하며
        //분할 된 배열을 다시 분할 하도록 재귀함수로 만듦.
        //first: 배열 index의 첫 값
        //n: 배열 요소의 개수
        //n1: pivot보다 작은 배열의 요소의 개수
        //n2: pivot보다 큰 배열의 요소의 개수
        //pivotIndex: pivot의 index
        int n1, n2, pivotIndex;
        if (n > 1) {
            pivotIndex = partition(first, n);
            n1 = pivotIndex - first;
            n2 = n - n1 - 1;
            quickSort(first, n1);
            quickSort(pivotIndex + 1, n2);
        }
    }

    private int partition(int first, int n) {
        //partition: pivot을 기준으로 pivot 보다 큰 수의 배열, 작은 수의 배열로 나눈 후 각 배열을 크기순으로 나열
        //pivot: 배열을 나누는 기준값
        //tooBigIndex: pivot을 제외한 배열의 제일 앞 index
        //tooSmallIndex: 배열의 마지막 index
        int pivot = sortedArray[first];
        int tooBigIndex = first + 1;
        int tooSmallIndex = first + n - 1;

        while (tooBigIndex < tooSmallIndex) {
            while (tooBigIndex < tooSmallIndex && sortedArray[tooBigIndex] <= pivot) {
                tooBigIndex++;
            }
            while (sortedArray[tooSmallIndex] > pivot) {
                tooSmallIndex--;
            }
            if (tooBigIndex < tooSmallIndex) {
                int temp = sortedArray[tooBigIndex];
                sortedArray[tooBigIndex] = sortedArray[tooSmallIndex];
                sortedArray[tooSmallIndex] = temp;
            }
        }
        if(sortedArray[tooSmallIndex]<=pivot) {
            sortedArray[first] = sortedArray[tooSmallIndex];
            sortedArray[tooSmallIndex] = pivot;

        }
        arrayPrint();
        return tooSmallIndex;
    }

    void arrayPrint(){
        // 배열의 모든 요소 출력
        for(int i = 0; i<this.sortedArray.length; i++){
            System.out.print(this.sortedArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // array[]: 0-31까지 순서는 랜덤하게 32개의 정수들로 이뤄진 배열
        // random 32개의 정수의 랜덤한 순서를 만들기 위해
        // 먼저 원본을 보여주고
        // 정렬되는 과정을 보여준다.
        int[] array = new int[32];
        Random random =  new Random();
        for(int i=0;i< array.length;i++)
        {
            array[i]= random.nextInt(32);
            for (int j=0; j<i;j++)
            {
                if(array[i]==array[j])
                {
                    i--;
                    continue;
                }
            }
        }
        Quick sort = new Quick(array);
        sort.arrayPrint();
        sort.quickSort(0,32);

    }
}
