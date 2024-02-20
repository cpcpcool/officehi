# 🖥️ Spring MVC Legacy Project
### 온라인 회사 업무 관리 서비스

배포링크
[AWS] http://54.180.31.7:9999/officehi-1.0.0-BUILD-SNAPSHOT

최종 보고서, 기획서등을 포함한 최종 산출물 링크
[구글 드라이브] https://drive.google.com/drive/folders/1fItYaOcz05qKoLrdA7tQZNDzokkkGbXS?usp=sharing
<br>

## 🏢 프로젝트 명
그룹웨어"OfficeHi"

<br>

## 🕰️ 개발 기간
* 23.12.12 - 24.01.02

<br>

## 👨‍💻 개발 인원
4명

<br>

## 💻 담당 업무

|       | 박재용(팀장)                                                                                                    | 엄다빈(팀원)                                                                                         | 이승준(팀원)                                                                             | 정유진(팀원)                                  |
|-------|-----------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|-----------------------------------------------|
| **Front** | -관리자 공지사항 페이지<br> -출퇴근(근태관리) 페이지 <br> -사원 정보 관리 | -결재 문서 페이지 | -CSS 전체 레이아웃 및 세부 디자인 <br> -로그인 페이지 <br> -메인 페이지 | -마이페이지 <br> -사용자 공지사항 페이지 |
| **Back**  | -출퇴근 시간 체크/계산 <br> -출퇴근 시간 조회 <br> -사원 리스트/검색 <br> -사원 정보 등록/수정/삭제 <br> -사원정보 파일 데이터 관리 | -결재 문서 리스트 <br> -결재 문서 작성/조회 <br> -결재 문서 승인/반려 <br> -결재자 신청/요청 필터 <br> -중간 결재자 기능 | -로그인/로그아웃 <br> -메인 페이지 연결 <br> -공지사항 리스트/검색 <br> -관리자 공지사항 작성/수정/삭제 | -마이페이지 조회 <br> -사용자 공지사항 리스트/조회 |

<br>

## 🛠개발 환경

