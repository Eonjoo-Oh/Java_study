package gradeConverter;

/**
 * @author Eonjoo Oh (eonjoo29@hanmail.net)
 */
import java.util.Scanner;

public class GradeConverter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("점수를 입력하시오 : ");
        while(!sc.hasNextInt())
        {
            sc.next();
            System.err.print("잘못된 입력값입니다. 다시 입력해주세요:");
        }
        char credit;
        int score = sc.nextInt() / 10;
        if (score >= 0 && score <= 10) {
            if (score == 10 || score == 9)
                credit = 'A';
            else if (score == 8)
                credit = 'B';
            else if (score == 7)
                credit = 'C';
            else if (score == 6)
                credit = 'D';
            else
                credit = 'F';
            System.out.println("학점은 " + credit + "입니다");
        }
        else
            System.out.println("시험점수가 잘못 입력되었습니다.");
    }

}
