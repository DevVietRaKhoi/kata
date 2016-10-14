<?php
require_once('autoload.php');
use FinTech\AccountManager;

$handleIn = fopen("php://stdin", "r");
$handleOut = fopen('php://stdout', 'w');

$accountManager = new AccountManager();

while (1) {
    fwrite($handleOut, "Enter the action: ");
    fscanf($handleIn, "%s %s %s", $action, $name, $amount);
    if ($action == 'E') {
        exit;
    }
    fwrite($handleOut, $accountManager->makeAction($action, $name, $amount).PHP_EOL);
}
