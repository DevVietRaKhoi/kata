<?php

$bank = Bank::getInstance();
$bank->welcome();

class Account
{
	private $_name;
	private $_money;

	function __construct($name, $money) {
		$this->_name = $name;
		$this->_money = $money;
	}

	public function withdraw($amount) {
		if ($amount < 0 || $amount > $this->_money)
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
	private $_keywords;
    private static $_instance;

    protected function __construct() {
		$this->_accounts = array();
		$this->_keywords = array('A', 'D', 'W');
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

	public function welcome() {
		while (1) {
			$command = dd_read();

			if ($command == 'fuck') exit('bye, xD.'.PHP_EOL);
			if ($command == 'dump') {
				print_r($this->_accounts);
				continue;
			}

			if ($command = $this->parseCommand($command)) {
				$name = strtolower($command[1]);
				$amount = (double) $command[2];

				switch ($command[0]) {
					case 'A':
						$account =  new Account($command[1], $command[2]);
						dd_linef( $this->add($account) ? 'True' : 'False' );
						break;

					case 'D':
						if ($acc = $this->findAccountByName($name)) {
							if ($acc->deposite($amount)) {
                                $acc->save();
								dd_linef('True');
							} else
                                dd_linef('False');
						} else
						    dd_linef('False');
						break;

					case 'W':
						if ($acc = $this->findAccountByName($name)) {
							if ($acc->withdraw($amount)) {
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
		$command = preg_split('/\s+/', $string);
		$errors = array();
		
		//just usefull when all commands have 4 arguments
		if (count($command) != 3) {
			dd_linef("Wrong structure command!");
			return false;
		}
		if (!in_array($command[0], $this->_keywords))
			// $errors[] = 'Invalid keyword';
			$errors[] = 'Invalid';
		if (!preg_match("/^([a-zA-Z]+)/", $command[1]))
			$errors[] = 'Invalid name';
		if ((double)$command[2]."" != $command[2])
			$errors[] = 'Invalid amount of money';
		if (count($errors)) {
			foreach ($errors as $error)
				dd_linef($error);
			return false;
		}
		return $command;
	}

	public function accounts() {
		return $this->_accounts;
	}

	public function keywords() {
		return $this->_keywords;
	}

}

//helper function, dd just is my prefix :D
function dd_line($text) {
	fwrite(STDOUT, $text);
}
function dd_linef($text) {
	fwrite(STDOUT, $text.PHP_EOL);
}
function dd_read() {
	// fflush(STDIN);
	return trim(fgets(STDIN));
}