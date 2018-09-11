<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

$servername = "localhost";
$user = "id6342051_root";
$password = "123456789";
$dbname = "id6342051_mydb";

$userID = $_POST["userid"];

// Connect to the database
 $conn = new mysqli($servername, $user, $password,$dbname) or die("Connect failed: %s\n". $conn -> error);
// $con = new mysqli($servername, $user, $password,$dbname) or die("Connect failed: %s\n". $conn -> error);
 $sql="SELECT * FROM `trainee_register_course` WHERE `user_iduser`='$userID'";
 $result=mysqli_query($conn,$sql);
 $details_arr=array();




while($row = mysqli_fetch_array($result))
{
	$courseID=$row['course_idcourse'];
	$query="SELECT * FROM course WHERE idcourse = '$courseID'";
	
	$newResult=mysqli_query($conn,$query);
	while($row = mysqli_fetch_array($newResult))
{
	    $idcourse=$row['idcourse'];
        $name=$row['name'];
		$level=$row['level'];
		$price=$row['price'];
		$certified=$row['certified'];
		$numOfSessions=$row['numOfSessions'];
		$startDate=$row['startDate'];
		$endDate=$row['endDate'];
			  
        extract($row);
 
        $details_item=array(
			"idcourse" => $idcourse,
            "name" => $name,
            "level" => $level,
            "price" => $price,
            "certified" => $certified,
            "numOfLevels" =>$numOfSessions,
            "startDate" => $startDate,
            "endDate" =>$endDate
           
        );
 
        array_push($details_arr, $details_item);
    }	
}
    echo json_encode($details_arr);

?>