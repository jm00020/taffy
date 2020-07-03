package taffy;

public class Check {
	int TNum; //서비스 시간 난수
	int money; //지불 금액 난수
	static Thread [] stf = new Thread[Taffy.DeskNum]; //스태프 서비스시작을 위한 쓰레드
	static Thread [] cguest  = new Thread[Taffy.MAXGUEST]; //전화 손님 도착을 위한 쓰레드
	Check(){
		TNum = 0;
		money = 0;
	}
	boolean SetGuest(){ //손님 등장 난수 발생
		int Guestcheck;
		Guestcheck = (int)(Math.random()*4+1); //1~4의 난수 발생
		if(Guestcheck == 4) //4이면 손님 생성
			return true;
		else
			return false;
	}
	boolean SetCallGuest(){ //전화 손님 등장 난수 발생
		int CallGuestcheck;
		CallGuestcheck = (int)(Math.random()*10+1); //1~10의 난수 발생
		if(CallGuestcheck == 10) //10이면 전화 손님 생성
			return true;
		else 
			return false;
	}
	void AddGuest(){ //손님을 대기손님배열에 대입
		if(SetGuest()){
			if(Taffy.GuestNum == Taffy.MAXGUEST) //최대 손님 수를 초과하였는지 확인 후 초과할 경우 리턴
				return;
			Services.guest[Taffy.GuestNum] = new Guest(); //최기화
			Services.guest[Taffy.GuestNum].SetTime(SetTime()); //서비스 시간 난수 발생
			Services.guest[Taffy.GuestNum].SetMoney(SetMoney()); //지불 금액 난수 발생
			Taffy.GuestNum++; //대기손님 수 증가
		}
	}
	void AddCallGuest(){ //전화 손님의 정보를 생성하고 쓰레드 동작
		if(SetCallGuest()){
			if(Taffy.CallGuestNum == Taffy.MAXGUEST) //최대 손님 수를 초과하였는지 확인 후 초과할 경우 리턴
				return;
			Services.callguest[Taffy.CallGuestNum] = new CallGuest(); //초기화
			Services.callguest[Taffy.CallGuestNum].SetCallTime(SetTime()); //등장시간 초기화
			Services.callguest[Taffy.CallGuestNum].SetTime(SetTime()); //서비스 시간 초기화
			Services.callguest[Taffy.CallGuestNum].SetMoney(SetMoney()); //지불 금액 초기화
			cguest[Taffy.CallGuestNum] = new Thread(Services.callguest[Taffy.CallGuestNum]);
			cguest[Taffy.CallGuestNum].start(); //등장시간동안 쓰레드 동작
			Taffy.CallGuestNum++; //전화손님수 증가
		}
	}
	void ArrvialGuest(){ //전화 손님 도착에 따른 대기손님배열에 추가
		for(int i = 0; i < Taffy.CallGuestNum; i ++){
			if(Services.callguest[i].ArrivalGuest == true){ //전화 손님이 도착하였는지 확인
				if(Taffy.GuestNum >= Taffy.MAXGUEST-1) //대기열이 꽉 찼으면 리턴
					return;
				for(int j = Taffy.GuestNum; j > 0; j--){ //앞에서 부투 한 칸씩 뒤로 이동
					Services.guest[j] = Services.guest[j-1];
				} 
				Services.guest[0] = new Guest(); //초기화
				Services.guest[0].ArrivalTime = Services.callguest[i].ArrivalTime + Services.callguest[i].CallTime; //도착시간 입력
				Services.guest[0].Money = Services.callguest[i].Money; //지불 금액 입력
				Services.guest[0].ServicesTime = Services.callguest[i].ServicesTime; //서비스 시간 입력
				Taffy.GuestNum++; //대기손님 수 증가
				Taffy.CallGuestNum--; //전화 손님 수 감소
			}
		}
	}
	void WorkingStaff(){ //스태프가 일을 하고 있는지 체크하고 손님 배치
		if(Taffy.GuestNum > 0 )
			for(int i = 0; i < Taffy.DeskNum; i++){
				if(Services.staff[i].Working == false){ //스태프가 일을 하고 있는지 체크
					Services.staff[i].SetStaff(Services.guest[0].ServicesTime); // 서비스시간 입력, 일하눈 중으로 변경
					stf[i] = new Thread(Services.staff[i]);
					stf[i].start(); //스태프 일 시작
					Statistics.DelayTime = Taffy.PlayTime-Services.guest[0].ArrivalTime; //대기시간 입력
					Statistics.GPlayTime += Services.guest[0].ServicesTime; //서비스 시간 입력
					Statistics.GetMoney += Services.guest[0].Money; //지불 금액 입력
					for(int j = 0; j < Taffy.GuestNum-1; j++) //앞으로 한칸씩 땡김
						Services.guest[j] = Services.guest[j+1];
					Taffy.GuestNum--; //손님수 감수
					if(Taffy.GuestNum == 0) //대기 손님이 없을시 탈출
						break;
				}
			}
			
	}
	int SetTime(){ //서비스 시간 난수 발생
		TNum = (int)(Math.random()*10+1); //1~10난수 발생
		return TNum;
	}
	int SetMoney(){ //지불 금액 난수 발생
		money = (int)(Math.random()*10+1)*1000; //1~10의 난수를 발생해 1000을 곱함
		return money;
	}
	boolean EndServices(int endtime, int cometime){ //두 시간이 같은 지 비교
		if(endtime == cometime)
			return true;
		else
			return false;
	}
}
