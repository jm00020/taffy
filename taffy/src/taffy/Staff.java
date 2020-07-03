package taffy;

import java.lang.Runnable;

public class Staff implements Runnable {
	boolean Working; //일하는 중인지 유무
	int ServicesTime; //서비스 시간
	int StaffStartTime; //시작 서비스 시간(시간이 지남에 따라 증가)

	Staff(){
		Working = false;
		ServicesTime = 0;
		StaffStartTime = 0;
	}
	void SetStaff(int time){ //일하는 중이라고 변경, 손님에게 서비스 시간을 받아옴
		this.Working = true; //일하는 중이면 true
		this.ServicesTime = time; //손님에게 서비스시간을 받아 입력
	}
	void StopStaff(){ //일이 끝나 초기화
		this.Working = false; //쉬는 중 false
		this.StaffStartTime = 0; //각 시간 0으로 초기화
		this.ServicesTime = 0;
	}
	public void run(){
		while(true){
			if(StaffStartTime == ServicesTime){ //서비스시간과 서비스 실행시간이 같으면 초기화
				StopStaff();
				return;
			}
			try{
				Thread.sleep(1000/Taffy.speed);
			}
			catch(InterruptedException e){
				StopStaff();
				return;
			}
			StaffStartTime++;
		}
	}
}

