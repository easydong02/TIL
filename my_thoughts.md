### 2023/07/13

[에러 로그를 꼼꼼히 보자]

- 원래 gradle 환경에서 잘 빌드되던 것들이 어느날 timeout이 걸림.
- 코드가 변경된 것은 없음. 그리고 빌드 시 timeout이 될 때마다 로그를 보면 다 다른 요소들이 찍힘.
- 캐시 지우고 gradle 재설치해보고 다시 로드해보고 별짓을 다함.
- 한참을 보다가 언젠가 되겠지 하고 다른 기능테스트를 위한 프로젝트 만들어서 개발중이었음.
- 그러다가 사수님이 보더니 검색을 10분하고 해결하셨음.
- 원인은 build.gradle에서 repositories{} 에서 원격 저장소가 jcenter로 되어있었음.
- 에러로그를 보면 다 다른 라이브러리 빌드 에러가 떴지만 공통적으로 jcenter에서 가져오는 것이었음.
- jcenter를 찾아가보니 공지에 재작년? 쯤부터 운영을 중단하기로 시작했다는 글이었음. 아마도 예전에 작성했던거라 굳이 안바꾸고 냅둔 것 같음.
- 그래서 다시 mavenCentral로 원격저장소를 바꾸니 바로 해결됐음.
- 자괴감도 들고 그랬지만 이번에 배운 것은 에러로그를 그냥 보는 것이 아닌 그 수많은 로그 중에서 문제 해결에 필요한 키포인트를 찾아내는 '통찰력'이 필요하다고 뼈저리게 느낌..

---
