<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

$servername = "localhost";
$user = "id6342051_root";
$password = "123456789";
$dbname = "id6342051_mydb";

$name = $_POST["username"];
$pass = $_POST["password"];

// Connect to the database
 $conn = new mysqli($servername, $user, $password,$dbname) or die("Connect failed: %s\n". $conn -> error);
 $sql="SELECT * FROM user WHERE userName = '$name'";
 $result=mysqli_query($conn,$sql);
 $details_arr=array();



$row = mysqli_fetch_array($result);

if($row["userName"]==$name && $row["password"]==$pass)
{

        $iduser=$row['iduser'];
		$type=$row['type'];
		$userName=$row['userName'];
		$password=$row['password'];
		$email=$row['email'];
		$university=$row['university'];
		$college=$row['college'];
		$address=$row['address'];
		$phone=$row['phone'];
		$ssn=$row['ssn'];

			  
        extract($row);
 
        $details_item=array(
            "iduser" => $iduser,
            "type" => $type,
            "userName" => $userName,
            "password" => $password,
            "email" =>$email,
            "university" => $university,
            "college" =>$college,
            "address" => $address,
            "phone" => $phone,
			"ssn" => $ssn
           
        );
 
        array_push($details_arr, $details_item);
    
 
    echo json_encode($details_item);

 
}
else
{
     $error_arr = array('Error' => 'Not Found');
     echo json_encode($error_arr);
}

 
?>