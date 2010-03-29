<script type="text/javascript" src="<c:url value="/scripts/jquery/easydrag.js"/>"></script>
<script type="text/javascript" src="<c:url value="/scripts/jquery/dimensions.js"/>"></script>
<script type="text/javascript" src="<c:url value="/scripts/jquery/autocomplete.js"/>"></script>

<h2> Ejemplos de JQuery </h2>
<p>Este Framework no tiene efectos espectaculares, pero permite programar de una forma muy sencilla</p>


<script type="text/javascript">                                         
   //Aqu va el js
   $(document).ready(function() {
   
   	var contador = 0;
   
   	$("#seccion").addClass("claseAzul");
   	$("#seccion2").addClass("claseAzul");
   	  //Code for example B
	$("input.buttonBslidedown").click(function(){ $("#seccion").slideDown("slow"); });
	$("input.buttonBslideup").click(function(){ $("#seccion").slideUp("slow"); });                                
   	$("input.buttonHola").click(function(){ $("<p>Mundo</p>").appendTo("#seccion2"); });
   	$("input.buttonHide").click(function(){ $("#thirdparagraph").hide("slow"); });
   	
   	//Aadir la propiedad de "dragable"
   	//$("#box1").easydrag();
	//Accin en el drop
	$("#box1").ondrop(function(e, element){ 
		contador++;
		$("#counter").html("N&uacute;mero de drops:"+contador);
	 });
	 
 });
         
     
</script>

 <input type="button" value="Slide Out" class="buttonBslideup" />
 <input type="button" value="Slide In" class="buttonBslidedown" />
 <input type="button" value="Hola" class="buttonHola" />
 <input type="button" value="Hide3" class="buttonHide" />
 
 <div id="seccion">
 <p>En un lugar de la Mancha, de cuyo nombre no quiero acordarme, 
  no ha mucho tiempo que viva un hidalgo de los de lanza en astillero, adarga antigua, 
  rocn flaco y galgo corredor. Una olla de algo ms vaca que carnero, salpicn las ms noches, 
  duelos y quebrantos los sbados, lantejas los viernes, algn palomino de aadidura los domingos, 
  consuman las tres partes de su hacienda.</p> <p> El resto della concluan sayo de velarte, 
  calzas de velludo para las fiestas, con sus pantuflos de lo mesmo, 
  y los das de entresemana se honraba con su vellor de lo ms fino.</p><p id="thirdparagraph">
  Tena en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, 
  y un mozo de campo y plaza, que as ensillaba el rocn como tomaba la podadera. 
  Frisaba la edad de nuestro hidalgo con los cincuenta aos; era de complexin recia, seco de carnes, 
  enjuto de rostro, gran madrugador y amigo de la caza. Quieren decir que tena el sobrenombre de Quijada, 
  o Quesada, que en esto hay alguna diferencia en los autores que deste caso escriben; 
  aunque, por conjeturas verosmiles, se deja entender que se llamaba Quejana.  
  Pero esto importa poco a nuestro cuento; basta que en la narracin dl no se salga un punto de la verdad. Es, pues, de saber que este sobredicho hidalgo, los ratos que estaba ocioso, que eran los ms del ao, se daba a leer libros de caballeras, con tanta aficin y gusto, que olvid casi de todo punto el ejercicio de la caza, y aun la administracin de su hacienda<p></div>                                     

<div id="seccion2">Hola </div>

<h2> Plugins de jQuery</h2>
<h3> EasyDrag </h3>
	<a href="http://fromvega.com/wordpress/2007/07/14/easydrag-jquery-plugin/">Enlace EasyDrag</a>	
	<div id="box1" style="background-color: yellow; padding: 5px; border: 2px solid orange; width: 200px;">Esta es una caja que se va a poder mover</div>
	<div id="counter">N&uacute;mero de drops: 0</div>