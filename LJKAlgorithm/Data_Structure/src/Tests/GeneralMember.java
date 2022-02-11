package Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class GeneralMember {
    //ȸ�� ���̵�, ȸ�� �̸�, ȸ�� �ּ�
    private String memberId;
    private String memberName;
    private String memberAddress;
    private Video video;

    //Default Constructor
    public GeneralMember() throws IOException {
    	BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("ȸ���� ���̵� : "); this.memberId = br2.readLine();
        System.out.print("ȸ���� �̸� : "); this.memberName = br2.readLine();
        System.out.print("ȸ���� �ּ� : "); this.memberAddress = br2.readLine();
        br2.close();
        this.video = new Video();
    }

    //getters
    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public Video getVideo() {
        return video;
    }

    //��� �޼���
    public void printAll() {
        System.out.println("ȸ���� ���̵� : " + getMemberId());
        System.out.println("ȸ���� �̸� : " + getMemberName());
        System.out.println("ȸ���� �ּ� : " + getMemberAddress());
        System.out.println("ȸ���� �뿩�� ���� ��ȣ : " +  getVideo().getVideoNumber());
        System.out.println("ȸ���� �뿩�� ���� ���� : " +  getVideo().getTitle());
        System.out.println("ȸ���� �뿩�� ���� ���ΰ� : " + getVideo().getMainActor());
        System.out.println();
    }
}