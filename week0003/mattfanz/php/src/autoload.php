<?php
define('BASE_PATH', realpath(dirname(__FILE__)));
function __autoload($class)
{
    $filename = BASE_PATH . '/' . str_replace('\\', '/', $class) . '.php';
    require_once($filename);
}
