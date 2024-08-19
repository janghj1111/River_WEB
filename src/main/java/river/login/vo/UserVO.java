package river.login.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import oracle.sql.DATE;

@Data
public class UserVO {
	// tip. UserVO 드래그 우클릭 후 references project 하면 참조되는 소스파일 파악할 수 있음 
	// 회사마다 DTO, VO, Bean 등등 식으로 이름이 다를 수 있음
	
		// 테이블 컬럼들
		// JSP에 넘길떄는 화면 name과 일치해야 화면에서 받을 수 있다
	
		private int userNo;
		private String userId;
		private String userPw;
		private String nickName;
		//private DATE enterDay;
		private String enterIp;
		//private DATE loginDay;
		private String loginIp;
		private int loginCount;
		private String usePermit;
		private int nouse_Count;
		//private DATE limitTime;
		private int limitCount;
		private String condition_Yn;
		//private DATE condition_Date;
		
		// 롬복을 통해서 getter setter 코드를 생략할 수 있음.
		// getter setter 만드는법 => 빈 화면 마우스 우클릭 Source 클릭 - Generate getter setter
		
}
