# Android 程式作業
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