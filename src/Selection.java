import java.util.Random;

public class Selection {
    //sortedArray: selection sorting을 진행할 배열
    private int[] sortedArray;

    Selection(int[] array){
        this.sortedArray = array;
    }

    void selectionSort(){
        //selectionSort: selection sorting 을 진행하는 함수
        //for 반복을 이용해 배열을 정렬한다.
        //정렬이 안된 배열 중 가장 큰 값을 찾아 정렬된 배열의 제일 앞으로 보낸다.
        //
        //temp: 정렬될 차례의 숫자
        //bigIndex: 정렬 안된 배열 중 가장 큰 값이 있는 index
        int bigIndex, temp;
        for(int i = this.sortedArray.length-1; i>=0 ; i--)
        {
            bigIndex = i;
            for(int j = i-1; j>=0; j--)
            {
                if(this.sortedArray[j]>this.sortedArray[bigIndex])
                    bigIndex=j;
            }
            temp = this.sortedArray[bigIndex];
            this.sortedArray[bigIndex]=this.sortedArray[i];
            this.sortedArray[i]=temp;
            arrayPrint();
        }
    }

    void arrayPrint(){
        //arrayPrint: 배열의 요소를 모두 출력
        for(int i = 0; i<this.sortedArray.length; i++)
            System.out.print(this.sortedArray[i] + "\t");

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
        Selection sort = new Selection(array);
        sort.arrayPrint();
        sort.selectionSort();
    }
}
