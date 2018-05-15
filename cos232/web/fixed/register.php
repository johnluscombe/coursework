<?php
    session_start();
    include('sessions.php');
    include('connect.php');
    include('user.php');
    include('header.php');
    $DB = connect();
?>

<div class="post">
    <div class="post-bgtop">
        <div class="post-bgbtm">
            <h2 class = "title">hackme Registration</h2>
            <?php
            if (isset($_POST['submit'])) {
                $_POST['uname'] = trim($_POST['uname']);
                check_registration_fields($_POST['uname'], $_POST['password'], $_POST['fname'], $_POST['lname']);
                check_password_length($_POST['password']);
                check_password_numbers($_POST['password']);
                check_for_duplicate_users($DB, $_POST['uname']);
                $password_hash = password_hash($_POST['password'], PASSWORD_DEFAULT);
                add_user($DB, $_POST['uname'], $password_hash, $_POST['fname'], $_POST['lname']);
                echo "<h3> Registration Successful!</h3> <p>Welcome ". $_POST['fname'] ."! Please log in...</p>";
            } else {
            ?>
                <form method="post" action="register.php">
                    <table>
                        <tr>
                            <td>Username</td>
                            <td><input type="text" name="uname" maxlength="20" /></td>
                            <td><em>choose a login id</em></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" maxlength="40" /></td>
                        </tr>
                        <tr>
                            <td>First Name</td>
                            <td><input type="text" name="fname" maxlength="25" /></td>
                        </tr>
                         <tr>
                            <td>Last Name</td>
                            <td><input type="text" name="lname" maxlength="25" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="submit" value="Register" /></td>
                        </tr>
                    </table>
                </form>
            <?php
            }
            ?>
        </div>
    </div>
</div>
<?php
    include('footer.php');
?>
</body>
</html>
