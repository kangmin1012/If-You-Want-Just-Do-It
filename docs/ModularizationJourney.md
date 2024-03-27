# 모듈화 여정
해당 프로젝트의 모듈화는 어떻게 진행되었는고 어떤 전략을 사용했는지 작성한 문서

## 모듈화란?
단일 모놀리식 모듈 설계에서 벗어나 각각의 기능을 독립적인 모듈로 만들어 구성하는 기법

### 모듈화의 장점

**확장성** - 단일 모듈의 경우 간단한 변경도 다른 곳들에 영향을 줄 수 있습니다. 멀티 모듈의 경우 각 모듈마다 관심사가 다르기 때문에 프로젝트의 변경사항에도 쉽게 대응이 가능합니다.

**유지보수성** - 독립적으로 구성된 모듈의 경우 문제가 발생했을 때 해당 모듈만 수정하면 됩니다.

**빌드시간 단축** - 변경된 모듈만 재빌드하기 때문에 이는 곧 빌드시간의 단축으로 이어집니다.

**재사용성** - 특정 기능이 필요할 때 그에 맞는 모듈의 의존성을 추가하여 사용하면 추가 코드 작성이 필요 없습니다.

**캡슐화** - 격리된 코드는 읽기 쉽고, 테스트에 용이합니다. 

## 모듈 구성
해당 프로젝트는 다음과 같은 모듈로 구성되어져 있습니다.

<table>
  <tr>
   <td><strong>모듈 이름</strong>
   </td>
   <td><strong>역할</strong>
   </td>
   <td><strong>예시 클래스</strong>
   </td>
  </tr>

  <tr>
    <td><code>app</code></td>
    <td>app 모듈은 프로젝트의 핵심이며 다양한 모듈을 통해 앱을 구성합니다.</td>
    <td><code>IfYouApplication, MainActivity</code></td>
  </tr>

  <tr>
    <td><code>feature:A, feature:B</code></td>
    <td>앱의 특정 기능들을 담당하는 모듈입니다. 일반적으로 UI Screen과 ViewModel이 있습니다.</td>
    <td><code>DrawerScreen, UserInfoScreen</code></td>
  </tr>

  <tr>
    <td><code>core:domain</code></td>
    <td>앱의 복잡한 비즈니스 로직을 가지고 있습니다.<br>UI 레이어는 도메인 레이어에 있는 UseCase를 통해 원하는 액션을 진행합니다.</td>
    <td><code>GetUserNameUseCase</td>
  </tr>

  <tr>
    <td><code>core:data</code></td>
    <td>앱에 필요한 정보들을 다양한 경로를 통해 받아오는 역할을 합니다.</td>
    <td><code>UserInfoRepository<br>UserInfoDataSource<br>UserInfoDataStore...</td>
  </tr>

  <tr>
    <td><code>core:ui</code></td>
    <td>feature 모듈에서 사용되는 복합적인 Composable UI를 관리합니다.</td>
    <td><code>NumberPickerSpinner</code></td>
  </tr>

  <tr>
    <td><code>core:designsystem</code></td>
    <td>공통으로 사용되는 핵심 UI 요소(Material3)와 테마, 컬러 등을 관리합니다.</td>
    <td><code>IfYouTheme</code></td>
  </table>

  ## 참고 문서 및 프로젝트
  - [Now in Android](https://github.com/android/nowinandroid)