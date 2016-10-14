<?php
require_once('autoload.php');
use FinTech\AccountManager;

$accountManager = new AccountManager();

while ($action = fgets(STDIN)) {
    sscanf($action, "%s %s %s", $action, $name, $amount);
    if ($action == 'E') {
        exit;
    }
    fwrite(STDOUT, $accountManager->makeAction($action, $name, $amount).PHP_EOL);
}
