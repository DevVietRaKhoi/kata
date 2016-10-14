<?php
require_once('../src/autoload.php');
use FinTech\AccountManager;

$handleOut = fopen('php://stdout', 'w');

$accountManager = new AccountManager();

fwrite($handleOut, $accountManager->makeAction('A', 'Viet', 10000).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('D', 'Jenny', 1000).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('A', 'Jenny', 1000).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('W', 'An', 256).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('A', 'Viet', 9999).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('W', 'Viet', 1000).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('D', 'Jenny', 256).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('A', 'An', 567).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('W', 'Jenny', 2000).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('D', 'Viet', 345).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('B', 'An', 123456).PHP_EOL);
fwrite($handleOut, $accountManager->makeAction('Q', 'Stark', 999999999).PHP_EOL);
