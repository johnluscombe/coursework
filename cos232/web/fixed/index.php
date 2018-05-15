<?php
    session_start();
	include('sessions.php');
	include('connect.php');
	if(is_logged_in()) {
		header("Location: members.php");
	}
	include('header.php');
?>

<div class="post">
	<div class="post-bgtop">
		<div class="post-bgbtm">
			<h2 class="title"><a href="#">Welcome to hackme </a></h2>
            <div class="entry">
		    <?php
			if(!is_logged_in()) {
            ?>
	           	<form method="post" action="members.php">
                    <h2>LOGIN</h2>
                    <table>
                        <tr>
                            <td>Username</td>
                            <td><input type="text" name="username" /></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" /></td>
                            <td><input type="submit" name = "submit" value="Login" /></td>
                        </tr>
                    </table>
				</form>
				<hr style="color:#000033" /><br>
			    <p>If you are not a member yet, please click <a href="register.php">here</a> to register.</p>
            <?php
            }
		    ?>
            </div>
	    </div>
	</div>
</div>

<?php
    include('footer.php');
?>

</body>
</html>
