<?php

$bank = Bank::getInstance();
$bank->run();

class Account
{
    private $_name;
    private $_money;

    function __construct($name, $money) {
        $this->_name = $name;
        $this->_money = $money;
    }

    public function withdraw($amount) {
        if ($amount <= 0 || $amount > $this->_money)
            return false;
        $this->_money -= $amount;
        return true;
    }

    public function deposite($amount) {
        if ($amount < 0)
            return false;
        $this->_money += $amount;
        return true;
    }

    public function save() {
        $bank = Bank::getInstance();
        $bank->accounts()[strtolower($this->getName())] = $this;
    }

    public function getName() {
        return $this->_name;
    }

    public function getMoney() {
        return $this->_money;
    }
}

/**
* using bank instance
*/
class Bank
{
    private $_accounts;
    const ACTION_ADD_CLIENT = 'A';
    const ACTION_WITHDRAW_CLIENT = 'W';
    const ACTION_DEPOSIT_CLIENT = 'D';

    private static $_instance;

    protected function __construct() {
        $this->_accounts = array();
    }

    public static function getInstance() {
        if (null === self::$_instance) {
            self::$_instance = new self();
        }
        return self::$_instance;
    }

    public function add(Account $account) {
        if ( $this->_accounts[strtolower($account->getName())] )
            return false;
        else
            $this->_accounts[strtolower( $account->getName() )] = $account;
        return true;
    }

    public function save($account) {
        if ( $this->_accounts[strtolower($account->getName())] ) {
            $this->_accounts[strtolower($account->getName())] = $account;
            return true;
        }
        return false;
    }

    public function run() {
        while ($command = dd_read()) {

            if ($command == 'dump') {
                print_r($this->_accounts);
                continue;
            }

            if ($command = $this->parseCommand($command)) {
                $name = strtolower($command['accountName']); //this name use as key of bank per account.
                
                switch ($command['action']) {
                    case self::ACTION_ADD_CLIENT:
                        $account =  new Account($command['accountName'], $command['amount']);
                        if ($this->add($account))
                            dd_linef('True');
                        else
                            dd_linef('False');
                        break;

                    case self::ACTION_DEPOSIT_CLIENT:
                        if ($acc = $this->findAccountByName($name)) {
                            if ($acc->deposite($command['amount'])) {
                                $acc->save();
                                dd_linef('True');
                            } else
                                dd_linef('False');
                        } else
                            dd_linef('False');
                        break;

                    case self::ACTION_WITHDRAW_CLIENT:
                        if ($acc = $this->findAccountByName($name)) {
                            if ($acc->withdraw($command['amount'])) {
                                $acc->save();
                                dd_linef('True');
                            } else
                                dd_linef('False');
                        } else
                            dd_linef('False');
                        break;
                    
                    default:
                        dd_linef('Invalid');
                        break;
                }
            }
        }
    }

    public function findAccountByName($name) {
        if ($this->_accounts[$name])
            return $this->_accounts[$name];
        return false;
    }

    private function parseCommand($string) {
        $string = preg_split('/\s+/', $string);
        $errors = array();
        
        //just usefull when all commands have 3 arguments
        if (count($string) != 3) {
            dd_error("Wrong structure command!");
            return false;
        }

        $command = array();
        $command['action'] = $string[0];
        $command['accountName'] = $string[1];
        $command['amount'] = $string[2];

        if (!in_array($command['action'], $this->getActions()))
            $errors[] = 'Invalid';
        if (!preg_match("/^([a-zA-Z]+)/", $command['accountName']))
            $errors[] = 'Invalid name';
        if ((double)$command['amount']."" != $command['amount'])
            $errors[] = 'Invalid amount of money';
        if (count($errors)) {
            foreach ($errors as $error)
                dd_error($error);
            return false;
        }
        return $command;
    }

    public function accounts() {
        return $this->_accounts;
    }

    public function getActions() {        
        return array(self::ACTION_ADD_CLIENT, self::ACTION_DEPOSIT_CLIENT, self::ACTION_WITHDRAW_CLIENT);
    }

}

//helper function, dd just is my prefix :D
function dd_line($text) { //no new line
    fwrite(STDOUT, $text);
}
function dd_linef($text) { //enter new line
    fwrite(STDOUT, $text.PHP_EOL);
}
function dd_error($text) { //printt error
    fwrite(STDERR, $text.PHP_EOL);
}
function dd_read() {
    // fflush(STDIN);
    return trim(fgets(STDIN));
}