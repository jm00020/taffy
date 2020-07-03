package taffy;

import java.awt.EventQueue;

public class Taffy  {
	static int PlayTime = 0; //시뮬레이션 시간
	static int DeskNum = 0; //창구 수
	static int StartTime = 0; //첫 시작부터 시간 카운터
	static int GuestNum = 0; //대기손님 수
	static int CallGuestNum = 0; //전화손님 수
	static int speed = 1; //시물레이션 배속
	static final int MAXGUEST = 100; //대기손님 최대수
	
	Taffy(){
	}

	public static void main(String [] args){ //GUI실행
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}