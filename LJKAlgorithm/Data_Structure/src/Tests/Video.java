package Tests;

import java.io.*;

public class Video {
    //���� ��ȣ, ����, �ֿ� ���
    private int videoNumber;
    private String title;
    private String mainActor;

    //Default Constructor
    public Video() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("ȸ���� �뿩�� ���� ��ȣ : "); this.videoNumber = Integer.parseInt(br.readLine());
        System.out.print("ȸ���� �뿩�� ���� ���� : "); this.title = br.readLine();
        System.out.print("ȸ���� �뿩�� ���� ���ΰ� : "); this.mainActor = br.readLine();
        System.out.println();
        br.close();
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getMainActor() {
        return mainActor;
    }

    public int getVideoNumber() {
        return videoNumber;
    }
}
