<?php

function login($user, $pass) {
    $_SESSION['hackme'] = $user;
    $_SESSION['hackme_pass'] = $pass;
}

function is_logged_in() {
    if (isset($_SESSION['hackme'])) {
        if ($_SESSION['hackme'] == "") {
            $logged_in = false;
        } else {
            $logged_in = true;
        }
    } else {
        $logged_in = false;
    }
    return $logged_in;
}

function verify_logged_in() {
    if (isset($_SESSION['hackme'])) {
        if ($_SESSION['hackme'] == "") {
            die('Why are you not logged in?!');
        }
    } else {
        die('Why are you not logged in?!');
    }
}

function logged_in_user() {
    return $_SESSION['hackme'];
}

function logout() {
    $_SESSION['hackme'] = "";
    $_SESSION['hackme_pass'] = "";
}