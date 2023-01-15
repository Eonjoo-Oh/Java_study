package commonDivisiorFinder;

/**
 * @author Eonjoo Oh (eonjoo29@hanmail.net)
 */
import java.util.Scanner;

public class CommonDivisorFinder {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a, b;
        int i = 1;
        System.out.println("첫 번째 수를 입력하세요");
        a = sc.nextInt();
        System.out.println("두 번째 수를 입력하세요");
        b = sc.nextInt();
        System.out.print(a + " 와" + b + " 의 공배수는 ");
        while (i <= a && i <= b)
        {
            if (a % i == 0 && b % i == 0)
                System.out.print(i + " ");
            i++;
        }
        System.out.println("입니다.");
    }
}
