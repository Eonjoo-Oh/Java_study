package landOwnershipTaxCalculator;

/**
 * @author Eonjoo Oh (eonjoo29@hanmail.net)
 */

import java.util.Scanner;

public class LandTaxCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int taxRate;
        float tax;
        float areaTax;
        System.out.print("토지 면적을 입력하세요 : ");
        int area = sc.nextInt();
        System.out.print("토지 소유 기간을 입력하세요 : ");
        int year = sc.nextInt();
        System.out.print("토지에 건물 보유 여부를 입력하세요. (건물이 없으면 0, 있으면 1을 입력) :");
        int building = sc.nextInt();
        if (building == 0) {
            if (area <= 1000)
                taxRate = 1800;
            else if (area <= 2500)
                taxRate = 2000;
            else
                taxRate = 3000;
            areaTax = taxRate * area;
            if (year < 3)
                taxRate = 0;
            else if (year < 13)
                taxRate = year - 2;
            else
                taxRate = 10;
            tax = areaTax - areaTax * 0.05f * taxRate;
        }
        else {
            if (area <= 1000)
                taxRate = 3600;
            else if (area <= 2500)
                taxRate = 4000;
            else
                taxRate = 6000;
            areaTax = taxRate * area;
            if (year < 3)
                taxRate = 0;
            else if (year < 13)
                taxRate = year - 2;
            else
                taxRate = 10;
            tax = areaTax - areaTax * 0.05f * taxRate;
        }
        tax = tax + 0.03f * areaTax;

        System.out.printf("토지 보유세금액은 %5.1f원 입니다.", tax);
        // 5.1f는 전체 5자리 + 좌측공백 + 소수 1자리
    }
}

