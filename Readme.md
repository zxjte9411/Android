# Android 程式作業

<br />

### 目前已提交的作業進度：

* [HW1](#hw1)
* [HW2](#hw2)
* [HW3](#hw3)
* [HW4-1](#hw4-1)

***
## HW1
##### 作業說明：

1. change the app title from "My Application" to "婚姻建議".
2. change the resource values (strings.xml) as follows:
    the value of sex: "性別" ---> "性別(sex)" 
    the value of age: "年齡" ---> "年齡(age)" 
3. change the conditions of marriage suggestions (MainActivity.java) as follows:
    male, <30 - not hurry; 30<=age<=35 - get marry; >35 - find couple 
    female, <28 - not hurry; 28<=age<=32 - get marry; >32 - find couple


***
## HW2
##### 作業說明：

1. change the app title from "HW#2: your name".

2. (try to convert the Chinese characters into English in your the program and corresponding resource values (strings.xml) For example:
    <dd>using "male" instead of "男" and "female" instead of "女"</dd>
    <dd>using  "age" instead of "年齡"</dd>
    <dd>using "find a couple" instead of "開始找對象"</dd>
    <dd>...</dd>
***
## HW3
##### 作業說明：

1. Change the app title to "作業三: your name".

2. Change the code so that the suggestion of marriage is based on the following criteria:

| *Sex=male* | age <30 | 30 <= age <=40 | 40 < age |
|:---------|:-------:|:--------------:|---------:|
| family member number <4 | 趕快結婚 | 趕快結婚 | 開始找對象 |
| 4 <= family member number <=10 | 趕快結婚 | 開始找對象 | 開始找對象 |
| 10 < family member number | 還不急 | 還不急 | 開始找對象 |

<br />

| *Sex=female* | age < 28	| 28 <= age <=35 | 35 < age |
|:-----------|:--------:|:--------------:|---------:|
|family member number < 4| 趕快結婚 | 趕快結婚 | 開始找對象|
|4<= family member number <=10 | 趕快結婚 | 開始找對象 | 趕快結婚|
|10< family member number | 還不急 | 還不急 | 開始找對象 |

3. Write JUnit test code to test the getSuggestion() method and make sure that All the above marriage suggestion criteria have been tested  and achieve at least 90% statement code coverage for the MarriageSuggestion class.

<br />

4. Write the Instrumented test for the MainActivity and test the following scenarios:

* male, age < 30, family number = 12
* male, 30 <= age <= 40, family number = 5
* male, 40 < age, family number = 3
* female, age < 28, family number = 3
* female, 30 <= age <= 40, family number = 5
* female, 40 < age, family number = 8

***
## HW4-1
##### 作業說明：

1. Change the app title to "作業四之一: your name".

2. Remove the Number Picker and its related code.

3. Replace the Spinner (for selecting Male/Female) with two RadioButtons.

4. Replace the RadioGroup and RadioButtons (for selecting age) with a Spinner. Using different Spinners for Male and Female.

5. Add ScrollView and Checkbox and allow users to select their hobbies. Implement at least 10 hobbies as follows:

       <string name="music">音樂</string>
       <string name="sing">唱歌</string>
       <string name="dance">跳舞</string>
       <string name="travel">旅行</string>
       <string name="reading">閱讀</string>
       <string name="writing">寫作</string>
       <string name="climbing">爬山</string>
       <string name="swim">游泳</string>
       <string name="eating">美食</string>
       <string name="drawing">繪畫</string>

6. Add a TextView (in addition to marriage suggestion) to show the hobbies selected by users.

  作業說明參考連結：[點我](http://www.cc.ntut.edu.tw/~cliu/courses/ad/homework/homework.htm)