import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class D12_Calendar {
	/*
		# java.util.Calendar
		
		- 달력을 구현해 놓은 클래스
		- 날짜 및 시간을 손쉽게 계산할 수 있는 기능들이 구현되어 있다
		- 생성자 대신 getInstance()라는 스태틱 메서드로 인스턴스를 받아와 사용한다
	 */
	public static void main(String[] args) {
		// Calendar.getInstance() : 현재 시간이 담겨 있는 캘린더 인스턴스를 받아오는 스태틱 메서드
		Calendar now = Calendar.getInstance();
		
		System.out.println(now);
		
		// get(fieldNumber) : 필드 번호를 전달하여 해당 필드의 값을 가져온다
		// 번호만으로는 필드를 외울 수 없기 때문에, 캘린더 클래스에 상수가 만들어져 있다
		System.out.println(now.get(0));
		System.out.println(now.get(1));
		System.out.println(now.get(2));
		System.out.println(now.get(3));
		System.out.println(now.get(4));
		System.out.println(now.get(7));
		
		// 여러 필드들이 있지만 상수가 있기 때문에 번호를 외울 필요가 없다
		System.out.println("년: " + now.get(Calendar.YEAR));
		// ※ 캘린더 클래스는 특이하게 월만 0부터 시작하게 만들어져 있다
		System.out.println("월: " + now.get(Calendar.MONTH + 1));
		
		System.out.println("이번달의 몇번째 주인가?:  " + now.get(Calendar.WEEK_OF_MONTH));
		System.out.println("올해의 몇번째 날인가?: " + now.get(Calendar.DAY_OF_YEAR));
		System.out.println("이번달의 몇번째 날인가?:" + now.get(Calendar.DAY_OF_MONTH));
		// 요일을 알 수 있지만 번호로 나와서 알기 힘들다
		// 요일에 대한 상수도 캘린더에 정의되어 있다
		System.out.println("이번주의 몇번째 날인가?:" +now.get(Calendar.DAY_OF_WEEK));
		System.out.println("일요일: " + Calendar.SUNDAY);
		System.out.println("월요일: " + Calendar.MONDAY);
		System.out.println("화요일: " + Calendar.TUESDAY);
		System.out.println("수요일: " + Calendar.WEDNESDAY);
		System.out.println("목요일: " + Calendar.THURSDAY);
		System.out.println("금요일: " + Calendar.FRIDAY);
		System.out.println("토요일: " + Calendar.SATURDAY);
		
		System.out.println("12시: " + now.get(Calendar.HOUR));
		System.out.println("24시: " + now.get(Calendar.HOUR_OF_DAY));
		System.out.println(now.get(Calendar.MINUTE));
		System.out.println(now.get(Calendar.SECOND));
		System.out.println(now.get(Calendar.MILLISECOND));

		// set(fieldNumber, value)
		// : 필드번호로 필드를 선택하여 인스턴스의 특정 필드의 값을 변경하는 메서드
		now.set(Calendar.DAY_OF_YEAR, 300);
		System.out.printf("%d년 %d월 %d일 %d요일\n", 
				now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1,
				now.get(Calendar.DATE), now.get(Calendar.DAY_OF_WEEK));
		
		// add(fieldNumber, value)
		// : 필드번호로 필드의 값을 선택하여 해당 필드의 값을 더할 수 있다
		Calendar now2 = Calendar.getInstance();
		
		now2.add(Calendar.DATE, 110);
		System.out.printf("%d년 %d월 %d일 %d요일\n", 
				now2.get(Calendar.YEAR), now2.get(Calendar.MONTH) + 1,
				now2.get(Calendar.DATE), now2.get(Calendar.DAY_OF_WEEK));
		
		// getDisplayName(field, style, ) : 달, 요일 등을 번호 대신 문자 이름으로 꺼낸다
		// style - 길게 표현할 지 짧게 표현할 지 등을 결정한다
		// Locale - 어떤 언어로 표현할 지 결정한다
		String month = now2.getDisplayName(
				Calendar.MONTH, 
				Calendar.SHORT_FORMAT, 
				Locale.ITALY);
		System.out.println(month);
		
		/*
			# SimpleDateFormat 클래스
			
			- Date 타입 인스턴스를 편리하게 출력하는 기능이 구현되어 있는 클래스
			
			- y : 연
			- M : 월
			- d : 일
			- H : 24시
			- h : 12시
			- m : 분
			- s : 초
			- S : 밀리초
			- E : 요일 (여러 개 붙이면 길게)
			- a : 오전 / 오후
		 */
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss.SSS EEEEE");
		
		// 캘린더 인스턴스의 getTime()메서드로 Date 타입 인스턴스를 생성할 수 있다
		String result = sdf.format(now.getTime());
		System.out.println(result);
		
		// 시간이 몇초만 달라도 equals가 false이기 때문에
		// 같은 날짜인지 구분하기 위해 equals를 쓰는 것은 불가능하다
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.set(2024, 0, 1);
		cal2.set(2024, 0, 1);
		
		System.out.println(cal1.equals(cal2));
	}
}
