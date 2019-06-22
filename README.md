# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Test기능목록
- Money
  - 입력한 금액이 1000원 미만이면 exception
- Number
- Numbers
  - 1~45까지의 넘버생성
- Lottery
  - 6개 이하면 에러처리
  - Collections.shuffle()
  - 당첨번호
- Rank(통계)
  - 3개일치 1개
  - 4개일치 0개
  - 총 수익률 계산
- 보너스
  - 보너스 넘버
 
 ## Step3 기능 목록
 - 순서
    - [x] 문구 추가
    - [x] 메인 문구 순서 지정
- 테스트 추가
  - [x] 금액에서 수동구매제외한 자동구매리스트 생성
- 기능개선에 필요한 사항
  - 수동입력(당첨번호 입력해주세요 기능 사용하기)
  - 수동도 3개 입력이면 3개 입력하게 만들기.
  - 구매번호 입력
  - 자동으로 해야할 갯수
  - 로또제너레이터 기능 변경