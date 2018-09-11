<?php

$signup ="-------------SignUp--------------\r\n
Input: type,username,password,email,university,college,qualifications,address,phone,ssn \r\n
Output: '(true)' in case of successful insertion \r\n
		'(false)' in case of error
\n \n";

$login ="-------------LogIn--------------\r\n
Input: user name, password
Output: '(true:student)' in case of successful login as a student \r\n 
		'(true:instructor)' in case of successful login as an instructor \r\n
		'(false:error)' in case of error
\n \n";

$login ="-------------LogIn--------------\r\n
Input: user name, password
Output: '(true student)' in case of successful login as a student \r\n
		'(true instructor)' in case of successful login as an instructor \r\n
		'(false error)' in case of error
\n \n";

$getcourse ="-------------Get Course--------------\r\n
Input: course name \r\n
Output: JSONObject contains all details about this course\r\n
\n \n";

$allcourses ="-------------All Courses--------------\r\n
Input: no input\r\n
Output: JSONArray contains all courses with details
\n \n";

$closedcourses ="-------------Close Courses--------------\r\n
Input: no input\r\n
Output: JSONArray contains names of all closed courses 
\n \n";



echo($signup);
echo($login);
echo($getcourse);
echo($allcourses);
echo($closedcourses);


?>