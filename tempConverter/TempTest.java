package tempConverter;

/**
 * @author Eonjoo Oh (eonjoo29@hanmail.net)
 */
import java.util.Scanner;

public class TempTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("온도를 입력하세요 : ");
        while (!sc.hasNextFloat()) {
            sc.next();
            System.err.print("잘못된 값입니다. 다시 입력해주세요 : ");
        }
        float fahrenheit = sc.nextFloat();

        int BASE=32;
        float celsius=0f;

        celsius=(fahrenheit-BASE)* 5.0f / 9.0f;
        System.out.println("화씨 "+fahrenheit+" ,도에서 섭씨온도는 : "+celsius+"도 입니다.");

        fahrenheit=celsius * 9.0f / 5.0f + BASE;
        System.out.println("섭씨: "+celsius+"도에 대한 화씨온도는 : "+fahrenheit+"도 입니다.");
    }
}
