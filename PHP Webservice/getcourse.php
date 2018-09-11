<?php


header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");


$dbhost = "localhost";
 $dbuser = "id6342051_root";
 $dbpass = "123456789";
 $db = "id6342051_mydb";
 $courseName=$_POST["name"];
 
 
 $conn = new mysqli($dbhost, $dbuser, $dbpass,$db) or die("Connect failed: %s\n". $conn -> error);
 $sql="SELECT idcourse,name,level,price,certified,numOfSessions,startDate,endDate FROM course WHERE name = '$courseName'";
$result=mysqli_query($conn,$sql);

$details_arr=array();

   
   	while($row = mysqli_fetch_array($result))
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
 
    echo json_encode($details_item);
?>