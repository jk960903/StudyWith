package Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        System.out.print("입력 받을 회원 수를 입력하세요 : ");
        int memberCount = Integer.parseInt(br1.readLine());

        GeneralMember[] generalMember = new GeneralMember[memberCount];

        for (int i = 0; i < memberCount; i++) generalMember[i] = new GeneralMember();
        for (int i = 0; i < memberCount; i++) generalMember[i].printAll();
    }
}
