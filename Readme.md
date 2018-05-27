 Android 程式作業

## HW10
##### 作業說明：

 Refer to Unit052, Unit053, Unit057, Unit 060 and implement the following requirements.

1. Change the app title to "作業 十: your name".
2. Refer to Unit027 and create two Fragments: "AddNewContact" and "SearchContact". The AddNewContact is used to add a new contact (including name, phone number, and the type of phone number). It has two TextViews and corresponding EditTexts for users to enter name and phone number. It also has a Spinner for users to select the type of the phone number, such as mobile, home, and office. The SearchContact will show all the contacts using a ListView and allow users to search a specific contact by giving the name of the contact. If the specific contact is found, your app will highlight the contact in one way or another. Otherwise, show a message like "the contact is not found" using Toast.
3. Refer to Unit060 and use SQLite to insert (i.e., add) and query (i.e., search) the contact info.
4. Refer to Unit057 and allow users to switch between the above two Fragments using Tab. You may also use the ViewPager, FragmentPagerAdapter, and TabLayout to implement Tab.
5. Instead of using Buttons, you may use an Options Menu (Unit052) to implement the action of "adding a new contact" and an Action Bar [with an icon] (Unit054) to implement the action of "searching a contact".