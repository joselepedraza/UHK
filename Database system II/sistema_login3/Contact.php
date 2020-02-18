<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Pereira Aragüete Abogados</title>

<link rel="stylesheet" href="style_inicio_about_service_warning_contact_library.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link  rel="icon" href="img/hoja.png" type="image/png">
</head>

<body>

<?php	//to show the form only if you have not logged in(formulario.html)
	session_start();
	if(!isset($_SESSION["usuario"])){
		include("formulario.html");
	}else{
		echo "USER: " . $_SESSION["usuario"];	//it will only show the name of the user who has logged in
	}

if(isset($_SESSION["mensaje_insertado"])){
    echo $_SESSION["mensaje_insertado"];	//it will only appear when a message is inserted
    unset($_SESSION["mensaje_insertado"]);  //we must erase it so that it does not appear again
}



?>
	<header>
    	<figure id="MainImg">
        	<img src="img/logo.png" alt="logo" width="300" height="125"/>
        </figure>
    	<h1>Contact Us</h1>
    
    </header>
    
    <nav>
    	<ul id="bar">
        	<a class="lbar" href="Home.html"><li class="linksBar">HOME</li></a>
            <a class="lbar" href="About.html"><li class="linksBar"> ABOUT US </li></a>
            <a class="lbar" href="Services.html"><li class="linksBar"> OUR SERVICES </li></a>
            <a class="lbar" href="Library.html"><li class="linksBar"> NEWSPAPER LIBRARY </li></a>
            <a class="lbar" href="Contact.php"><li class="linksBar"> CONTACT US </li></a>
            
        </ul>
    </nav>
    
  	<section id="sectServices">
    	<div class="contactText">
        	<article>
            <!--Envianos un mensaje-->
            	<h2>Make your inquiry</h2>
                <!--Si tienes alguna pregunta acerca de nuestros productos o servicios, por favor rellena el siguiente formulario y en breve nos pondremos en contacto contigo. También nos puedes llamar en horarios de oficina.-->
                <p>If you have any questions about our products or services, please fill in the following form and we will contact you as soon as possible. You can also call us during office hours.</p>
            	<img id="contactImg" src="img/background-pereira-aragüete-abogados.jpg" alt="logo" width="600" height="350"/>
            </article>
        
        </div>
        
        
		<?php	//to show the form only if you have not logged in(formulario1.html)

            if(!isset($_SESSION["usuario"])){
                echo "<br><br><br><br>PLEASE LOGIN FOR FILL YOUR REQUEST";	
            }else{
                echo "<br><br><br>USER: " . $_SESSION["usuario"];
                include("formulario1.html");
            }

        ?>
        
        <?php	//to show the session closure button only if you have logged in(formulario_cierre.html)

            if(isset($_SESSION["usuario"])){
                include("formulario_cierre.html");
			}

        ?>
        
        
        
	</section>
    
	<footer>
        <figure>
        	<img src="img/footer-araguete.png" alt="logofooter" width="200" height="70">
            
        </figure>
        
    	<address>
        Address: 
        Avd/ Villanueva 3, 1º A 06005 Badajoz, Spain
        </address>
        
        <address>
        Contact us: +34 924223821
        </address>
        
        <div>
        <a href="Warning.html">LEGAL WARNING</a>
        </div>
       <!-- 
        <figure>
        	<img src="img/footer-araguete.png" alt="logofooter" width="200" height="70">
        </figure>
        -->
    </footer>

</body>
</html>
