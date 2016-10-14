<?php
namespace FinTech;

class AccountManager
{
    protected $accounts = [];
    
    const ACTION_ADD_CLIENT = 'A';
    const ACTION_DEPOSIT_MONEY = 'D';
    const ACTION_WITHDRAW_MONEY = 'W';

    public function makeAction($action, $name, $amount)
    {
        switch ($action) {
            case self::ACTION_ADD_CLIENT:
                return $this->addAccount($name, $amount);
                break;
            case self::ACTION_DEPOSIT_MONEY:
                return $this->depositMoney($name, $amount);
                break;
            case self::ACTION_WITHDRAW_MONEY:
                return $this->withdrawMoney($name, $amount);
                break;
            default:
                return 'Invalid';
                break;
        }
    }

    public function getLog()
    {
        return $this->log;
    }

    protected function getKeyName($name)
    {
        return strtolower($name);
    }

    protected function checkAccountExist($name)
    {
        return array_key_exists($this->getKeyName($name), $this->accounts);
    }

    protected function checkAmountType($amount)
    {
        return (is_numeric($amount));
    }

    protected function addAccount($name, $amount)
    {
        if (ctype_alpha($name) && !$this->checkAccountExist($name) && $this->checkAmountType($amount) && $amount >= 0) {
            $newAccount = new Account($name, $amount);
            $this->accounts[$this->getKeyName($name)] = $newAccount;
            return 'True';
        } else {
            return 'False';
        }
    }

    protected function depositMoney($name, $amount)
    {
        if ($this->checkAmountType($amount) && $amount > 0 && $this->checkAccountExist($name)) {
            $this->accounts[$this->getKeyName($name)]->deposit($amount);
            return 'True';
        } else {
            return 'False';
        }
    }

    protected function withdrawMoney($name, $amount)
    {
        if ($this->checkAmountType($amount) && $amount > 0 && $this->checkAccountExist($name)) {
            if ($this->accounts[$this->getKeyName($name)]->withdraw($amount)) {
                return 'True';
            } else {
                return 'False';
            }
        } else {
            return 'False';
        }
    }
}
