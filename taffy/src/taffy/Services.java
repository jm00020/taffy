package taffy;
import java.lang.Runnable;
import javax.swing.*;

public class Services extends JFrame implements Runnable{
	JLabel GuestNum;
	JLabel CallGuestNum;
	JLabel [] Stime;
	JLabel [] Gstand;
	JTextPane EndMessage;
	JButton play_statis; // 상황에 따라 문구를 바꾸기 위한 것들
	static Guest [] guest; //손님 대기 배열 생성
	static Staff [] staff; //스태프 배열 생성
	static CallGuest [] callguest; //전환 손님 배열 생성
	Services(){}
	Services(JLabel GuestNum, JLabel [] Stime, JLabel [] Gstand, JTextPane EndMessage, JButton play_statis, JLabel CallGuestNum){
		this.GuestNum = GuestNum;
		this.Stime = Stime;
		this.Gstand = Gstand;
		this.EndMessage = EndMessage;
		this.play_statis = play_statis;
		this.CallGuestNum = CallGuestNum;
	}
	void GuestCount(){ //시간지남에 따란 변화
		GuestNum.setText("손님 수 :  " + Integer.toString(Taffy.GuestNum));
		CallGuestNum.setText("전화 손님 수 : " + Integer.toString(Taffy.CallGuestNum)); //시간지남에 따란 변화
	}
	void DeskSet(){ //시간지남에 따란 변화
		for(int i =0; i < Taffy.DeskNum; i++){
			if(staff[i].Working == true){
				Stime[i].setText("서비스 시간:" + Integer.toString(staff[i].ServicesTime) + "분");
				Gstand[i].setText("손님 유무:O");
			}
			else{
				Stime[i].setText("서비스 시간:0분");
				Gstand[i].setText("손님 유무:X");
			}
		}
	}

	public void run(){
		guest = new Guest [Taffy.MAXGUEST]; //최대 대기손님 수만큼 생성
		staff = new Staff [Taffy.DeskNum]; //입력받은 창구 수 만큼 생성
		callguest = new CallGuest [Taffy.MAXGUEST];//최대 대기손님 수만큼 생성
		Check check = new Check(); 
		for(int i = 0; i < Taffy.DeskNum; i++)
			staff[i] = new Staff(); //스태프 배열 초기화
		while(true){
			if(check.EndServices(Taffy.StartTime, Taffy.PlayTime)){ //시뮬레이션시간과 실행 시간이 동일해지면 정지
				EndMessage.setText("시뮬레이션이    종료 하였습니다.");
				play_statis.setVisible(true);
				Taffy.GuestNum = 0;
				Taffy.CallGuestNum = 0;
				return ;
			}
			check.AddGuest(); //손님 등장 난수 발생 및 손님 생성 
			check.AddCallGuest();//전화 손님 등장 난수 발생 및 손님 생성
			check.ArrvialGuest();//전화 손님 도착하였는지 확인 후 대기손님 배열에 추가
			GuestCount(); //손님 수 변경
			check.WorkingStaff(); //쉬고 있는 스태프가 있는지 확인 후 손님 배치
			DeskSet(); //창구에 문구 변경
			GuestCount();
			try{
				Thread.sleep(1000/Taffy.speed); //배속에 따라 속도 변경
			}
			catch(InterruptedException e){ //시물레이션 중 강제 종료 시 
				for(int i = 0; i < Taffy.DeskNum; i++){
					Check.stf[i].interrupt();
				}
				for(int i = 0; i < Taffy.DeskNum; i++){
					Check.cguest[i].interrupt();
				}
				Taffy.GuestNum = 0;
				Taffy.CallGuestNum = 0;
				return;
			}
			Taffy.StartTime++; //실행시간을 계속 증가 시킴
		}
	}
}

