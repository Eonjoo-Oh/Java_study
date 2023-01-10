package circleTest;

/**
 * @author Eonjoo Oh (eonjoo29@hanmail.net)
 */

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("반지름을 입력하세요 : ");
        while (!sc.hasNextFloat()) {
            sc.next();
            System.err.print("잘못된 입력값입니다. 다시 입력해주세요 : ");
        }
        float radius = sc.nextFloat();
        float circum, area;
        float PI=3.141592f;
        circum = radius * 2 * PI;
        area = radius * radius * PI;
        System.out.println("반지름이 "+radius+"인 원의 둘레:"+circum+", 면적: "+area+"입니다.");
    }
}
