# Blog 


## Blog ERD
![image](https://user-images.githubusercontent.com/108926837/178678865-06d06078-3b20-4d86-927b-359f626ebb2f.png)

## 프로젝트 계획 이유
> Hibernate를 이용한 블로그 입니다.  
> 회원가입, 로그인, 글쓰기, 댓글과 대댓글, 좋아요/싫어요, 태그 기능을 담고있습니다.
> 비밀번호는 SHA-256으로 암호화 하고있습니다.
> 회원가입시 사용한 이메일을 통해 회원가입 확인 메일을 전송합니다.  
> 회원만 글쓰기가 가능하며, 글 보기와 댓글 기능은 비회원도 가능합니다.  
> 여러 태그를 달 수 있으며, 태그로 검색이 가능합니다.  

## 프로젝트 설명
> Maven 프로젝트  
> DB : mysql  
> FrameWork : Hibernate  
> API : JPA  
> Library : jstl  
> WebServer : Tomcat  
> 
## DataBase(Mysql)
> 커넥션 생성 후 sql 덤프를 import하여 데이터베이스 테이블을 추가할 수 있습니다.

## 기능설명

### [회원정보]
1.가입
 + 회원가입은 이메일 형식이어야 합니다
 + 회원가입 후 이메일로 회원가입 확인메일이 전송되며, 전송링크를 클릭하여 확인해야 회원가입 절차가 완료됩니다.
 
2.수정
 + 로그인 한 회원 정보만 수정이 가능합니다.
 + 비밀번호 미입력 할 경우 비밀번호는 수정되지 않습니다.
 
3.탈퇴
 + 회원 탈퇴시 정보 삭제가 아닌 회원 상태만 변경됩니다.
 + 회원이 작성한 글 댓글은 삭제되지 않으며, 열람 가능합니다.

### [글 작성]
1.글쓰기
 + 글쓰기는 로그인 한 회원만 작성 가능합니다.
 + 글에는 여러 태그를 달 수 있습니다.
2.글 삭제
 + 글 삭제시 해당 글에 달린 댓글도 삭제됩니다.

### [댓글]
1.댓글달기
 + 댓글은 비회원도 작성 가능하며 비회원은 접속한 ip가 기록됩니다.
 + 회원은 회원id가 기록됩니다.
 + 댓글에 댓글을 달수 있으나, 대댓글에는 댓글을 달 수 없습니다.

### [태그]
1. 태그달기
 + 태그에는 수량이나 글자수에 제한을 두지 않습니다






