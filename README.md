# java-racingcar-precourse 기능 목록

## 1. 입출력 형식 설정
 - camp.nextstep.edu.missionutils.Console의 readLine()을 활용해 경주할 n대의 자동차 이름을 입력 받는다.
   - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
 - readLine()을 활용해 경기를 진행할 횟수를 변수 numberOccurrences에 입력 받는다.
   - 시도할 횟수는 몇 회인가요?
 - 차수별 실행 결과 출력
   - 예: (실행 결과 \n pobi : --)
 - 최종 우승자를 출력한다. 공동 우승자가 발생할 경우 쉼표를 찍어 동시에 출력한다.
    - 최종 우승자 : {자동차이름} || 최종 우승자 : {자동차이름1, 자동차이름2, ...}
## 2. 검증
- 자동차 이름 유효성 검사
  - 이름의 길이가 1~5 글자가 아니라면 IllegalArgumentException을 발생시킨 후 종료. (System.exit()를 호출하지 않는다.)
  - 빈 입력이면 IllegalArgumentException
  - 이름에 공백 포함 시 트림 후 빈 문자열로 판단되면 IllegalArgumentException
- 시도할 횟수 유효성 검사
  - 정수가 아니거나 음수이면 IllegalArgumentException
## 3. 도메인(해결하고자 하는 문제의 영역)
- Car: 개별 자동차 객체
    - name: 자동차 이름
    - position: 현재 이동 거리(초기값 0)
    - move(): 전진 조건이 참이면 position++
    - getName(), getPosition(): 조회 메서드
- RacingRule: 전진 조건 설정
  - 랜덤값(0~9)이 4이상이면 참
- RandomNumberGenerator: 랜덤 숫자 생성
  - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
- Race: 라운드 진행/상태 관리
  - playRound(): Cars에게 전진 명령을 내려 한 라운드 진행
  - isFinished(): 모든 라운드가 종료되었는지 확인
  - getWinners(): 최종 우승자 목록 반환
- Cars: 자동차 컬렉션
  - 입력된 자동차 목록의 중복/개수/형식 검증
  - moveAll(): 모든 자동차에 전진 명령 일괄 수행