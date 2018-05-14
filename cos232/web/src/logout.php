<?php
    session_start();
    include 'sessions.php';
    logout();
    header("Location: index.php");
