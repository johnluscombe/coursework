<?php

function check_login_fields($user, $pass) {
    if(!$user | !$pass) {
        die('<p>You did not fill in a required field.
			Please go back and try again!</p>');
    }
}

function get_user_row($DB, $user) {
    $query = $DB->prepare("SELECT * FROM users WHERE username = ?");
    $query->bind_param("s", $user);
    $query->execute() or die(mysqli_error($DB));
    $check = $query->get_result();
    return mysqli_fetch_array($check);
}

function check_user_exists($mysqli_array) {
    if (!$mysqli_array) {
        die("<p>Sorry, user name does not exist.</p>");
    }
}

function get_password_attempts($DB, $user) {
    $query = $DB->prepare("SELECT password_attempts FROM users WHERE username = ?");
    $query->bind_param("s", $user);
    $query->execute() or die(mysqli_error($DB));
    $result = $query->get_result();
    $result_array = mysqli_fetch_array($result);
    return (int)$result_array[0];
}

function check_password_attempts($password_attempts) {
    if ($password_attempts >= 3) {
        die('Sorry, your account has been locked due to 3 incorrect password attempts.
        Contact an administrator to regain access to your account.');
    }
}

function log_password_attempts($DB, $user, $password_attempts) {
    $query = $DB->prepare("UPDATE users SET password_attempts = ? WHERE username = ?");
    $query->bind_param("is", $password_attempts, $user);
    $query->execute() or die(mysqli_error($DB));
    if ($password_attempts >= 3) {
        die('Sorry, your account has been locked due to 3 incorrect password attempts.
        Contact an administrator to regain access to your account.');
    } else {
        die('Incorrect password, '.(3-$password_attempts).' attempts remaining.');
    }
}

function reset_password_attempts($DB, $user) {
    $query = $DB->prepare("UPDATE users SET password_attempts=0 WHERE username = ?");
    $query->bind_param("s", $user);
    $query->execute() or die(mysqli_error($DB));
}

function check_password($DB, $user, $pass, $mysqli_array) {
    $password_attempts = get_password_attempts($DB, $user);
    check_password_attempts($password_attempts);

    if (!password_verify($pass, $mysqli_array['pass'])) {
        $password_attempts++;
        log_password_attempts($DB, $user, $password_attempts);
    }
}