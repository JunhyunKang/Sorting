import java.util.Random;

public class Merge {
    private int[] sortedArray;

    Merge(int[] array){
        this.sortedArray = array;
    }
    void mergeSort(int first, int n){
        //mergeSort: 배열을 절반으로 나누고 나누는 재귀함수를 한 후,
        //merge함수를 호출해 정렬함.
        //first: 정렬할 배열의 첫 index
        //n: 배열 개수
        int n1, n2;
        if(n>1)
        {
            n1=n/2;
            n2=n-n1;
            mergeSort(first, n1);
            mergeSort(first+n1, n2);
            merge(first, n1, n2);
        }
    }

    private void merge(int first, int n1, int n2) {
        //merge: 분리된 배열들을 요소들이 오름차순이 되게 병합시킨다.
        //first: 정렬할 배열의 첫 index
        //n1: 첫번째 배열의 개수
        //n2: 두번째 배열의 개수
        //tempArray[]: 병합한 배열을 넣을 곳
        // tempArray는 마지막에 sortedArray에 다시 붙인다.
        int[] tempArray = new int[n1 + n2];
        int mergeTemp = 0;
        int mergeArray1 = 0;
        int mergeArray2 = 0;
        while ((mergeArray1 < n1) && (mergeArray2 < n2))
        {
            if (this.sortedArray[first + mergeArray1] < this.sortedArray[first + n1 + mergeArray2])
                tempArray[mergeTemp++] = this.sortedArray[first + (mergeArray1++)];
            else
                tempArray[mergeTemp++] = this.sortedArray[first + n1 + (mergeArray2++)];
        }

        while(mergeArray1 < n1)
            tempArray[mergeTemp++] = this.sortedArray[first + (mergeArray1++)];

        while(mergeArray2 < n2)
            tempArray[mergeTemp++] = this.sortedArray[first + n1 + (mergeArray2++)];
        for(int i = 0; i < n1+n2; i++)
            this.sortedArray[first + i] = tempArray[i];
        arrayPrint();
    }



        void arrayPrint(){
        //배열의 요소를 모두 출력하는 함수
        for(int i = 0;i<this.sortedArray.length;i++){
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
        Merge sort = new Merge(array);
        sort.arrayPrint();
        sort.mergeSort(0,32);
    }
}
