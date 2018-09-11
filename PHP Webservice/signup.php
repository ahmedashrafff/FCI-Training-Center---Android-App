<?php


$servername = "localhost";
$user = "id6342051_root";
$password = "123456789";
$dbname = "id6342051_mydb";

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
$username=  $_REQUEST["username"];
$password2= $_REQUEST["password"];
$email= $_REQUEST["email"];
$university= $_REQUEST["university"];
$college= $_REQUEST["college"];
$qualifications= $_REQUEST["qualifications"];
$address= $_REQUEST["address"];
$phone= $_REQUEST["phone"];
$ssn= $_REQUEST["ssn"];
$type=	$_REQUEST["type"];

		

$db = new mysqli($servername, $user, $password, $dbname);

if ($db->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
		
	
		$q='INSERT INTO user (type,username,password,email,university,college,qualifications,address,phone,ssn)
        VALUES( "'.$type.'", "'.$username.'", "'.$password2.'", "'.$email.'", "'.$university.'", "'.$college.'", "'.$qualifications.'",
		"'.$address.'", "'.$phone.'", "'.$ssn.'")';
		
		
if (mysqli_query($db, $q)) {
    //echo "New record created successfully";
    echo json_encode ("true");
} 
else {
    //echo "Error: " . $q . "<br>" . mysqli_error($db);
    echo json_encode ("false");
}




?>