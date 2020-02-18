<?php	//guardar_peticion.php = save_request.php

	session_start();

    try{
        $base=new PDO("mysql:host=localhost; dbname=pruebas" , "root", "");	/*data of connection to the database in phpmyadmin*/
        /*we establish ownership of the connection*/
        $base->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);/*the base object calls the function attribute*/

        //we prepare the sentence to insert a request in the database
        $sql="insert into contact_form (USERID, IDSTATE, REQUEST, DATE) VALUES (:user_id, :state_id, :request, NOW())";

        $user_id = $_SESSION['userid'];//it's the id of the user that we saved in session when we did login
        $sate_id = 1; //this id corresponds to the state that we put into the database manually (waiting for review)
        $request = htmlentities(addslashes($_POST['message'])); //message written by the user sent by POST
		

        //binding values
        $resultado=$base->prepare($sql);
        $resultado->bindValue(":user_id", $user_id);
        $resultado->bindValue(":state_id", $sate_id);
        $resultado->bindValue(":request", $request);

        /*execute our sql instruction*/
        $resultado->execute();

        $_SESSION['mensaje_insertado'] = "<br><br>THE QUERY HAS BEEN SENT. PLEASE CLOSE SESSION.<br>";

        header("Location:/Enreos PHP/sistema_login3/Contact.php");

    }catch(Exception $e){

        die("Error: " . $e->getMessage());
    }
