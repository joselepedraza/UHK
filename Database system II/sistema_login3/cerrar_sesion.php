
<?php	//cerrar_sesion.php = close_session.php
//to destroy (close) open session

	session_start(); //we must resume it first (to indicate which is the session we want to close, although there is only one open)
	
	session_destroy();	//close session
	
	header("Location:/Enreos PHP/sistema_login3/Contact.php"); //redirected at the start session page

?>
