package taffy;

import java.lang.Runnable;

public class Guest{
	static int Count = 0; //서비스받은 손님 수
	int ServicesTime; //서비스 시간
	int ArrivalTime; //도착시간
	int Money; // 지불할 돈
	
	Guest(){
		Count++; //손님이 생성 될 때마다 증가
		ServicesTime = 0;
		ArrivalTime = 0;
		Money = 0;
	}
	
	void SetTime(int stime){ //서비스 시간과 도칙시간 입력
		ArrivalTime = Taffy.StartTime; //도착시간 입력
		ServicesTime = stime; //서비스 시간입력
	}
	
	void SetMoney(int money){ //지불 금액 입력
		Money = money; //지불 금액 입력
	}
}

class CallGuest extends Guest implements Runnable{
	static int CallCount = 0;
	int CallTime = 0;
	int counttime = 0;
	boolean ArrivalGuest;
	
	CallGuest(){
		CallCount++; //전화 손님 수 증가
		ArrivalGuest = false;
	}
	
	void SetCallTime(int time){ //도착까지 걸리는 시간 생성
		CallTime = time; //도착까지 걸리는 시간 생성
	}
	
	public void run() {
		while(true){
			if(counttime == CallTime){ //도착하였는지 체크 후 도착하였다고 나타냄
				ArrivalGuest = true; //도착시 true로 변환
				return;
			}
			try{
				Thread.sleep(1000/Taffy.speed);
			}
			catch(InterruptedException e){
				return;
			}
			counttime++;
		}
	}
}
