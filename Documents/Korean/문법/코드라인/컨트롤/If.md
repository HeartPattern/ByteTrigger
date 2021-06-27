#If
###정의
`If`는 코드를 실행할지를 제어하는 컨트롤입니다.
###구조
```
>If <값1> <비교자> <값2>
[Or또는 And 컨트롤]
    {코드}
<
```
###설명
`If`는 코드를 실행할지를 제어하는 컨트롤입니다.
`>if` 다음에 나오는 `<값1> <비교자> <값2>`가 참일경우, `{코드}`를 실행하며, 그렇지 않을경우 `{코드}`는 실행되지 않습니다.
###예시
```
!Event CommandInput Compare
#<argument:1> < <argument:2>를 만족한다면 다음 문장을 실행합니다.
>If <argument:1> < <argument:2>
    #<argument:1> < <argument:2> 일때만 실행됩니다.
    @Print <argument:1>이 <argument:2>보다 작습니다.
<
#<argument:1> > <argument:2>를 만족한다면 다음 문장을 실행합니다.
>If <argument:1> > <argument:2>
    #<argument:1> > <argument:2> 일때만 실행됩니다.
    @Print <argument:2>이 <argument:1>보다 작습니다.
<
```
###실행결과
####입력
```
Compare 3 8
```
####출력
```
3이 8보다 작습니다.
```