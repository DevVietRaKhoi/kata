<?php
require_once('autoload.php');
use FinTech\AccountManager;
use FinTech\Action;

$accountManager = new AccountManager();

while ($input = fgets(STDIN)) {
    sscanf($input, "%s %s %s", $action, $name, $amount);
    $newAction = new Action($action, $name, $amount, $accountManager);
    $output = $newAction->performAction();
    fwrite(STDOUT, $output.PHP_EOL);
}
