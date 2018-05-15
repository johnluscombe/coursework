<?php
    session_start();
	include('sessions.php');
	include('connect.php');
	include('login.php');
	$DB = connect();
	
	if (isset($_POST['submit'])) {
		$_POST['username'] = trim($_POST['username']);
		check_login_fields($_POST['username'], $_POST['password']);
		$result = get_user_row($DB, $_POST['username']);
		check_user_exists($result);
		check_password($DB, $_POST['username'], $_POST['password'], $result);
        login($_POST['username'], $_POST['password']);
        reset_password_attempts($DB, $_POST['username']);
	} else {
	    verify_logged_in();
    }
	include('header.php');
?>

<div class="post">
	<div class="post-bgtop">
		<div class="post-bgbtm">
        <h2 class = "title">hackme bulletin board</h2>
            <p>Logged in as <a><?php echo logged_in_user() ?></a></p>
        </div>
    </div>
</div>

<?php
	$threads = mysqli_query($DB, "SELECT * FROM threads ORDER BY date DESC")or die(mysqli_error($DB));
	while($thisthread = mysqli_fetch_array( $threads )){
?>

	<div class="post">
        <div class="post-bgtop">
            <div class="post-bgbtm">
                <h2 class="title">
                    <a href="show.php?pid=<?php echo $thisthread['id'] ?>"><?php echo $thisthread['title']?></a>
                </h2>
                <p class="meta">
                    <?php echo date('l, d F, Y',$thisthread['date']) ?> - Posted by
                    <a href="#"><?php echo $thisthread['username'] ?></a>
                </p>
            </div>
        </div>
	</div> 

<?php
    }
	include('footer.php');
?>

</body>
</html>
