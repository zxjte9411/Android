 Android 程式作業

<br />

### 目前已提交的作業進度：

* [HW1](https://github.com/zxjte9411/Android/archive/hw1.zip)
* [HW2](https://github.com/zxjte9411/Android/archive/hw2.zip)
* [HW3](https://github.com/zxjte9411/Android/archive/hw3.zip)
* [HW4-1](https://github.com/zxjte9411/Android/archive/hw4.1.zip)
* [HW4-2](https://github.com/zxjte9411/Android/archive/hw4.2.zip)
* [HW5](https://github.com/zxjte9411/Android/archive/hw5.zip)
* [HW6](https://github.com/zxjte9411/Android/archive/hw6.zip)
* [HW7](https://github.com/zxjte9411/Android/archive/hw7.zip)
* [HW8](https://github.com/zxjte9411/Android/archive/hw8.zip)
* [HW9](https://github.com/zxjte9411/Android/archive/hw9.zip)

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

***
## HW4-2
##### 作業說明：

  Clone or download the sample code Unit018 from [Here](https://github.com/cxl1521/SampleCode.git)

  Import the sample code and modify the code according to the following requirements.

1. Change the app title to "作業四之二: your name".
2. Change the layout to switch right-hand-side to left-hand-side and vice versa.
3. Try to create a pure Java class/method so that 3 btnXXXonClick() listeners can call this pure Java method to handle 電腦出拳 (instead doing this within the OnClickListener). 
4. Write the JUnit test for your pure Java method.

***
## HW5
##### 作業說明：
Clone or download the sample code Unit023 from [Here](https://github.com/cxl1521/SampleCode.git)

Import the sample code and modify the code according to the following requirements.
1. Change the app title to "作業五: your name".
2. Change the setting or configuration of all animation resource xml files, including alpha, scale, and trans.
3. Create two additional animation resource files scale_rotate_trans_in and scale_rotate_trans_out, give necessary and proper settings for these two files, and change the program so that these two animation resource will be used in the program.
4. Change the columns to 4 for GridView and add the images files upto 12 (or more) to the drawable directory  and change the program accordingly. 
5. Implement the AlphaAnimation, ScaleAnimation, TranslateAnimation, and RotateAnimation classes corresponding to your  animation resource files in step 2. Change your program to use AnimationSet to combine these classes so as to implement above animation instead of using animation resource files.

***
## HW6
##### 作業說明：

Clone or download the sample code Unit030 from [Here](https://github.com/cxl1521/SampleCode.git)

Import the sample code and modify the code according to the following requirements.
1. Change the app title to "作業六: your name".
2. Change the game scissor-stone-paper  to rolling-a-dice in which a user can click the dice ImageButton and the computer will randomly generate a number ranging from 1 to 6. If the generated number is greater than 4 then computer wins. If the number is equal to 3 or 4, then the result is draw. Otherwise, the user wins. Use a TextView to show the game result (i.e., user wins, computer wins, or draw). Update the program and resource accordingly. 
3. When the user click the dice, your app shall show a dice-rolling animation in an ImageView. You may refer to Unit024 for drawable animation. 
4. Keep tracking of the game statistics, including the total number of game that has been played and the total number of computer/user win and draw. Use a fragment to show the game statistics and provide two buttons to show/hide the game result.
5. The layout of the fragment shall use LinearLayout.


***
## HW7
##### 作業說明：

Copy your HW#6 to another app and rename the app as HW#7

Import HW#7 and modify the code according to the following requirements.

1. Change the app title to "作業 七: your name".
2. Change the game rolling-a-dice in which a user can click a Button and the computer will randomly generate a number ranging from 1 to 6. If the generated number is greater than 4 then computer wins. If the number is equal to 3 or 4, then the result is draw. Otherwise, the user wins. Use a Toast to show the game result (i.e., user wins, computer wins, or draw). Update the program and resource accordingly. 
3. Moreover, when the user click the Button, your app shall show a dice-rolling animation in an ImageView. You may refer to Unit024 for drawable animation. 
4. Keep tracking of the game statistics, including the total number of game that has been played and the total number of computer/user win and draw. Use another activity to show the game statistics and provide one Button to show the game statistics. 
5. The layout of the "game-statistics" activity shall use LinearLayout. In addition to show the game statistics, the layout of this activity shall also contain a Button. When the user click that Button, the app will go back to previous activity (i.e., MainActivity).
***
## HW8
##### 作業說明
Refer to Unit031, Unit035, Unit038, and Unit044 and develop a simple money bookkeeper app to record the money that the user spends on the meals according to the following requirements:

1. The title of the app shall be "作業 八: your name".
2. The app shall have two Activities where the MainActivity (the first activity) shall allows users to enter the purchased meal , the purchased date, and the amount of the purchase. The purchased meal can be "Breakfast", "Lunch", or "Dinner" which can be selected by user using a spinner. The user may enter multiple purchases of the meals that he/she brought. The layout the MainActivity is shown in Fig. 8a.
3. Moreover, when the user clicks datePicker (datePicker mode = spinner) and changes date, the purchased date picked by the user will be displayed on the TextView "日期". Further, when the user clicks the "輸入" Button, your app shall show the purchased amount that the user enters in the EditText "金額" using a Toast as shown in Fig. 8b. 
4. The user can keep entering the detailed information of each purchased meal in multiple times and all the entered data will be recorded in the MainActivity (may use arrays of primitive types or user-defined Serializable or Parcelable objects).
5. When the user clicks the the "紀錄" Button on Fig. 8a, the MainActivity will pass all the recorded data to the second activity where the data will be displayed using a ListView as shown in Fig. 8c.
***
## HW9
##### 作業說明：
Copy your HW#8 to another app and rename the app as HW#9.
Refer to Unit052 and Unit 053 and modify HW#9 according to the following requirements.

1. Change the app title to "作業 九: your name".
2. Refer to Unit052 and add a two-level Options Menu to the MainActivity. An example of the Options Menu is shown in Fig. 9a. When the user clicks the menu item "背景音樂", a submenu will show up as Fig. 9b. If the use clicks the menu item "關於這個程式...", an alert dialog will show up as Fig. 9c. Modify your program to add the Menu accordingly. Note that, similar to Unit 052, you will use Service to implement the  services for media player.
3. Refer to Unit053 and add a Context Menu to the MainActivity. When the user clicks the layout of the MainActivity for more than 1 second, the Context Menu will show up as Fig. 9d. Then, if the user clicks the menu item "背景音樂", a submenu will show up as Fig. 9e. If the use clicks the menu item "關於這個程式...", a dialog will show up as Fig. 9c. Modify your program to add the Context Menu  accordingly. Note that you may use the same Service as implemented in step 2.
***

作業說明參考連結：[點我](http://www.cc.ntut.edu.tw/~cliu/courses/ad/homework/homework.htm)