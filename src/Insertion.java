import java.util.Random;

public class Insertion {
    //sortedArray: insertion sorting을 진행할 배열
    private int[] sortedArray;

    Insertion(int[] sortedArray){
        this.sortedArray = sortedArray;
    }

    void insertionSort(){
        //insertionSort: insertion sorting 을 진행하는 함수
        //for 반복을 이용해 배열을 정렬한다.
        //현재 정렬할 숫자를 택하고 앞에 정렬된 배열의 값들과 비교를 진행하며
        // 본인보다 큰 숫자 앞에서 삽입히고, 나머지 정렬된 배열요소들은 한 칸 씩 미뤄준다.
        //
        //temp: 정렬될 차례의 숫자
        //fianlIndex: 정렬된 배열까지의 index

        for(int i = 1; i<this.sortedArray.length; i++)
        {
            int temp = this.sortedArray[i];
            int finalIndex;
            for(finalIndex=i-1; finalIndex>=0 && this.sortedArray[finalIndex] > temp; finalIndex--)
                this.sortedArray[finalIndex+1] = this.sortedArray[finalIndex];
            this.sortedArray[finalIndex+1] = temp;
            arrayPrint();
        }
    }

    void arrayPrint(){
        //배열의 요소를 모두 출력하는 함수
        for(int i = 0; i<this.sortedArray.length; i++)
            System.out.print(this.sortedArray[i] + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        // array[]: 0-31까지 순서는 랜덤하게 32개의 정수들로 이뤄진 배열
        // random 32개의 정수의 랜덤한 순서를 만들기 위해
        //먼저 원본 배열을 보여주고
        //정렬되는 과정을 보여준다.
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
        Insertion sort = new Insertion(array);
        sort.arrayPrint();
        sort.insertionSort();
    }
}


