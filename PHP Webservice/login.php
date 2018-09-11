<?php


$servername = "localhost";
$username = "id6342051_root";
$password = "123456789";
$dbname = "id6342051_mydb";

$name = $_POST["username"];
$pass = $_POST["password"];

// Connect to the database
$con = mysqli_connect($servername,$username,$password);
// Make sure we connected successfully
if(! $con)
{
    die('Connection Failed'.mysql_error());
}

// Select the database to use
mysqli_select_db($con,$dbname);

$result = mysqli_query($con,"SELECT userName, password, type FROM user WHERE userName = '$name'");


$row = mysqli_fetch_array($result);

if($row["userName"]==$name && $row["password"]==$pass)
{
	$msg1="true:student";
	$msg2="true:instructor";
	$msg3="false:notype";
	
	
	if($row["type"]=="Student")
		echo json_encode($msg1);
	else if($row["type"]=="Instructor")
		echo json_encode($msg2);
	else
		echo json_encode($msg3);
}
    
else
{
   $msg4="false:User not found";
   echo json_encode($msg4);
}



?>