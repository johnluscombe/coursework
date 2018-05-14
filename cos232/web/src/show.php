<?php
    session_start();
	include('sessions.php');
	include('connect.php');
	verify_logged_in();
	$DB = connect();
	
	if (!isset($_GET['pid'])) {
		if (isset($_GET['delpid'])){
		    $query = $DB->prepare("SELECT username FROM threads WHERE id = ?");
		    $query->bind_param("i", $_GET['delpid']);
		    $query->execute() or die(mysqli_error($DB));
		    $result = $query->get_result();
            if (mysqli_num_rows($result) == 1) {
                $result_array = mysqli_fetch_array($result);
                $username = $result_array[0];
                if (logged_in_user() == $username) {
                    $query = $DB->prepare("DELETE FROM threads WHERE id = ?");
                    $query->bind_param("i", $_GET['delpid']);
                    $query->execute() or die(mysqli_error($DB));
                } else {
                    die("You cannot delete someone else's post!");
                }
            }
		}
        header("Location: members.php");
	}

	include('header.php');
    print("<p>Logged in as <a>".logged_in_user()."</a></p>");
    $query = $DB->prepare("SELECT * FROM threads WHERE id = ?");
    $query->bind_param("i", $_GET['pid']);
    $query->execute() or die(mysqli_error($DB));
    $threads = $query->get_result();
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
                <a href="#"><?php echo $thisthread['username'] ?> </a>
            </p>
            <div class="entry">
                <?php echo $thisthread['message'] ?>
            </div>
        </div>
    </div>
</div>

<?php
		if (logged_in_user() == $thisthread['username']) {
		    print('<a href="show.php?delpid='.$thisthread['id'].'">DELETE</a>');
		}
    }
	include('footer.php');
?>

</body>
</html>