![개발환경](https://github.com/100opa/officehi/assets/147002859/ee904293-7cc8-4db0-b1f3-e3e54c6acf6d)

* ### Front <br> 
HTML5, JavaScript5, CSS3, jQuery 3.7.1

* ### Back <br>
Windows10, Spring Framework 5.2.25.RELEASE, Java 11, Tomcat 8.5, MySQL 8.0.22, spring-jdbc 5.2.25, MyBatis 3.5.14, MyBatis-spring 2.1.2, Lombok 1.18.30, hibernate-validator 6.0.23.Final, validation-api 2.0.1. Final

<br>

## 📃 설계 배경
온라인에서 효율적인 회사 업무 관리를 위해 제작

<br>

## 📌 설계 목적
사원 정보를 디지털로 관리하고, 사원들의 온라인 업무를 관리하는 시스템 구축

<br>

## 🎇 기대 효과
회사 사원들의 정보, 출퇴근 시간, 결재 문서 등의 실시간 데이터 반영을 통해 사원들의 업무 효율성 증대

<br>

## 👨‍👩‍👦‍👦 서비스 대상
직원과 서류 데이터의 전산화와 근태 관리가 필요한 회사


<br>
<br>

---


<br>
<br>


## 🔔주요 기능

<br>
<br>

#### ** 로그인 페이지 **
- 회원 로그인 페이지
- 존재하지 않는 아이디 또는 비밀번호 입력 시 로그인 불가
![login](https://github.com/100opa/officehi/assets/146176667/122c0fc7-8444-41cd-b305-c78f68a58873)

<br>

#### ** 사용자 메인 페이지 **
- 사용자가 등록한 프로필 사진 표시
- 가장 최근에 작성한 공지사항 표시
- 결재 문서 표시
- 출퇴근 버튼 선택하여 근태관리
![main](https://github.com/100opa/officehi/assets/146176667/6557c50d-e623-40a4-9dd5-449465334a4a)

<br>

#### ** 공지사항 조회 **
- 관리자가 작성한 공지사항 확인
![noticeList](https://github.com/100opa/officehi/assets/146176667/fc67366c-7674-4745-89ab-c315055c3b11)

<br>

#### ** 결재 현황 조회 **
 - 사용자가 작성한 문서 또는 참조된 문서를 표시
 - 기안문, 참조문 보기 선택 시 필터링하여 목록 표시
 - 사용자가 작성한 신청 상태의 문서만 삭제 및 수정 가능
![approvalList](https://github.com/100opa/officehi/assets/146176667/5e96482c-111d-46a7-ba17-7cb03efa867b)

<br>

#### ** 결재 문서 작성 **
 - 사용자보다 높은 직급의 사용자만 승인자로 지정
 - 1차 승인자만 지정하거나 2차 승인자까지 지정할 수 있음
 - 결재 요청 선택 시 1차 승인자가 해당 문서를 확인할 수 있음
![approvalAddForm](https://github.com/100opa/officehi/assets/146176667/71c4d634-575d-4b2a-aae6-d6bd37301612)

<br>

#### ** 출퇴근 시간 기록 **
 - 출근, 퇴근 선택 시 시간 기록
 - 하루에 한 번만 출근을 선택할 수 있음
![work](https://github.com/100opa/officehi/assets/146176667/e9c64810-06b1-4e4b-9af4-e1dfb1c8cc7f)

<br>

#### ** 근무 시간 확인 **
 - 사용자의 출퇴근 기록과 근무 시간을 표시
 - 퇴근 시간과 출근 시간의 차이로 근무시간을 자동 계산
![workList](https://github.com/100opa/officehi/assets/146176667/7acf41ea-3d55-49aa-84e7-93944ec0f2c1)

<br>

#### ** 마이페이지 **
 - 사용자 본인의 정보를 표시
 - 프로필 이미지와 인감이미지를 수정할 수 있음
 - 이외 정보는 수정 불가
![myPage](https://github.com/100opa/officehi/assets/146176667/367f8ace-6030-437e-9330-4b37788b55cb)

<br>

#### ** 사원 정보 관리 **
 - 모든 사용자 목록을 확인할 수 있음
 - 퇴사 버튼 선택시 '사번'과 '사원명'에 취소선을 추가하고 퇴사일을 오늘 날짜로 추가
![employeeTotal](https://github.com/100opa/officehi/assets/146176667/1cd13616-552e-4a77-9702-5ea8bac29c5e)

<br>

#### ** 사원 정보 등록  **
 - 새로운 사용자를 등록할 수 있음
 - 사번은 자동생성 되어 수정불가
 - 모든 정보를 기입하지 않으면 등록이 진행되지 않음
 - 등록을 완료하면 해당 사용자의 계정정보 또한 함께 등록 진행
![employeeAddForm](https://github.com/100opa/officehi/assets/146176667/41fe23e5-a3f8-490c-8ec0-66a0f364fa92)

<br>

#### ** 사원 정보 상세  **
 - 사용자의 마이페이지와 다르게 사번을 제외한 모든 정보를 수정할 수 있음
 - 퇴사일은 퇴사 처리를 진행해야 표시
![employeeDetail](https://github.com/100opa/officehi/assets/146176667/0a5940f0-ef64-4f62-9af9-ac5fecbaab84)

<br>

#### ** 결재 문서 관리 **
 - 모든 사용자가 작성한 문서를 조회할 수 있음
![approvalTotal](https://github.com/100opa/officehi/assets/146176667/c4610e15-cd33-4d2c-978c-7c0485d67962)

<br>

#### ** 공지사항 관리 **
 - 작성한 공지사항 목록을 확인, 수정, 삭제할 수 있음
![noitceTotal](https://github.com/100opa/officehi/assets/146176667/25ffa9d2-fee9-4c5e-9d30-301226aeb0ae)

<br>

#### ** 공지사항 등록 **
 - 새로운 공지사항을 등록할 수 있음
![noticeAddForm](https://github.com/100opa/officehi/assets/146176667/eb87f4f3-e95d-4594-9221-af57de725353)
