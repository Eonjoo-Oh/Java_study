package aliquotFinder;

/**
 * @author Eonjoo Oh (eonjoo29@hanmail.net)
 */

import java.util.Scanner;

public class AliquotFinder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num;
        int i = 1;
        System.out.print("수를 입력하세요 : ");
        num = sc.nextInt();
        System.out.print(num + "의 약수는 ");
        while (i <= num)
        {
            if (num % i == 0)
                System.out.print(i + " ");
            i++;
        }
        System.out.print("입니다.");
    }
}
