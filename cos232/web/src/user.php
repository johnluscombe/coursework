<?php

function check_registration_fields($user, $pass, $fname, $lname) {
    if(!$user | !$pass | !$fname | !$lname) {
        die('<p>You did not fill in a required field. Please go back and try again!</p>');
    }
}

function check_password_length($pass) {
    if (strlen($pass) <= 8) {
        die('<p>Password must be longer than 8 characters in length!');
    }
}

function check_password_numbers($pass) {
    $password_contains_numbers = false;
    for ($i = 0; $i < 10; $i++) {
        if (strpos($pass, (string)$i)) {
            $password_contains_numbers = true;
            break;
        }
    }
    if (!$password_contains_numbers) {
        die('<p>Password must contain numbers!');
    }
}

function check_for_duplicate_users($DB, $user) {
    $query = $DB->prepare("SELECT * FROM users WHERE username = ?");
    $query->bind_param("s", $user);
    $query->execute() or die(mysqli_error($DB));
    $result = $query->get_result();
    $num_rows = mysqli_num_rows($result);
    if ($num_rows != 0) {
        die('<p>Sorry, user name already exists.</p>');
    }
}

function add_user($DB, $user, $pass, $fname, $lname) {
    $query = $DB->prepare("INSERT INTO users (username, pass, fname, lname) VALUES (?, ?, ?, ?)");
    $query->bind_param("ssss", $user, $pass, $fname, $lname);
    $query->execute() or die(mysqli_error($DB));
}