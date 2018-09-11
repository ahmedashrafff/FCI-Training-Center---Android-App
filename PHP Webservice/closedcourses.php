	<?php


	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");


	$dbhost = "localhost";
	$dbuser = "id6342051_root";
	$dbpass = "123456789";
	$db = "id6342051_mydb";
	 
	 $status="off";
	 $conn = new mysqli($dbhost, $dbuser, $dbpass,$db) or die("Connect failed: %s\n". $conn -> error);
	 $sql="SELECT name FROM course where opened='$status'";
	 $result=mysqli_query($conn,$sql);

	$details_arr=array();
	   
		while($row = mysqli_fetch_array($result))
	{
	$name=$row['name'];

		  
			extract($row);
	 
			$details_item=array(
				"name" => $name
				
			   
			);
	 
			array_push($details_arr, $details_item);
		}
	 
		echo json_encode($details_arr);

	 





	?>