<?php


header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");


$dbhost = "localhost";
 $dbuser = "id6342051_root";
 $dbpass = "123456789";
 $db = "id6342051_mydb";
 $courseID=$_POST["cid"];
 $traineeID=$_POST["tid"];

 
 
 $conn = new mysqli($dbhost, $dbuser, $dbpass,$db) or die("Connect failed: %s\n". $conn -> error);
 $sql='INSERT INTO `trainee_register_course`(`user_iduser`, `course_idcourse`, `year`, `paied`) VALUES ("'.$traineeID.'","'.$courseID.'","2018","no")';
$result=mysqli_query($conn,$sql);

if (mysqli_query($conn, $sql)) {
    //echo "New record created successfully";
    echo json_encode ("User enrolled Successfully");
} 
else {
    //echo "Error: " . $q . "<br>" . mysqli_error($db);
    echo json_encode ("false");
}
   
   
 

 





?>