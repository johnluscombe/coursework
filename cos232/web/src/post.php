<?php
    session_start();
	include('sessions.php');
	include('connect.php');
	verify_logged_in();
	$DB = connect();
	$post_submitted = isset($_POST['post_submit']);

	if ($post_submitted && $_SERVER['HTTP_REFERER'] == 'http://10.121.20.109/hackme/post.php') {
		$_POST['title'] = trim($_POST['title']);
		if(!$_POST['title'] | !$_POST['message']) {
			include('header.php');
			die('<p>You did not fill in a required field.
			Please go back and try again!</p>');
		}
        $_POST['title'] = filter_var($_POST['title'], FILTER_SANITIZE_STRING);
        $_POST['message'] = filter_var($_POST['message'], FILTER_SANITIZE_STRING);
        $query = $DB->prepare("INSERT INTO threads (username, title, message, date) VALUES (?, ?, ?, ?)");
        $query->bind_param("sssi", $_COOKIE['hackme'], $_POST['title'], $_POST['message'], time());
        $query->execute() or die(mysqli_error($DB));
        header("Location: members.php");
	}
	include('header.php');
?>

<div class="post">
	<div class="post-bgtop">
		<div class="post-bgbtm">
            <h2 class="title">hackme bulletin board</h2>
        	<p>Logged in as <a><?php echo logged_in_user() ?></a></p>
            <h2 class="title">NEW POST</h2>
            <p class="meta">by <a href="#"><?php echo logged_in_user() ?></a></p>
            <p>do not leave any fields blank...</p>
            <form method="post" action="post.php">
                Title: <input type="text" name="title" maxlength="50"/><br /><br />
                Posting:<br /><br />
                <textarea name="message" cols="120" rows="10" id="message"></textarea><br /><br />
                <input name="post_submit" type="submit" id="post_submit" value="POST" />
            </form>
        </div>
    </div>
</div>

<?php
	include('footer.php');
?>

</body>
</html>
