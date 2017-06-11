<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizaci�n Empleados</title>

<style>
.body {
	position: fixed;
	overflow-y: scroll;
	width: 100%;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(http://www.boliviaentusmanos.com/noticias/images/segip1825030215.jpg);
	background-size: cover;
	-webkit-filter: blur(0px);
}

form {
  display: block;
  margin: 30px;
  overflow: hidden;
  background: #fff;
  border: 1px solid #e4e4e4;
  border-radius: 5px;
  font-size: 0;
}
 
form > div > label {
  display: block;
  padding: 20px 20px 10px;
  vertical-align: top;
  font-size: 13px;
  font-weight: bold;
  text-transform: uppercase;
  color: #939393;
  cursor: pointer;
}
form > div.switch > label {
  padding: 16px 20px 13px;
}
 
.col-2, .col-3, .col-4 { 
  border-bottom: 1px solid #e4e4e4;
}
 
form > div > .col-4 {
  height: 86px;
}
 
label > input {
  display: inline-block;
  position: relative;
  width: 100%;
  height: 27px;
  line-height: 27px;
  margin: 5px -5px 0;
  padding: 7px 5px 3px;
  border: none;
  outline: none;
  color: #555;
  font-family: 'Helvetica Neue', Arial, sans-serif;
  font-weight: bold;
  font-size: 14px;
  opacity: .6;
  transition: all linear .3s;
}
 
.col-submit {
  text-align: center;
  padding: 20px;
}
 
label > select {
  display: block;
  width: 100%;
  padding: 0;
  color: #555;
  margin: 16px 0 6px;
  font-weight: 500;
  background: transparent;
  border: none;
  outline: none;
  font-family: 'Helvetica Neue', Arial, sans-serif;
  font-size: 14px;
  opacity: .4;
  transition: all linear .3s;
}
 
label > input:focus, label > select:focus {
  opacity: 1;
}
</style>
</head>

<body>
<label>Actualizar foto cliente</label>  
<form action="Clientes_Actualizar"  method="post">

 Select Image <input type="file" name="upfile" />
    <div class="col-1">
	
     <label>
      N�mero de ID
      <input type="text" placeholder="Insertar ID" name="id" tabindex="1">
  </label>
  </div>
  <div class="col-2">
    <label>
      Nombre completo
      <input type="text" placeholder="Insertar nombre" name="nombre" tabindex="2">
    </label>
  </div>
  <div class="col-3">
    <label>
      Profesi�n
      <input type="text" placeholder="Insertar profesi�n" name="profesion" tabindex="3">
    </label>
  </div>
  <div class="col-4">
    <label>
      Fecha de nacimiento
      <input type="text" placeholder="Insertar fecha" name="fecha" tabindex="4">
    </label>
  </div>
  <div class="col-5">
    <label>
      Estado civil
      <input type="text" placeholder="Insertar estado civil" name="estado" tabindex="5">
    </label>
  </div>
  <div class="col-6">
    <label>
      Direcci�n
      <input type="text" placeholder="Insertar direcci�n" name="direccion" tabindex="6">
    </label>
  </div>
  
  <div class="col-submit">
    <input type="submit" name="submit" value = "Insertar datos"/>
  </div>
  <div class="col-submit">
    <a href="http://localhost:8081/ProyectoIngSoft"><input type="button" value="Cerrar Sesi�n"></a>
  </div>
 
</form>

	<?php	

		$filebasename = basename($_FILES['upfile']['name']);
$ext = strtolower(substr($filebasename, strrpos($filebasename, '.') + 1));

if(($ext == "jpg" || $ext == "png" ) && ($_FILES["upfile"]["type"] == 
"image/jpeg" || $_FILES["upfile"]["type"] == "image/png" )){

    $desired_dir="uploads/";
    $file_name = $_FILES["upfile"]["name"];
    move_uploaded_file($_FILES["upfile"]["tmp_name"],
    $desired_dir . $file_name);
    $message = $file_name . "succesfully uploaded";
} else{
    $message = "Error! Archivo no valido";
}


	?>

</body>
</html