<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inscription</title>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<!-- 	<div class="container"> -->
		<fieldset>
			<div class="panel panel-primary">
				<div class="panel-heading">Créer un nouveau compte MglAlbumPhoto</div>
				<div class="panel-body">
					<form action="mglSignUp" method="post" class="form-horizontal">
						<div class="form-group">
							<label for="prenom" class="control-label col-sm-2">Prénom</label>
							<div class="col-sm-2">
								<input type="text" name="prenom" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="nom" class="control-label col-sm-2">Nom</label>
							<div class="col-sm-2">
								<input type="text" name="nom" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="login" class="control-label col-sm-2">Nom d'utilisateur</label>
							<div class="col-sm-2">
								<input type="text" name="login" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for ="numero" class="control-label col-sm-2">Numéro de téléphone</label>
							<div class="col-sm-2">
								<input type="text" name="numero" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="control-label col-sm-2">Mot de passe</label>
							<div class="col-sm-2">
								<input type="password" name="password" class="form-control">
							</div>
						</div>
					</form>
				</div>
			</div>
		</fieldset>
</body>
</html>
