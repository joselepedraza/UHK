<!--ESTA PAGINA TB SE DEBERA DE ENCARGAR DE COMPROBAR QUE EL USUARIO SE ENCUENTRA EN LA BASE DE DATOS-->
<?php	//hacer_login.php = start_session.php
if(isset($_POST["enviar"])){

    try{
        $base=new PDO("mysql:host=localhost; dbname=pruebas" , "root", "");	/*data of connection to the database in phpmyadmin*/
        /*we establish ownership of the connection*/
        $base->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);/*the base object calls the function attribute*/
        $sql="SELECT * FROM USUARIOS_PASS WHERE USUARIOS= :login AND PASSWORD= :password"; /*use the two markers for the sql statement (sql instruction responsible for looking in the database if the user is registered)*/
        /*we create consultation prepared with markers:*/
        $resultado=$base->prepare($sql);	/*create variable result = connection that calls the function prepare, responsible for preparing the instruction sql*/
        /*we rescue login and password entered in the form of the page*/
        $login=htmlentities(addslashes($_POST["login"]));	/*we convert any symbol to html "_-... (addslashes will omit those sql injection characters)*/
        $password=htmlentities(addslashes($_POST["password"]));/*to rescue what the user entered in the password text box of the form*/

        /*IDENTIFY EACH MARKER WITH YOUR TEXT PICTURE(binding)*/
        $resultado->bindValue(":login", $login);
        $resultado->bindValue(":password", $password);
        /*execute our sql instruction*/
        $resultado->execute();

        //I retrieve the row of the user with his data to keep the id stored in the session
        $usuario_autentificado = $resultado->fetch();

        /*TO KNOW IF THE USER IS WITHIN OR NOT WITH THE DATABASE (rowCount-> returns the number of records that a query returns, if it does not exist = 0 rows, if it exists = 1 row)*/
        $numero_registro=$resultado->rowCount();
        if($numero_registro != 0){/*is exist*/
            session_start(); //to create session for the user who has just logged in (variable superglobal $ _SESSION, we can use it anywhere in our site)
            $_SESSION["usuario"]=$_POST["login"];	//we rescue from the page of the form (login text box of the form)
            $_SESSION["userid"]= $usuario_autentificado['ID'];
            header("Location:/Enreos PHP/sistema_login3/Contact.php");

        }else{//if not exist

            echo "<br><br>ERROR. Incorrect user or password. TRY AGAIN";
			

        }


    }catch(Exception $e){

        die("Error: " . $e->getMessage());
    }

}