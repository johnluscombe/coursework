<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>hackme</title>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="header">
	<div id="menu">
		<ul>
        <?php
			if(is_logged_in()) {
        ?>
                <li><a href="members.php">Main</a></li>
                <li><a href="post.php">Post</a></li>
                <li><a href="logout.php">logout</a></li>
        <?php
			} else {
		?>
                <li><a href="index.php">Login</a></li>
                <li><a href="register.php">Register</a></li>
        <?php
			}
        ?>
		</ul>
	</div>
</div>
<div id="logo">
	<h1><a href="#">hackme </a></h1>
	<p><em>an information security bulletin board</em></p>
</div>
<hr />
<div id="page">
	<div id="page-bgtop">
		<div id="page-bgbtm">
			<div id="content">
